package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

/**
 * <p>You are given an <code>m x n</code> integer array <code>grid</code>. There is a robot initially located at the <b>top-left corner</b> (i.e., <code>grid[0][0]</code>). The robot tries to move to the <strong>bottom-right corner</strong> (i.e., <code>grid[m-1][n-1]</code>). The robot can only move either down or right at any point in time.</p>
 *
 * <p>An obstacle and space are marked as <code>1</code> or <code>0</code> respectively in <code>grid</code>. A path that the robot takes cannot include <strong>any</strong> square that is an obstacle.</p>
 *
 * <p>Return <em>the number of possible unique paths that the robot can take to reach the bottom-right corner</em>.</p>
 *
 * <p>The testcases are generated so that the answer will be less than or equal to <code>2 * 10<sup>9</sup></code>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/11/04/robot1.jpg" style="width: 242px; height: 242px;" />
 * <pre>
 * <strong>Input:</strong> obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
 * <strong>Output:</strong> 2
 * <strong>Explanation:</strong> There is one obstacle in the middle of the 3x3 grid above.
 * There are two ways to reach the bottom-right corner:
 * 1. Right -&gt; Right -&gt; Down -&gt; Down
 * 2. Down -&gt; Down -&gt; Right -&gt; Right
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/11/04/robot2.jpg" style="width: 162px; height: 162px;" />
 * <pre>
 * <strong>Input:</strong> obstacleGrid = [[0,1],[0,0]]
 * <strong>Output:</strong> 1
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>m == obstacleGrid.length</code></li>
 * 	<li><code>n == obstacleGrid[i].length</code></li>
 * 	<li><code>1 &lt;= m, n &lt;= 100</code></li>
 * 	<li><code>obstacleGrid[i][j]</code> is <code>0</code> or <code>1</code>.</li>
 * </ul>
 * <div><div>Related Topics</div><div><li>数组</li><li>动态规划</li><li>矩阵</li></div></div><br><div><li>👍 783</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2022/05/01
 */
@Solution(no = "63", title = "Unique Paths II", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/unique-paths-ii/")
public class UniquePathsII {

    public static void main(String[] args) {
        Assertions.assertExpect(2, (Object) new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}});
    }

    @Test(value = "DP")
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length - 1, n = obstacleGrid[0].length - 1;
        obstacleGrid[0][0] = 1;
        // 首行/列的到达方式只有从左侧/上方到达
        for (int i = 1; i <= m; i++) {
            // 如果自己是障碍，到达方式就是0，否则等于其上方的到达方式
            obstacleGrid[i][0] = obstacleGrid[i][0] == 1 ? 0 : obstacleGrid[i - 1][0];
        }
        for (int j = 1; j <= n; j++) {
            obstacleGrid[0][j] = obstacleGrid[0][j] == 1 ? 0 : obstacleGrid[0][j - 1];
        }
        // 其他点
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                obstacleGrid[i][j] = obstacleGrid[i][j] == 1 ? 0 : obstacleGrid[i][j - 1] + obstacleGrid[i - 1][j];
            }
        }
        return obstacleGrid[m][n];
    }
}
