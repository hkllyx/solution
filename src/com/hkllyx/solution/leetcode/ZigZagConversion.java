package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

/**
 * <p>The string <code>&quot;PAYPALISHIRING&quot;</code> is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)</p>
 *
 * <pre>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * </pre>
 *
 * <p>And then read line by line: <code>&quot;PAHNAPLSIIGYIR&quot;</code></p>
 *
 * <p>Write the code that will take a string and make this conversion given a number of rows:</p>
 *
 * <pre>
 * string convert(string s, int numRows);
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> s = &quot;PAYPALISHIRING&quot;, numRows = 3
 * <strong>Output:</strong> &quot;PAHNAPLSIIGYIR&quot;
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> s = &quot;PAYPALISHIRING&quot;, numRows = 4
 * <strong>Output:</strong> &quot;PINALSIGYAHRPI&quot;
 * <strong>Explanation:</strong>
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * </pre>
 *
 * <p><strong>Example 3:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> s = &quot;A&quot;, numRows = 1
 * <strong>Output:</strong> &quot;A&quot;
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= s.length &lt;= 1000</code></li>
 * 	<li><code>s</code> consists of English letters (lower-case and upper-case), <code>&#39;,&#39;</code> and <code>&#39;.&#39;</code>.</li>
 * 	<li><code>1 &lt;= numRows &lt;= 1000</code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>字符串</li></div></div><br><div><li>👍 1428</li><li>👎 0</li></div>
 * @author hkllyx
 * @date 2021/03/29
 */
@Solution(no = "6", title = "ZigZag Conversion", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/zigzag-conversion/")
public class ZigZagConversion {

    public static void main(String[] args) {
        Assertions.assertExpect(ZigZagConversion.class, "PAHNAPLSIIGYIR", "PAYPALISHIRING", 3);
        Assertions.assertExpect(ZigZagConversion.class, "PINALSIGYAHRPI", "PAYPALISHIRING", 4);
    }

    /**
     * 规律：Z 字形周期
     * 第一行和最后一行一个周期只有一个，其他行则有两个
     */
    @Test
    public String convert(String s, int numRows) {
        if (numRows < 2) {
            return s;
        }
        int period = (numRows << 1) - 2;
        char[] dest = new char[s.length()];
        int cur = 0;
        for (int row = 0; row < numRows; row++) {
            int idx = row;
            int dist1 = row << 1; // 当前行在一个周期内有两个节点时，前一周期第二个节点到后一周期第一个节点的距离
            int dist2 = period - dist1; // 一个周期内第二个节点到第一个节点的的距离
            boolean onlyOne = (row == 0) | (row == (numRows - 1)); // 当前行在一个周期内是否只有一个节点
            boolean isFirst = true; // 是否是周期内的第一个节点
            while (idx < s.length()) {
                dest[cur++] = s.charAt(idx);
                idx += onlyOne ? period : isFirst ? dist2 : dist1;
                isFirst = !isFirst;
            }
        }
        return new String(dest);
    }
}
