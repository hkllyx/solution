package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

/**
 * <p>Given an integer array <code>nums</code> and an integer <code>val</code>, remove all occurrences of <code>val</code> in <code>nums</code> <a href="https://en.wikipedia.org/wiki/In-place_algorithm" target="_blank"><strong>in-place</strong></a>. The relative order of the elements may be changed.</p>
 *
 * <p>Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the <strong>first part</strong> of the array <code>nums</code>. More formally, if there are <code>k</code> elements after removing the duplicates, then the first <code>k</code> elements of <code>nums</code> should hold the final result. It does not matter what you leave beyond the first <code>k</code> elements.</p>
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
 * int val = ...; // Value to remove
 * int[] expectedNums = [...]; // The expected answer with correct length.
 *                             // It is sorted with no values equaling val.
 *
 * int k = removeElement(nums, val); // Calls your implementation
 *
 * assert k == expectedNums.length;
 * sort(nums, 0, k); // Sort the first k elements of nums
 * for (int i = 0; i &lt; actualLength; i++) {
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
 * <strong>Input:</strong> nums = [3,2,2,3], val = 3
 * <strong>Output:</strong> 2, nums = [2,2,_,_]
 * <strong>Explanation:</strong> Your function should return k = 2, with the first two elements of nums being 2.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> nums = [0,1,2,2,3,0,4,2], val = 2
 * <strong>Output:</strong> 5, nums = [0,1,4,0,3,_,_,_]
 * <strong>Explanation:</strong> Your function should return k = 5, with the first five elements of nums containing 0, 0, 1, 3, and 4.
 * Note that the five elements can be returned in any order.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>0 &lt;= nums.length &lt;= 100</code></li>
 * 	<li><code>0 &lt;= nums[i] &lt;= 50</code></li>
 * 	<li><code>0 &lt;= val &lt;= 100</code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>数组</li><li>双指针</li></div></div><br><div><li>👍 1134</li><li>👎 0</li></div>
 *
 * @author hkllyx
 * @date 2021/04/19
 */
@Solution(no = "27", difficulty = Difficulty.SIMPLE, url = "https://leetcode-cn.com/problems/remove-element/")
public class RemoveElement {

    public static void main(String[] args) {
        Assertions.assertExpect(RemoveElement.class, 2, new int[]{3, 2, 2, 3}, 3);
        Assertions.assertExpect(RemoveElement.class, 5, new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2);
    }

    public int removeElement1(int[] nums, int val) {
        int i = 0;
        for (int j = nums.length - 1; j >= i; ) {
            if (nums[j] == val) {
                j--;
            } else if (nums[i] == val) {
                nums[i++] = nums[j--];
            } else {
                i++;
            }
        }
        return i;
    }

    /** 快排思想 */
    @Test
    public int removeElement2(int[] nums, int val) {
        int i = -1;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[++i] = nums[j];
            }
        }
        return i + 1;
    }
}
