package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

/**
 * <p>There is a robot on an <code>m x n</code> grid. The robot is initially located at the <strong>top-left corner</strong> (i.e., <code>grid[0][0]</code>). The robot tries to move to the <strong>bottom-right corner</strong> (i.e., <code>grid[m - 1][n - 1]</code>). The robot can only move either down or right at any point in time.</p>
 *
 * <p>Given the two integers <code>m</code> and <code>n</code>, return <em>the number of possible unique paths that the robot can take to reach the bottom-right corner</em>.</p>
 *
 * <p>The test cases are generated so that the answer will be less than or equal to <code>2 * 10<sup>9</sup></code>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 * <img src="https://assets.leetcode.com/uploads/2018/10/22/robot_maze.png" style="width: 400px; height: 183px;" />
 * <pre>
 * <strong>Input:</strong> m = 3, n = 7
 * <strong>Output:</strong> 28
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> m = 3, n = 2
 * <strong>Output:</strong> 3
 * <strong>Explanation:</strong> From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 * 1. Right -&gt; Down -&gt; Down
 * 2. Down -&gt; Down -&gt; Right
 * 3. Down -&gt; Right -&gt; Down
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= m, n &lt;= 100</code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>数学</li><li>动态规划</li><li>组合数学</li></div></div><br><div><li>👍 1389</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2022/05/01
 */
@Solution(no = "62", title = "Unique Paths", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/unique-paths/")
public class UniquePaths {

    public static void main(String[] args) {
        Assertions.assertExpect(28, 3, 7);
    }

    @Test(value = "DP")
    public int uniquePaths(int m, int n) {
        // 某一点的到达方式是从其上方到达方式、从其左侧到达方式之和
        int[][] dp = new int[m][n];
        // 首行/列的到达方式只有从左侧/上方到达
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = 1;
        }
        // 其他点
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }
        return dp[m - 1][n - 1];
    }
}
