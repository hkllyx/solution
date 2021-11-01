package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;

import java.util.HashSet;
import java.util.Set;

/**
 * @author xiaoyong3
 * @date 2021/11/01
 */
@Solution(no = "575", difficulty = Difficulty.SIMPLE, url = "https://leetcode-cn.com/problems/distribute-candies/")
public class DistributeCandies {

    public int distributeCandies(int[] candyType) {
        int limit = candyType.length >> 1;
        Set<Integer> unique = new HashSet<>(limit);
        for (int type : candyType) {
            if (unique.size() >= limit) {
                return limit;
            }
            unique.add(type);
        }
        return unique.size();
    }
}
