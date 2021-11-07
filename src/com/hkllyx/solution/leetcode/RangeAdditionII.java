package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;

/**
 * @author hkllyx
 * @date 2021-11-07
 */
@Solution(no = "598", difficulty = Difficulty.SIMPLE, url = "https://leetcode-cn.com/problems/range-addition-ii/")
public class RangeAdditionII {

    public int maxCount(int m, int n, int[][] ops) {
        int m1 = m, n1 = n;
        for (int[] op : ops) {
            m1 = Math.min(op[0], m1);
            n1 = Math.min(op[1], n1);
        }
        return m1 * n1;
    }
}
