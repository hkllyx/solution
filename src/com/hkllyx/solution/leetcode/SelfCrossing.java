package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Test;

/**
 * @author xiaoyong3
 * @date 2021/10/29
 */
@Solution(no = "335", difficulty = Difficulty.HARD, url = "https://leetcode-cn.com/problems/self-crossing/")
public class SelfCrossing {

    @Test
    public boolean isSelfCrossing(int[] distance) {
        int[][] bound = new int[4][200001];
        // 初始坐标
        int x = 0, y = 0;
        // 是否在y轴上移动，移动方向是否为正
        boolean my = true, mp = true;
        for (int i = 0; i < distance.length; i++, my = !my, mp = !mp) {
            for (int j = 0; j < distance[i]; j++) {
                //
                int k = (my ? y : x) + (mp ? j : -j) + 100000;
            }
        }
        return false;
    }
}
