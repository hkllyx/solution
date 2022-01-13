package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.info.Status;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

/**
 * <p>Given a string <code>s</code> containing only three types of characters: <code>&#39;(&#39;</code>, <code>&#39;)&#39;</code> and <code>&#39;*&#39;</code>, return <code>true</code> <em>if</em> <code>s</code> <em>is <strong>valid</strong></em>.</p>
 *
 * <p>The following rules define a <strong>valid</strong> string:</p>
 *
 * <ul>
 * 	<li>Any left parenthesis <code>&#39;(&#39;</code> must have a corresponding right parenthesis <code>&#39;)&#39;</code>.</li>
 * 	<li>Any right parenthesis <code>&#39;)&#39;</code> must have a corresponding left parenthesis <code>&#39;(&#39;</code>.</li>
 * 	<li>Left parenthesis <code>&#39;(&#39;</code> must go before the corresponding right parenthesis <code>&#39;)&#39;</code>.</li>
 * 	<li><code>&#39;*&#39;</code> could be treated as a single right parenthesis <code>&#39;)&#39;</code> or a single left parenthesis <code>&#39;(&#39;</code> or an empty string <code>&quot;&quot;</code>.</li>
 * </ul>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 * <pre><strong>Input:</strong> s = "()"
 * <strong>Output:</strong> true
 * </pre><p><strong>Example 2:</strong></p>
 * <pre><strong>Input:</strong> s = "(*)"
 * <strong>Output:</strong> true
 * </pre><p><strong>Example 3:</strong></p>
 * <pre><strong>Input:</strong> s = "(*))"
 * <strong>Output:</strong> true
 * </pre>
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= s.length &lt;= 100</code></li>
 * 	<li><code>s[i]</code> is <code>&#39;(&#39;</code>, <code>&#39;)&#39;</code> or <code>&#39;*&#39;</code>.</li>
 * </ul>
 * <div><div>Related Topics</div><div><li>栈</li><li>贪心</li><li>字符串</li><li>动态规划</li></div></div><br><div><li>👍 435</li><li>👎 0</li></div>
 *
 * @author hkllyx
 * @date 2021-09-12
 */
@Solution(no = "678", title = "Valid Parenthesis String", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/valid-parenthesis-string/", status = Status.FAILED)
public class ValidParenthesisString {

    public static void main(String[] args) {
        Assertions.assertExpect(true, "()");
        Assertions.assertExpect(true, "(*)");
        Assertions.assertExpect(false, ")(");
        Assertions.assertExpect(true, "(*))");
        Assertions.assertExpect(false,
                "(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())");
    }

    @Test
    public boolean checkValidString(String s) {
        int length = s.length(), left = 0, star = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                left++;
            } else if (c == '*') {
                star++;
            } else if (left > 0) {
                left--;
            } else if (star > 0) {
                star--;
            } else {
                return false;
            }
        }
        return star >= left;
    }
}
