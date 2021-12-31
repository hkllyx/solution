package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;

/**
 * <p>输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre><strong>输入：</strong>matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * <strong>输出：</strong>[1,2,3,6,9,8,7,4,5]
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre><strong>输入：</strong>matrix =&nbsp;[[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * <strong>输出：</strong>[1,2,3,4,8,12,11,10,9,5,6,7]
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>限制：</strong></p>
 *
 * <ul>
 * 	<li><code>0 &lt;= matrix.length &lt;= 100</code></li>
 * 	<li><code>0 &lt;= matrix[i].length&nbsp;&lt;= 100</code></li>
 * </ul>
 *
 * <p>注意：本题与主站 54 题相同：<a href="https://leetcode-cn.com/problems/spiral-matrix/">https://leetcode-cn.com/problems/spiral-matrix/</a></p>
 * <div><div>Related Topics</div><div><li>数组</li><li>矩阵</li><li>模拟</li></div></div><br><div><li>👍 330</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2021/06/07
 */
@Solution(no = "剑指 Offer 29", difficulty = Difficulty.SIMPLE, url = "https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/")
public class 顺时针打印矩阵 extends SpiralMatrix {

    public int[] spiralOrder1(int[][] matrix) {
        int wt, ht;
        if ((ht = matrix.length) <= 0 || (wt = matrix[0].length) <= 0) {
            return new int[0];
        }
        int[] res = new int[wt-- * ht--];
        int p = 0, wf = 0, hf = 0, step = 1;
        while ((wf - wt) * step <= 0 && (hf - ht) * step <= 0) {
            for (int w = wf; (wt - w) * step > 0; w = w + step) {
                res[p++] = matrix[hf][w];
            }
            for (int h = hf; (ht - h) * step >= 0; h = h + step) {
                res[p++] = matrix[h][wt];
            }
            int tmp = wf;
            wf = wt - step;
            wt = tmp;
            tmp = hf;
            hf = ht;
            ht = tmp + step;
            step = -step;
        }
        return res;
    }
}
