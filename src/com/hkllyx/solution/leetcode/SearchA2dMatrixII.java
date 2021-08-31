package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Test;
import com.hkllyx.solution.util.test.TestUtils;

/**
 * @author xiaoyong3
 * @date 2021/05/24
 */
@Solution(no = "240", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/search-a-2d-matrix-ii/")
public class SearchA2dMatrixII {

    public static void main(String[] args) {
        TestUtils.assertion(SearchA2dMatrixII.class, true, new int[][]{{1, 1}}, 1);
        TestUtils.assertion(SearchA2dMatrixII.class, true, new int[][]{{-5}}, -5);
        TestUtils.assertion(SearchA2dMatrixII.class, false, new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}}, 20);
        TestUtils.assertion(SearchA2dMatrixII.class, true, new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}}, 5);
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
