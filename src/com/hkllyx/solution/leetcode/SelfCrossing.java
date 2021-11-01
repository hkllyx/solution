package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

/**
 * @author xiaoyong3
 * @date 2021/10/29
 */
@Solution(no = "335", difficulty = Difficulty.HARD, url = "https://leetcode-cn.com/problems/self-crossing/")
public class SelfCrossing {

    public static void main(String[] args) {
        Assertions.assertExpect(true, (Object) new int[]{1, 1, 2, 1, 1});
        Assertions.assertExpect(true, (Object) new int[]{2, 1, 3, 2, 2, 1});
        Assertions.assertExpect(true, (Object) new int[]{2, 1, 1, 2});
        Assertions.assertExpect(false, (Object) new int[]{1, 2, 3, 4});
        Assertions.assertExpect(true, (Object) new int[]{1, 1, 1, 1});
    }

    @Test
    public boolean isSelfCrossing(int[] distance) {
        for (int i = 3; i < distance.length; i++) {
            if (isSelfCrossing4(distance, i) || isSelfCrossing5(distance, i) || isSelfCrossing6(distance, i)) {
                return true;
            }
        }
        return false;
    }

    private boolean isSelfCrossing4(int[] distance, int e) {
        // [0] >= [2] && [3] >= [1]
        return e >= 3 && distance[e - 3] >= distance[e - 1] && distance[e] >= distance[e - 2];
    }

    private boolean isSelfCrossing5(int[] distance, int e) {
        // [0] + [4] >= [2] && [1] == [3]
        return e >= 4 && distance[e - 4] + distance[e] >= distance[e - 2] && distance[e - 3] == distance[e - 1];
    }

    private boolean isSelfCrossing6(int[] distance, int e) {
        // [0] >= [2] - [4] >= 0 && [5] >= [3] - [1] >= 0
        int tmp;
        return e >= 5 && distance[e - 5] >= (tmp = distance[e - 3] - distance[e - 1]) && tmp >= 0
                && distance[e] >= (tmp = distance[e - 2] - distance[e - 4]) && tmp >= 0;
    }
}
