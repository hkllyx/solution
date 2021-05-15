package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.info.Difficulty;
import com.hkllyx.solution.info.Fail;
import com.hkllyx.solution.info.Failure;
import com.hkllyx.solution.info.Solution;
import com.hkllyx.solution.util.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaoyong3
 * @date 2021/05/15
 */
@Solution(no = "18", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/4sum/")
@Fail(Failure.NOT_FINISHED)
public class FourSum {

    @Test
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return result;
        }
        return result;
    }
}
