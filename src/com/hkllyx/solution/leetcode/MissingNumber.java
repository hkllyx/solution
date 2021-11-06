package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

/**
 * @author xiaoyong3
 * @date 2021/11/06
 */
@Solution(no = "268", difficulty = Difficulty.SIMPLE, url = "https://leetcode-cn.com/problems/missing-number/")
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
