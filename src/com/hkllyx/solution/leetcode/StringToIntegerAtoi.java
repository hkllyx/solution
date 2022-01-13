package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

/**
 * <p>Implement the <code>myAtoi(string s)</code> function, which converts a string to a 32-bit signed integer (similar to C/C++&#39;s <code>atoi</code> function).</p>
 *
 * <p>The algorithm for <code>myAtoi(string s)</code> is as follows:</p>
 *
 * <ol>
 * 	<li>Read in and ignore any leading whitespace.</li>
 * 	<li>Check if the next character (if not already at the end of the string) is <code>&#39;-&#39;</code> or <code>&#39;+&#39;</code>. Read this character in if it is either. This determines if the final result is negative or positive respectively. Assume the result is positive if neither is present.</li>
 * 	<li>Read in next the characters until the next non-digit character or the end of the input is reached. The rest of the string is ignored.</li>
 * 	<li>Convert these digits into an integer (i.e. <code>&quot;123&quot; -&gt; 123</code>, <code>&quot;0032&quot; -&gt; 32</code>). If no digits were read, then the integer is <code>0</code>. Change the sign as necessary (from step 2).</li>
 * 	<li>If the integer is out of the 32-bit signed integer range <code>[-2<sup>31</sup>, 2<sup>31</sup> - 1]</code>, then clamp the integer so that it remains in the range. Specifically, integers less than <code>-2<sup>31</sup></code> should be clamped to <code>-2<sup>31</sup></code>, and integers greater than <code>2<sup>31</sup> - 1</code> should be clamped to <code>2<sup>31</sup> - 1</code>.</li>
 * 	<li>Return the integer as the final result.</li>
 * </ol>
 *
 * <p><strong>Note:</strong></p>
 *
 * <ul>
 * 	<li>Only the space character <code>&#39; &#39;</code> is considered a whitespace character.</li>
 * 	<li><strong>Do not ignore</strong> any characters other than the leading whitespace or the rest of the string after the digits.</li>
 * </ul>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> s = &quot;42&quot;
 * <strong>Output:</strong> 42
 * <strong>Explanation:</strong> The underlined characters are what is read in, the caret is the current reader position.
 * Step 1: &quot;42&quot; (no characters read because there is no leading whitespace)
 *          ^
 * Step 2: &quot;42&quot; (no characters read because there is neither a &#39;-&#39; nor &#39;+&#39;)
 *          ^
 * Step 3: &quot;<u>42</u>&quot; (&quot;42&quot; is read in)
 *            ^
 * The parsed integer is 42.
 * Since 42 is in the range [-2<sup>31</sup>, 2<sup>31</sup> - 1], the final result is 42.
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> s = &quot;   -42&quot;
 * <strong>Output:</strong> -42
 * <strong>Explanation:</strong>
 * Step 1: &quot;<u>   </u>-42&quot; (leading whitespace is read and ignored)
 *             ^
 * Step 2: &quot;   <u>-</u>42&quot; (&#39;-&#39; is read, so the result should be negative)
 *              ^
 * Step 3: &quot;   -<u>42</u>&quot; (&quot;42&quot; is read in)
 *                ^
 * The parsed integer is -42.
 * Since -42 is in the range [-2<sup>31</sup>, 2<sup>31</sup> - 1], the final result is -42.
 * </pre>
 *
 * <p><strong>Example 3:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> s = &quot;4193 with words&quot;
 * <strong>Output:</strong> 4193
 * <strong>Explanation:</strong>
 * Step 1: &quot;4193 with words&quot; (no characters read because there is no leading whitespace)
 *          ^
 * Step 2: &quot;4193 with words&quot; (no characters read because there is neither a &#39;-&#39; nor &#39;+&#39;)
 *          ^
 * Step 3: &quot;<u>4193</u> with words&quot; (&quot;4193&quot; is read in; reading stops because the next character is a non-digit)
 *              ^
 * The parsed integer is 4193.
 * Since 4193 is in the range [-2<sup>31</sup>, 2<sup>31</sup> - 1], the final result is 4193.
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>0 &lt;= s.length &lt;= 200</code></li>
 * 	<li><code>s</code> consists of English letters (lower-case and upper-case), digits (<code>0-9</code>), <code>&#39; &#39;</code>, <code>&#39;+&#39;</code>, <code>&#39;-&#39;</code>, and <code>&#39;.&#39;</code>.</li>
 * </ul>
 * <div><div>Related Topics</div><div><li>字符串</li></div></div><br><div><li>👍 1303</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2021/04/28
 */
@Solution(no = "8", title = "String to Integer (atoi)", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/string-to-integer-atoi/")
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
                // ignore
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
