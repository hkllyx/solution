package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;

/**
 * <p>输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre><strong>输入：</strong>nums = [2,7,11,15], target = 9
 * <strong>输出：</strong>[2,7] 或者 [7,2]
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre><strong>输入：</strong>nums = [10,26,30,31,47,60], target = 40
 * <strong>输出：</strong>[10,30] 或者 [30,10]
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>限制：</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= nums.length &lt;= 10^5</code></li>
 * 	<li><code>1 &lt;= nums[i]&nbsp;&lt;= 10^6</code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>数组</li><li>双指针</li><li>二分查找</li></div></div><br><div><li>👍 148</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2022/01/04
 */
@Solution(no = "剑指 Offer 57", title = "和为s的两个数字", difficulty = Difficulty.EASY, url = "https://leetcode-cn.com/problems/he-wei-sde-liang-ge-shu-zi-lcof/")
public class 和为s的两个数字 {

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0, j = nums.length - 1; i < j; ) {
            int sum = nums[i] + nums[j];
            if (sum == target) {
                return new int[]{nums[i], nums[j]};
            } else if (sum > target) {
                j--;
            } else {
                i++;
            }
        }
        return new int[0];
    }
}
