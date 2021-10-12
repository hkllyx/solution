package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.info.Status;
import com.hkllyx.solution.util.test.Test;
import com.hkllyx.solution.util.test.TestUtils;

/**
 * @author xiaoyong3
 * @date 2021/10/12
 */
@Solution(no = "29", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/divide-two-integers/", status = Status.HELPED)
public class DivideTwoIntegers {

    public static void main(String[] args) {
        TestUtils.assertion(1, 1, 1);
        TestUtils.assertion(3, 10, 3);
        TestUtils.assertion(-2, 7, -3);
        TestUtils.assertion(Integer.MAX_VALUE, Integer.MIN_VALUE, -1);
        TestUtils.assertion(Integer.MIN_VALUE, Integer.MIN_VALUE, 1);
    }

    @Test
    public int divide(int dividend, int divisor) {
        boolean positive = (dividend ^ divisor) >= 0;
        long dividendLong = Math.abs((long) dividend);
        long divisorLong = Math.abs((long) divisor);
        int res = 0;
        for (int i = 31; i >= 0 && dividendLong >= divisorLong; i--) {
            long tmp = divisorLong << i;
            if (dividendLong >= tmp) {
                res += (1 << i);
                dividendLong -= tmp;
            }
        }
        return positive ? res < 0 ? Integer.MAX_VALUE : res : -res;
    }
}
