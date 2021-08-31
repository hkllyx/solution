package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Test;
import com.hkllyx.solution.util.test.TestUtils;

/**
 * @author xiaoyong3
 * @date 2021/05/27
 */
@Solution(no = "343", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/integer-break/")
public class IntegerBreak {

    public static void main(String[] args) {
        TestUtils.assertion(IntegerBreak.class, 36, 1000);
    }

    public int integerBreak(int n) {
        long[] res = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            res[i] = i == n ? i - 1 : i;
            for (int j = 1; j <= i >> 1; j++) {
                res[i] = Math.max(res[i], res[j] * res[i - j]) % 1000000007;
            }
        }
        return (int) res[n];
    }

    /**
     * 数学分析nb
     */
    @Test
    public int integerBreak1(int n) {
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        int a = n / 3;
        int b = n % 3;
        if (b == 0) {
            return (int) Math.pow(3, a) % 1000000007;
        } else if (b == 1) {
            return (int) ((long) Math.pow(3, a - 1) * 4) % 1000000007;
        } else {
            return (int) ((long) Math.pow(3, a) * 2) % 1000000007;
        }
    }
}
