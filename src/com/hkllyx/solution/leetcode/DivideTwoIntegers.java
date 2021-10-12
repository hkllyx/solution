package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.info.Status;

/**
 * @author xiaoyong3
 * @date 2021/10/12
 */
@Solution(no = "29", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/divide-two-integers/", status = Status.HELPED)
public class DivideTwoIntegers {

    public int divide(int dividend, int divisor) {
        boolean isMinDividend = dividend == Integer.MIN_VALUE;
        if (divisor == Integer.MIN_VALUE) {
            return isMinDividend ? 1 : 0;
        }
        if (isMinDividend && divisor == 1) {
            return Integer.MIN_VALUE;
        }
        if (isMinDividend && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        boolean positive = (dividend ^ divisor) > 0;
        dividend = dividend > 0 ? dividend : isMinDividend ? Integer.MAX_VALUE : -dividend;
        divisor = divisor > 0 ? divisor : -divisor;
        int res = isMinDividend && divisor == 2 ? 1 : 0;
        for (int i = 1; i < 32; i++) {
            if ((dividend >> i) < divisor) {
                dividend -= 1;
            }
        }
        return positive ? res : -res;
    }
}
