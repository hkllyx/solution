package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

/**
 * <p>Given two binary strings <code>a</code> and <code>b</code>, return <em>their sum as a binary string</em>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 * <pre><strong>Input:</strong> a = "11", b = "1"
 * <strong>Output:</strong> "100"
 * </pre><p><strong>Example 2:</strong></p>
 * <pre><strong>Input:</strong> a = "1010", b = "1011"
 * <strong>Output:</strong> "10101"
 * </pre>
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= a.length, b.length &lt;= 10<sup>4</sup></code></li>
 * 	<li><code>a</code> and <code>b</code> consist&nbsp;only of <code>&#39;0&#39;</code> or <code>&#39;1&#39;</code> characters.</li>
 * 	<li>Each string does not contain leading zeros except for the zero itself.</li>
 * </ul>
 * <div><div>Related Topics</div><div><li>位运算</li><li>数学</li><li>字符串</li><li>模拟</li></div></div><br><div><li>👍 807</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2022/05/01
 */
@Solution(no = "67", title = "Add Binary", difficulty = Difficulty.EASY, url = "https://leetcode-cn.com/problems/add-binary/")
public class AddBinary {

    public static void main(String[] args) {
        Assertions.assertExpect("0", "0", "0");
        Assertions.assertExpect("100", "11", "1");
        Assertions.assertExpect("10101", "1010", "1011");
    }

    @Test
    public String addBinary(String a, String b) {
        if (a.length() < b.length()) {
            String t = a;
            a = b;
            b = t;
        }
        char[] res = new char[a.length() + 1];
        res[0] = '0';
        for (int i = 0; i < a.length(); i++) {
            res[i + 1] = a.charAt(i);
        }
        for (int i = b.length() - 1, j = res.length - 1; i >= 0; i--, j--) {
            if (b.charAt(i) == '1') {
                res[j]++;
            }
        }
        for (int i = res.length - 1; i > 0; i--) {
            if (res[i] > '1') {
                res[i] -= 2;
                res[i - 1]++;
            }
        }
        int offset = res[0] == '0' ? 1 : 0;
        return new String(res, offset, res.length - offset);
    }
}
