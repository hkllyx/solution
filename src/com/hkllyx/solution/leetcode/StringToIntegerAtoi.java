package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.info.Tag;
import com.hkllyx.solution.util.info.Tags;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

/**
 * @author xiaoyong3
 * @date 2021/04/28
 */
@Solution(no = "8", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/string-to-integer-atoi/")
@Tags({Tag.MATH, Tag.STRING})
public class StringToIntegerAtoi {
    public static void main(String[] args) {
        Assertions.assertExpect(StringToIntegerAtoi.class, 2147483646, "2147483646");
        Assertions.assertExpect(StringToIntegerAtoi.class, 2147483647, "2147483647");
        Assertions.assertExpect(StringToIntegerAtoi.class, 2147483647, "2147483648");
        Assertions.assertExpect(StringToIntegerAtoi.class, -2147483647, "-2147483647");
        Assertions.assertExpect(StringToIntegerAtoi.class, -2147483648, "-2147483648");
        Assertions.assertExpect(StringToIntegerAtoi.class, -2147483648, "-2147483649");
        Assertions.assertExpect(StringToIntegerAtoi.class, 1234, "    1234");
        Assertions.assertExpect(StringToIntegerAtoi.class, 1234, "    1234   ");
        Assertions.assertExpect(StringToIntegerAtoi.class, -1234, "    -1234   ");
        Assertions.assertExpect(StringToIntegerAtoi.class, 0, "       ");
        Assertions.assertExpect(StringToIntegerAtoi.class, 0, "hh 1");
        Assertions.assertExpect(StringToIntegerAtoi.class, 0, "- ddd");
    }

    @Test
    public int myAtoi(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int res = 0;
        int flag = 0;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (flag != 0 && cur >= '0' && cur <= '9') {
                int n = cur - '0';
                if (flag == 1 && res > (Integer.MAX_VALUE - n) / 10) {
                    return Integer.MAX_VALUE;
                } else if (flag == -1 && -res < (Integer.MIN_VALUE + n) / 10) {
                    return Integer.MIN_VALUE;
                }
                res = res * 10 + n;
            } else if (flag != 0) {
                return flag * res;
            } else if (cur >= '0' && cur <= '9') {
                flag = 1;
                res = cur - '0';
            } else if (cur == ' ') {
            } else if (cur == '+') {
                flag = 1;
            } else if (cur == '-') {
                flag = -1;
            } else {
                return 0;
            }
        }
        return flag * res;
    }
}
