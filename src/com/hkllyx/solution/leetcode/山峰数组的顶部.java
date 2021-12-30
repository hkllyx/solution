package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;

/**
 * @author xiaoyong3
 * @date 2021/10/14
 */
@Solution(no = "剑指 Offer II 069", difficulty = Difficulty.SIMPLE, url = "https://leetcode-cn.com/problems/B1IidL/")
public class 山峰数组的顶部 {

    public int peakIndexInMountainArray(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            if (arr[i] < arr[j]) {
                return j;
            }
        }
        return 0;
    }
}
