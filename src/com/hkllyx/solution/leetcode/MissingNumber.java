package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

/**
 * <p>Given an array <code>nums</code> containing <code>n</code> distinct numbers in the range <code>[0, n]</code>, return <em>the only number in the range that is missing from the array.</em></p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> nums = [3,0,1]
 * <strong>Output:</strong> 2
 * <strong>Explanation:</strong> n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> nums = [0,1]
 * <strong>Output:</strong> 2
 * <strong>Explanation:</strong> n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.
 * </pre>
 *
 * <p><strong>Example 3:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> nums = [9,6,4,2,3,5,7,0,1]
 * <strong>Output:</strong> 8
 * <strong>Explanation:</strong> n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>n == nums.length</code></li>
 * 	<li><code>1 &lt;= n &lt;= 10<sup>4</sup></code></li>
 * 	<li><code>0 &lt;= nums[i] &lt;= n</code></li>
 * 	<li>All the numbers of <code>nums</code> are <strong>unique</strong>.</li>
 * </ul>
 *
 * <p>&nbsp;</p>
 * <p><strong>Follow up:</strong> Could you implement a solution using only <code>O(1)</code> extra space complexity and <code>O(n)</code> runtime complexity?</p>
 * <div><div>Related Topics</div><div><li>位运算</li><li>数组</li><li>哈希表</li><li>数学</li><li>排序</li></div></div><br><div><li>👍 547</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2021/11/06
 */
@Solution(no = "268", difficulty = Difficulty.EASY, url = "https://leetcode-cn.com/problems/missing-number/")
public class MissingNumber {

    public static void main(String[] args) {
        Assertions.assertExpect(2, (Object) new int[]{0, 1, 3});
    }

    @Test(value = "数学方法", mills = 0, memory = 38.8)
    public int missingNumber(int[] nums) {
        // 0 + 1 + 2 + 3 + ... + n = ((1 + n) * n) / 2
        int n = nums.length, sum = ((n + 1) * n) >> 1;
        for (int num : nums) {
            sum -= num;
        }
        return sum;
    }

    @Test(value = "位运算", mills = 0, memory = 38.6)
    public int missingNumber1(int[] nums) {
        // x ^ x = 0
        // x ^ 0 = x
        int ans = 0;
        for (int i = 0, len = nums.length; i <= len; i++) {
            ans ^= i;
        }
        for (int num : nums) {
            ans ^= num;
        }
        return ans;
    }

    @Test(value = "数组", mills = 0, memory = 38.7)
    public int missingNumber2(int[] nums) {
        byte[] trace = new byte[nums.length + 1];
        for (int num : nums) {
            trace[num] = 1;
        }
        for (int i = 0, j = trace.length - 1; i <= j; i++, j--) {
            if (trace[i] == 0) {
                return i;
            }
            if (trace[j] == 0) {
                return j;
            }
        }
        return -1;
    }
}
