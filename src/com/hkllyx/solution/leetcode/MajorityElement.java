package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Test;

import java.util.Arrays;

/**
 * <p>Given an array <code>nums</code> of size <code>n</code>, return <em>the majority element</em>.</p>
 *
 * <p>The majority element is the element that appears more than <code>&lfloor;n / 2&rfloor;</code> times. You may assume that the majority element always exists in the array.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 * <pre><strong>Input:</strong> nums = [3,2,3]
 * <strong>Output:</strong> 3
 * </pre><p><strong>Example 2:</strong></p>
 * <pre><strong>Input:</strong> nums = [2,2,1,1,1,2,2]
 * <strong>Output:</strong> 2
 * </pre>
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>n == nums.length</code></li>
 * 	<li><code>1 &lt;= n &lt;= 5 * 10<sup>4</sup></code></li>
 * 	<li><code>-2<sup>31</sup> &lt;= nums[i] &lt;= 2<sup>31</sup> - 1</code></li>
 * </ul>
 *
 * <p>&nbsp;</p>
 * <strong>Follow-up:</strong> Could you solve the problem in linear time and in <code>O(1)</code> space?<div><div>Related Topics</div><div><li>数组</li><li>哈希表</li><li>分治</li><li>计数</li><li>排序</li></div></div><br><div><li>👍 1255</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2021/11/16
 */
@Solution(no = "169", difficulty = Difficulty.EASY, url = "https://leetcode-cn.com/problems/majority-element/")
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
