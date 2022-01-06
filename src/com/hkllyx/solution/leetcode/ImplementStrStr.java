package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;

/**
 * <p>Implement <a href="http://www.cplusplus.com/reference/cstring/strstr/" target="_blank">strStr()</a>.</p>
 *
 * <p>Return the index of the first occurrence of needle in haystack, or <code>-1</code> if <code>needle</code> is not part of <code>haystack</code>.</p>
 *
 * <p><strong>Clarification:</strong></p>
 *
 * <p>What should we return when <code>needle</code> is an empty string? This is a great question to ask during an interview.</p>
 *
 * <p>For the purpose of this problem, we will return 0 when <code>needle</code> is an empty string. This is consistent to C&#39;s&nbsp;<a href="http://www.cplusplus.com/reference/cstring/strstr/" target="_blank">strstr()</a> and Java&#39;s&nbsp;<a href="https://docs.oracle.com/javase/7/docs/api/java/lang/String.html#indexOf(java.lang.String)" target="_blank">indexOf()</a>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 * <pre><strong>Input:</strong> haystack = "hello", needle = "ll"
 * <strong>Output:</strong> 2
 * </pre><p><strong>Example 2:</strong></p>
 * <pre><strong>Input:</strong> haystack = "aaaaa", needle = "bba"
 * <strong>Output:</strong> -1
 * </pre><p><strong>Example 3:</strong></p>
 * <pre><strong>Input:</strong> haystack = "", needle = ""
 * <strong>Output:</strong> 0
 * </pre>
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>0 &lt;= haystack.length, needle.length &lt;= 5 * 10<sup>4</sup></code></li>
 * 	<li><code>haystack</code> and&nbsp;<code>needle</code> consist of only lower-case English characters.</li>
 * </ul>
 * <div><div>Related Topics</div><div><li>双指针</li><li>字符串</li><li>字符串匹配</li></div></div><br><div><li>👍 1194</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2021/04/20
 */
@Solution(no = "28", difficulty = Difficulty.EASY, url = "https://leetcode-cn.com/problems/implement-strstr/")
public class ImplementStrStr {

    public static void main(String[] args) {
        Assertions.assertExpect(ImplementStrStr.class, 1, "mississippi", "issi");
        Assertions.assertExpect(ImplementStrStr.class, -1, "aaa", "aaaa");
        Assertions.assertExpect(ImplementStrStr.class, 0, "", "");
        Assertions.assertExpect(ImplementStrStr.class, -1, "aaaa", "bba");
        Assertions.assertExpect(ImplementStrStr.class, 2, "hello", "ll");
    }

    public int strStr1(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }
        if (needle.isEmpty()) {
            return 0;
        }
        char n0 = needle.charAt(0);
        int hl = haystack.length();
        int nl = needle.length();
        int dl = hl - nl; // i + (nl - 1) < hl ==> i + (nl - 1) <= hl - 1
        for (int i = 0; i < hl && i <= dl; ) {
            int ni = i;
            int j;
            for (j = 0; j < nl; j++) {
                int k = i + j;
                char h = haystack.charAt(k);
                char n = needle.charAt(j);
                if (i == ni && h == n0) {
                    ni = k;
                }
                if (h != n) {
                    i = i == ni ? i + 1 : ni;
                    break;
                }
            }
            if (j == nl) {
                return i;
            }
        }
        return -1;
    }

    public int strStr2(String haystack, String needle) {
        int i = 0, j = 0;
        while (i < haystack.length() && j < needle.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }
        return j == needle.length() ? i - j : -1;
    }
}
