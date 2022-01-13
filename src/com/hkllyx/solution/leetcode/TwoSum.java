package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Given an array of integers <code>nums</code>&nbsp;and an integer <code>target</code>, return <em>indices of the two numbers such that they add up to <code>target</code></em>.</p>
 *
 * <p>You may assume that each input would have <strong><em>exactly</em> one solution</strong>, and you may not use the <em>same</em> element twice.</p>
 *
 * <p>You can return the answer in any order.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> nums = [2,7,11,15], target = 9
 * <strong>Output:</strong> [0,1]
 * <strong>Output:</strong> Because nums[0] + nums[1] == 9, we return [0, 1].
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> nums = [3,2,4], target = 6
 * <strong>Output:</strong> [1,2]
 * </pre>
 *
 * <p><strong>Example 3:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> nums = [3,3], target = 6
 * <strong>Output:</strong> [0,1]
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>2 &lt;= nums.length &lt;= 10<sup>4</sup></code></li>
 * 	<li><code>-10<sup>9</sup> &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
 * 	<li><code>-10<sup>9</sup> &lt;= target &lt;= 10<sup>9</sup></code></li>
 * 	<li><strong>Only one valid answer exists.</strong></li>
 * </ul>
 *
 * <p>&nbsp;</p>
 * <strong>Follow-up:&nbsp;</strong>Can you come up with an algorithm that is less than&nbsp;<code>O(n<sup>2</sup>)&nbsp;</code>time complexity?<div><div>Related Topics</div><div><li>数组</li><li>哈希表</li></div></div><br><div><li>👍 13060</li><li>👎 0</li></div>
 *
 * @author hkllyx
 * @date 2021/04/19
 */
@Solution(no = "1", title = "Two Sum", difficulty = Difficulty.EASY, url = "https://leetcode-cn.com/problems/two-sum/")
public class TwoSum {

    public static void main(String[] args) {
        Assertions.assertExpect(TwoSum.class, new int[]{1, 0}, new int[]{2, 7, 11, 15}, 9);
        Assertions.assertExpect(TwoSum.class, new int[]{2, 1}, new int[]{3, 2, 4}, 6);
        Assertions.assertExpect(TwoSum.class, new int[]{1, 0}, new int[]{3, 3}, 6);
    }

    @Test
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            Integer j = map.get(target - nums[i]);
            if (j == null) {
                map.put(nums[i], i);
            } else {
                return new int[]{i, j};
            }
        }
        return new int[2];
    }
}
