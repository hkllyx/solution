package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Test;
import com.hkllyx.solution.util.test.TestUtils;

/**
 * @author hkllyx
 * @date 2021/03/30
 */
@Solution(no = "74", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/search-a-2d-matrix/")
public class SearchA2dMatrix {

    public static void main(String[] args) {
        TestUtils.assertion(SearchA2dMatrix.class, true, new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}},
                30);
        TestUtils.assertion(SearchA2dMatrix.class, true, new int[][]{{1}, {3}}, 3);
        TestUtils.assertion(SearchA2dMatrix.class, true, new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}},
                3);
        TestUtils.assertion(
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
