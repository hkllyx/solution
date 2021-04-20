package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.info.Difficulty;
import com.hkllyx.solution.info.Solution;
import com.hkllyx.solution.util.Test;
import com.hkllyx.solution.util.TestUtils;

/**
 * @author hkllyx
 * @date 2021/03/29
 */
@Solution(no = 190, difficulty = Difficulty.SIMPLE, url = "https://leetcode-cn.com/problems/reverse-bits/")
public class ReverseBits {

    public static void main(String[] args) {
        TestUtils.assertion(ReverseBits.class, 0b00000010100101000001111010011100, 0b00111001011110000010100101000000);
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
