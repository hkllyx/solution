package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author xiaoyong3
 * @date 2021/12/27
 */
@Solution(no = "剑指Offer 45", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/")
public class 把数组排成最小的数 {

    public String minNumber(int[] nums) {
        return Arrays.stream(nums).mapToObj(String::valueOf)
                .sorted((s1, s2) -> (s1 + s2).compareTo(s2 + s1)).collect(Collectors.joining());
    }
}
