package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

/**
 * <p>Suppose an array of length <code>n</code> sorted in ascending order is <strong>rotated</strong> between <code>1</code> and <code>n</code> times. For example, the array <code>nums = [0,1,2,4,5,6,7]</code> might become:</p>
 *
 * <ul>
 * 	<li><code>[4,5,6,7,0,1,2]</code> if it was rotated <code>4</code> times.</li>
 * 	<li><code>[0,1,2,4,5,6,7]</code> if it was rotated <code>7</code> times.</li>
 * </ul>
 *
 * <p>Notice that <strong>rotating</strong> an array <code>[a[0], a[1], a[2], ..., a[n-1]]</code> 1 time results in the array <code>[a[n-1], a[0], a[1], a[2], ..., a[n-2]]</code>.</p>
 *
 * <p>Given the sorted rotated array <code>nums</code> of <strong>unique</strong> elements, return <em>the minimum element of this array</em>.</p>
 *
 * <p>You must write an algorithm that runs in&nbsp;<code>O(log n) time.</code></p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> nums = [3,4,5,1,2]
 * <strong>Output:</strong> 1
 * <strong>Explanation:</strong> The original array was [1,2,3,4,5] rotated 3 times.
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> nums = [4,5,6,7,0,1,2]
 * <strong>Output:</strong> 0
 * <strong>Explanation:</strong> The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.
 * </pre>
 *
 * <p><strong>Example 3:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> nums = [11,13,15,17]
 * <strong>Output:</strong> 11
 * <strong>Explanation:</strong> The original array was [11,13,15,17] and it was rotated 4 times.
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>n == nums.length</code></li>
 * 	<li><code>1 &lt;= n &lt;= 5000</code></li>
 * 	<li><code>-5000 &lt;= nums[i] &lt;= 5000</code></li>
 * 	<li>All the integers of <code>nums</code> are <strong>unique</strong>.</li>
 * 	<li><code>nums</code> is sorted and rotated between <code>1</code> and <code>n</code> times.</li>
 * </ul>
 * <div><div>Related Topics</div><div><li>数组</li><li>二分查找</li></div></div><br><div><li>👍 644</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2021/05/24
 */
@Solution(no = "153", title = "Find Minimum in Rotated Sorted Array", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/")
public class FindMinimumInRotatedSortedArray {

    public static void main(String[] args) {
        Assertions.assertExpect(FindMinimumInRotatedSortedArray.class, 1, new int[]{3, 4, 5, 1, 2});
        Assertions.assertExpect(FindMinimumInRotatedSortedArray.class, 1, new int[]{3, 1});
        Assertions.assertExpect(FindMinimumInRotatedSortedArray.class, 1, new int[]{1, 3});
        Assertions.assertExpect(FindMinimumInRotatedSortedArray.class, 1, new int[]{1});
    }

    @Test
    public int findMin(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int head = nums[i], tail = nums[j];
            if (head <= tail) {
                return head;
            } else {
                int m = (i + j) >> 1;
                if (head <= nums[m]) {
                    i = m + 1;
                } else {
                    j = m;
                }
            }
        }
        return nums[i];
    }
}
