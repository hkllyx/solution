package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

/**
 * <p>Given an input string (<code>s</code>) and a pattern (<code>p</code>), implement wildcard pattern matching with support for <code>&#39;?&#39;</code> and <code>&#39;*&#39;</code> where:</p>
 *
 * <ul>
 * 	<li><code>&#39;?&#39;</code> Matches any single character.</li>
 * 	<li><code>&#39;*&#39;</code> Matches any sequence of characters (including the empty sequence).</li>
 * </ul>
 *
 * <p>The matching should cover the <strong>entire</strong> input string (not partial).</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> s = &quot;aa&quot;, p = &quot;a&quot;
 * <strong>Output:</strong> false
 * <strong>Explanation:</strong> &quot;a&quot; does not match the entire string &quot;aa&quot;.
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> s = &quot;aa&quot;, p = &quot;*&quot;
 * <strong>Output:</strong> true
 * <strong>Explanation:</strong>&nbsp;&#39;*&#39; matches any sequence.
 * </pre>
 *
 * <p><strong>Example 3:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> s = &quot;cb&quot;, p = &quot;?a&quot;
 * <strong>Output:</strong> false
 * <strong>Explanation:</strong>&nbsp;&#39;?&#39; matches &#39;c&#39;, but the second letter is &#39;a&#39;, which does not match &#39;b&#39;.
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>0 &lt;= s.length, p.length &lt;= 2000</code></li>
 * 	<li><code>s</code> contains only lowercase English letters.</li>
 * 	<li><code>p</code> contains only lowercase English letters, <code>&#39;?&#39;</code> or <code>&#39;*&#39;</code>.</li>
 * </ul>
 * <div><div>Related Topics</div><div><li>贪心</li><li>递归</li><li>字符串</li><li>动态规划</li></div></div><br><div><li>👍 824</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2022/02/22
 */
@Solution(no = "44", title = "Wildcard Matching", difficulty = Difficulty.HARD, url = "https://leetcode-cn.com/problems/wildcard-matching/")
public class WildcardMatching {

    public static void main(String[] args) {
        Assertions.assertExpect(true, "abcdecd", "a*c*d");
        Assertions.assertExpect(true, "acadb", "a*a*b");
        Assertions.assertExpect(true, "", "*****");
        Assertions.assertExpect(false, "", "****a");
        Assertions.assertExpect(true, "aba", "a*a");
        Assertions.assertExpect(true, "aa", "a*a");
        Assertions.assertExpect(false, "aa", "a");
        Assertions.assertExpect(true, "aa", "*");
        Assertions.assertExpect(false, "cb", "?a");
    }

    @Test(value = "递归 Time Limit Exceeded", active = false)
    public boolean isMatch(String s, String p) {
        return isMatch(s, p, 0, 0);
    }

    private boolean isMatch(String s, String p, int i, int j) {
        if (i >= s.length() && j >= p.length()) {
            return true;
        } else if (j >= p.length()) {
            return false;
        }
        char pc = p.charAt(j++);
        if (pc == '*') {
            while (i <= s.length()) {
                if (isMatch(s, p, i++, j)) {
                    return true;
                }
            }
        }
        if (i >= s.length()) {
            return false;
        }
        return (pc == '?' || pc == s.charAt(i)) && isMatch(s, p, i + 1, j);
    }

    @Test(value = "DP", mills = 36, memory = 41.5, active = false)
    public boolean isMatch1(String s, String p) {
        int len1 = s.length(), len2 = p.length();
        // match[i][j]表示s前i未和p前j位是否匹配
        boolean[][] match = new boolean[len1 + 1][len2 + 1];
        // ""和""匹配
        match[0][0] = true;
        // s（非空）和""不匹配
        // ""和p的匹配情况
        for (int j = 1; j <= len2; j++) {
            match[0][j] = match[0][j - 1] && p.charAt(j - 1) == '*';
            if (!match[0][j]) {
                break;
            }
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                char sc = s.charAt(i - 1), pc = p.charAt(j - 1);
                match[i][j] = (sc == pc || pc == '?') && match[i - 1][j - 1]
                        // 分别表示'*'匹配0/1/n个字符
                        || pc == '*' && (match[i - 1][j] || match[i - 1][j - 1] || match[i][j - 1]);
            }
        }
        return match[len1][len2];
    }

    @Test(value = "贪心,'*'每次匹配最少", mills = 2, helped = true)
    public boolean isMatch2(String s, String p) {
        // 最近遍历的'*'的位置
        int asterisk = -1;
        // 当前'*'开始匹配的位置
        int match = -1;
        int i = 0, j = 0;
        while (i < s.length()) {
            if (j < p.length() && (p.charAt(j) == s.charAt(i) || p.charAt(j) == '?')) {
                // 字符匹配，i、j自增
                i++;
                j++;
            } else if (j < p.length() && p.charAt(j) == '*') {
                // 遇到'*'，假设它匹配0个字符，所以只有j自增
                match = i;
                asterisk = j++;
            } else if (asterisk != -1) {
                // '*'匹配数+1
                i = ++match;
                j = asterisk + 1;
            } else {
                return false;
            }
        }
        while (j < p.length() && p.charAt(j) == '*') {
            j++;
        }
        return j == p.length();
    }
}
