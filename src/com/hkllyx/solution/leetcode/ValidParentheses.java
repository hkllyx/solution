package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <p>Given a string <code>s</code> containing just the characters <code>&#39;(&#39;</code>, <code>&#39;)&#39;</code>, <code>&#39;{&#39;</code>, <code>&#39;}&#39;</code>, <code>&#39;[&#39;</code> and <code>&#39;]&#39;</code>, determine if the input string is valid.</p>
 *
 * <p>An input string is valid if:</p>
 *
 * <ol>
 * 	<li>Open brackets must be closed by the same type of brackets.</li>
 * 	<li>Open brackets must be closed in the correct order.</li>
 * </ol>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> s = &quot;()&quot;
 * <strong>Output:</strong> true
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> s = &quot;()[]{}&quot;
 * <strong>Output:</strong> true
 * </pre>
 *
 * <p><strong>Example 3:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> s = &quot;(]&quot;
 * <strong>Output:</strong> false
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= s.length &lt;= 10<sup>4</sup></code></li>
 * 	<li><code>s</code> consists of parentheses only <code>&#39;()[]{}&#39;</code>.</li>
 * </ul>
 * <div><div>Related Topics</div><div><li>栈</li><li>字符串</li></div></div><br><div><li>👍 2924</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2022/01/24
 */
@Solution(no = "20", title = "Valid Parentheses", difficulty = Difficulty.EASY, url = "https://leetcode-cn.com/problems/valid-parentheses/")
public class ValidParentheses {

    public static void main(String[] args) {
        Assertions.assertExpect(true, "[()]{}");
        Assertions.assertExpect(true, "()[]{}");
    }

    @Test(active = false)
    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0, l = s.length(); i < l; i++) {
            char c = s.charAt(i), peek;
            if (!stack.isEmpty() && (c - (peek = stack.peek()) == 1 || c - peek == 2)) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    @Test
    public boolean isValid1(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        char[] stack = new char[s.length()];
        int point = 0;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(':
                    stack[point++] = '(';
                    break;
                case '[':
                    stack[point++] = '[';
                    break;
                case '{':
                    stack[point++] = '{';
                    break;
                case ')':
                    if (point == 0 || stack[--point] != '(') {
                        return false;
                    }
                    break;
                case ']':
                    if (point == 0 || stack[--point] != '[') {
                        return false;
                    }
                    break;
                case '}':
                    if (point == 0 || stack[--point] != '{') {
                        return false;
                    }
                    break;
                default:
                    return false;
            }
        }
        return point == 0;
    }
}
