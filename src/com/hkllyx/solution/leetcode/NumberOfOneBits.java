package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

/**
 * <p>Write a function that takes an unsigned integer and returns the number of &#39;1&#39; bits it has (also known as the <a href="http://en.wikipedia.org/wiki/Hamming_weight" target="_blank">Hamming weight</a>).</p>
 *
 * <p><strong>Note:</strong></p>
 *
 * <ul>
 * 	<li>Note that in some languages, such as Java, there is no unsigned integer type. In this case, the input will be given as a signed integer type. It should not affect your implementation, as the integer&#39;s internal binary representation is the same, whether it is signed or unsigned.</li>
 * 	<li>In Java, the compiler represents the signed integers using <a href="https://en.wikipedia.org/wiki/Two%27s_complement" target="_blank">2&#39;s complement notation</a>. Therefore, in <strong>Example 3</strong>, the input represents the signed integer. <code>-3</code>.</li>
 * </ul>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> n = 00000000000000000000000000001011
 * <strong>Output:</strong> 3
 * <strong>Explanation:</strong> The input binary string <strong>00000000000000000000000000001011</strong> has a total of three &#39;1&#39; bits.
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> n = 00000000000000000000000010000000
 * <strong>Output:</strong> 1
 * <strong>Explanation:</strong> The input binary string <strong>00000000000000000000000010000000</strong> has a total of one &#39;1&#39; bit.
 * </pre>
 *
 * <p><strong>Example 3:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> n = 11111111111111111111111111111101
 * <strong>Output:</strong> 31
 * <strong>Explanation:</strong> The input binary string <strong>11111111111111111111111111111101</strong> has a total of thirty one &#39;1&#39; bits.
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li>The input must be a <strong>binary string</strong> of length <code>32</code>.</li>
 * </ul>
 *
 * <p>&nbsp;</p>
 * <strong>Follow up:</strong> If this function is called many times, how would you optimize it?<div><div>Related Topics</div><div><li>位运算</li></div></div><br><div><li>👍 407</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2021/05/31
 */
@Solution(no = "191", difficulty = Difficulty.SIMPLE, url = "https://leetcode-cn.com/problems/number-of-1-bits/")
public class NumberOfOneBits {

    public static void main(String[] args) {
        Assertions.assertExpect(NumberOfOneBits.class, 31, 0b11111111111111111111111111111101);
    }

    @Deprecated
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                res++;
            }
            n >>>= 1;
        }
        return res;
    }

    @Test
    public int hammingWeight1(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1); // 可以将最后一位清0
        }
        return count;
    }
}
