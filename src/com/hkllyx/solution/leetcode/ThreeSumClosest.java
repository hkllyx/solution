package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

import java.util.Arrays;

/**
 * <p>Given an integer array <code>nums</code> of length <code>n</code> and an integer <code>target</code>, find three integers in <code>nums</code> such that the sum is closest to <code>target</code>.</p>
 *
 * <p>Return <em>the sum of the three integers</em>.</p>
 *
 * <p>You may assume that each input would have exactly one solution.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> nums = [-1,2,1,-4], target = 1
 * <strong>Output:</strong> 2
 * <strong>Explanation:</strong> The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> nums = [0,0,0], target = 1
 * <strong>Output:</strong> 0
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>3 &lt;= nums.length &lt;= 1000</code></li>
 * 	<li><code>-1000 &lt;= nums[i] &lt;= 1000</code></li>
 * 	<li><code>-10<sup>4</sup> &lt;= target &lt;= 10<sup>4</sup></code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>数组</li><li>双指针</li><li>排序</li></div></div><br><div><li>👍 993</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2021/05/13
 */
@Solution(no = "16", title = "3Sum Closest", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/3sum-closest/")
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
