package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

/**
 * <p>You are given two strings <code>s1</code> and <code>s2</code> of equal length. A <strong>string swap</strong> is an operation where you choose two indices in a string (not necessarily different) and swap the characters at these indices.</p>
 *
 * <p>Return <code>true</code> <em>if it is possible to make both strings equal by performing <strong>at most one string swap </strong>on <strong>exactly one</strong> of the strings. </em>Otherwise, return <code>false</code>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> s1 = "bank", s2 = "kanb"
 * <strong>Output:</strong> true
 * <strong>Explanation:</strong> For example, swap the first character with the last character of s2 to make "bank".
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> s1 = "attack", s2 = "defend"
 * <strong>Output:</strong> false
 * <strong>Explanation:</strong> It is impossible to make them equal with one string swap.
 * </pre>
 *
 * <p><strong class="example">Example 3:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> s1 = "kelb", s2 = "kelb"
 * <strong>Output:</strong> true
 * <strong>Explanation:</strong> The two strings are already equal, so no string swap operation is required.
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 *  <li><code>1 &lt;= s1.length, s2.length &lt;= 100</code></li>
 *  <li><code>s1.length == s2.length</code></li>
 *  <li><code>s1</code> and <code>s2</code> consist of only lowercase English letters.</li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>哈希表</li><li>字符串</li><li>计数</li></div></div><br><div><li>👍 75</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2022/10/11
 */
@Solution(no = "1790", title = "Check if One String Swap Can Make Strings Equal", difficulty = Difficulty.EASY, url = "https://leetcode-cn.com/problems/check-if-one-string-swap-can-make-strings-equal/")
public class CheckIfOneStringSwapCanMakeStringsEqual {

    public static void main(String[] args) {
        Assertions.assertExpect(false, "qgqeg", "gqgeq");
    }

    @Test
    public boolean areAlmostEqual(String s1, String s2) {
        int len = s1.length(), p = -1, times = 0;
        for (int i = 0; i < len; i++) {
            char c1 = s1.charAt(i), c2 = s2.charAt(i);
            if (c1 != c2) {
                if (p == -1) {
                    p = i;
                } else if (s1.charAt(p) == c2 && s2.charAt(p) == c1) {
                    times++;
                } else {
                    return false;
                }
            }
        }
        return p == -1 || times == 1;
    }
}
