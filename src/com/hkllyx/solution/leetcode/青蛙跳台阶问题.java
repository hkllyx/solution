package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Test;

/**
 * @author xiaoyong3
 * @date 2021/05/24
 */
@Solution(no = "剑指 Offer 10-II", difficulty = Difficulty.SIMPLE, url = "https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/")
public class 青蛙跳台阶问题 extends ClimbingStairs {

    @Test
    public int numWays(int n) {
        if (n <= 1) {
            return 1;
        }
        int a = 1, b = 2;
        for (int i = 2; i <= n; i++) {
            int c = b;
            b = (a + b) % 1000000007;
            a = c;
        }
        return a;
    }
}
