package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.info.Difficulty;
import com.hkllyx.solution.info.Solution;

/**
 * @author xiaoyong3
 * @date 2021/05/22
 */
@Solution(no = "剑指 Offer 09", difficulty = Difficulty.SIMPLE, url = "https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/")
public class 用两个栈实现队列 {

    public static class CQueue {
        private final int[] stack1;
        private final int[] stack2;
        private int p1, p2;

        public CQueue() {
            stack1 = new int[10000];
            stack2 = new int[10000];
        }

        public void appendTail(int value) {
            stack1[p1++] = value;
        }

        public int deleteHead() {
            if (p2 == 0) {
                if (p1 == 0) {
                    return -1;
                }
                while (p1 > 0) {
                    stack2[p2++] = stack1[--p1];
                }
            }
            return stack2[--p2];
        }
    }
}
