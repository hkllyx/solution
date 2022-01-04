package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

/**
 * <p>Reverse bits of a given 32 bits unsigned integer.</p>
 *
 * <p><strong>Note:</strong></p>
 *
 * <ul>
 * 	<li>Note that in some languages, such as Java, there is no unsigned integer type. In this case, both input and output will be given as a signed integer type. They should not affect your implementation, as the integer&#39;s internal binary representation is the same, whether it is signed or unsigned.</li>
 * 	<li>In Java, the compiler represents the signed integers using <a href="https://en.wikipedia.org/wiki/Two%27s_complement" target="_blank">2&#39;s complement notation</a>. Therefore, in <strong>Example 2</strong> above, the input represents the signed integer <code>-3</code> and the output represents the signed integer <code>-1073741825</code>.</li>
 * </ul>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> n = 00000010100101000001111010011100
 * <strong>Output:</strong>    964176192 (00111001011110000010100101000000)
 * <strong>Explanation: </strong>The input binary string <strong>00000010100101000001111010011100</strong> represents the unsigned integer 43261596, so return 964176192 which its binary representation is <strong>00111001011110000010100101000000</strong>.
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> n = 11111111111111111111111111111101
 * <strong>Output:</strong>   3221225471 (10111111111111111111111111111111)
 * <strong>Explanation: </strong>The input binary string <strong>11111111111111111111111111111101</strong> represents the unsigned integer 4294967293, so return 3221225471 which its binary representation is <strong>10111111111111111111111111111111</strong>.
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li>The input must be a <strong>binary string</strong> of length <code>32</code></li>
 * </ul>
 *
 * <p>&nbsp;</p>
 * <p><strong>Follow up:</strong> If this function is called many times, how would you optimize it?</p>
 * <div><div>Related Topics</div><div><li>位运算</li><li>分治</li></div></div><br><div><li>👍 478</li><li>👎 0</li></div>
 *
 * @author hkllyx
 * @date 2021/03/29
 */
@Solution(no = "190", difficulty = Difficulty.SIMPLE, url = "https://leetcode-cn.com/problems/reverse-bits/")
public class ReverseBits {

    public static void main(String[] args) {
        Assertions.assertExpect(ReverseBits.class, 0b00000010100101000001111010011100,
                0b00111001011110000010100101000000);
    }

    /**
     * 将第 i 位右移 i 位：n >> i
     * 和 1 取与，只保留最后一位：(n >> i) & 1
     * 再左移到 31 - i 位：((n >> i) & 1) << (31 - i)
     * 得到第 i 位反转结果
     * 将所以结果取或
     */
    @Test
    public int reverseBits(int n) {
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            ret |= ((n >> i) & 1) << (31 - i);
        }
        return ret;
    }
}
