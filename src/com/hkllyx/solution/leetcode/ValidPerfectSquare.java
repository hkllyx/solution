package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

/**
 * @author hkllyx
 * @date 2021-11-04
 */
@Solution(no = "367", difficulty = Difficulty.SIMPLE, url = "https://leetcode-cn.com/problems/valid-perfect-square/")
public class ValidPerfectSquare {

    public static void main(String[] args) {
        Assertions.assertExpect(false, 14);
        Assertions.assertExpect(true, 1);
        Assertions.assertExpect(true, 9);
        Assertions.assertExpect(true, 25);
        Assertions.assertExpect(false, 32);
    }

    @Test(value = "暴力", mills = -1, active = false)
    public boolean isPerfectSquare(int num) {
        for (int i = 0; i <= num; i++) {
            int s = i * i;
            if (s == num) {
                return true;
            } else if (s > num) {
                break;
            }
        }
        return false;
    }

    @Test(value = "二分法", mills = 0)
    public boolean isPerfectSquare1(int num) {
        if (num <= 1) {
            return true;
        }
        for (int i = num >> 1, j = num; i < j; ) {
            int k = num / i, m = i * k;
            if (i == k) {
                return m == num;
            }
            if (i > k) {
                j = i;
                i >>= 1;
            } else if (j == i + 1) {
                break;
            } else {
                i = (i + j) >> 1;
            }
        }
        return false;
    }
}
