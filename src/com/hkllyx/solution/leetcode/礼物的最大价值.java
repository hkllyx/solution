package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;

/**
 * <p>在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1:</strong></p>
 *
 * <pre><strong>输入:</strong>
 * <code>[
 * &nbsp; [1,3,1],
 * &nbsp; [1,5,1],
 * &nbsp; [4,2,1]
 * ]</code>
 * <strong>输出:</strong> <code>12
 * </code><strong>解释:</strong> 路径 1&rarr;3&rarr;5&rarr;2&rarr;1 可以拿到最多价值的礼物</pre>
 *
 * <p>&nbsp;</p>
 *
 * <p>提示：</p>
 *
 * <ul>
 * 	<li><code>0 &lt; grid.length &lt;= 200</code></li>
 * 	<li><code>0 &lt; grid[0].length &lt;= 200</code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>数组</li><li>动态规划</li><li>矩阵</li></div></div><br><div><li>👍 226</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2021/12/27
 */
@Solution(no = "剑指 Offer 47", title = "礼物的最大价值", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof/")
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
