package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Test;

/**
 * <p>Given a <code>m x n</code> <code>grid</code> filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.</p>
 *
 * <p><strong>Note:</strong> You can only move either down or right at any point in time.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/11/05/minpath.jpg" style="width: 242px; height: 242px;" />
 * <pre>
 * <strong>Input:</strong> grid = [[1,3,1],[1,5,1],[4,2,1]]
 * <strong>Output:</strong> 7
 * <strong>Explanation:</strong> Because the path 1 &rarr; 3 &rarr; 1 &rarr; 1 &rarr; 1 minimizes the sum.
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> grid = [[1,2,3],[4,5,6]]
 * <strong>Output:</strong> 12
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>m == grid.length</code></li>
 * 	<li><code>n == grid[i].length</code></li>
 * 	<li><code>1 &lt;= m, n &lt;= 200</code></li>
 * 	<li><code>0 &lt;= grid[i][j] &lt;= 100</code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>数组</li><li>动态规划</li><li>矩阵</li></div></div><br><div><li>👍 1228</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2022/05/01
 */
@Solution(no = "64", title = "Minimum Path Sum", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/minimum-path-sum/")
public class MinimumPathSum {

    @Test(value = "DP", mills = 2)
    public int minPathSum(int[][] grid) {
        int m = grid.length - 1, n = grid[0].length - 1;
        for (int i = 1; i <= m; i++) {
            grid[i][0] += grid[i - 1][0];
        }
        for (int j = 1; j <= n; j++) {
            grid[0][j] += grid[0][j - 1];
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                grid[i][j] += Math.min(grid[i][j - 1], grid[i - 1][j]);
            }
        }
        return grid[m][n];
    }
}
