package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

/**
 * <p>The <strong>complement</strong> of an integer is the integer you get when you flip all the <code>0</code>&#39;s to <code>1</code>&#39;s and all the <code>1</code>&#39;s to <code>0</code>&#39;s in its binary representation.</p>
 *
 * <ul>
 * 	<li>For example, The integer <code>5</code> is <code>&quot;101&quot;</code> in binary and its <strong>complement</strong> is <code>&quot;010&quot;</code> which is the integer <code>2</code>.</li>
 * </ul>
 *
 * <p>Given an integer <code>num</code>, return <em>its complement</em>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> num = 5
 * <strong>Output:</strong> 2
 * <strong>Explanation:</strong> The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> num = 1
 * <strong>Output:</strong> 0
 * <strong>Explanation:</strong> The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= num &lt; 2<sup>31</sup></code></li>
 * </ul>
 *
 * <p>&nbsp;</p>
 * <p><strong>Note:</strong> This question is the same as 1009: <a href="https://leetcode.com/problems/complement-of-base-10-integer/" target="_blank">https://leetcode.com/problems/complement-of-base-10-integer/</a></p>
 * <div><div>Related Topics</div><div><li>位运算</li></div></div><br><div><li>👍 288</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2021/10/18
 */
@Solution(no = "476", difficulty = Difficulty.EASY, url = "https://leetcode-cn.com/problems/number-complement/")
public class NumberComplement {

    public static void main(String[] args) {
        Assertions.assertExpect(0, 0);
        Assertions.assertExpect(2, 5);
    }

    @Test
    public int findComplement(int num) {
        if (num == 0) {
            return 1;
        }
        int res = 0;
        for (int i = 0; num != 0; i++, num >>= 1) {
            if ((num & 1) == 0) {
                res += 1 << i;
            }
        }
        return res;
    }
}
