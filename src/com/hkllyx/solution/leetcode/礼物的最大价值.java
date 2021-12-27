package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;

/**
 * @author xiaoyong3
 * @date 2021/12/27
 */
@Solution(no = "剑指Offer 47", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof/")
public class 礼物的最大价值 {

    public int maxValue(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        // 第一列
        for (int i = 1; i < rows; i++) {
            grid[i][0] += grid[i - 1][0];
        }
        // 第一行
        for (int i = 1; i < cols; i++) {
            grid[0][i] += grid[0][i - 1];
        }
        // 其他
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                grid[i][j] += Math.max(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[rows - 1][cols - 1];
    }
}
