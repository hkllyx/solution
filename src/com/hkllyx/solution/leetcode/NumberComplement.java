package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

/**
 * @author xiaoyong3
 * @date 2021/10/18
 */
@Solution(no = "476", difficulty = Difficulty.SIMPLE, url = "https://leetcode-cn.com/problems/number-complement/")
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
