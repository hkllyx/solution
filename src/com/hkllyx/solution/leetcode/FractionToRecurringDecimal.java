package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

import java.util.HashMap;

/**
 * <p>Given two integers representing the <code>numerator</code> and <code>denominator</code> of a fraction, return <em>the fraction in string format</em>.</p>
 *
 * <p>If the fractional part is repeating, enclose the repeating part in parentheses.</p>
 *
 * <p>If multiple answers are possible, return <strong>any of them</strong>.</p>
 *
 * <p>It is <strong>guaranteed</strong> that the length of the answer string is less than <code>10<sup>4</sup></code> for all the given inputs.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> numerator = 1, denominator = 2
 * <strong>Output:</strong> &quot;0.5&quot;
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> numerator = 2, denominator = 1
 * <strong>Output:</strong> &quot;2&quot;
 * </pre>
 *
 * <p><strong>Example 3:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> numerator = 4, denominator = 333
 * <strong>Output:</strong> &quot;0.(012)&quot;
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>-2<sup>31</sup> &lt;=&nbsp;numerator, denominator &lt;= 2<sup>31</sup> - 1</code></li>
 * 	<li><code>denominator != 0</code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>哈希表</li><li>数学</li><li>字符串</li></div></div><br><div><li>👍 347</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2021/10/03
 */
@Solution(no = "166", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/fraction-to-recurring-decimal/")
public class FractionToRecurringDecimal {

    public static void main(String[] args) {
        Assertions.assertExpect("2147483648", -2147483648, -1);
        Assertions.assertExpect("0.0000000004656612873077392578125", -1, -2147483648);
        Assertions.assertExpect("-0.58(3)", 7, -12);
        Assertions.assertExpect("-6.25", -50, 8);
        Assertions.assertExpect("2", 2, 1);
        Assertions.assertExpect("0.5", 1, 2);
        Assertions.assertExpect("0.(3)", 1, 3);
        Assertions.assertExpect("0.(012)", 4, 333);
        Assertions.assertExpect("0.1(6)", 1, 6);
        Assertions.assertExpect("-2", -2, 1);
        Assertions.assertExpect("-0.5", -1, 2);
        Assertions.assertExpect("-0.(3)", -1, 3);
        Assertions.assertExpect("-0.(012)", -4, 333);
        Assertions.assertExpect("-0.1(6)", -1, 6);
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
