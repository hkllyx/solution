package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;

/**
 * @author xiaoyong3
 * @date 2021/06/07
 */
@Solution(no = "剑指Offer 29", difficulty = Difficulty.SIMPLE, url = "https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/")
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
