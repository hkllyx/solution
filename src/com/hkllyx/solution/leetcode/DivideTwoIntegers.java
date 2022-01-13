package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.info.Status;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

/**
 * <p>Given two integers <code>dividend</code> and <code>divisor</code>, divide two integers <strong>without</strong> using multiplication, division, and mod operator.</p>
 *
 * <p>The integer division should truncate toward zero, which means losing its fractional part. For example, <code>8.345</code> would be truncated to <code>8</code>, and <code>-2.7335</code> would be truncated to <code>-2</code>.</p>
 *
 * <p>Return <em>the <strong>quotient</strong> after dividing </em><code>dividend</code><em> by </em><code>divisor</code>.</p>
 *
 * <p><strong>Note: </strong>Assume we are dealing with an environment that could only store integers within the <strong>32-bit</strong> signed integer range: <code>[&minus;2<sup>31</sup>, 2<sup>31</sup> &minus; 1]</code>. For this problem, if the quotient is <strong>strictly greater than</strong> <code>2<sup>31</sup> - 1</code>, then return <code>2<sup>31</sup> - 1</code>, and if the quotient is <strong>strictly less than</strong> <code>-2<sup>31</sup></code>, then return <code>-2<sup>31</sup></code>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> dividend = 10, divisor = 3
 * <strong>Output:</strong> 3
 * <strong>Explanation:</strong> 10/3 = 3.33333.. which is truncated to 3.
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> dividend = 7, divisor = -3
 * <strong>Output:</strong> -2
 * <strong>Explanation:</strong> 7/-3 = -2.33333.. which is truncated to -2.
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>-2<sup>31</sup> &lt;= dividend, divisor &lt;= 2<sup>31</sup> - 1</code></li>
 * 	<li><code>divisor != 0</code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>位运算</li><li>数学</li></div></div><br><div><li>👍 802</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2021/10/12
 */
@Solution(no = "29", title = "Divide Two Integers", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/divide-two-integers/", status = Status.HELPED)
public class DivideTwoIntegers {

    public static void main(String[] args) {
        Assertions.assertExpect(1, 1, 1);
        Assertions.assertExpect(3, 10, 3);
        Assertions.assertExpect(-2, 7, -3);
        Assertions.assertExpect(Integer.MAX_VALUE, Integer.MIN_VALUE, -1);
        Assertions.assertExpect(Integer.MIN_VALUE, Integer.MIN_VALUE, 1);
    }

    @Test
    public int divide(int dividend, int divisor) {
        boolean positive = (dividend ^ divisor) >= 0;
        long dividendLong = Math.abs((long) dividend);
        long divisorLong = Math.abs((long) divisor);
        int res = 0;
        for (int i = 31; i >= 0 && dividendLong >= divisorLong; i--) {
            long tmp = divisorLong << i;
            if (dividendLong >= tmp) {
                res += (1 << i);
                dividendLong -= tmp;
            }
        }
        return positive ? res < 0 ? Integer.MAX_VALUE : res : -res;
    }
}
