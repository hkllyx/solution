package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.Test;
import com.hkllyx.solution.util.TestUtils;
import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;

/**
 * @author xiaoyong3
 * @date 2021/08/09
 */
@Solution(no = "1337", difficulty = Difficulty.SIMPLE, url = "https://leetcode-cn.com/problems/the-k-weakest-rows-in-a-matrix/")
public class TheKWeakestRowsInAMatrix {

    public static void main(String[] args) {
        TestUtils.assertion(TheKWeakestRowsInAMatrix.class, new int[]{2, 0, 3},
                new int[][]{{1, 1, 0, 0, 0},
                        {1, 1, 1, 1, 0},
                        {1, 0, 0, 0, 0},
                        {1, 1, 0, 0, 0},
                        {1, 1, 1, 1, 1}},
                3);
    }

    @Test
    public int[] kWeakestRows(int[][] mat, int k) {
        if (k < 1) {
            return new int[0];
        }
        int[][] res = new int[2][k--];
        int n = -1;
        for (int i = 0, matLength = mat.length; i < matLength; i++) {
            int sum = 0;
            for (int cell : mat[i]) {
                sum += cell;
            }
            int j = n;
            while (j >= 0 && res[1][j] > sum) {
                if (j < k) {
                    res[0][j + 1] = res[0][j];
                    res[1][j + 1] = res[1][j];
                }
                j--;
            }
            if (++j <= k) {
                res[0][j] = i;
                res[1][j] = sum;
            }
            if (n < k) {
                n++;
            }
        }
        return res[0];
    }
}
