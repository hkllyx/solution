package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;

/**
 * <p>给你一根长度为 <code>n</code> 的绳子，请把绳子剪成整数长度的 <code>m</code> 段（m、n都是整数，n&gt;1并且m&gt;1），每段绳子的长度记为 <code>k[0],k[1]...k[m-1]</code> 。请问 <code>k[0]*k[1]*...*k[m-1]</code> 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre><strong>输入: </strong>2
 * <strong>输出: </strong>1
 * <strong>解释: </strong>2 = 1 + 1, 1 &times; 1 = 1</pre>
 *
 * <p><strong>示例&nbsp;2:</strong></p>
 *
 * <pre><strong>输入: </strong>10
 * <strong>输出: </strong>36
 * <strong>解释: </strong>10 = 3 + 3 + 4, 3 &times;&nbsp;3 &times;&nbsp;4 = 36</pre>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * 	<li><code>2 &lt;= n &lt;= 58</code></li>
 * </ul>
 *
 * <p>注意：本题与主站 343 题相同：<a href="https://leetcode-cn.com/problems/integer-break/">https://leetcode-cn.com/problems/integer-break/</a></p>
 * <div><div>Related Topics</div><div><li>数学</li><li>动态规划</li></div></div><br><div><li>👍 339</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2021/05/27
 */
@Solution(no = "剑指 Offer 14-I", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/jian-sheng-zi-lcof/")
public class 剪绳子 extends IntegerBreak {
}
