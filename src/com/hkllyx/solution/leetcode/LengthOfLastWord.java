package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;

/**
 * <p>Given a string <code>s</code> consisting&nbsp;of some words separated by some number of spaces, return <em>the length of the <strong>last</strong> word in the string.</em></p>
 *
 * <p>A <strong>word</strong> is a maximal substring consisting of non-space characters only.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> s = &quot;Hello World&quot;
 * <strong>Output:</strong> 5
 * <strong>Explanation:</strong> The last word is &quot;World&quot; with length 5.
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> s = &quot;   fly me   to   the moon  &quot;
 * <strong>Output:</strong> 4
 * <strong>Explanation:</strong> The last word is &quot;moon&quot; with length 4.
 * </pre>
 *
 * <p><strong>Example 3:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> s = &quot;luffy is still joyboy&quot;
 * <strong>Output:</strong> 6
 * <strong>Explanation:</strong> The last word is &quot;joyboy&quot; with length 6.
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= s.length &lt;= 10<sup>4</sup></code></li>
 * 	<li><code>s</code> consists of only English letters and spaces <code>&#39; &#39;</code>.</li>
 * 	<li>There will be at least one word in <code>s</code>.</li>
 * </ul>
 * <div><div>Related Topics</div><div><li>字符串</li></div></div><br><div><li>👍 437</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2022/03/21
 */
@Solution(no = "58", title = "Length of Last Word", difficulty = Difficulty.EASY, url = "https://leetcode-cn.com/problems/length-of-last-word/")
public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        int res = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                res++;
            } else if (res > 0) {
                break;
            }
        }
        return res;
    }
}
