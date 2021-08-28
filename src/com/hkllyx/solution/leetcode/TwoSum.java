package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.Test;
import com.hkllyx.solution.util.TestUtils;
import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.info.Tag;
import com.hkllyx.solution.util.info.Tags;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hkllyx
 * @date 2021/04/19
 */
@Solution(no = "1", difficulty = Difficulty.SIMPLE, url = "https://leetcode-cn.com/problems/two-sum/")
@Tags({Tag.ARRAY, Tag.HASH_TABLE})
public class TwoSum {

    public static void main(String[] args) {
        TestUtils.assertion(TwoSum.class, new int[]{1, 0}, new int[]{2, 7, 11, 15}, 9);
        TestUtils.assertion(TwoSum.class, new int[]{2, 1}, new int[]{3, 2, 4}, 6);
        TestUtils.assertion(TwoSum.class, new int[]{1, 0}, new int[]{3, 3}, 6);
    }

    @Test
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            Integer j = map.get(target - nums[i]);
            if (j == null) {
                map.put(nums[i], i);
            } else {
                return new int[]{i, j};
            }
        }
        return new int[2];
    }
}
