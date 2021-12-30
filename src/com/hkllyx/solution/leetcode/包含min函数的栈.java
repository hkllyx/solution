package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;

/**
 * @author xiaoyong3
 * @date 2021/06/07
 */
@Solution(no = "剑指 Offer 30", difficulty = Difficulty.SIMPLE, url = "https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/")
public class 包含min函数的栈 extends MinStack {

    public int min() {
        return super.getMin();
    }
}
