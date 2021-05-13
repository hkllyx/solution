package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.info.Difficulty;
import com.hkllyx.solution.info.Solution;
import com.hkllyx.solution.util.Test;
import com.hkllyx.solution.util.TestUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xiaoyong3
 * @date 2021/04/30
 */
@Solution(no = "12", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/integer-to-roman/")
public class IntegerToRoman {
    private static final Map<Integer, Character> MAP = new HashMap<>(7);
    private static final int[] INTEGERS = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] ROMANS = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    static {
        MAP.put(1, 'I');
        MAP.put(5, 'V');
        MAP.put(10, 'X');
        MAP.put(50, 'L');
        MAP.put(100, 'C');
        MAP.put(500, 'D');
        MAP.put(1000, 'M');
    }

    public static void main(String[] args) {
        TestUtils.assertion(IntegerToRoman.class, "MCMXCIV", 1994);
        TestUtils.assertion(IntegerToRoman.class, "LVIII", 58);
        TestUtils.assertion(IntegerToRoman.class, "IX", 9);
        TestUtils.assertion(IntegerToRoman.class, "IV", 4);
        TestUtils.assertion(IntegerToRoman.class, "III", 3);
    }

    public String intToRoman1(int num) {
        if (num < 1 || num > 3999) {
            throw new IllegalArgumentException();
        }
        char[] buffer = new char[32];
        int index = buffer.length;
        int one = 1, four = 4, five = 5, nine = 9;
        while (num > 0) {
            int ten = one * 10;
            int tmp = num % ten;
            Character oneChar = MAP.get(one);
            if (tmp == nine) {
                buffer[--index] = MAP.get(ten);
                buffer[--index] = oneChar;
            } else if (tmp >= five) {
                for (int i = 0; i < (tmp - five) / one; i++) {
                    buffer[--index] = oneChar;
                }
                buffer[--index] = MAP.get(five);
            } else if (tmp == four) {
                buffer[--index] = MAP.get(five);
                buffer[--index] = oneChar;
            } else {
                for (int i = 0; i < tmp / one; i++) {
                    buffer[--index] = oneChar;
                }
            }
            num -= tmp;
            one = ten;
            four *= 10;
            five *= 10;
            nine *= 10;
        }
        return new String(buffer, index, buffer.length - index);
    }

    /**
     * faster
     */
    @Test
    public String intToRoman2(int num) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; num > 0; ) {
            if (num >= INTEGERS[i]) {
                builder.append(ROMANS[i]);
                num -= INTEGERS[i];
            } else {
                i++;
            }
        }
        return builder.toString();
    }
}
