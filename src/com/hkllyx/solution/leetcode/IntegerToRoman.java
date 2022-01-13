package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Roman numerals are represented by seven different symbols:&nbsp;<code>I</code>, <code>V</code>, <code>X</code>, <code>L</code>, <code>C</code>, <code>D</code> and <code>M</code>.</p>
 *
 * <pre>
 * <strong>Symbol</strong>       <strong>Value</strong>
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000</pre>
 *
 * <p>For example,&nbsp;<code>2</code> is written as <code>II</code>&nbsp;in Roman numeral, just two one&#39;s added together. <code>12</code> is written as&nbsp;<code>XII</code>, which is simply <code>X + II</code>. The number <code>27</code> is written as <code>XXVII</code>, which is <code>XX + V + II</code>.</p>
 *
 * <p>Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not <code>IIII</code>. Instead, the number four is written as <code>IV</code>. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as <code>IX</code>. There are six instances where subtraction is used:</p>
 *
 * <ul>
 * 	<li><code>I</code> can be placed before <code>V</code> (5) and <code>X</code> (10) to make 4 and 9.&nbsp;</li>
 * 	<li><code>X</code> can be placed before <code>L</code> (50) and <code>C</code> (100) to make 40 and 90.&nbsp;</li>
 * 	<li><code>C</code> can be placed before <code>D</code> (500) and <code>M</code> (1000) to make 400 and 900.</li>
 * </ul>
 *
 * <p>Given an integer, convert it to a roman numeral.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> num = 3
 * <strong>Output:</strong> &quot;III&quot;
 * <strong>Explanation:</strong> 3 is represented as 3 ones.
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> num = 58
 * <strong>Output:</strong> &quot;LVIII&quot;
 * <strong>Explanation:</strong> L = 50, V = 5, III = 3.
 * </pre>
 *
 * <p><strong>Example 3:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> num = 1994
 * <strong>Output:</strong> &quot;MCMXCIV&quot;
 * <strong>Explanation:</strong> M = 1000, CM = 900, XC = 90 and IV = 4.
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= num &lt;= 3999</code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>哈希表</li><li>数学</li><li>字符串</li></div></div><br><div><li>👍 752</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2021/04/30
 */
@Solution(no = "12", title = "Integer to Roman", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/integer-to-roman/")
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
        Assertions.assertExpect(IntegerToRoman.class, "MCMXCIV", 1994);
        Assertions.assertExpect(IntegerToRoman.class, "LVIII", 58);
        Assertions.assertExpect(IntegerToRoman.class, "IX", 9);
        Assertions.assertExpect(IntegerToRoman.class, "IV", 4);
        Assertions.assertExpect(IntegerToRoman.class, "III", 3);
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
