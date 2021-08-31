package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Test;
import com.hkllyx.solution.util.test.TestUtils;

/**
 * @author xiaoyong3
 * @date 2021/05/24
 */
@Solution(no = "153", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/")
public class FindMinimumInRotatedSortedArray {

    public static void main(String[] args) {
        TestUtils.assertion(FindMinimumInRotatedSortedArray.class, 1, new int[]{3, 4, 5, 1, 2});
        TestUtils.assertion(FindMinimumInRotatedSortedArray.class, 1, new int[]{3, 1});
        TestUtils.assertion(FindMinimumInRotatedSortedArray.class, 1, new int[]{1, 3});
        TestUtils.assertion(FindMinimumInRotatedSortedArray.class, 1, new int[]{1});
    }

    @Test
    public int findMin(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int head = nums[i], tail = nums[j];
            if (head <= tail) {
                return head;
            } else {
                int m = (i + j) >> 1;
                if (head <= nums[m]) {
                    i = m + 1;
                } else {
                    j = m;
                }
            }
        }
        return nums[i];
    }
}
