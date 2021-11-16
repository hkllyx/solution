package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Test;

import java.util.Arrays;

/**
 * @author xiaoyong3
 * @date 2021/11/16
 */
@Solution(no = "169", difficulty = Difficulty.SIMPLE, url = "https://leetcode-cn.com/problems/majority-element/")
public class MajorityElement {

    @Test(value = "排序", active = false)
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length >> 1];
    }

    @Test(value = "Boyer-Moore投票算法")
    public int majorityElement1(int[] nums) {
        int n = -1, count = 0;
        for (int num : nums) {
            // 如果n不是超过一半的数，超过一半的数可以将这些数的count抵消还有余
            // 最后n就一定是超过一半的数
            if (count == 0) {
                n = num;
            }
            count += n == num ? 1 : -1;
        }
        return n;
    }
}
