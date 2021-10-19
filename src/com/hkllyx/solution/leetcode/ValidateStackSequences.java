package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

/**
 * @author xiaoyong3
 * @date 2021/06/07
 */
@Solution(no = "946", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/validate-stack-sequences/")
public class ValidateStackSequences {

    public static void main(String[] args) {
        Assertions.assertExpect(ValidateStackSequences.class, true, new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1});
        Assertions.assertExpect(ValidateStackSequences.class, false, new int[]{1, 2, 3, 4, 5},
                new int[]{4, 3, 5, 1, 2});
    }

    @Test
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int length = pushed.length;
        if (length != popped.length) {
            return false;
        }
        int[] stack = new int[length];
        int p = -1, i = 0, j = 0;
        while (j < length) {
            if (p >= 0 && stack[p] == popped[j]) {
                p--;
                j++;
            } else if (i < length) {
                stack[++p] = pushed[i++];
            } else {
                return false;
            }
        }
        return true;
    }
}
