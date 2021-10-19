package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

/**
 * @author xiaoyong3
 * @date 2021/06/03
 */
@Solution(no = "剑指Offer 20", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof/")
public class 表示数值的字符串 {

    public static void main(String[] args) {
        for (String s : new String[]{"+100", "5e2", "-123", "3.1416", "-1E-16", "0123", ".1", "3.", "   1.   "}) {
            Assertions.assertExpect(表示数值的字符串.class, true, s);
        }
        for (String s : new String[]{"12e", "1a3.14", "1.2.3", "+-5", "12e+5.4", "E9", "1 1", ".-4"}) {
            Assertions.assertExpect(表示数值的字符串.class, false, s);
        }
    }

    @Test
    public boolean isNumber(String s) {
        int from = 0, to = s.length();
        while (from < to && s.charAt(from) == ' ') {
            from++;
        }
        while (from < to && s.charAt(to - 1) == ' ') {
            to--;
        }
        return isNumber(s, from, to, true, true);
    }

    private boolean isNumber(String s, int from, int to, boolean acceptDot, boolean acceptE) {
        boolean acceptSign = true, hasNumber = false;
        for (int i = from; i < to; i++) {
            char c = s.charAt(i);
            if (c == '+' || c == '-') {
                if (acceptSign) {
                    acceptSign = false;
                } else {
                    return false;
                }
            } else if (c == '.') {
                if (acceptDot) {
                    acceptDot = false;
                    acceptSign = false;
                } else {
                    return false;
                }
            } else if (c >= '0' && c <= '9') {
                acceptSign = false;
                hasNumber = true;
            } else if (c == 'E' || c == 'e') {
                return hasNumber && acceptE && isNumber(s, i + 1, to, false, false);
            } else {
                return false;
            }
        }
        return hasNumber;
    }
}
