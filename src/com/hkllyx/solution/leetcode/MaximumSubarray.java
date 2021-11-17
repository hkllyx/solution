package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Test;

/**
 * @author xiaoyong3
 * @date 2021/11/17
 */
@Solution(no = "53", difficulty = Difficulty.SIMPLE, url = "https://leetcode-cn.com/problems/maximum-subarray/")
public class MaximumSubarray {

    @Test(value = "DP", mills = 2, memory = 48.6)
    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // f(i) = max(f(i - 1) + nums[i], nums[i])
            int pre = nums[i - 1];
            if (pre > 0) {
                nums[i] += pre;
            }
            ans = Math.max(ans, nums[i]);
        }
        return ans;
    }
}
