package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Test;

/**
 * <p>Given an integer array <code>nums</code>, find the contiguous subarray (containing at least one number) which has the largest sum and return <em>its sum</em>.</p>
 *
 * <p>A <strong>subarray</strong> is a <strong>contiguous</strong> part of an array.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> nums = [-2,1,-3,4,-1,2,1,-5,4]
 * <strong>Output:</strong> 6
 * <strong>Explanation:</strong> [4,-1,2,1] has the largest sum = 6.
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> nums = [1]
 * <strong>Output:</strong> 1
 * </pre>
 *
 * <p><strong>Example 3:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> nums = [5,4,-1,7,8]
 * <strong>Output:</strong> 23
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
 * 	<li><code>-10<sup>4</sup> &lt;= nums[i] &lt;= 10<sup>4</sup></code></li>
 * </ul>
 *
 * <p>&nbsp;</p>
 * <p><strong>Follow up:</strong> If you have figured out the <code>O(n)</code> solution, try coding another solution using the <strong>divide and conquer</strong> approach, which is more subtle.</p>
 * <div><div>Related Topics</div><div><li>数组</li><li>分治</li><li>动态规划</li></div></div><br><div><li>👍 4166</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2021/11/17
 */
@Solution(no = "53", difficulty = Difficulty.EASY, url = "https://leetcode-cn.com/problems/maximum-subarray/")
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
