package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

/**
 * <p>Write an efficient algorithm that searches for a <code>target</code> value in an <code>m x n</code> integer <code>matrix</code>. The <code>matrix</code> has the following properties:</p>
 *
 * <ul>
 * 	<li>Integers in each row are sorted in ascending from left to right.</li>
 * 	<li>Integers in each column are sorted in ascending from top to bottom.</li>
 * </ul>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/11/24/searchgrid2.jpg" style="width: 300px; height: 300px;" />
 * <pre>
 * <strong>Input:</strong> matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
 * <strong>Output:</strong> true
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/11/24/searchgrid.jpg" style="width: 300px; height: 300px;" />
 * <pre>
 * <strong>Input:</strong> matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
 * <strong>Output:</strong> false
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>m == matrix.length</code></li>
 * 	<li><code>n == matrix[i].length</code></li>
 * 	<li><code>1 &lt;= n, m &lt;= 300</code></li>
 * 	<li><code>-10<sup>9</sup> &lt;= matrix[i][j] &lt;= 10<sup>9</sup></code></li>
 * 	<li>All the integers in each row are <strong>sorted</strong> in ascending order.</li>
 * 	<li>All the integers in each column are <strong>sorted</strong> in ascending order.</li>
 * 	<li><code>-10<sup>9</sup> &lt;= target &lt;= 10<sup>9</sup></code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>数组</li><li>二分查找</li><li>分治</li><li>矩阵</li></div></div><br><div><li>👍 896</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2021/05/24
 */
@Solution(no = "240", title = "Search a 2D Matrix II", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/search-a-2d-matrix-ii/")
public class SearchA2dMatrixII {

    public static void main(String[] args) {
        Assertions.assertExpect(SearchA2dMatrixII.class, true, new int[][]{{1, 1}}, 1);
        Assertions.assertExpect(SearchA2dMatrixII.class, true, new int[][]{{-5}}, -5);
        Assertions.assertExpect(SearchA2dMatrixII.class, false,
                new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24},
                        {18, 21, 23, 26, 30}}, 20);
        Assertions.assertExpect(SearchA2dMatrixII.class, true,
                new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24},
                        {18, 21, 23, 26, 30}}, 5);
    }

    @Test
    public boolean searchMatrix(int[][] matrix, int target) {
        int w, h;
        if ((h = matrix.length - 1) < 0 || (w = matrix[0].length - 1) < 0) {
            return false;
        }
        for (int r = 0; r <= h; r++) {
            if (matrix[r][0] > target) {
                break;
            }
            if (matrix[r][w] < target) {
                continue;
            }
            for (int c = 0; c <= w; ) {
                int m, medium;
                if ((medium = matrix[r][(m = (c + w) >> 1)]) == target) {
                    return true;
                } else if (medium < target) {
                    c = m + 1;
                } else {
                    w = m - 1;
                }
            }
        }
        return false;
    }
}
