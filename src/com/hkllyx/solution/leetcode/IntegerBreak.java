package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

/**
 * <p>Given an integer <code>n</code>, break it into the sum of <code>k</code> <strong>positive integers</strong>, where <code>k &gt;= 2</code>, and maximize the product of those integers.</p>
 *
 * <p>Return <em>the maximum product you can get</em>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> n = 2
 * <strong>Output:</strong> 1
 * <strong>Explanation:</strong> 2 = 1 + 1, 1 &times; 1 = 1.
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> n = 10
 * <strong>Output:</strong> 36
 * <strong>Explanation:</strong> 10 = 3 + 3 + 4, 3 &times; 3 &times; 4 = 36.
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>2 &lt;= n &lt;= 58</code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>数学</li><li>动态规划</li></div></div><br><div><li>👍 664</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2021/05/27
 */
@Solution(no = "343", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/integer-break/")
public class IntegerBreak {

    public static void main(String[] args) {
        Assertions.assertExpect(IntegerBreak.class, 36, 1000);
    }

    public int integerBreak(int n) {
        long[] res = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            res[i] = i == n ? i - 1 : i;
            for (int j = 1; j <= i >> 1; j++) {
                res[i] = Math.max(res[i], res[j] * res[i - j]) % 1000000007;
            }
        }
        return (int) res[n];
    }

    /**
     * 数学分析nb
     */
    @Test
    public int integerBreak1(int n) {
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        int a = n / 3;
        int b = n % 3;
        if (b == 0) {
            return (int) Math.pow(3, a) % 1000000007;
        } else if (b == 1) {
            return (int) ((long) Math.pow(3, a - 1) * 4) % 1000000007;
        } else {
            return (int) ((long) Math.pow(3, a) * 2) % 1000000007;
        }
    }
}
