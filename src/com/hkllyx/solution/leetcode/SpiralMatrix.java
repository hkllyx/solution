package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Given an <code>m x n</code> <code>matrix</code>, return <em>all elements of the</em> <code>matrix</code> <em>in spiral order</em>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/11/13/spiral1.jpg" style="width: 242px; height: 242px;" />
 * <pre>
 * <strong>Input:</strong> matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * <strong>Output:</strong> [1,2,3,6,9,8,7,4,5]
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/11/13/spiral.jpg" style="width: 322px; height: 242px;" />
 * <pre>
 * <strong>Input:</strong> matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * <strong>Output:</strong> [1,2,3,4,8,12,11,10,9,5,6,7]
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>m == matrix.length</code></li>
 * 	<li><code>n == matrix[i].length</code></li>
 * 	<li><code>1 &lt;= m, n &lt;= 10</code></li>
 * 	<li><code>-100 &lt;= matrix[i][j] &lt;= 100</code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>数组</li><li>矩阵</li><li>模拟</li></div></div><br><div><li>👍 949</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2021/06/05
 */
@Solution(no = "54", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/spiral-matrix/")
public class SpiralMatrix {

    public static void main(String[] args) {
        Assertions.assertExpect(SpiralMatrix.class, Arrays.asList(1, 2), (Object) new int[][]{{1, 2}});
        Assertions.assertExpect(SpiralMatrix.class, Arrays.asList(1, 2), (Object) new int[][]{{1}, {2}});
        Assertions.assertExpect(SpiralMatrix.class, Arrays.asList(1, 2, 3, 6, 9, 8, 7, 4, 5),
                (Object) new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
    }

    @Test
    public List<Integer> spiralOrder(int[][] matrix) {
        int wt, ht;
        if ((ht = matrix.length) <= 0 || (wt = matrix[0].length) <= 0) {
            return new ArrayList<>(0);
        }
        List<Integer> res = new ArrayList<>(wt-- * ht--);
        int wf = 0, hf = 0, step = 1;
        while ((wf - wt) * step <= 0 && (hf - ht) * step <= 0) {
            for (int w = wf; (wt - w) * step > 0; w = w + step) {
                res.add(matrix[hf][w]);
            }
            for (int h = hf; (ht - h) * step >= 0; h = h + step) {
                res.add(matrix[h][wt]);
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
