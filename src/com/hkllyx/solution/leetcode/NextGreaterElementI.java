package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>The <strong>next greater element</strong> of some element <code>x</code> in an array is the <strong>first greater</strong> element that is <strong>to the right</strong> of <code>x</code> in the same array.</p>
 *
 * <p>You are given two <strong>distinct 0-indexed</strong> integer arrays <code>nums1</code> and <code>nums2</code>, where <code>nums1</code> is a subset of <code>nums2</code>.</p>
 *
 * <p>For each <code>0 &lt;= i &lt; nums1.length</code>, find the index <code>j</code> such that <code>nums1[i] == nums2[j]</code> and determine the <strong>next greater element</strong> of <code>nums2[j]</code> in <code>nums2</code>. If there is no next greater element, then the answer for this query is <code>-1</code>.</p>
 *
 * <p>Return <em>an array </em><code>ans</code><em> of length </em><code>nums1.length</code><em> such that </em><code>ans[i]</code><em> is the <strong>next greater element</strong> as described above.</em></p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> nums1 = [4,1,2], nums2 = [1,3,4,2]
 * <strong>Output:</strong> [-1,3,-1]
 * <strong>Explanation:</strong> The next greater element for each value of nums1 is as follows:
 * - 4 is underlined in nums2 = [1,3,<u>4</u>,2]. There is no next greater element, so the answer is -1.
 * - 1 is underlined in nums2 = [<u>1</u>,3,4,2]. The next greater element is 3.
 * - 2 is underlined in nums2 = [1,3,4,<u>2</u>]. There is no next greater element, so the answer is -1.
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> nums1 = [2,4], nums2 = [1,2,3,4]
 * <strong>Output:</strong> [3,-1]
 * <strong>Explanation:</strong> The next greater element for each value of nums1 is as follows:
 * - 2 is underlined in nums2 = [1,<u>2</u>,3,4]. The next greater element is 3.
 * - 4 is underlined in nums2 = [1,2,3,<u>4</u>]. There is no next greater element, so the answer is -1.
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= nums1.length &lt;= nums2.length &lt;= 1000</code></li>
 * 	<li><code>0 &lt;= nums1[i], nums2[i] &lt;= 10<sup>4</sup></code></li>
 * 	<li>All integers in <code>nums1</code> and <code>nums2</code> are <strong>unique</strong>.</li>
 * 	<li>All the integers of <code>nums1</code> also appear in <code>nums2</code>.</li>
 * </ul>
 *
 * <p>&nbsp;</p>
 * <strong>Follow up:</strong> Could you find an <code>O(nums1.length + nums2.length)</code> solution?<div><div>Related Topics</div><div><li>栈</li><li>数组</li><li>哈希表</li><li>单调栈</li></div></div><br><div><li>👍 623</li><li>👎 0</li></div>
 *
 * @author hkllyx
 * @date 2021-10-26
 */
@Solution(no = "496", difficulty = Difficulty.EASY, url = "https://leetcode-cn.com/problems/next-greater-element-i/")
public class NextGreaterElementI {

    public static void main(String[] args) {
        Assertions.assertExpect(new int[] {-1, 3, -1}, new int[] {4, 1, 2}, new int[] {1, 3, 4, 2});
    }

    @Test(value = "哈希表+遍历", active = false)
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], i);
        }
        for (int i = 0; i < nums1.length; i++) {
            int next = -1;
            for (int j = map.get(nums1[i]) + 1; j < nums2.length; j++) {
                if (nums2[j] > nums1[i]) {
                    next = nums2[j];
                    break;
                }
            }
            res[i] = next;
        }
        return res;
    }

    @Test(value = "哈希表+单调栈")
    public int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>(nums2.length);
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
                stack.pop();
            }
            map.put(nums2[i], stack.isEmpty() ? -1 : stack.peek());
            stack.push(nums2[i]);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
}
