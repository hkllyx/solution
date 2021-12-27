package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

/**
 * @author xiaoyong3
 * @date 2021/12/27
 */
@Solution(no = "剑指Offer 46", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/")
public class 把数字翻译成字符串 {

    public static void main(String[] args) {
        Assertions.assertExpect(2, 25);
    }

    @Test
    public int translateNum(int num) {
        String s = String.valueOf(num);
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[0] = dp[1] = 1;
        for (int i = 1; i < len; i++) {
            char pre = s.charAt(i - 1), cur = s.charAt(i);
            if (pre == '1' || (pre == '2' && cur <= '5')) {
                dp[i + 1] = dp[i] + dp[i - 1];
            } else {
                dp[i + 1] = dp[i];
            }
        }
        return dp[len];
    }
}
