package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

/**
 * <p>You are given an integer array <code>nums</code>. You are initially positioned at the array&#39;s <strong>first index</strong>, and each element in the array represents your maximum jump length at that position.</p>
 *
 * <p>Return <code>true</code><em> if you can reach the last index, or </em><code>false</code><em> otherwise</em>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> nums = [2,3,1,1,4]
 * <strong>Output:</strong> true
 * <strong>Explanation:</strong> Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> nums = [3,2,1,0,4]
 * <strong>Output:</strong> false
 * <strong>Explanation:</strong> You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= nums.length &lt;= 10<sup>4</sup></code></li>
 * 	<li><code>0 &lt;= nums[i] &lt;= 10<sup>5</sup></code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>贪心</li><li>数组</li><li>动态规划</li></div></div><br><div><li>👍 1663</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2022/02/26
 */
@Solution(no = "55", title = "Jump Game", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/jump-game/")
public class JumpGame {

    public static void main(String[] args) {
        Assertions.assertExpect(true, (Object) new int[]{2, 0, 1, 1, 4});
        Assertions.assertExpect(false, (Object) new int[]{3, 2, 1, 0, 4});
        Assertions.assertExpect(true, (Object) new int[]{2, 3, 1, 1, 4});
    }

    @Test(value = "前缀和", mills = 4, memory = 42, active = false)
    public boolean canJump(int[] nums) {
        int len = nums.length - 1;
        // line[i]表示nums[i]到nums[i + 1]中间能被覆盖的次数
        // nums: 2   3   1   1   4
        // line:   1   2   2   2
        int[] line = new int[len];
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                line[i]++;
                int j = i + nums[i];
                if (j < len) {
                    line[j]--;
                }
            }
            if (i > 0) {
                line[i] += line[i - 1];
            }
            if (line[i] <= 0) {
                return false;
            }
        }
        return true;
    }

    @Test(value = "贪心", helped = true, active = false)
    public boolean canJump2(int[] nums) {
        int maxReach = 0, len = nums.length - 1;
        for (int i = 0; i < len; i++) {
            // i + nums[i]为i处能达到的最大位置
            maxReach = Math.max(maxReach, i + nums[i]);
            // 当前位不能到达下一位
            if (maxReach < i + 1) {
                return false;
            }
            // 当前位已经能到达最后一位
            if (maxReach >= len) {
                return true;
            }
        }
        return true;
    }

    @Test(value = "贪心", helped = true)
    public boolean canJump3(int[] nums) {
        int maxReach = 0, len = nums.length - 1;
        for (int i = 0; i < len; i++) {
            // 当前位可到达
            if (maxReach >= i) {
                maxReach = Math.max(maxReach, i + nums[i]);
                // 可以到达最后一位
                if (maxReach >= len) {
                    return true;
                }
            }
        }
        return false;
    }
}
