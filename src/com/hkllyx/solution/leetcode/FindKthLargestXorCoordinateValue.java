package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.Test;
import com.hkllyx.solution.util.TestUtils;
import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;

import java.util.Arrays;

/**
 * @author xiaoyong3
 * @date 2021/05/20
 */
@Solution(no = "1738", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/find-kth-largest-xor-coordinate-value/")
public class FindKthLargestXorCoordinateValue {

    public static void main(String[] args) {
        TestUtils.assertion(FindKthLargestXorCoordinateValue.class, 7, new int[][]{{5, 2}, {1, 6}}, 1);
    }

    @Test
    public int kthLargestValue(int[][] matrix, int k) {
        int width, height;
        if ((height = matrix.length) <= 0 || (width = matrix[0].length) <= 0) {
            return 0;
        }
        int[] arr = new int[width * height];
        int n = 0;
        arr[n++] = matrix[0][0];
        for (int i = 1; i < height; i++) {
            arr[n++] = (matrix[i][0] ^= matrix[i - 1][0]);
        }
        for (int j = 1; j < width; j++) {
            arr[n++] = (matrix[0][j] ^= matrix[0][j - 1]);
        }
        for (int i = 1; i < height; i++) {
            for (int j = 1; j < width; j++) {
                arr[n++] = (matrix[i][j] ^= (matrix[i - 1][j] ^ matrix[i][j - 1] ^ matrix[i - 1][j - 1]));
            }
        }
        Arrays.sort(arr);
        return arr[arr.length - k];
    }
}
