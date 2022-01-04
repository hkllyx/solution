package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.info.Status;

/**
 * <p>An integer array is called arithmetic if it consists of <strong>at least three elements</strong> and if the difference between any two consecutive elements is the same.</p>
 *
 * <ul>
 * 	<li>For example, <code>[1,3,5,7,9]</code>, <code>[7,7,7,7]</code>, and <code>[3,-1,-5,-9]</code> are arithmetic sequences.</li>
 * </ul>
 *
 * <p>Given an integer array <code>nums</code>, return <em>the number of arithmetic <strong>subarrays</strong> of</em> <code>nums</code>.</p>
 *
 * <p>A <strong>subarray</strong> is a contiguous subsequence of the array.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> nums = [1,2,3,4]
 * <strong>Output:</strong> 3
 * <strong>Explanation:</strong> We have 3 arithmetic slices in nums: [1, 2, 3], [2, 3, 4] and [1,2,3,4] itself.
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> nums = [1]
 * <strong>Output:</strong> 0
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= nums.length &lt;= 5000</code></li>
 * 	<li><code>-1000 &lt;= nums[i] &lt;= 1000</code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>数组</li><li>动态规划</li></div></div><br><div><li>👍 397</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2021/08/10
 */
@Solution(no = "413", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/arithmetic-slices/", status = Status.FAILED)
public class ArithmeticSlices {

    public int numberOfArithmeticSlices(int[] nums) {
        return 0;
    }
}
