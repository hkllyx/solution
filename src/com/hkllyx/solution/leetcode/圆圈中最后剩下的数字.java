package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.info.Status;

/**
 * <p>0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字（删除后从下一个数字开始计数）。求出这个圆圈里剩下的最后一个数字。</p>
 *
 * <p>例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。</p>
 *
 * <p> </p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入:</strong> n = 5, m = 3
 * <strong>输出: </strong>3
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入:</strong> n = 10, m = 17
 * <strong>输出: </strong>2
 * </pre>
 *
 * <p> </p>
 *
 * <p><strong>限制：</strong></p>
 *
 * <ul>
 * 	<li><code>1 <= n <= 10^5</code></li>
 * 	<li><code>1 <= m <= 10^6</code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>递归</li><li>数学</li></div></div><br><div><li>👍 516</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2022/01/19
 */
@Solution(no = "剑指 Offer 62", title = "圆圈中最后剩下的数字", difficulty = Difficulty.EASY, url = "https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/", status = Status.HELPED)
public class 圆圈中最后剩下的数字 {

    /** 看不懂，小丑竟是我自己 */
    public int lastRemaining(int n, int m) {
        return n == 1 ? 0 : (lastRemaining(n - 1, m) + m) % n;
    }

    /** 迭代 代替 递归 */
    public int lastRemaining2(int n, int m) {
        int r = 0;
        for (int i = 2; i != n + 1; i++) {
            r = (r + m) % i;
        }
        return r;
    }
}
