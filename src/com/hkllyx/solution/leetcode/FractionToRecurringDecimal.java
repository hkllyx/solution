package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Test;
import com.hkllyx.solution.util.test.TestUtils;

import java.util.HashMap;

/**
 * @author xiaoyong3
 * @date 2021/10/03
 */
@Solution(no = "166", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/fraction-to-recurring-decimal/")
public class FractionToRecurringDecimal {

    public static void main(String[] args) {
        TestUtils.assertion("2147483648", -2147483648, -1);
        TestUtils.assertion("0.0000000004656612873077392578125", -1, -2147483648);
        TestUtils.assertion("-0.58(3)", 7, -12);
        TestUtils.assertion("-6.25", -50, 8);
        TestUtils.assertion("2", 2, 1);
        TestUtils.assertion("0.5", 1, 2);
        TestUtils.assertion("0.(3)", 1, 3);
        TestUtils.assertion("0.(012)", 4, 333);
        TestUtils.assertion("0.1(6)", 1, 6);
        TestUtils.assertion("-2", -2, 1);
        TestUtils.assertion("-0.5", -1, 2);
        TestUtils.assertion("-0.(3)", -1, 3);
        TestUtils.assertion("-0.(012)", -4, 333);
        TestUtils.assertion("-0.1(6)", -1, 6);
    }

    @Test
    public String fractionToDecimal(int numerator, int denominator) {
        // 整数部分
        long integer = (long) numerator / denominator;
        long remainder = numerator % denominator;
        if (remainder == 0) {
            return Long.toString(integer);
        }
        StringBuilder decimal = new StringBuilder();
        if (integer == 0 && ((numerator > 0) ^ (denominator > 0))) {
            decimal.append('-');
        }
        decimal.append(integer).append('.');
        // 小数部分
        HashMap<Long, Integer> presented = new HashMap<>();
        for (int index = decimal.length(); remainder != 0; index++) {
            // 出现循环小数
            Integer preIndex = presented.put(remainder, index);
            if (preIndex != null) {
                decimal.insert(preIndex.intValue(), '(');
                decimal.append(')');
                break;
            }
            remainder *= 10;
            decimal.append((char) (Math.abs(remainder / denominator) + '0'));
            remainder %= denominator;
        }
        return decimal.toString();
    }
}
