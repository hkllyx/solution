package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

/**
 * <p>There is an integer array <code>nums</code> sorted in ascending order (with <strong>distinct</strong> values).</p>
 *
 * <p>Prior to being passed to your function, <code>nums</code> is <strong>possibly rotated</strong> at an unknown pivot index <code>k</code> (<code>1 &lt;= k &lt; nums.length</code>) such that the resulting array is <code>[nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]</code> (<strong>0-indexed</strong>). For example, <code>[0,1,2,4,5,6,7]</code> might be rotated at pivot index <code>3</code> and become <code>[4,5,6,7,0,1,2]</code>.</p>
 *
 * <p>Given the array <code>nums</code> <strong>after</strong> the possible rotation and an integer <code>target</code>, return <em>the index of </em><code>target</code><em> if it is in </em><code>nums</code><em>, or </em><code>-1</code><em> if it is not in </em><code>nums</code>.</p>
 *
 * <p>You must write an algorithm with <code>O(log n)</code> runtime complexity.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 * <pre><strong>Input:</strong> nums = [4,5,6,7,0,1,2], target = 0
 * <strong>Output:</strong> 4
 * </pre><p><strong>Example 2:</strong></p>
 * <pre><strong>Input:</strong> nums = [4,5,6,7,0,1,2], target = 3
 * <strong>Output:</strong> -1
 * </pre><p><strong>Example 3:</strong></p>
 * <pre><strong>Input:</strong> nums = [1], target = 0
 * <strong>Output:</strong> -1
 * </pre>
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= nums.length &lt;= 5000</code></li>
 * 	<li><code>-10<sup>4</sup> &lt;= nums[i] &lt;= 10<sup>4</sup></code></li>
 * 	<li>All values of <code>nums</code> are <strong>unique</strong>.</li>
 * 	<li><code>nums</code> is an ascending array that is possibly rotated.</li>
 * 	<li><code>-10<sup>4</sup> &lt;= target &lt;= 10<sup>4</sup></code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>数组</li><li>二分查找</li></div></div><br><div><li>👍 1839</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2022/02/17
 */
@Solution(no = "33", title = "Search in Rotated Sorted Array", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/search-in-rotated-sorted-array/")
public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        Assertions.assertExpect(-1, new int[]{4, 5, 6, 7, 0, 1, 2}, 3);
        Assertions.assertExpect(4, new int[]{4, 5, 6, 7, 0, 1, 2}, 0);
    }

    @Test
    public int search(int[] nums, int target) {
        int pivot = 1;
        while (pivot < nums.length && nums[pivot] > nums[pivot - 1]) {
            pivot++;
        }
        int res = binarySearch(nums, target, 0, pivot);
        if (res == -1) {
            res = binarySearch(nums, target, pivot, nums.length);
        }
        return res;
    }

    private int binarySearch(int[] nums, int target, int begin, int end) {
        end--;
        while (begin <= end) {
            int medium = (begin + end) >> 1;
            if (nums[medium] == target) {
                return medium;
            } else if (nums[medium] > target) {
                end = medium - 1;
            } else {
                begin = medium + 1;
            }
        }
        return -1;
    }
}
