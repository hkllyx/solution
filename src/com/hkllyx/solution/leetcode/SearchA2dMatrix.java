package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

/**
 * <p>Write an efficient algorithm that searches for a value in an <code>m x n</code> matrix. This matrix has the following properties:</p>
 *
 * <ul>
 * 	<li>Integers in each row are sorted from left to right.</li>
 * 	<li>The first integer of each row is greater than the last integer of the previous row.</li>
 * </ul>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/10/05/mat.jpg" style="width: 322px; height: 242px;" />
 * <pre>
 * <strong>Input:</strong> matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * <strong>Output:</strong> true
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/10/05/mat2.jpg" style="width: 322px; height: 242px;" />
 * <pre>
 * <strong>Input:</strong> matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * <strong>Output:</strong> false
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>m == matrix.length</code></li>
 * 	<li><code>n == matrix[i].length</code></li>
 * 	<li><code>1 &lt;= m, n &lt;= 100</code></li>
 * 	<li><code>-10<sup>4</sup> &lt;= matrix[i][j], target &lt;= 10<sup>4</sup></code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>数组</li><li>二分查找</li><li>矩阵</li></div></div><br><div><li>👍 555</li><li>👎 0</li></div>
 *
 * @author hkllyx
 * @date 2021/03/30
 */
@Solution(no = "74", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/search-a-2d-matrix/")
public class SearchA2dMatrix {

    public static void main(String[] args) {
        Assertions.assertExpect(SearchA2dMatrix.class, true,
                new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}},
                30);
        Assertions.assertExpect(SearchA2dMatrix.class, true, new int[][]{{1}, {3}}, 3);
        Assertions.assertExpect(SearchA2dMatrix.class, true,
                new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}},
                3);
        Assertions.assertExpect(
                SearchA2dMatrix.class, false, new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}},
                13);
    }

    /**
     * 先找出行，再找出列
     */
    @Test
    public boolean searchMatrix(int[][] matrix, int target) {
        int maxRow = matrix.length - 1;
        int maxCol = matrix[0].length - 1;
        if (target < matrix[0][0] || target > matrix[maxRow][maxCol]) {
            return false;
        }
        int row = 0;
        for (int i = 1; i <= maxRow; i++) {
            int cur = matrix[i][0];
            if (cur == target) {
                return true;
            } else if (cur < target) {
                row = i;
            } else {
                break;
            }
        }
        for (int i = 0; i <= maxCol; i++) {
            int cur = matrix[row][i];
            if (cur == target) {
                return true;
            } else if (cur > target) {
                return false;
            }
        }
        return false;
    }
}
