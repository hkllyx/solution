package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.info.Difficulty;
import com.hkllyx.solution.info.Solution;
import com.hkllyx.solution.util.Test;
import com.hkllyx.solution.util.TestUtils;

/**
 * @author xiaoyong3
 * @date 2021/05/22
 */
@Solution(no = "剑指 Offer 03", difficulty = Difficulty.SIMPLE, url = "https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/")
public class 数组中重复的数字 {

    public static void main(String[] args) {
        TestUtils.assertion(数组中重复的数字.class, 2, new int[]{2, 3, 1, 0, 2, 5, 3});
    }

    @Test
    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; ) {
            int cur = nums[i];
            if (cur != i) {
                int place = nums[cur];
                if (cur == place) {
                    return cur;
                }
                nums[i] = place;
                nums[cur] = cur;
            } else {
                i++;
            }
        }
        return 0;
    }
}
