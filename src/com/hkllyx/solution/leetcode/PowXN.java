package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

/**
 * @author xiaoyong3
 * @date 2021/06/01
 */
@Solution(no = "50", difficulty = Difficulty.SIMPLE, url = "https://leetcode-cn.com/problems/powx-n/")
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
