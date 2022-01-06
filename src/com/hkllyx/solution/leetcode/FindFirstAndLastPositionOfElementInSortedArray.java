package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

/**
 * <p>Given an array of integers <code>nums</code> sorted in non-decreasing order, find the starting and ending position of a given <code>target</code> value.</p>
 *
 * <p>If <code>target</code> is not found in the array, return <code>[-1, -1]</code>.</p>
 *
 * <p>You must&nbsp;write an algorithm with&nbsp;<code>O(log n)</code> runtime complexity.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 * <pre><strong>Input:</strong> nums = [5,7,7,8,8,10], target = 8
 * <strong>Output:</strong> [3,4]
 * </pre><p><strong>Example 2:</strong></p>
 * <pre><strong>Input:</strong> nums = [5,7,7,8,8,10], target = 6
 * <strong>Output:</strong> [-1,-1]
 * </pre><p><strong>Example 3:</strong></p>
 * <pre><strong>Input:</strong> nums = [], target = 0
 * <strong>Output:</strong> [-1,-1]
 * </pre>
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>0 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
 * 	<li><code>-10<sup>9</sup>&nbsp;&lt;= nums[i]&nbsp;&lt;= 10<sup>9</sup></code></li>
 * 	<li><code>nums</code> is a non-decreasing array.</li>
 * 	<li><code>-10<sup>9</sup>&nbsp;&lt;= target&nbsp;&lt;= 10<sup>9</sup></code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>数组</li><li>二分查找</li></div></div><br><div><li>👍 1379</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2022/01/05
 */
@Solution(no = "34", difficulty = Difficulty.EASY, url = "https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/")
public class FindFirstAndLastPositionOfElementInSortedArray {

    public static void main(String[] args) {
        Assertions.assertExpect(new int[]{-1, -1}, new int[]{5, 7, 7, 8, 8, 10}, 6);
        Assertions.assertExpect(new int[]{1, 2}, new int[]{5, 7, 7, 8, 8, 10}, 7);
        Assertions.assertExpect(new int[]{3, 4}, new int[]{5, 7, 7, 8, 8, 10}, 8);
        Assertions.assertExpect(new int[]{-1, -1}, new int[]{5, 7, 7, 8, 8, 10}, 9);
        Assertions.assertExpect(new int[]{5, 5}, new int[]{5, 7, 7, 8, 8, 10}, 10);
    }

    @Test
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = (l + r) >> 1;
            if (nums[m] < target) {
                l = m + 1;
            } else if (nums[m] > target) {
                r = m - 1;
            } else {
                res[0] = m;
                res[1] = m;
                // 左端，中值左偏
                while (l < res[0]) {
                    int lm = (l + res[0]) >> 1;
                    if (nums[lm] < target) {
                        l = lm + 1;
                    } else {
                        res[0] = lm;
                    }
                }
                // 右端，中值右偏
                while (res[1] < r) {
                    int rm = ((res[1] + r) >> 1) + 1;
                    if (nums[rm] > target) {
                        r = rm - 1;
                    } else {
                        res[1] = rm;
                    }
                }
                return res;
            }
        }
        return res;
    }


    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = (l + r) >> 1;
            if (nums[m] < target) {
                l = m + 1;
            } else if (nums[m] > target) {
                r = m - 1;
            } else {
                int lr = m, rl = m;
                // 左端，中值左偏
                while (l < lr) {
                    int lm = (l + lr) >> 1;
                    if (nums[lm] < target) {
                        l = lm + 1;
                    } else {
                        lr = lm;
                    }
                }
                // 右端，中值右偏
                while (rl < r) {
                    int rm = ((rl + r) >> 1) + 1;
                    if (nums[rm] > target) {
                        r = rm - 1;
                    } else {
                        rl = rm;
                    }
                }
                return rl - lr + 1;
            }
        }
        return 0;
    }
}
