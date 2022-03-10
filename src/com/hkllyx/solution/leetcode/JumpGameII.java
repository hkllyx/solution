package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

/**
 * <p>Given an array of non-negative integers <code>nums</code>, you are initially positioned at the first index of the array.</p>
 *
 * <p>Each element in the array represents your maximum jump length at that position.</p>
 *
 * <p>Your goal is to reach the last index in the minimum number of jumps.</p>
 *
 * <p>You can assume that you can always reach the last index.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> nums = [2,3,1,1,4]
 * <strong>Output:</strong> 2
 * <strong>Explanation:</strong> The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> nums = [2,3,0,1,4]
 * <strong>Output:</strong> 2
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= nums.length &lt;= 10<sup>4</sup></code></li>
 * 	<li><code>0 &lt;= nums[i] &lt;= 1000</code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>贪心</li><li>数组</li><li>动态规划</li></div></div><br><div><li>👍 1436</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2022/03/05
 */
@Solution(no = "45", title = "Jump Game II", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/jump-game-ii/")
public class JumpGameII {

    public static void main(String[] args) {
        // Assertions.assertExpect(0, (Object) new int[]{0});
        Assertions.assertExpect(1, (Object) new int[]{1, 0});
        Assertions.assertExpect(2, (Object) new int[]{2, 3, 1, 1, 4});
        Assertions.assertExpect(2, (Object) new int[]{2, 3, 0, 1, 4});
        Assertions.assertExpect(3, (Object) new int[]{5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0});
        Assertions.assertExpect(5, (Object) new int[]{5, 6, 4, 4, 6, 9, 4, 4, 7, 4, 4, 8, 2, 6, 8, 1, 5, 9, 6, 5, 2, 7, 9, 7, 9, 6, 9, 4, 1, 6, 8, 8, 4, 4, 2, 0, 3, 8, 5});
    }

    @Test(value = "超时", active = false)
    public int jump(int[] nums) {
        return jump(nums, 0);
    }

    private int jump(int[] nums, int i) {
        // 跳到最后
        if (i + 1 >= nums.length) {
            return 0;
        }
        int res = -1;
        for (int j = 1; j <= nums[i]; j++) {
            int next = jump(nums, i + j);
            // 跳不到最后
            if (next == -1) {
                continue;
            }
            if (res == -1) {
                res = next + 1;
            } else {
                res = Math.min(res, next + 1);
            }
        }
        return res;
    }

    @Test(mills = 49, memory = 41.7, active = false)
    public int jump1(int[] nums) {
        int len = nums.length;
        int[] trace = new int[len];
        int last = len - 1;
        for (int i = 0; i < last; i++) {
            for (int j = i + 1, k = Math.min(i + nums[i], last); j <= k; j++) {
                trace[j] = trace[j] == 0 ? trace[i] + 1 : Math.min(trace[j], trace[i] + 1);
            }
        }
        return trace[len - 1];
    }

    @Test(value = "贪心，反向查找出发位置。时间复杂度O(n^2)", active = false)
    public int jump2(int[] nums) {
        int steps = 0;
        int position = nums.length - 1;
        while (position > 0) {
            // 下一个position = 最左侧能跳到position
            for (int i = 0; i < position; i++) {
                if (i + nums[i] >= position) {
                    position = i;
                    steps++;
                    break;
                }
            }
        }
        return steps;
    }

    @Test(value = "贪心，正向查找可到达的最大位置。时间复杂度O(n)")
    public int jump3(int[] nums) {
        int steps = 0;
        // preMax: 上一次能跳到的最远位置
        // max: 此时能跳到的最远位置
        for(int i = 0, preMax = 0, max = 0, len = nums.length - 1; preMax < len; i++){
            max = Math.max(max, i + nums[i]);
            if(i == preMax){
                // 从preMax到max只需要跳一次
                // 因为跳到max的位置，一定在上上次能跳到的最远位置 ~ preMax之间
                steps++;
                preMax = max;
            }
        }
        return steps;
    }
}
