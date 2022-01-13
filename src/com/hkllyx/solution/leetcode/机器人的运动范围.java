package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

/**
 * <p>地上有一个m行n列的方格，从坐标 <code>[0,0]</code> 到坐标 <code>[m-1,n-1]</code> 。一个机器人从坐标 <code>[0, 0] </code>的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre><strong>输入：</strong>m = 2, n = 3, k = 1
 * <strong>输出：</strong>3
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre><strong>输入：</strong>m = 3, n = 1, k = 0
 * <strong>输出：</strong>1
 * </pre>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= n,m &lt;= 100</code></li>
 * 	<li><code>0 &lt;= k&nbsp;&lt;= 20</code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>深度优先搜索</li><li>广度优先搜索</li><li>动态规划</li></div></div><br><div><li>👍 412</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2021/05/24
 */
@Solution(no = "剑指 Offer 13", title = "机器人的运动范围", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/")
public class 机器人的运动范围 {

    public static void main(String[] args) {
        Assertions.assertExpect(机器人的运动范围.class, 3, 2, 3, 1);
        Assertions.assertExpect(机器人的运动范围.class, 1, 2, 3, 0);
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
