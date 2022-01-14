package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;

/**
 * <p>把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p>你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1:</strong></p>
 *
 * <pre><strong>输入:</strong> 1
 * <strong>输出:</strong> [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]
 * </pre>
 *
 * <p><strong>示例&nbsp;2:</strong></p>
 *
 * <pre><strong>输入:</strong> 2
 * <strong>输出:</strong> [0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0.05556,0.02778]</pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>限制：</strong></p>
 *
 * <p><code>1 &lt;= n &lt;= 11</code></p>
 * <div><div>Related Topics</div><div><li>数学</li><li>动态规划</li><li>概率与统计</li></div></div><br><div><li>👍 339</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2022/01/13
 */
@Solution(no = "剑指 Offer 60", title = "n个骰子的点数", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/nge-tou-zi-de-dian-shu-lcof/")
public class n个骰子的点数 {

    public double[] dicesProbability(int n) {
        double[][] dp = new double[n][];
        dp[0] = new double[]{1, 1, 1, 1, 1, 1};
        for (int i = 1; i < n; i++) {
            double[] pre = dp[i - 1];
            dp[i] = new double[pre.length + 5];
            for (int j = 0; j < pre.length; j++) {
                for (int k = 0; k < 6; k++) {
                    dp[i][j + k] += pre[j];
                }
            }
        }
        double[] res = dp[n - 1];
        double total = Math.pow(6, n);
        for (int i = 0; i < res.length; i++) {
            res[i] /= total;
        }
        return res;
    }
}
