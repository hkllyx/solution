package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;

/**
 *
 * <p>Write a function to find the longest common prefix string amongst an array of strings.</p>
 *
 * <p>If there is no common prefix, return an empty string <code>&quot;&quot;</code>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> strs = [&quot;flower&quot;,&quot;flow&quot;,&quot;flight&quot;]
 * <strong>Output:</strong> &quot;fl&quot;
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> strs = [&quot;dog&quot;,&quot;racecar&quot;,&quot;car&quot;]
 * <strong>Output:</strong> &quot;&quot;
 * <strong>Explanation:</strong> There is no common prefix among the input strings.
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= strs.length &lt;= 200</code></li>
 * 	<li><code>0 &lt;= strs[i].length &lt;= 200</code></li>
 * 	<li><code>strs[i]</code> consists of only lower-case English letters.</li>
 * </ul>
 * <div><div>Related Topics</div><div><li>字符串</li></div></div><br><div><li>👍 1985</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2022/01/24
 */
@Solution(no = "14", title = "Longest Common Prefix", difficulty = Difficulty.EASY, url = "https://leetcode-cn.com/problems/longest-common-prefix/")
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() <= i || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}
