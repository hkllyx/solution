package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

/**
 * <p>Implement <a href="http://www.cplusplus.com/reference/valarray/pow/" target="_blank">pow(x, n)</a>, which calculates <code>x</code> raised to the power <code>n</code> (i.e., <code>x<sup>n</sup></code>).</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> x = 2.00000, n = 10
 * <strong>Output:</strong> 1024.00000
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> x = 2.10000, n = 3
 * <strong>Output:</strong> 9.26100
 * </pre>
 *
 * <p><strong>Example 3:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> x = 2.00000, n = -2
 * <strong>Output:</strong> 0.25000
 * <strong>Explanation:</strong> 2<sup>-2</sup> = 1/2<sup>2</sup> = 1/4 = 0.25
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>-100.0 &lt; x &lt; 100.0</code></li>
 * 	<li><code>-2<sup>31</sup> &lt;= n &lt;= 2<sup>31</sup>-1</code></li>
 * 	<li><code>-10<sup>4</sup> &lt;= x<sup>n</sup> &lt;= 10<sup>4</sup></code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>递归</li><li>数学</li></div></div><br><div><li>👍 833</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2021/06/01
 */
@Solution(no = "50", title = "Pow(x, n)", difficulty = Difficulty.EASY, url = "https://leetcode-cn.com/problems/powx-n/")
public class PowXN {

    public static void main(String[] args) {
        double base = 2.0;
        int i = -8;
        System.out.println(-i);
        Assertions.assertExpect(PowXN.class, Math.pow(base, i), base, i);
    }

    /**
     * 分治 + 递归
     */
    public double myPow(double x, int n) {
        return n < 0 ? 1 / quickMultiply(x, -n) : quickMultiply(x, n);
    }

    public double quickMultiply(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double res = quickMultiply(x, n / 2);
        res *= res;
        return n % 2 == 0 ? res : res * x;
    }

    /**
     * 基于分治，每次都是计算一半结果然后平方，类似求二进制
     * 例如，x^13 = x^1 * x^4 * x^8。1，4，8就是13二进制的表现ob1101
     * 所以可以递归二进制位，向左移动一位，x = x^2，如果改位是1，就要计入乘法算式中
     */
    @Test
    public double myPow1(double x, int n) {
        boolean negative = n < 0;
        // -(n + 1)是为了防止-Integer.MIN_VALUE = Integer.MIN_VALUE
        n = negative ? -(n + 1) : n;
        double res = negative ? x : 1.0;
        while (n != 0) {
            if ((n & 1) != 0) {
                res *= x;
            }
            x *= x;
            n >>= 1;
        }
        return negative ? 1.0 / res : res;
    }
}
