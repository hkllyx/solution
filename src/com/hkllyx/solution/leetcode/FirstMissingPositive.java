package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.ops.ArrayOps;
import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

/**
 * <p>Given an unsorted integer array <code>nums</code>, return the smallest missing positive integer.</p>
 *
 * <p>You must implement an algorithm that runs in <code>O(n)</code> time and uses constant extra space.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 * <pre><strong>Input:</strong> nums = [1,2,0]
 * <strong>Output:</strong> 3
 * </pre><p><strong>Example 2:</strong></p>
 * <pre><strong>Input:</strong> nums = [3,4,-1,1]
 * <strong>Output:</strong> 2
 * </pre><p><strong>Example 3:</strong></p>
 * <pre><strong>Input:</strong> nums = [7,8,9,11,12]
 * <strong>Output:</strong> 1
 * </pre>
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= nums.length &lt;= 5 * 10<sup>5</sup></code></li>
 * 	<li><code>-2<sup>31</sup> &lt;= nums[i] &lt;= 2<sup>31</sup> - 1</code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>数组</li><li>哈希表</li></div></div><br><div><li>👍 1347</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2022/02/19
 */
@Solution(no = "41", title = "First Missing Positive", difficulty = Difficulty.HARD, url = "https://leetcode-cn.com/problems/first-missing-positive/")
public class FirstMissingPositive implements ArrayOps {

    public static void main(String[] args) {
        Assertions.assertExpect(2, (Object) new int[]{1, 1});
        Assertions.assertExpect(1, (Object) new int[]{-1, 3, 4});
        Assertions.assertExpect(3, (Object) new int[]{1, 2, 0});
        Assertions.assertExpect(2, (Object) new int[]{3, 4, -1, 1});
        Assertions.assertExpect(1, (Object) new int[]{7, 8, 9, 10, 11});
        Assertions.assertExpect(5, (Object) new int[]{1, 2, 3, 4});
    }

    @Test
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = nums[i] - 1; i != j && j >= 0 && j < len && nums[i] != nums[j]; j = nums[i] - 1) {
            // while (nums[i] > 0 && nums[i] <= len && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return len + 1;
    }
}
