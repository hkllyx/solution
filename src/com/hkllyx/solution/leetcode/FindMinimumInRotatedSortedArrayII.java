package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

/**
 * <p>Suppose an array of length <code>n</code> sorted in ascending order is <strong>rotated</strong> between <code>1</code> and <code>n</code> times. For example, the array <code>nums = [0,1,4,4,5,6,7]</code> might become:</p>
 *
 * <ul>
 * 	<li><code>[4,5,6,7,0,1,4]</code> if it was rotated <code>4</code> times.</li>
 * 	<li><code>[0,1,4,4,5,6,7]</code> if it was rotated <code>7</code> times.</li>
 * </ul>
 *
 * <p>Notice that <strong>rotating</strong> an array <code>[a[0], a[1], a[2], ..., a[n-1]]</code> 1 time results in the array <code>[a[n-1], a[0], a[1], a[2], ..., a[n-2]]</code>.</p>
 *
 * <p>Given the sorted rotated array <code>nums</code> that may contain <strong>duplicates</strong>, return <em>the minimum element of this array</em>.</p>
 *
 * <p>You must decrease the overall operation steps as much as possible.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 * <pre><strong>Input:</strong> nums = [1,3,5]
 * <strong>Output:</strong> 1
 * </pre><p><strong>Example 2:</strong></p>
 * <pre><strong>Input:</strong> nums = [2,2,2,0,1]
 * <strong>Output:</strong> 0
 * </pre>
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>n == nums.length</code></li>
 * 	<li><code>1 &lt;= n &lt;= 5000</code></li>
 * 	<li><code>-5000 &lt;= nums[i] &lt;= 5000</code></li>
 * 	<li><code>nums</code> is sorted and rotated between <code>1</code> and <code>n</code> times.</li>
 * </ul>
 *
 * <p>&nbsp;</p>
 * <p><strong>Follow up:</strong> This problem is similar to&nbsp;<a href="https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/" target="_blank">Find Minimum in Rotated Sorted Array</a>, but&nbsp;<code>nums</code> may contain <strong>duplicates</strong>. Would this affect the runtime complexity? How and why?</p>
 *
 * <p>&nbsp;</p>
 * <div><div>Related Topics</div><div><li>数组</li><li>二分查找</li></div></div><br><div><li>👍 435</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2021/05/24
 */
@Solution(no = "154", difficulty = Difficulty.HARD, url = "https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/")
public class FindMinimumInRotatedSortedArrayII {

    public static void main(String[] args) {
        Assertions.assertExpect(FindMinimumInRotatedSortedArrayII.class, 1, new int[]{10, 1, 10, 10, 10});
        Assertions.assertExpect(FindMinimumInRotatedSortedArrayII.class, 1, new int[]{3, 4, 5, 1, 2});
        Assertions.assertExpect(FindMinimumInRotatedSortedArrayII.class, 1, new int[]{3, 1, 3});
        Assertions.assertExpect(FindMinimumInRotatedSortedArrayII.class, 1, new int[]{1});
    }

    @Test
    public int findMin(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int head = nums[i], tail = nums[j];
            if (head == tail) {
                i++;
            } else if (head < tail) {
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
