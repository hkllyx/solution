package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.info.Status;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

/**
 * @author xiaoyong3
 * @date 2021/09/11
 */
@Solution(no = "600", difficulty = Difficulty.HARD, url = "https://leetcode-cn.com/problems/non-negative-integers-without-consecutive-ones/", status = Status.HELPED)
public class NonNegativeIntegersWithoutConsecutiveOnes {
    private static final int[] CONSECUTIVE_ONES = new int[26];

    static {
        CONSECUTIVE_ONES[0] = 0b11;
        for (int i = 1; i < CONSECUTIVE_ONES.length; i++) {
            CONSECUTIVE_ONES[i] = CONSECUTIVE_ONES[i - 1] << 1;
        }
    }

    public static void main(String[] args) {
        Assertions.assertExpect(5, 5);
    }

    @Test(value = "暴力，超出时间限制", active = false)
    public int findIntegers(int n) {
        int res = 0;
        for (int i = 1; i <= n; i++) {
            if (withoutConsecutiveOnes(i)) {
                res++;
            }
        }
        return res;
    }

    private boolean withoutConsecutiveOnes(int i) {
        // 1 <= n <= 10^9
        for (int test : CONSECUTIVE_ONES) {
            if ((test & i) == test) {
                return false;
            }
        }
        return true;
    }

    @Test(value = "DFS", active = false)
    public int findIntegers1(int n) {
        return dfs(1, n) + 1;
    }

    private int dfs(int i, int n) {
        if (i > n) {
            return 0;
        }
        int res = 1;
        // 左移1位，末位补零
        int j = i << 1;
        res += dfs(j, n);
        // 如果当前末位是0，左移后末位还可以补1
        if ((i & 1) == 0) {
            res += dfs(j + 1, n);
        }
        return res;
    }

    @Test(value = "DP、字典树")
    public int findIntegers2(int n) {
        // 根据字典树原理构建DP
        int[] dp = new int[31];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        int res = 0;
        boolean preIsOne = false;
        // 从高位开始
        for (int i = 31; i >= 0; i--) {
            if ((n >> i & 1) == 1) {
                res += dp[i];
                // 出现连续1，此分支之后所有抛弃，后续1也无须考虑
                if (preIsOne) {
                    return res;
                }
                preIsOne = true;
            } else {
                preIsOne = false;
            }
        }
        // 自身没有连续1，结果加1
        return res + 1;
    }
}
