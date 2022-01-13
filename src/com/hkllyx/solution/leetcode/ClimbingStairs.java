package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

/**
 * <p>You are climbing a staircase. It takes <code>n</code> steps to reach the top.</p>
 *
 * <p>Each time you can either climb <code>1</code> or <code>2</code> steps. In how many distinct ways can you climb to the top?</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> n = 2
 * <strong>Output:</strong> 2
 * <strong>Explanation:</strong> There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> n = 3
 * <strong>Output:</strong> 3
 * <strong>Explanation:</strong> There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= n &lt;= 45</code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>记忆化搜索</li><li>数学</li><li>动态规划</li></div></div><br><div><li>👍 2096</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2021/05/24
 */
@Solution(no = "70", title = "Climbing Stairs", difficulty = Difficulty.EASY, url = "https://leetcode-cn.com/problems/climbing-stairs/")
public class ClimbingStairs {

    public static void main(String[] args) {
        Assertions.assertExpect(ClimbingStairs.class, 1, 1);
        Assertions.assertExpect(ClimbingStairs.class, 2, 2);
        Assertions.assertExpect(ClimbingStairs.class, 21, 7);
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
