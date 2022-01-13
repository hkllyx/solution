package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

/**
 * <p>A message containing letters from <code>A-Z</code> can be <strong>encoded</strong> into numbers using the following mapping:</p>
 *
 * <pre>
 * &#39;A&#39; -&gt; &quot;1&quot;
 * &#39;B&#39; -&gt; &quot;2&quot;
 * ...
 * &#39;Z&#39; -&gt; &quot;26&quot;
 * </pre>
 *
 * <p>To <strong>decode</strong> an encoded message, all the digits must be grouped then mapped back into letters using the reverse of the mapping above (there may be multiple ways). For example, <code>&quot;11106&quot;</code> can be mapped into:</p>
 *
 * <ul>
 * 	<li><code>&quot;AAJF&quot;</code> with the grouping <code>(1 1 10 6)</code></li>
 * 	<li><code>&quot;KJF&quot;</code> with the grouping <code>(11 10 6)</code></li>
 * </ul>
 *
 * <p>Note that the grouping <code>(1 11 06)</code> is invalid because <code>&quot;06&quot;</code> cannot be mapped into <code>&#39;F&#39;</code> since <code>&quot;6&quot;</code> is different from <code>&quot;06&quot;</code>.</p>
 *
 * <p>Given a string <code>s</code> containing only digits, return <em>the <strong>number</strong> of ways to <strong>decode</strong> it</em>.</p>
 *
 * <p>The test cases are generated so that the answer fits in a <strong>32-bit</strong> integer.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> s = &quot;12&quot;
 * <strong>Output:</strong> 2
 * <strong>Explanation:</strong> &quot;12&quot; could be decoded as &quot;AB&quot; (1 2) or &quot;L&quot; (12).
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> s = &quot;226&quot;
 * <strong>Output:</strong> 3
 * <strong>Explanation:</strong> &quot;226&quot; could be decoded as &quot;BZ&quot; (2 26), &quot;VF&quot; (22 6), or &quot;BBF&quot; (2 2 6).
 * </pre>
 *
 * <p><strong>Example 3:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> s = &quot;06&quot;
 * <strong>Output:</strong> 0
 * <strong>Explanation:</strong> &quot;06&quot; cannot be mapped to &quot;F&quot; because of the leading zero (&quot;6&quot; is different from &quot;06&quot;).
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= s.length &lt;= 100</code></li>
 * 	<li><code>s</code> contains only digits and may contain leading zero(s).</li>
 * </ul>
 * <div><div>Related Topics</div><div><li>字符串</li><li>动态规划</li></div></div><br><div><li>👍 1044</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2021/04/21
 */
@Solution(no = "91", title = "Decode Ways", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/decode-ways/")
public class DecodeWays {

    public static void main(String[] args) {
        Assertions.assertExpect(DecodeWays.class, 1, "2101");
        Assertions.assertExpect(DecodeWays.class, 1, "120");
        Assertions.assertExpect(DecodeWays.class, 1, "101");
        Assertions.assertExpect(DecodeWays.class, 3, "1201234");
        Assertions.assertExpect(DecodeWays.class, 1, "99");
        Assertions.assertExpect(DecodeWays.class, 0, "0");
        Assertions.assertExpect(DecodeWays.class, 0, "06");
        Assertions.assertExpect(DecodeWays.class, 3, "226");
        Assertions.assertExpect(DecodeWays.class, 2, "12");
    }

    @Test
    public int numDecodings(String s) {
        if (s == null || s.isEmpty() || s.charAt(0) == '0') {
            return 0;
        }
        int p0 = 1;
        int p1 = 1;
        for (int i = 1; i < s.length(); i++) {
            char cur = s.charAt(i);
            char pre = s.charAt(i - 1);
            int p2;
            if (cur == '0' && pre != '1' && pre != '2') {
                return 0;
            } else if (cur == '0') {
                p2 = p0;
            } else if ((pre == '1' && (cur >= '1' && cur <= '9')) || (pre == '2' && (cur >= '1' && cur <= '6'))) {
                p2 = p0 + p1;
            } else {
                p2 = p1;
            }
            p0 = p1;
            p1 = p2;
        }
        return p1;
    }
}
