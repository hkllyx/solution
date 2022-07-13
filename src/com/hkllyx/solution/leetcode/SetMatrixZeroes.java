package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

/**
 * <p>Given an <code>m x n</code> integer matrix <code>matrix</code>, if an element is <code>0</code>, set its entire row and column to <code>0</code>&#39;s.</p>
 *
 * <p>You must do it <a href="https://en.wikipedia.org/wiki/In-place_algorithm" target="_blank">in place</a>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/08/17/mat1.jpg" style="width: 450px; height: 169px;" />
 * <pre>
 * <strong>Input:</strong> matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * <strong>Output:</strong> [[1,0,1],[0,0,0],[1,0,1]]
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/08/17/mat2.jpg" style="width: 450px; height: 137px;" />
 * <pre>
 * <strong>Input:</strong> matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 * <strong>Output:</strong> [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>m == matrix.length</code></li>
 * 	<li><code>n == matrix[0].length</code></li>
 * 	<li><code>1 &lt;= m, n &lt;= 200</code></li>
 * 	<li><code>-2<sup>31</sup> &lt;= matrix[i][j] &lt;= 2<sup>31</sup> - 1</code></li>
 * </ul>
 *
 * <p>&nbsp;</p>
 * <p><strong>Follow up:</strong></p>
 *
 * <ul>
 * 	<li>A straightforward solution using <code>O(mn)</code> space is probably a bad idea.</li>
 * 	<li>A simple improvement uses <code>O(m + n)</code> space, but still not the best solution.</li>
 * 	<li>Could you devise a constant space solution?</li>
 * </ul>
 * <div><div>Related Topics</div><div><li>数组</li><li>哈希表</li><li>矩阵</li></div></div><br><div><li>👍 739</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2022/07/07
 */
@Solution(no = "73", title = "Set Matrix Zeroes", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/set-matrix-zeroes/")
public class SetMatrixZeroes {

    public static void main(String[] args) {
        Assertions.assertExpect(new int[0][0], (Object) new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}});
    }

    @Test
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        // 第一列是否要置0
        boolean firstCol = false;
        for (int[] row : matrix) {
            if (row[0] == 0) {
                firstCol = true;
                break;
            }
        }
        // 用第一行、列记录哪些行、列有0
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        // 填充0
        for (int j = 1; j < n; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i < m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (firstCol) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
