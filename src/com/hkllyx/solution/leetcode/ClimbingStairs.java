package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Test;
import com.hkllyx.solution.util.test.TestUtils;

/**
 * @author xiaoyong3
 * @date 2021/05/24
 */
@Solution(no = "70", difficulty = Difficulty.SIMPLE, url = "https://leetcode-cn.com/problems/climbing-stairs/")
public class ClimbingStairs {

    public static void main(String[] args) {
        TestUtils.assertion(ClimbingStairs.class, 1, 1);
        TestUtils.assertion(ClimbingStairs.class, 2, 2);
        TestUtils.assertion(ClimbingStairs.class, 21, 7);
    }

    @Test
    public int climbStairs(int n) {
        int a = 1, b = 2;
        for (int i = 2; i <= n; i++) {
            int c = b;
            b += a;
            a = c;
        }
        return a;
    }
}
