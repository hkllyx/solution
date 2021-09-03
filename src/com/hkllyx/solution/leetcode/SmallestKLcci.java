package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Test;
import com.hkllyx.solution.util.test.TestUtils;

import java.util.Arrays;

/**
 * @author xiaoyong3
 * @date 2021/09/03
 */
@Solution(no = "面试题17.14", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/smallest-k-lcci/")
public class SmallestKLcci extends 最小的k个数 {

    public static void main(String[] args) {
        TestUtils.assertion(new int[]{1, 2, 3, 4}, new int[]{1, 3, 5, 7, 2, 4, 6, 8}, 4);
    }

    @Test
    public int[] smallestK(int[] arr, int k) {
        quickSort(arr, 0, arr.length - 1, k);
        return Arrays.copyOf(arr, k);
    }

    private void quickSort(int[] arr, int from, int to, int k) {
        if (from >= to) {
            return;
        }
        int tail = arr[to], i = from;
        for (int j = from; j < to; j++) {
            if (arr[j] < tail) {
                swap(arr, i++, j);
            }
        }
        swap(arr, i, to);
        if (i > k) {
            quickSort(arr, from, i - 1, k);
        } else if (i < k) {
            quickSort(arr, i + 1, to, k);
        }
    }
}
