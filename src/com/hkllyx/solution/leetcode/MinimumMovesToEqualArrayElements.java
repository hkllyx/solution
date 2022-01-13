package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

/**
 * <p>Given an integer array <code>nums</code> of size <code>n</code>, return <em>the minimum number of moves required to make all array elements equal</em>.</p>
 *
 * <p>In one move, you can increment <code>n - 1</code> elements of the array by <code>1</code>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> nums = [1,2,3]
 * <strong>Output:</strong> 3
 * <strong>Explanation:</strong> Only three moves are needed (remember each move increments two elements):
 * [1,2,3]  =&gt;  [2,3,3]  =&gt;  [3,4,3]  =&gt;  [4,4,4]
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> nums = [1,1,1]
 * <strong>Output:</strong> 0
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>n == nums.length</code></li>
 * 	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
 * 	<li><code>-10<sup>9</sup> &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
 * 	<li>The answer is guaranteed to fit in a <strong>32-bit</strong> integer.</li>
 * </ul>
 * <div><div>Related Topics</div><div><li>数组</li><li>数学</li></div></div><br><div><li>👍 411</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2021/10/20
 */
@Solution(no = "453", title = "Minimum Moves to Equal Array Elements", difficulty = Difficulty.EASY, url = "https://leetcode-cn.com/problems/minimum-moves-to-equal-array-elements/")
public class MinimumMovesToEqualArrayElements {

    public static void main(String[] args) {
        Assertions.assertExpect(0, (Object) new int[]{1, 1, 1});
        Assertions.assertExpect(3, (Object) new int[]{1, 2, 3});
        Assertions.assertExpect(6, (Object) new int[]{1, 2, 3, 4});
    }

    @Test(value = "暴力", active = false)
    public int minMoves(int[] nums) {
        int res = 0;
        while (!isEqualArray(nums)) {
            int max = 0;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] > nums[max]) {
                    nums[max]++;
                } else {
                    nums[i]++;
                }
            }
            res++;
        }
        return res;
    }

    @Test("逆向思维，每次剩余n - 1个加1，相当于一个减1")
    public int minMoves1(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num < min) {
                min = num;
            }
        }
        int res = 0;
        for (int num : nums) {
            res += num - min;
        }
        return res;
    }

    private boolean isEqualArray(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
