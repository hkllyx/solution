package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Test;

/**
 * <p><strong>Balanced</strong> strings are those that have an equal quantity of <code>&#39;L&#39;</code> and <code>&#39;R&#39;</code> characters.</p>
 *
 * <p>Given a <strong>balanced</strong> string <code>s</code>, split it in the maximum amount of balanced strings.</p>
 *
 * <p>Return <em>the maximum amount of split <strong>balanced</strong> strings</em>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> s = &quot;RLRRLLRLRL&quot;
 * <strong>Output:</strong> 4
 * <strong>Explanation:</strong> s can be split into &quot;RL&quot;, &quot;RRLL&quot;, &quot;RL&quot;, &quot;RL&quot;, each substring contains same number of &#39;L&#39; and &#39;R&#39;.
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> s = &quot;RLLLLRRRLR&quot;
 * <strong>Output:</strong> 3
 * <strong>Explanation:</strong> s can be split into &quot;RL&quot;, &quot;LLLRRR&quot;, &quot;LR&quot;, each substring contains same number of &#39;L&#39; and &#39;R&#39;.
 * </pre>
 *
 * <p><strong>Example 3:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> s = &quot;LLLLRRRR&quot;
 * <strong>Output:</strong> 1
 * <strong>Explanation:</strong> s can be split into &quot;LLLLRRRR&quot;.
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= s.length &lt;= 1000</code></li>
 * 	<li><code>s[i]</code> is either <code>&#39;L&#39;</code> or <code>&#39;R&#39;</code>.</li>
 * 	<li><code>s</code> is a <strong>balanced</strong> string.</li>
 * </ul>
 * <div><div>Related Topics</div><div><li>贪心</li><li>字符串</li><li>计数</li></div></div><br><div><li>👍 175</li><li>👎 0</li></div>
 *
 * @author hkllyx
 * @date 2021-09-07
 */
@Solution(no = "1221", difficulty = Difficulty.SIMPLE, url = "https://leetcode-cn.com/problems/split-a-string-in-balanced-strings/")
public class SplitAStringInBalancedStrings {

    @Test
    public int balancedStringSplit(String s) {
        int lc = 0, rc = 0, res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'L') {
                lc++;
            } else if (c == 'R') {
                rc++;
            }
            if (lc !=0 && lc == rc) {
                res++;
                lc = rc = 0;
            }
        }
        return res;
    }

    @Test
    public int balancedStringSplit1(String s) {
        int counter = 0, res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'L') {
                counter++;
            } else {
                counter--;
            }
            if (counter == 0) {
                res++;
            }
        }
        return res;
    }
}
