package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

/**
 * <p>Given two version numbers,&nbsp;<code>version1</code> and <code>version2</code>, compare them.</p>
 *
 * <ul>
 * </ul>
 *
 * <p>Version numbers consist of <strong>one or more revisions</strong> joined by a dot&nbsp;<code>&#39;.&#39;</code>. Each revision&nbsp;consists of <strong>digits</strong>&nbsp;and may contain leading <strong>zeros</strong>. Every revision contains <strong>at least one character</strong>. Revisions are <strong>0-indexed from left to right</strong>, with the leftmost revision being revision 0, the next revision being revision 1, and so on. For example&nbsp;<code>2.5.33</code>&nbsp;and&nbsp;<code>0.1</code>&nbsp;are valid version numbers.</p>
 *
 * <p>To compare version numbers, compare their revisions in <strong>left-to-right order</strong>. Revisions are compared using their&nbsp;<strong>integer value ignoring any leading zeros</strong>. This means that revisions&nbsp;<code>1</code>&nbsp;and&nbsp;<code>001</code>&nbsp;are considered&nbsp;<strong>equal</strong>. If a version number does not specify a revision at an index, then&nbsp;<strong>treat the revision as&nbsp;<code>0</code></strong>. For example, version&nbsp;<code>1.0</code> is less than version&nbsp;<code>1.1</code>&nbsp;because their revision 0s are the same, but their revision 1s are&nbsp;<code>0</code>&nbsp;and&nbsp;<code>1</code>&nbsp;respectively, and&nbsp;<code>0 &lt; 1</code>.</p>
 *
 * <p><em>Return the following:</em></p>
 *
 * <ul>
 * 	<li>If <code>version1 &lt; version2</code>, return <code>-1</code>.</li>
 * 	<li>If <code>version1 &gt; version2</code>, return <code>1</code>.</li>
 * 	<li>Otherwise, return <code>0</code>.</li>
 * </ul>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> version1 = &quot;1.01&quot;, version2 = &quot;1.001&quot;
 * <strong>Output:</strong> 0
 * <strong>Explanation:</strong> Ignoring leading zeroes, both &quot;01&quot; and &quot;001&quot; represent the same integer &quot;1&quot;.
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> version1 = &quot;1.0&quot;, version2 = &quot;1.0.0&quot;
 * <strong>Output:</strong> 0
 * <strong>Explanation:</strong> version1 does not specify revision 2, which means it is treated as &quot;0&quot;.
 * </pre>
 *
 * <p><strong>Example 3:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> version1 = &quot;0.1&quot;, version2 = &quot;1.1&quot;
 * <strong>Output:</strong> -1
 * <strong>Explanation:</strong> version1&#39;s revision 0 is &quot;0&quot;, while version2&#39;s revision 0 is &quot;1&quot;. 0 &lt; 1, so version1 &lt; version2.
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= version1.length, version2.length &lt;= 500</code></li>
 * 	<li><code>version1</code> and <code>version2</code>&nbsp;only contain digits and <code>&#39;.&#39;</code>.</li>
 * 	<li><code>version1</code> and <code>version2</code>&nbsp;<strong>are valid version numbers</strong>.</li>
 * 	<li>All the given revisions in&nbsp;<code>version1</code> and <code>version2</code>&nbsp;can be stored in&nbsp;a&nbsp;<strong>32-bit integer</strong>.</li>
 * </ul>
 * <div><div>Related Topics</div><div><li>双指针</li><li>字符串</li></div></div><br><div><li>👍 256</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2021/09/01
 */
@Solution(no = "165", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/compare-version-numbers/")
public class CompareVersionNumbers {
    public static void main(String[] args) {
        Assertions.assertExpect(0, "1.01", "1.001");
        Assertions.assertExpect(0, "1.0", "1.0.0");
        Assertions.assertExpect(-1, "0.1", "1.1");
        Assertions.assertExpect(1, "1.0.1", "1");
    }

    @Test
    public int compareVersion(String version1, String version2) {
        return compare(version1, version1.length(), 0, version2, version2.length(), 0);
    }

    private int compare(String version1, int l1, int i1, String version2, int l2, int i2) {
        if (l1 <= i1 && l2 <= i2) {
            return 0;
        }
        int sv1 = 0, sv2 = 0;
        for (char c; i1 < l1 && (c = version1.charAt(i1)) != '.'; i1++) {
            sv1 = sv1 * 10 + c - '0';
        }
        for (char c; i2 < l2 && (c = version2.charAt(i2)) != '.'; i2++) {
            sv2 = sv2 * 10 + c - '0';
        }
        int compare = Integer.compare(sv1, sv2);
        return compare == 0 ? compare(version1, l1, i1 + 1, version2, l2, i2 + 1) : compare;
    }
}
