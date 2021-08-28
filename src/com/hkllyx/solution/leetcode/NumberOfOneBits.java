package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.Test;
import com.hkllyx.solution.util.TestUtils;
import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;

/**
 * @author xiaoyong3
 * @date 2021/05/31
 */
@Solution(no = "191", difficulty = Difficulty.SIMPLE, url = "https://leetcode-cn.com/problems/number-of-1-bits/")
public class NumberOfOneBits {

    public static void main(String[] args) {
        TestUtils.assertion(NumberOfOneBits.class, 31, 0b11111111111111111111111111111101);
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
