package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

/**
 * <p>You are given an <code>n x n</code> 2D <code>matrix</code> representing an image, rotate the image by <strong>90</strong> degrees (clockwise).</p>
 *
 * <p>You have to rotate the image <a href="https://en.wikipedia.org/wiki/In-place_algorithm" target="_blank"><strong>in-place</strong></a>, which means you have to modify the input 2D matrix directly. <strong>DO NOT</strong> allocate another 2D matrix and do the rotation.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/08/28/mat1.jpg" style="width: 500px; height: 188px;" />
 * <pre>
 * <strong>Input:</strong> matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * <strong>Output:</strong> [[7,4,1],[8,5,2],[9,6,3]]
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/08/28/mat2.jpg" style="width: 500px; height: 201px;" />
 * <pre>
 * <strong>Input:</strong> matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
 * <strong>Output:</strong> [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>n == matrix.length == matrix[i].length</code></li>
 * 	<li><code>1 &lt;= n &lt;= 20</code></li>
 * 	<li><code>-1000 &lt;= matrix[i][j] &lt;= 1000</code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>数组</li><li>数学</li><li>矩阵</li></div></div><br><div><li>👍 1202</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2022/03/11
 */
@Solution(no = "48", title = "Rotate Image", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/rotate-image/")
public class RotateImage {

    public static void main(String[] args) {
        Assertions.assertExpect(new int[][]{{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}},
                (Object) new int[][]{{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}});
        Assertions.assertExpect(new int[][]{{7, 4, 1}, {8, 5, 2}, {9, 6, 3}},
                (Object) new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
    }

    @Test
    public int[][] rotate(int[][] matrix) {
        for (int s = 0, e = matrix.length - 1; s < e; s++, e--) {
            for (int i = s, j = e; i < e; i++, j--) {
                int tmp = matrix[s][i];
                matrix[s][i] = matrix[j][s];
                matrix[j][s] = matrix[e][j];
                matrix[e][j] = matrix[i][e];
                matrix[i][e] = tmp;
            }
        }
        return matrix;
    }
}
