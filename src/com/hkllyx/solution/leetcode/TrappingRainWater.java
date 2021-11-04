package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author xiaoyong3
 * @date 2021/11/03
 */
@Solution(no = "42", difficulty = Difficulty.HARD, url = "https://leetcode-cn.com/problems/trapping-rain-water/")
public class TrappingRainWater {

    public static void main(String[] args) {
        Assertions.assertExpect(6, (Object) new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
        Assertions.assertExpect(9, (Object) new int[]{4, 2, 0, 3, 2, 5});
    }

    @Test(value = "双指针", mills = 0, memory = 38.3)
    public int trap(int[] height) {
        int ans = 0, from = 0, minus = 0;
        // 最高点左侧
        for (int i = from + 1, len = height.length; i < len; i++) {
            if (height[i] >= height[from]) {
                ans += height[from] * (i - from - 1) - minus;
                from = i;
                minus = 0;
            } else {
                minus += height[i];
            }
        }
        int highest = from;
        from = height.length - 1;
        minus = 0;
        // 最高点右侧
        for (int i = from - 1; i >= highest; i--) {
            if (height[i] >= height[from]) {
                ans += height[from] * (from - i - 1) - minus;
                minus = 0;
                from = i;
            } else {
                minus += height[i];
            }
        }
        return ans;
    }

    @Test(value = "单调栈", active = false, mills = 2, memory = 38.7)
    public int trap1(int[] height) {
        int ans = 0;
        // 有凹陷才能接到雨水，先递减再增时才能出现凹陷，所以需要一个单调递减栈
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0, n = height.length; i < n; i++) {
            // 栈中递减，出现一个增，即可以接到雨水
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                // 单调递减，所以栈顶为凹陷最低处
                int floor = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int left = stack.peek();
                int currWidth = i - stack.peek() - 1;
                // - height[floor]是因为之前循环已经计算了低于floor的凹陷可接的雨水
                int currHeight = Math.min(height[left], height[i]) - height[floor];
                ans += currWidth * currHeight;
            }
            // 单调入栈
            stack.push(i);
        }
        return ans;
    }
}
