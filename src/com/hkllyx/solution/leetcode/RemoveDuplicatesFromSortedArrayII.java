package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

/**
 * <p>Given an integer array <code>nums</code> sorted in <strong>non-decreasing order</strong>, remove some duplicates <a href="https://en.wikipedia.org/wiki/In-place_algorithm" target="_blank"><strong>in-place</strong></a> such that each unique element appears <strong>at most twice</strong>. The <strong>relative order</strong> of the elements should be kept the <strong>same</strong>.</p>
 *
 * <p>Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the <strong>first part</strong> of the array <code>nums</code>. More formally, if there are <code>k</code> elements after removing the duplicates, then the first <code>k</code> elements of <code>nums</code>&nbsp;should hold the final result. It does not matter what you leave beyond the first&nbsp;<code>k</code>&nbsp;elements.</p>
 *
 * <p>Return <code>k</code><em> after placing the final result in the first </em><code>k</code><em> slots of </em><code>nums</code>.</p>
 *
 * <p>Do <strong>not</strong> allocate extra space for another array. You must do this by <strong>modifying the input array <a href="https://en.wikipedia.org/wiki/In-place_algorithm" target="_blank">in-place</a></strong> with O(1) extra memory.</p>
 *
 * <p><strong>Custom Judge:</strong></p>
 *
 * <p>The judge will test your solution with the following code:</p>
 *
 * <pre>
 * int[] nums = [...]; // Input array
 * int[] expectedNums = [...]; // The expected answer with correct length
 *
 * int k = removeDuplicates(nums); // Calls your implementation
 *
 * assert k == expectedNums.length;
 * for (int i = 0; i &lt; k; i++) {
 *     assert nums[i] == expectedNums[i];
 * }
 * </pre>
 *
 * <p>If all assertions pass, then your solution will be <strong>accepted</strong>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> nums = [1,1,1,2,2,3]
 * <strong>Output:</strong> 5, nums = [1,1,2,2,3,_]
 * <strong>Explanation:</strong> Your function should return k = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> nums = [0,0,1,1,1,1,2,3,3]
 * <strong>Output:</strong> 7, nums = [0,0,1,1,2,3,3,_,_]
 * <strong>Explanation:</strong> Your function should return k = 7, with the first seven elements of nums being 0, 0, 1, 1, 2, 3 and 3 respectively.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= nums.length &lt;= 3 * 10<sup>4</sup></code></li>
 * 	<li><code>-10<sup>4</sup> &lt;= nums[i] &lt;= 10<sup>4</sup></code></li>
 * 	<li><code>nums</code> is sorted in <strong>non-decreasing</strong> order.</li>
 * </ul>
 * <div><div>Related Topics</div><div><li>数组</li><li>双指针</li></div></div><br><div><li>👍 713</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2022/07/14
 */
@Solution(no = "80", title = "Remove Duplicates from Sorted Array II", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/")
public class RemoveDuplicatesFromSortedArrayII {

    public static void main(String[] args) {
        Assertions.assertExpect(5, (Object) new int[]{1, 1, 1, 2, 2, 3});
    }

    @Test
    public int removeDuplicates(int[] nums) {
        int result = 1;
        // 第几次出现
        int times = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                times++;
                if (times < 3) {
                    nums[result++] = nums[i];
                }
            } else {
                times = 1;
                nums[result++] = nums[i];
            }
        }
        return result;
    }
}
