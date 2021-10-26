package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

/**
 * @author xiaoyong3
 * @date 2021/10/20
 */
@Solution(no = "453", difficulty = Difficulty.SIMPLE, url = "https://leetcode-cn.com/problems/minimum-moves-to-equal-array-elements/")
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
