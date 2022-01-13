package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

/**
 * <p>Given an input string <code>s</code>&nbsp;and a pattern <code>p</code>, implement regular expression matching with support for <code>&#39;.&#39;</code> and <code>&#39;*&#39;</code> where:</p>
 *
 * <ul>
 * 	<li><code>&#39;.&#39;</code> Matches any single character.​​​​</li>
 * 	<li><code>&#39;*&#39;</code> Matches zero or more of the preceding element.</li>
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
 * <strong>Input:</strong> s = &quot;aa&quot;, p = &quot;a*&quot;
 * <strong>Output:</strong> true
 * <strong>Explanation:</strong> &#39;*&#39; means zero or more of the preceding element, &#39;a&#39;. Therefore, by repeating &#39;a&#39; once, it becomes &quot;aa&quot;.
 * </pre>
 *
 * <p><strong>Example 3:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> s = &quot;ab&quot;, p = &quot;.*&quot;
 * <strong>Output:</strong> true
 * <strong>Explanation:</strong> &quot;.*&quot; means &quot;zero or more (*) of any character (.)&quot;.
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= s.length&nbsp;&lt;= 20</code></li>
 * 	<li><code>1 &lt;= p.length&nbsp;&lt;= 30</code></li>
 * 	<li><code>s</code> contains only lowercase English letters.</li>
 * 	<li><code>p</code> contains only lowercase English letters, <code>&#39;.&#39;</code>, and&nbsp;<code>&#39;*&#39;</code>.</li>
 * 	<li>It is guaranteed for each appearance of the character <code>&#39;*&#39;</code>, there will be a previous valid character to match.</li>
 * </ul>
 * <div><div>Related Topics</div><div><li>递归</li><li>字符串</li><li>动态规划</li></div></div><br><div><li>👍 2631</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2021/06/01
 */
@Solution(no = "10", title = "Regular Expression Matching", difficulty = Difficulty.HARD, url = "https://leetcode-cn.com/problems/regular-expression-matching/")
public class RegularExpressionMatching {

    public static void main(String[] args) {
        Assertions.assertExpect(false, "aa", "a");
        Assertions.assertExpect(true, "aa", "a*");
        Assertions.assertExpect(true, "ab", ".*");
        Assertions.assertExpect(true, "aab", "c*a*b");
        Assertions.assertExpect(false, "mississippi", "mis*is*p*.");
    }

    @Test
    public boolean isMatch(String s, String p) {
        int sl = s.length(), pl = p.length();
        // dp[i][j]表示s.substring(0, i - 1)是否和p.substring(0, j - 1)匹配
        boolean[][] dp = new boolean[sl + 1][pl + 1];
        // ""和""一定匹配
        dp[0][0] = true;
        // 第0列除dp[0][0]外全为false；第0行和""比较，只有.*格式下的*所在位匹配
        for (int j = 2; j <= pl; j += 2) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = true;
            } else {
                break;
            }
        }
        // 第1~sl行
        for (int i = 1; i <= sl; i++) {
            for (int j = 1; j <= pl; j++) {
                char pc = p.charAt(j - 1);
                // 动态方程，根绝"aaa"/"aab"匹配"a*a"推导
                dp[i][j] = pc == '*'
                        // 分别代表'*'匹配0/1/n个（1和n个可以合并）
                        ? dp[i][j - 2] || dp[i][j - 1] || (dp[i - 1][j] && matches(s.charAt(i - 1), p.charAt(j - 2)))
                        : dp[i - 1][j - 1] && matches(s.charAt(i - 1), pc);
            }
        }
        return dp[sl][pl];
    }

    private boolean matches(char sc, char pc) {
        return (sc == pc || pc == '.');
    }
}
