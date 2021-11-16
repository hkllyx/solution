package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.info.Status;
import com.hkllyx.solution.util.test.Test;

/**
 * @author xiaoyong3
 * @date 2021/11/12
 */
@Solution(no = "375", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/guess-number-higher-or-lower-ii/", status = Status.HELPED)
public class GuessNumberHigherOrLowerII {

    @Test(value = "区间DP", mills = 22, memory = 36.8)
    public int getMoneyAmount(int n) {
        // dp[i][j]表示可以保证可以猜到i ~ j（包括i、j）任意数字的最小费用
        int[][] dp = new int[n + 2][n + 2];
        // diff = j - i
        for (int diff = 1; diff < n; diff++) {
            for (int i = 1, up = n - diff; i <= up; i++) {
                int j = i + diff;
                dp[i][j] = Integer.MAX_VALUE;
                // 第一步猜k，则此时最小费用为k加上dp[i][k - 1]、dp[k + 1][j]中的更大值
                for (int k = i; k <= j; k++) {
                    int cur = k + Math.max(dp[i][k - 1], dp[k + 1][j]);
                    dp[i][j] = Math.min(dp[i][j], cur);
                }
            }
        }
        return dp[1][n];
    }
}
