package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.info.Difficulty;
import com.hkllyx.solution.info.Solution;
import com.hkllyx.solution.util.Test;
import com.hkllyx.solution.util.TestUtils;

import java.util.Arrays;

/**
 * @author xiaoyong3
 * @date 2021/06/28
 */
@Solution(no = "剑指 Offer 40", difficulty = Difficulty.SIMPLE, url = "https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/")
public class 最小的k个数 {

    public static void main(String[] args) {
        TestUtils.assertion(最小的k个数.class,
                new int[]{},
                new int[]{3, 2, 1},
                2);
    }

    /** 选择 */
    @Deprecated
    public int[] getLeastNumbers(int[] arr, int k) {
        for (int i = 0; i < k; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    swap(arr, i, j);
                }
            }
        }
        return Arrays.copyOf(arr, k);
    }

    /** 完整快排 */
    public int[] getLeastNumbers1(int[] arr, int k) {
        quickSort(arr, 0, arr.length - 1);
        return Arrays.copyOf(arr, k);
    }

    private void quickSort(int[] arr, int l, int r) {
        if (r - l < 1) {
            return;
        }
        int i = l;
        for (int j = l; j < r; j++) {
            if (arr[j] < arr[r]) {
                swap(arr, i++, j);
            }
        }
        swap(arr, i, r);
        quickSort(arr, l, i - 1);
        quickSort(arr, i + 1, r);
    }

    /** 快排变形 */
    @Test
    public int[] getLeastNumbers2(int[] arr, int k) {
        int l = 0, r = arr.length - 1, p = 0;
        while (k != p) {
            p = partition(arr, l, r);
            if (p < k) {
                l = p + 1;
            } else {
                r = p - 1;
            }
        }
        return Arrays.copyOf(arr, k);
    }

    private int partition(int[] arr, int l, int r) {
        if (l >= r) {
            return l;
        }
        int i = l;
        for (int j = l; j < r; j++) {
            if (arr[j] < arr[r]) {
                swap(arr, i++, j);
            }
        }
        swap(arr, i, r);
        return i;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}
