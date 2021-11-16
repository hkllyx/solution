package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.ops.ArrayOps;
import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

/**
 * @author xiaoyong3
 * @date 2021/11/16
 */
@Solution(no = "31", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/next-permutation/")
public class NextPermutation implements ArrayOps {

    public static void main(String[] args) {
        NextPermutation obj = new NextPermutation();
        int[] nums = {1, 1};
        obj.nextPermutation(nums);
        Assertions.assertEquals(new int[]{1, 1}, nums);
    }

    @Test
    public void nextPermutation(int[] nums) {
        // i之后为递减，说明i之后已经是最大的排序
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        // 将i之后的排序倒转，编程递增
        for (int m = i + 1, n = nums.length - 1; m < n; m++, n--) {
            swap(nums, m, n);
        }
        if (i >= 0) {
            // 找到第一个比i大的
            int j = i + 1;
            while (j < nums.length && nums[i] >= nums[j]) {
                j++;
            }
            swap(nums, i, j);
        }
    }
}
