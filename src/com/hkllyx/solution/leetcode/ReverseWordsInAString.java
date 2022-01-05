package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

/**
 * <p>Given an input string <code>s</code>, reverse the order of the <strong>words</strong>.</p>
 *
 * <p>A <strong>word</strong> is defined as a sequence of non-space characters. The <strong>words</strong> in <code>s</code> will be separated by at least one space.</p>
 *
 * <p>Return <em>a string of the words in reverse order concatenated by a single space.</em></p>
 *
 * <p><b>Note</b> that <code>s</code> may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> s = &quot;the sky is blue&quot;
 * <strong>Output:</strong> &quot;blue is sky the&quot;
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> s = &quot;  hello world  &quot;
 * <strong>Output:</strong> &quot;world hello&quot;
 * <strong>Explanation:</strong> Your reversed string should not contain leading or trailing spaces.
 * </pre>
 *
 * <p><strong>Example 3:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> s = &quot;a good   example&quot;
 * <strong>Output:</strong> &quot;example good a&quot;
 * <strong>Explanation:</strong> You need to reduce multiple spaces between two words to a single space in the reversed string.
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= s.length &lt;= 10<sup>4</sup></code></li>
 * 	<li><code>s</code> contains English letters (upper-case and lower-case), digits, and spaces <code>&#39; &#39;</code>.</li>
 * 	<li>There is <strong>at least one</strong> word in <code>s</code>.</li>
 * </ul>
 *
 * <p>&nbsp;</p>
 * <p><b data-stringify-type="bold">Follow-up:&nbsp;</b>If the string data type is mutable in your language, can&nbsp;you solve it&nbsp;<b data-stringify-type="bold">in-place</b>&nbsp;with&nbsp;<code data-stringify-type="code">O(1)</code>&nbsp;extra space?</p>
 * <div><div>Related Topics</div><div><li>双指针</li><li>字符串</li></div></div><br><div><li>👍 421</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2022/01/05
 */
@Solution(no = "151", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/reverse-words-in-a-string/")
public class ReverseWordsInAString {

    public static void main(String[] args) {
        Assertions.assertExpect("blue is sky the", "the sky is blue");
        Assertions.assertExpect("world hello", "  hello world  ");
        Assertions.assertExpect("example good a", "a good   example");
    }

    @Test
    public String reverseWords(String s) {
        int oldLen = s.length(), newLen = 0;
        char[] arr = new char[oldLen];
        int l = s.length() - 1, r = l;
        while (l >= -1) {
            if (l == -1 || s.charAt(l) == ' ') {
                if (l == r) {
                    l--;
                    r--;
                } else {
                    if (newLen != 0) {
                        arr[newLen++] = ' ';
                    }
                    for (int i = l + 1; i <= r; i++) {
                        arr[newLen++] = s.charAt(i);
                    }
                    r = l;
                }
            } else {
                l--;
            }
        }
        return new String(arr, 0, newLen);
    }
}
