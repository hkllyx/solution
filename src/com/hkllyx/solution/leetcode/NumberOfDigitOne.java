package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.info.Status;

/**
 * <p>Given an integer <code>n</code>, count <em>the total number of digit </em><code>1</code><em> appearing in all non-negative integers less than or equal to</em> <code>n</code>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> n = 13
 * <strong>Output:</strong> 6
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> n = 0
 * <strong>Output:</strong> 0
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>0 &lt;= n &lt;= 10<sup>9</sup></code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>递归</li><li>数学</li><li>动态规划</li></div></div><br><div><li>👍 373</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2021/08/13
 */
@Solution(no = "233", title = "Number of Digit One", difficulty = Difficulty.HARD, url = "https://leetcode-cn.com/problems/number-of-digit-one/", status = Status.HELPED)
public class NumberOfDigitOne {

    public int countDigitOne(int n) {
        int ans = 0;
        // 完整的k+1位数为10^k ~ 10^(k+1) - 1
        // 第k+1位数为1的次数（注意，第k+1位数 > 0），以下两种情况取更小
        //     第k+1位数 > 1，为10^k
        //     第k+1位数 = 1, 为k位数大小，即 = k+1位数 - 10^k + 1
        // 循环统计第k+1位为1的次数，初始k = 0，ek表示10^k，ek1表示10^(k+1)
        long ek = 1;
        while (n >= ek) {
            long ek1 = ek * 10;
            // 出现完整k+1位数的次数 = n / 10^(k+1)
            ans += (n / ek1) * ek;
            // k+1位数 = n % ek1
            ans += Math.max(Math.min((n % ek1) - ek + 1, ek), 0);
            ek = ek1;
        }
        return ans;
    }
}
