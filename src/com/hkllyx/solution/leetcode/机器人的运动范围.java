package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.Test;
import com.hkllyx.solution.util.TestUtils;
import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;

/**
 * @author xiaoyong3
 * @date 2021/05/24
 */
@Solution(no = "剑指Offer 13", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/")
public class 机器人的运动范围 {

    public static void main(String[] args) {
        TestUtils.assertion(机器人的运动范围.class, 3, 2, 3, 1);
        TestUtils.assertion(机器人的运动范围.class, 1, 2, 3, 0);
    }

    @Test
    public int movingCount(int m, int n, int k) {
        return moving(new boolean[m][n], 0, 0, k);
    }

    private int moving(boolean[][] reached, int i, int j, int k) {
        if (i < 0 || j < 0 || i >= reached.length || j >= reached[0].length || reached[i][j]) {
            return 0;
        }
        reached[i][j] = true;
        int sum = i / 10 + i % 10 + j / 10 + j % 10;
        if (sum > k) {
            return 0;
        }
        return 1 + moving(reached, i + 1, j, k) + moving(reached, i, j + 1, k);
    }
}
