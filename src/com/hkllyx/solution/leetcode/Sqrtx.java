package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

/**
 * <p>Given a non-negative integer <code>x</code>,&nbsp;compute and return <em>the square root of</em> <code>x</code>.</p>
 *
 * <p>Since the return type&nbsp;is an integer, the decimal digits are <strong>truncated</strong>, and only <strong>the integer part</strong> of the result&nbsp;is returned.</p>
 *
 * <p><strong>Note:&nbsp;</strong>You are not allowed to use any built-in exponent function or operator, such as <code>pow(x, 0.5)</code> or&nbsp;<code>x ** 0.5</code>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> x = 4
 * <strong>Output:</strong> 2
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> x = 8
 * <strong>Output:</strong> 2
 * <strong>Explanation:</strong> The square root of 8 is 2.82842..., and since the decimal part is truncated, 2 is returned.</pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>0 &lt;= x &lt;= 2<sup>31</sup> - 1</code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>数学</li><li>二分查找</li></div></div><br><div><li>👍 1008</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2022/05/12
 */
@Solution(no = "69", title = "Sqrt(x)", difficulty = Difficulty.EASY, url = "https://leetcode-cn.com/problems/sqrtx/")
public class Sqrtx {

    public static void main(String[] args) {
        Assertions.assertExpect(2, 8);
    }

    @Test
    public int mySqrt(int x) {
        if (x < 2) {
            return x;
        }
        int i = 0, j = x;
        while (i < j) {
            int m = (i + j) >> 1;
            if (m == i) {
                return m;
            }
            long n = (long) m * m;
            if (n == x) {
                return m;
            } else if (n > x) {
                j = m;
            } else {
                i = m;
            }
        }
        return i;
    }
}
