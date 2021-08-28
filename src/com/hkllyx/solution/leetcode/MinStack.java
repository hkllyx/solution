package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.info.Tag;
import com.hkllyx.solution.util.info.Tags;

import java.util.Arrays;
import java.util.Random;

/**
 * @author xiaoyong3
 * @date 2021/06/07
 */
@Solution(no = "155", difficulty = Difficulty.SIMPLE, url = "https://leetcode-cn.com/problems/min-stack/")
@Tags(Tag.DESIGN)
public class MinStack {
    private int[] elements;
    private int[] mins;
    private int point;

    public MinStack() {
        point = -1;
    }

    public static void main(String[] args) {
        Random random = new Random(47);
        MinStack stack = new MinStack();
        for (int i = 0; i < 32; i++) {
            stack.push(random.nextInt(100));
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(stack.top() + " " + stack.getMin());
            stack.pop();
        }
    }

    public void push(int val) {
        if (point < 0) {
            elements = new int[16];
            mins = new int[16];
            elements[++point] = val;
            mins[point] = val;
            return;
        }
        // 简单动态扩容
        int length = elements.length;
        if (point > length - 2) {
            int newLength = length > 0x3fffffff ? Integer.MAX_VALUE : length << 1;
            elements = Arrays.copyOf(elements, newLength);
            mins = Arrays.copyOf(mins, newLength);
        }
        int min = Math.min(mins[point], val);
        elements[++point] = val;
        mins[point] = min;
    }

    public void pop() {
        point--;
    }

    public int top() {
        return elements[point];
    }

    public int getMin() {
        return mins[point];
    }
}
