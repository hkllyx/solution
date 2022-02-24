package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

/**
 * /**
 * <p>Given two non-negative integers <code>num1</code> and <code>num2</code> represented as strings, return the product of <code>num1</code> and <code>num2</code>, also represented as a string.</p>
 *
 * <p><strong>Note:</strong>&nbsp;You must not use any built-in BigInteger library or convert the inputs to integer directly.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 * <pre><strong>Input:</strong> num1 = "2", num2 = "3"
 * <strong>Output:</strong> "6"
 * </pre><p><strong>Example 2:</strong></p>
 * <pre><strong>Input:</strong> num1 = "123", num2 = "456"
 * <strong>Output:</strong> "56088"
 * </pre>
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= num1.length, num2.length &lt;= 200</code></li>
 * 	<li><code>num1</code> and <code>num2</code> consist of digits only.</li>
 * 	<li>Both <code>num1</code> and <code>num2</code>&nbsp;do not contain any leading zero, except the number <code>0</code> itself.</li>
 * </ul>
 * <div><div>Related Topics</div><div><li>数学</li><li>字符串</li><li>模拟</li></div></div><br><div><li>👍 835</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2022/02/21
 */
@Solution(no = "43", title = "Multiply Strings", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/multiply-strings/")
public class MultiplyStrings {

    public static void main(String[] args) {
        Assertions.assertExpect("891", "9", "99");
        Assertions.assertExpect("0", "0", "99");
        Assertions.assertExpect("100", "10", "10");
        Assertions.assertExpect("100", "10", "10");
        Assertions.assertExpect("9999999999998999990000000000001", "9999999999999", "999999999999999999");
    }

    @Test
    public String multiply(String num1, String num2) {
        // 计算
        int len1 = num1.length(), len2 = num2.length(), len = len1 + len2;
        int[] holder = new int[len];
        for (int i = len1 - 1; i >= 0; i--) {
            int n1 = num1.charAt(i) - '0';
            // k = len - (len1 - i) = len2 + i
            for (int j = len2 - 1, k = len2 + i; j >= 0; j--, k--) {
                int n2 = num2.charAt(j) - '0';
                holder[k] += n1 * n2;
            }
        }
        // 进位
        for (int i = len - 1; i > 0; i--) {
            if (holder[i] > 9) {
                int plus = holder[i] / 10;
                holder[i] %= 10;
                holder[i - 1] += plus;
            }
        }
        // 去除前导0
        int i = 0;
        while (i < len && holder[i] == 0) {
            i++;
        }
        // 结果
        if (i == len) {
            return "0";
        }
        StringBuilder res = new StringBuilder(len - i);
        while (i < len) {
            res.append((char) (holder[i++] + '0'));
        }
        return res.toString();
    }
}
