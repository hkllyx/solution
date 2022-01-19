package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <p>Given an integer array <code>nums</code> and an integer <code>k</code>, return <code>true</code> if there are two <strong>distinct indices</strong> <code>i</code> and <code>j</code> in the array such that <code>nums[i] == nums[j]</code> and <code>abs(i - j) &lt;= k</code>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> nums = [1,2,3,1], k = 3
 * <strong>Output:</strong> true
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> nums = [1,0,1,1], k = 1
 * <strong>Output:</strong> true
 * </pre>
 *
 * <p><strong>Example 3:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> nums = [1,2,3,1,2,3], k = 2
 * <strong>Output:</strong> false
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
 * 	<li><code>-10<sup>9</sup> &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
 * 	<li><code>0 &lt;= k &lt;= 10<sup>5</sup></code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>数组</li><li>哈希表</li><li>滑动窗口</li></div></div><br><div><li>👍 415</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2022/01/19
 */
@Solution(no = "219", title = "Contains Duplicate II", difficulty = Difficulty.EASY, url = "https://leetcode-cn.com/problems/contains-duplicate-ii/")
public class ContainsDuplicateII {

    @Test(value = "hash", mills = 24, memory = 47.4, active = false)
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer pre = map.get(nums[i]);
            if (pre == null || i - pre > k) {
                map.put(nums[i], i);
            } else {
                return true;
            }
        }
        return false;
    }

    @Test(value = "hash+滑动窗口", mills = 24, memory = 47.4, active = false)
    public boolean containsNearbyDuplicate1(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            // 超出滑动窗口
            if (i > k) {
                set.remove(nums[i - k - 1]);
            }
            // 窗口内存在相同的数
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }
}
