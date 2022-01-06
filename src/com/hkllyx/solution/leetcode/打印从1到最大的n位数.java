package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;

/**
 * <p>输入数字 <code>n</code>，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。</p>
 *
 * <p><strong>示例 1:</strong></p>
 *
 * <pre><strong>输入:</strong> n = 1
 * <strong>输出:</strong> [1,2,3,4,5,6,7,8,9]
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p>说明：</p>
 *
 * <ul>
 * 	<li>用返回一个整数列表来代替打印</li>
 * 	<li>n 为正整数</li>
 * </ul>
 * <div><div>Related Topics</div><div><li>数组</li><li>数学</li></div></div><br><div><li>👍 170</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2021/06/01
 */
@Solution(no = "剑指 Offer 17", difficulty = Difficulty.EASY, url = "https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/")
public class 打印从1到最大的n位数 {

    public int[] printNumbers(int n) {
        int l = (int) Math.pow(10, n) - 1;
        int[] res = new int[l];
        for (int s = 1; s <= l; s++, l--) {
            res[s - 1] = s;
            res[l - 1] = l;
        }
        return res;
    }
}
