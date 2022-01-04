package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.info.Tag;
import com.hkllyx.solution.util.info.Tags;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * <p>Given a string <code>s</code>, find the length of the <strong>longest substring</strong> without repeating characters.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> s = &quot;abcabcbb&quot;
 * <strong>Output:</strong> 3
 * <strong>Explanation:</strong> The answer is &quot;abc&quot;, with the length of 3.
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> s = &quot;bbbbb&quot;
 * <strong>Output:</strong> 1
 * <strong>Explanation:</strong> The answer is &quot;b&quot;, with the length of 1.
 * </pre>
 *
 * <p><strong>Example 3:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> s = &quot;pwwkew&quot;
 * <strong>Output:</strong> 3
 * <strong>Explanation:</strong> The answer is &quot;wke&quot;, with the length of 3.
 * Notice that the answer must be a substring, &quot;pwke&quot; is a subsequence and not a substring.
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>0 &lt;= s.length &lt;= 5 * 10<sup>4</sup></code></li>
 * 	<li><code>s</code> consists of English letters, digits, symbols and spaces.</li>
 * </ul>
 * <div><div>Related Topics</div><div><li>哈希表</li><li>字符串</li><li>滑动窗口</li></div></div><br><div><li>👍 6683</li><li>👎 0</li></div>
 *
 * @author hkllyx
 * @date 2021/04/19
 */
@Solution(no = "3", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/")
@Tags({Tag.HASH_TABLE, Tag.TWO_POINTERS, Tag.STRING, Tag.SLIDING_WINDOW})
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        Assertions.assertExpect(LongestSubstringWithoutRepeatingCharacters.class, 3, "dvdf");
        Assertions.assertExpect(LongestSubstringWithoutRepeatingCharacters.class, 3, "abcabcbb");
        Assertions.assertExpect(LongestSubstringWithoutRepeatingCharacters.class, 1, "bbbbbbb");
        Assertions.assertExpect(LongestSubstringWithoutRepeatingCharacters.class, 3, "pwwkew");
        Assertions.assertExpect(LongestSubstringWithoutRepeatingCharacters.class, 5, "abcde");
    }

    @Test(active = false)
    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        HashSet<Character> set = new HashSet<>(length);
        int max = 0;
        for (int i = 0, j = 0; j < length; j++) {
            char jc = s.charAt(j);
            if (!set.add(jc)) {
                max = Math.max(max, set.size());
                // 将 i 移到和 j 处相同字符位之后
                while (i < j) {
                    char ic = s.charAt(i++);
                    if (ic == jc) {
                        break;
                    }
                    set.remove(ic);
                }
                if (max >= length - i) {
                    return max;
                }
            }
        }
        return Math.max(max, set.size());
    }

    @Test
    public int lengthOfLongestSubstring1(String s) {
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0, j = -1; i < s.length(); i++) {
            int cur = i - j;
            Integer pre = map.put(s.charAt(i), i);
            // 有重复，移动j到重复处，并将当前长度-1
            if (pre != null && pre > j) {
                j = pre;
                cur--;
            }
            max = Math.max(max, cur);
        }
        return max;
    }
}
