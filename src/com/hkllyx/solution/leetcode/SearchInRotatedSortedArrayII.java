package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

/**
 * <p>There is an integer array <code>nums</code> sorted in non-decreasing order (not necessarily with <strong>distinct</strong> values).</p>
 *
 * <p>Before being passed to your function, <code>nums</code> is <strong>rotated</strong> at an unknown pivot index <code>k</code> (<code>0 &lt;= k &lt; nums.length</code>) such that the resulting array is <code>[nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]</code> (<strong>0-indexed</strong>). For example, <code>[0,1,2,4,4,4,5,6,6,7]</code> might be rotated at pivot index <code>5</code> and become <code>[4,5,6,6,7,0,1,2,4,4]</code>.</p>
 *
 * <p>Given the array <code>nums</code> <strong>after</strong> the rotation and an integer <code>target</code>, return <code>true</code><em> if </em><code>target</code><em> is in </em><code>nums</code><em>, or </em><code>false</code><em> if it is not in </em><code>nums</code><em>.</em></p>
 *
 * <p>You must decrease the overall operation steps as much as possible.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 * <pre><strong>Input:</strong> nums = [2,5,6,0,0,1,2], target = 0
 * <strong>Output:</strong> true
 * </pre><p><strong>Example 2:</strong></p>
 * <pre><strong>Input:</strong> nums = [2,5,6,0,0,1,2], target = 3
 * <strong>Output:</strong> false
 * </pre>
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= nums.length &lt;= 5000</code></li>
 * 	<li><code>-10<sup>4</sup> &lt;= nums[i] &lt;= 10<sup>4</sup></code></li>
 * 	<li><code>nums</code> is guaranteed to be rotated at some pivot.</li>
 * 	<li><code>-10<sup>4</sup> &lt;= target &lt;= 10<sup>4</sup></code></li>
 * </ul>
 *
 * <p>&nbsp;</p>
 * <p><strong>Follow up:</strong> This problem is similar to&nbsp;<a href="/problems/search-in-rotated-sorted-array/description/" target="_blank">Search in Rotated Sorted Array</a>, but&nbsp;<code>nums</code> may contain <strong>duplicates</strong>. Would this affect the runtime complexity? How and why?</p>
 * <div><div>Related Topics</div><div><li>数组</li><li>二分查找</li></div></div><br><div><li>👍 622</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2022/07/14
 */
@Solution(no = "81", title = "Search in Rotated Sorted Array II", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii/")
public class SearchInRotatedSortedArrayII {

    public static void main(String[] args) {
        Assertions.assertExpect(true, new int[]{1,1,1,1,1,1,1,1,1,13,1,1,1,1,1,1,1,1,1,1,1,1}, 13);
    }

    @Test(active = false)
    public boolean search(int[] nums, int target) {
        // 查找pivot
        int pivot = 1;
        while (pivot < nums.length && nums[pivot] >= nums[pivot - 1]) {
            pivot++;
        }
        return binarySearch(nums, target, 0, pivot - 1) || binarySearch(nums, target, pivot, nums.length - 1);
    }

    private boolean binarySearch(int[] nums, int target, int begin, int end) {
        while (begin <= end) {
            int medium = (begin + end) >> 1;
            if (nums[medium] == target) {
                return true;
            } else if (nums[medium] > target) {
                end = medium - 1;
            } else {
                begin = medium + 1;
            }
        }
        return false;
    }
}
