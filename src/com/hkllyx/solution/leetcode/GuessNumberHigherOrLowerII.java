package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.info.Status;
import com.hkllyx.solution.util.test.Test;

/**
 * <p>We are playing the Guessing Game. The game will work as follows:</p>
 *
 * <ol>
 * 	<li>I pick a number between&nbsp;<code>1</code>&nbsp;and&nbsp;<code>n</code>.</li>
 * 	<li>You guess a number.</li>
 * 	<li>If you guess the right number, <strong>you win the game</strong>.</li>
 * 	<li>If you guess the wrong number, then I will tell you whether the number I picked is <strong>higher or lower</strong>, and you will continue guessing.</li>
 * 	<li>Every time you guess a wrong number&nbsp;<code>x</code>, you will pay&nbsp;<code>x</code>&nbsp;dollars. If you run out of money, <strong>you lose the game</strong>.</li>
 * </ol>
 *
 * <p>Given a particular&nbsp;<code>n</code>, return&nbsp;<em>the minimum amount of money you need to&nbsp;<strong>guarantee a win regardless of what number I pick</strong></em>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/09/10/graph.png" style="width: 505px; height: 388px;" />
 * <pre>
 * <strong>Input:</strong> n = 10
 * <strong>Output:</strong> 16
 * <strong>Explanation:</strong> The winning strategy is as follows:
 * - The range is [1,10]. Guess 7.
 * &nbsp;   - If this is my number, your total is $0. Otherwise, you pay $7.
 * &nbsp;   - If my number is higher, the range is [8,10]. Guess 9.
 * &nbsp;       - If this is my number, your total is $7. Otherwise, you pay $9.
 * &nbsp;       - If my number is higher, it must be 10. Guess 10. Your total is $7 + $9 = $16.
 * &nbsp;       - If my number is lower, it must be 8. Guess 8. Your total is $7 + $9 = $16.
 * &nbsp;   - If my number is lower, the range is [1,6]. Guess 3.
 * &nbsp;       - If this is my number, your total is $7. Otherwise, you pay $3.
 * &nbsp;       - If my number is higher, the range is [4,6]. Guess 5.
 * &nbsp;           - If this is my number, your total is $7 + $3 = $10. Otherwise, you pay $5.
 * &nbsp;           - If my number is higher, it must be 6. Guess 6. Your total is $7 + $3 + $5 = $15.
 * &nbsp;           - If my number is lower, it must be 4. Guess 4. Your total is $7 + $3 + $5 = $15.
 * &nbsp;       - If my number is lower, the range is [1,2]. Guess 1.
 * &nbsp;           - If this is my number, your total is $7 + $3 = $10. Otherwise, you pay $1.
 * &nbsp;           - If my number is higher, it must be 2. Guess 2. Your total is $7 + $3 + $1 = $11.
 * The worst case in all these scenarios is that you pay $16. Hence, you only need $16 to guarantee a win.
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> n = 1
 * <strong>Output:</strong> 0
 * <strong>Explanation:</strong>&nbsp;There is only one possible number, so you can guess 1 and not have to pay anything.
 * </pre>
 *
 * <p><strong>Example 3:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> n = 2
 * <strong>Output:</strong> 1
 * <strong>Explanation:</strong>&nbsp;There are two possible numbers, 1 and 2.
 * - Guess 1.
 * &nbsp;   - If this is my number, your total is $0. Otherwise, you pay $1.
 * &nbsp;   - If my number is higher, it must be 2. Guess 2. Your total is $1.
 * The worst case is that you pay $1.
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= n &lt;= 200</code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>数学</li><li>动态规划</li><li>博弈</li></div></div><br><div><li>👍 452</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2021/11/12
 */
@Solution(no = "375", title = "Guess Number Higher or Lower II", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/guess-number-higher-or-lower-ii/", status = Status.HELPED)
public class GuessNumberHigherOrLowerII {

    @Test(value = "区间DP", mills = 22, memory = 36.8)
    public int getMoneyAmount(int n) {
        // dp[i][j]表示可以保证可以猜到i ~ j（包括i、j）任意数字的最小费用
        int[][] dp = new int[n + 2][n + 2];
        // diff = j - i
        for (int diff = 1; diff < n; diff++) {
            for (int i = 1, up = n - diff; i <= up; i++) {
                int j = i + diff;
                dp[i][j] = Integer.MAX_VALUE;
                // 第一步猜k，则此时最小费用为k加上dp[i][k - 1]、dp[k + 1][j]中的更大值
                for (int k = i; k <= j; k++) {
                    int cur = k + Math.max(dp[i][k - 1], dp[k + 1][j]);
                    dp[i][j] = Math.min(dp[i][j], cur);
                }
            }
        }
        return dp[1][n];
    }
}
