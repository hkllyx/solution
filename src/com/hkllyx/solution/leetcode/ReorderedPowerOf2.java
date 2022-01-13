package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * <p>You are given an integer <code>n</code>. We reorder the digits in any order (including the original order) such that the leading digit is not zero.</p>
 *
 * <p>Return <code>true</code> <em>if and only if we can do this so that the resulting number is a power of two</em>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> n = 1
 * <strong>Output:</strong> true
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> n = 10
 * <strong>Output:</strong> false
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= n &lt;= 10<sup>9</sup></code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>数学</li><li>计数</li><li>枚举</li><li>排序</li></div></div><br><div><li>👍 140</li><li>👎 0</li></div>
 *
 * @author hkllyx
 * @date 2021-10-28
 */
@Solution(no = "869", title = "Reordered Power of 2", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/reordered-power-of-2/")
public class ReorderedPowerOf2 {
    private final Set<String> sortedPowerOf2 = new HashSet<>(32);
    private final char[] tmp = new char[10];

    {
        for (int i = 0; i < 31; i++) {
            sortedPowerOf2.add(getSortedString(1 << i));
        }
    }

    public static void main(String[] args) {
        Assertions.assertExpect(true, 46);
        Assertions.assertExpect(true, 1);
    }

    @Test
    public boolean reorderedPowerOf2(int n) {
        return sortedPowerOf2.contains(getSortedString(n));
    }

    private String getSortedString(int n) {
        int i = 0;
        while (n != 0) {
            tmp[i++] = (char) (n % 10 + '0');
            n /= 10;
        }
        Arrays.sort(tmp, 0, i);
        return new String(tmp, 0, i);
    }
}
