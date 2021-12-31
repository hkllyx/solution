package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Test;

/**
 * <p>一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 <code>n</code>&nbsp;级的台阶总共有多少种跳法。</p>
 *
 * <p>答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre><strong>输入：</strong>n = 2
 * <strong>输出：</strong>2
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre><strong>输入：</strong>n = 7
 * <strong>输出：</strong>21
 * </pre>
 *
 * <p><strong>示例 3：</strong></p>
 *
 * <pre><strong>输入：</strong>n = 0
 * <strong>输出：</strong>1</pre>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * 	<li><code>0 &lt;= n &lt;= 100</code></li>
 * </ul>
 *
 * <p>注意：本题与主站 70 题相同：<a href="https://leetcode-cn.com/problems/climbing-stairs/">https://leetcode-cn.com/problems/climbing-stairs/</a></p>
 *
 * <p>&nbsp;</p>
 * <div><div>Related Topics</div><div><li>记忆化搜索</li><li>数学</li><li>动态规划</li></div></div><br><div><li>👍 229</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2021/05/24
 */
@Solution(no = "剑指 Offer 10-II", difficulty = Difficulty.SIMPLE, url = "https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/")
public class 青蛙跳台阶问题 extends ClimbingStairs {

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
