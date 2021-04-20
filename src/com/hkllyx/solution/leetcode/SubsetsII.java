package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.info.Difficulty;
import com.hkllyx.solution.info.Fail;
import com.hkllyx.solution.info.Failure;
import com.hkllyx.solution.info.Solution;
import com.hkllyx.solution.util.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hkllyx
 * @date 2021/03/31
 */
@Fail(Failure.NOT_FINISHED)
@Solution(no = 90, difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/subsets-ii/")
public class SubsetsII {

    @Test
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        // TODO
        return new ArrayList<>(0);
    }
}
