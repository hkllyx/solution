package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

/**
 * <p>Given an array <code>nums</code> with <code>n</code> objects colored red, white, or blue, sort them <strong><a href="https://en.wikipedia.org/wiki/In-place_algorithm" target="_blank">in-place</a> </strong>so that objects of the same color are adjacent, with the colors in the order red, white, and blue.</p>
 *
 * <p>We will use the integers <code>0</code>, <code>1</code>, and <code>2</code> to represent the color red, white, and blue, respectively.</p>
 *
 * <p>You must solve this problem without using the library&#39;s sort function.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> nums = [2,0,2,1,1,0]
 * <strong>Output:</strong> [0,0,1,1,2,2]
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> nums = [2,0,1]
 * <strong>Output:</strong> [0,1,2]
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>n == nums.length</code></li>
 * 	<li><code>1 &lt;= n &lt;= 300</code></li>
 * 	<li><code>nums[i]</code> is either <code>0</code>, <code>1</code>, or <code>2</code>.</li>
 * </ul>
 *
 * <p>&nbsp;</p>
 * <p><strong>Follow up:</strong>&nbsp;Could you come up with a one-pass algorithm using only&nbsp;constant extra space?</p>
 * <div><div>Related Topics</div><div><li>数组</li><li>双指针</li><li>排序</li></div></div><br><div><li>👍 1334</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2022/07/13
 */
@Solution(no = "75", title = "Sort Colors", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/sort-colors/")
public class SortColors {

    public static void main(String[] args) {
        Assertions.assertExpect(0, (Object) new int[]{2, 0, 1});
        Assertions.assertExpect(0, (Object) new int[]{0, 0, 1, 1, 2, 2});
    }

    @Test
    public void sortColors(int[] nums) {
        for (int p0 = 0, p1 = 0, p2 = 0, len = nums.length; p2 < len; p2++) {
            if (nums[p2] == 0) {
                // 先将p2置2
                nums[p2] = 2;
                // 0的数量增加，p0后移
                nums[p0++] = 0;
                // 已经出现了1，p1同步后移
                if (p1 > 0) {
                    nums[p1++] = 1;
                }
            } else if (nums[p2] == 1) {
                nums[p2] = 2;
                // 初始化p1
                if (p1 == 0) {
                    p1 = p0;
                }
                nums[p1++] = 1;
            }
        }
    }
}
