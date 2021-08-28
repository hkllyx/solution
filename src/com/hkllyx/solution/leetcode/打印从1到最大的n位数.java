package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;

/**
 * @author xiaoyong3
 * @date 2021/06/01
 */
@Solution(no = "剑指Offer 17", difficulty = Difficulty.SIMPLE, url = "https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/")
public class 打印从1到最大的n位数 {

    public int[] printNumbers(int n) {
        int l = (int) Math.pow(10, n) - 1;
        int[] res = new int[l];
        for (int s = 1; s <= l; s++, l--) {
            res[s - 1] = s;
            res[l - 1] = l;
        }
        return res;
    }
}
