package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.Test;
import com.hkllyx.solution.util.TestUtils;
import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xiaoyong3
 * @date 2021/06/05
 */
@Solution(no = "54", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/spiral-matrix/")
public class SpiralMatrix {

    public static void main(String[] args) {
        TestUtils.assertion(SpiralMatrix.class, Arrays.asList(1, 2), (Object) new int[][]{{1, 2}});
        TestUtils.assertion(SpiralMatrix.class, Arrays.asList(1, 2), (Object) new int[][]{{1}, {2}});
        TestUtils.assertion(SpiralMatrix.class, Arrays.asList(1, 2, 3, 6, 9, 8, 7, 4, 5),
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
}
