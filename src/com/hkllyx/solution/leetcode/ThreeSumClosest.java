package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

import java.util.Arrays;

/**
 * @author xiaoyong3
 * @date 2021/05/13
 */
@Solution(no = "16", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/3sum-closest/")
public class ThreeSumClosest {

    public static void main(String[] args) {
        Assertions.assertExpect(ThreeSumClosest.class, 82, new int[]{1, 2, 4, 8, 16, 32, 64, 128}, 82);
        Assertions.assertExpect(ThreeSumClosest.class, 0, new int[]{0, 2, 1, -3}, 0);
        Assertions.assertExpect(ThreeSumClosest.class, 2, new int[]{-1, 2, 1, -4}, 1);
    }

    @Test
    public int threeSumClosest(int[] nums, int target) {
        int result = 0;
        int minDiff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        int p0 = nums[0] - 1;
        for (int i = 0; i < nums.length - 2; i++) {
            if (p0 != nums[i]) {
                int p1 = nums[i] - 1;
                for (int j = i + 1, k = nums.length - 1; j < k; ) {
                    if (p1 != nums[j]) {
                        int sum = nums[i] + nums[j] + nums[k];
                        int diff = Math.abs(target - sum);
                        if (diff == 0) {
                            return sum;
                        } else if (sum < target) {
                            p1 = nums[j++];
                        } else {
                            k--;
                        }
                        if (diff < minDiff) {
                            minDiff = diff;
                            result = sum;
                        }
                    } else {
                        j++;
                    }
                }
                p0 = nums[i];
            }
        }
        return result;
    }
}
