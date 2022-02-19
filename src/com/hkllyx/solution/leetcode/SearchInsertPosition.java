package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

/**
 * <p>Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.</p>
 *
 * <p>You must&nbsp;write an algorithm with&nbsp;<code>O(log n)</code> runtime complexity.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> nums = [1,3,5,6], target = 5
 * <strong>Output:</strong> 2
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> nums = [1,3,5,6], target = 2
 * <strong>Output:</strong> 1
 * </pre>
 *
 * <p><strong>Example 3:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> nums = [1,3,5,6], target = 7
 * <strong>Output:</strong> 4
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= nums.length &lt;= 10<sup>4</sup></code></li>
 * 	<li><code>-10<sup>4</sup> &lt;= nums[i] &lt;= 10<sup>4</sup></code></li>
 * 	<li><code>nums</code> contains <strong>distinct</strong> values sorted in <strong>ascending</strong> order.</li>
 * 	<li><code>-10<sup>4</sup> &lt;= target &lt;= 10<sup>4</sup></code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>数组</li><li>二分查找</li></div></div><br><div><li>👍 1350</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2022/02/17
 */
@Solution(no = "35", title = "Search Insert Position", difficulty = Difficulty.EASY, url = "https://leetcode-cn.com/problems/search-insert-position/")
public class SearchInsertPosition {

    public static void main(String[] args) {
        Assertions.assertExpect(4, new int[]{1, 3, 5, 6}, 7);
        Assertions.assertExpect(1, new int[]{1, 3, 5, 6}, 2);
    }

    @Test
    public int searchInsert(int[] nums, int target) {
        int begin = 0, end = nums.length - 1;
        while (begin < end) {
            int medium = (begin + end) >> 1;
            if (nums[medium] == target) {
                return medium;
            } else if (nums[medium] < target) {
                begin = medium + 1;
            } else {
                end = medium - 1;
            }
        }
        return target > nums[begin] ? begin + 1 : begin;
    }
}
