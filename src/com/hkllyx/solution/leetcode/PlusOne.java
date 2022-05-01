package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;

/**
 * <p>You are given a <strong>large integer</strong> represented as an integer array <code>digits</code>, where each <code>digits[i]</code> is the <code>i<sup>th</sup></code> digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading <code>0</code>&#39;s.</p>
 *
 * <p>Increment the large integer by one and return <em>the resulting array of digits</em>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> digits = [1,2,3]
 * <strong>Output:</strong> [1,2,4]
 * <strong>Explanation:</strong> The array represents the integer 123.
 * Incrementing by one gives 123 + 1 = 124.
 * Thus, the result should be [1,2,4].
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> digits = [4,3,2,1]
 * <strong>Output:</strong> [4,3,2,2]
 * <strong>Explanation:</strong> The array represents the integer 4321.
 * Incrementing by one gives 4321 + 1 = 4322.
 * Thus, the result should be [4,3,2,2].
 * </pre>
 *
 * <p><strong>Example 3:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> digits = [9]
 * <strong>Output:</strong> [1,0]
 * <strong>Explanation:</strong> The array represents the integer 9.
 * Incrementing by one gives 9 + 1 = 10.
 * Thus, the result should be [1,0].
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= digits.length &lt;= 100</code></li>
 * 	<li><code>0 &lt;= digits[i] &lt;= 9</code></li>
 * 	<li><code>digits</code> does not contain any leading <code>0</code>&#39;s.</li>
 * </ul>
 * <div><div>Related Topics</div><div><li>数组</li><li>数学</li></div></div><br><div><li>👍 1004</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2022/05/01
 */
@Solution(no = "66", title = "Plus One", difficulty = Difficulty.EASY, url = "https://leetcode-cn.com/problems/plus-one/")
public class PlusOne {

    public int[] plusOne(int[] digits) {
        // 全部数字都是9才会增加一位数
        boolean plusDigit = true;
        for (int digit : digits) {
            if (digit != 9) {
                plusDigit = false;
                break;
            }
        }
        int length = digits.length;
        if (plusDigit) {
            // 全部数字都是9，再+1，结果就是增加一位数，最高位为1，后面都是0
            digits = new int[length + 1];
            digits[0] = 1;
            return digits;
        }
        // 不增加一位数的情况，先在末位+1
        digits[length - 1]++;
        for (int i = length - 1; i >= 0; i--) {
            // 进位
            if (digits[i] > 9) {
                digits[i - 1]++;
                digits[i] -= 10;
            }
        }
        return digits;
    }
}
