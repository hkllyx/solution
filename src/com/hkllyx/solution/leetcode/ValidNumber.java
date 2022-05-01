package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

/**
 * <p>A <strong>valid number</strong> can be split up into these components (in order):</p>
 *
 * <ol>
 * 	<li>A <strong>decimal number</strong> or an <strong>integer</strong>.</li>
 * 	<li>(Optional) An <code>&#39;e&#39;</code> or <code>&#39;E&#39;</code>, followed by an <strong>integer</strong>.</li>
 * </ol>
 *
 * <p>A <strong>decimal number</strong> can be split up into these components (in order):</p>
 *
 * <ol>
 * 	<li>(Optional) A sign character (either <code>&#39;+&#39;</code> or <code>&#39;-&#39;</code>).</li>
 * 	<li>One of the following formats:
 * 	<ol>
 * 		<li>One or more digits, followed by a dot <code>&#39;.&#39;</code>.</li>
 * 		<li>One or more digits, followed by a dot <code>&#39;.&#39;</code>, followed by one or more digits.</li>
 * 		<li>A dot <code>&#39;.&#39;</code>, followed by one or more digits.</li>
 * 	</ol>
 * 	</li>
 * </ol>
 *
 * <p>An <strong>integer</strong> can be split up into these components (in order):</p>
 *
 * <ol>
 * 	<li>(Optional) A sign character (either <code>&#39;+&#39;</code> or <code>&#39;-&#39;</code>).</li>
 * 	<li>One or more digits.</li>
 * </ol>
 *
 * <p>For example, all the following are valid numbers: <code>[&quot;2&quot;, &quot;0089&quot;, &quot;-0.1&quot;, &quot;+3.14&quot;, &quot;4.&quot;, &quot;-.9&quot;, &quot;2e10&quot;, &quot;-90E3&quot;, &quot;3e+7&quot;, &quot;+6e-1&quot;, &quot;53.5e93&quot;, &quot;-123.456e789&quot;]</code>, while the following are not valid numbers: <code>[&quot;abc&quot;, &quot;1a&quot;, &quot;1e&quot;, &quot;e3&quot;, &quot;99e2.5&quot;, &quot;--6&quot;, &quot;-+3&quot;, &quot;95a54e53&quot;]</code>.</p>
 *
 * <p>Given a string <code>s</code>, return <code>true</code><em> if </em><code>s</code><em> is a <strong>valid number</strong></em>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> s = &quot;0&quot;
 * <strong>Output:</strong> true
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> s = &quot;e&quot;
 * <strong>Output:</strong> false
 * </pre>
 *
 * <p><strong>Example 3:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> s = &quot;.&quot;
 * <strong>Output:</strong> false
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= s.length &lt;= 20</code></li>
 * 	<li><code>s</code> consists of only English letters (both uppercase and lowercase), digits (<code>0-9</code>), plus <code>&#39;+&#39;</code>, minus <code>&#39;-&#39;</code>, or dot <code>&#39;.&#39;</code>.</li>
 * </ul>
 * <div><div>Related Topics</div><div><li>字符串</li></div></div><br><div><li>👍 308</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2022/05/01
 */
@Solution(no = "65", title = "Valid Number", difficulty = Difficulty.HARD, url = "https://leetcode-cn.com/problems/valid-number/")
public class ValidNumber {

    public static void main(String[] args) {
        String[] valid = {"32.e-80123", "2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789"},
                invalid = {"abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53"};
        for (String s : valid) {
            Assertions.assertExpect(true, s);
        }
        for (String s : invalid) {
            Assertions.assertExpect(false, s);
        }
    }

    @Test
    public boolean isNumber(String s) {
        boolean digits = false, sign = false, e = false, dot = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                digits = true;
                // 出现数字后，就当已经出现了符号
                sign = true;
            } else if (c == '+' || c == '-') {
                // 出现数字、符号、小数点后不能再出现符号
                if (digits || sign || dot) {
                    return false;
                }
                sign = true;
            } else if (c == '.') {
                // 出现e/E、小数点之后不能再出现小数点
                if (e || dot) {
                    return false;
                }
                dot = true;
            } else if (c == 'e' || c == 'E') {
                // 出现数字之前，出现e之后，不能出现e
                if (!digits || e) {
                    return false;
                }
                e = true;
                // 出现e之后，清除符号、数字、小数点的出现状态
                digits = false;
                sign = false;
                dot = false;
            } else {
                return false;
            }
        }
        return digits;
    }
}
