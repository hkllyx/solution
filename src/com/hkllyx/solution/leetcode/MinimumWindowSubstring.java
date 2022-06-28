package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Given two strings <code>s</code> and <code>t</code> of lengths <code>m</code> and <code>n</code> respectively, return <em>the <strong>minimum window substring</strong> of </em><code>s</code><em> such that every character in </em><code>t</code><em> (<strong>including duplicates</strong>) is included in the window. If there is no such substring</em><em>, return the empty string </em><code>&quot;&quot;</code><em>.</em></p>
 *
 * <p>The testcases will be generated such that the answer is <strong>unique</strong>.</p>
 *
 * <p>A <strong>substring</strong> is a contiguous sequence of characters within the string.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> s = &quot;ADOBECODEBANC&quot;, t = &quot;ABC&quot;
 * <strong>Output:</strong> &quot;BANC&quot;
 * <strong>Explanation:</strong> The minimum window substring &quot;BANC&quot; includes &#39;A&#39;, &#39;B&#39;, and &#39;C&#39; from string t.
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> s = &quot;a&quot;, t = &quot;a&quot;
 * <strong>Output:</strong> &quot;a&quot;
 * <strong>Explanation:</strong> The entire string s is the minimum window.
 * </pre>
 *
 * <p><strong>Example 3:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> s = &quot;a&quot;, t = &quot;aa&quot;
 * <strong>Output:</strong> &quot;&quot;
 * <strong>Explanation:</strong> Both &#39;a&#39;s from t must be included in the window.
 * Since the largest window of s only has one &#39;a&#39;, return empty string.
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>m == s.length</code></li>
 * 	<li><code>n == t.length</code></li>
 * 	<li><code>1 &lt;= m, n&nbsp;&lt;= 10<sup>5</sup></code></li>
 * 	<li><code>s</code> and <code>t</code> consist of uppercase and lowercase English letters.</li>
 * </ul>
 *
 * <p>&nbsp;</p>
 * <strong>Follow up:</strong> Could you find an algorithm that runs in <code>O(m + n)</code> time?<div><div>Related Topics</div><div><li>哈希表</li><li>字符串</li><li>滑动窗口</li></div></div><br><div><li>👍 1957</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2022/06/28
 */
@Solution(no = "76", title = "Minimum Window Substring", difficulty = Difficulty.HARD, url = "https://leetcode-cn.com/problems/minimum-window-substring/")
public class MinimumWindowSubstring {

    public static void main(String[] args) {
        Assertions.assertExpect("BANC", "ADOBECODEBANC", "ABC");
        Assertions.assertExpect("a", "a", "a");
        Assertions.assertExpect("", "a", "aa");
        Assertions.assertExpect("", "a", "b");
    }

    @Test
    public String minWindow(String s, String t) {
        int m = s.length(), n = t.length();
        if (m < n) {
            return "";
        }
        // 汇总数量
        Map<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        // 记录最小窗口，窗口已包含目标字母数
        int left = 0, right = -1, contains = 0;
        // 遍历，初始窗口左右侧都是0
        for (int l = 0, r = 0; ; l++, r++) {
            // 窗口右侧向前移动，直至包含t中所有字母
            for (; r < m; r++) {
                Integer count = tMap.get(s.charAt(r));
                if (count == null) {
                    continue;
                }
                tMap.put(s.charAt(r), count - 1);
                // 已经包含足够数量该字母。比如已经包含了两个'a'，第三个'a'出现不会增加contains数
                if (count <= 0) {
                    continue;
                }
                contains++;
                // 全部包含
                if (contains == n) {
                    if (right < 0 || r - l < right - left) {
                        left = l;
                        right = r;
                    }
                    // 中断，窗口左侧向前滑动，找到最小窗口
                    break;
                }
            }
            // 窗口右侧滑到最后没有包含所有t中字母
            if (contains < n) {
                break;
            }
            // 窗口左侧向前滑动
            for (; l <= r; l++) {
                Integer count = tMap.get(s.charAt(l));
                if (count != null) {
                    tMap.put(s.charAt(l), count + 1);
                    if (count >= 0) {
                        // 包含的字母减少
                        contains--;
                        // 查看最小
                        if (r - l < right - left) {
                            left = l;
                            right = r;
                        }
                        // 中断，接着窗口右侧向前滑动
                        break;
                    }
                }
            }
        }
        return s.substring(left, right + 1);
    }
}
