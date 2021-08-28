package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.Test;
import com.hkllyx.solution.util.TestUtils;
import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;

/**
 * @author hkllyx
 * @date 2021/04/19
 */
@Solution(no = "27", difficulty = Difficulty.SIMPLE, url = "https://leetcode-cn.com/problems/remove-element/")
public class RemoveElement {

    public static void main(String[] args) {
        TestUtils.assertion(RemoveElement.class, 2, new int[]{3, 2, 2, 3}, 3);
        TestUtils.assertion(RemoveElement.class, 5, new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2);
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
