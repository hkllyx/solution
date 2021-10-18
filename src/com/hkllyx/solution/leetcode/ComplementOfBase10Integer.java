package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;

/**
 * @author xiaoyong3
 * @date 2021/10/18
 */
@Solution(no = "1009", difficulty = Difficulty.SIMPLE, url = "https://leetcode-cn.com/problems/complement-of-base-10-integer/")
public class ComplementOfBase10Integer extends NumberComplement {

    public int bitwiseComplement(int n) {
        return findComplement(n);
    }
}
