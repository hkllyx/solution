package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

/**
 *
 * <p>Given an integer <code>x</code>, return <code>true</code> if <code>x</code> is palindrome integer.</p>
 *
 * <p>An integer is a <strong>palindrome</strong> when it reads the same backward as forward.</p>
 *
 * <ul>
 * 	<li>For example, <code>121</code> is a palindrome while <code>123</code> is not.</li>
 * </ul>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> x = 121
 * <strong>Output:</strong> true
 * <strong>Explanation:</strong> 121 reads as 121 from left to right and from right to left.
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> x = -121
 * <strong>Output:</strong> false
 * <strong>Explanation:</strong> From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * </pre>
 *
 * <p><strong>Example 3:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> x = 10
 * <strong>Output:</strong> false
 * <strong>Explanation:</strong> Reads 01 from right to left. Therefore it is not a palindrome.
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>-2<sup>31</sup>&nbsp;&lt;= x &lt;= 2<sup>31</sup>&nbsp;- 1</code></li>
 * </ul>
 *
 * <p>&nbsp;</p>
 * <strong>Follow up:</strong> Could you solve it without converting the integer to a string?<div><div>Related Topics</div><div><li>数学</li></div></div><br><div><li>👍 1779</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2022/01/24
 */
@Solution(no = "9", title = "Palindrome Number", difficulty = Difficulty.EASY, url = "https://leetcode-cn.com/problems/palindrome-number/")
public class PalindromeNumber {

    public static void main(String[] args) {
        Assertions.assertExpect(false, 1000021);
        Assertions.assertExpect(true, 121121);
    }

    @Test
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int i = 1, j = 1;
        while (x / i > 9) {
            i *= 10;
        }
        while (i > j) {
            if ((x / i % 10) != (x / j % 10)) {
                return false;
            }
            i /= 10;
            j *= 10;
        }
        return true;
    }
}
