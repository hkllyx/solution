package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

/**
 * <p>Given an array of integers <code>nums</code> which is sorted in ascending order, and an integer <code>target</code>, write a function to search <code>target</code> in <code>nums</code>. If <code>target</code> exists, then return its index. Otherwise, return <code>-1</code>.</p>
 *
 * <p>You must write an algorithm with <code>O(log n)</code> runtime complexity.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> nums = [-1,0,3,5,9,12], target = 9
 * <strong>Output:</strong> 4
 * <strong>Explanation:</strong> 9 exists in nums and its index is 4
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> nums = [-1,0,3,5,9,12], target = 2
 * <strong>Output:</strong> -1
 * <strong>Explanation:</strong> 2 does not exist in nums so return -1
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= nums.length &lt;= 10<sup>4</sup></code></li>
 * 	<li><code>-10<sup>4</sup> &lt; nums[i], target &lt; 10<sup>4</sup></code></li>
 * 	<li>All the integers in <code>nums</code> are <strong>unique</strong>.</li>
 * 	<li><code>nums</code> is sorted in ascending order.</li>
 * </ul>
 * <div><div>Related Topics</div><div><li>数组</li><li>二分查找</li></div></div><br><div><li>👍 560</li><li>👎 0</li></div>
 *
 * @author hkllyx
 * @date 2021-09-06
 */
@Solution(no = "704", title = "Binary Search", difficulty = Difficulty.EASY, url = "https://leetcode-cn.com/problems/binary-search/")
public class BinarySearch {

    public static void main(String[] args) {
        Assertions.assertExpect(4, new int[]{-1, 0, 3, 5, 9, 12}, 9);
    }

    @Test
    public int search(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) >> 1;
            if (nums[m] == target) {
                return m;
            } else if (nums[m] < target) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        return -1;
    }
}
