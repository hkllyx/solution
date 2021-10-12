package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Test;
import com.hkllyx.solution.util.test.TestUtils;

/**
 * @author hkllyx
 * @date 2021-09-06
 */
@Solution(no = "704", difficulty = Difficulty.SIMPLE, url = "https://leetcode-cn.com/problems/binary-search/")
public class BinarySearch {

    public static void main(String[] args) {
        TestUtils.assertion(4, new int[]{-1, 0, 3, 5, 9, 12}, 9);
    }

    @Test
    public int search(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) >> 1;
            if (nums[m] == target) {
                return m;
            } else if (nums[m] < target) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        return -1;
    }
}
