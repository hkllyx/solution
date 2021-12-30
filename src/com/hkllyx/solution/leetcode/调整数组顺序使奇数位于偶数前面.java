package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

/**
 * @author xiaoyong3
 * @date 2021/06/04
 */
@Solution(no = "剑指 Offer 21", difficulty = Difficulty.SIMPLE, url = "https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/")
public class 调整数组顺序使奇数位于偶数前面 {

    public static void main(String[] args) {
        Assertions.assertExpect(调整数组顺序使奇数位于偶数前面.class, new int[]{1, 3, 2, 4}, new int[]{1, 2, 3, 4});
        Assertions.assertExpect(调整数组顺序使奇数位于偶数前面.class, new int[]{1, 3, 2, 4},
                new int[]{2, 16, 3, 5, 13, 1, 16, 1, 12, 18, 11, 8, 11, 11, 5, 1});
    }

    /**
     * 快排
     */
    public int[] exchange(int[] nums) {
        for (int i = 0, j = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 1) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j++] = tmp;
            }
        }
        return nums;
    }

    @Test
    public int[] exchange1(int[] nums) {
        for (int i = 0, j = nums.length - 1; i < j; ) {
            while (nums[i] % 2 == 1 && i < j) {
                i++;
            }
            while (nums[j] % 2 == 0 && i < j) {
                j--;
            }
            int tmp = nums[i];
            nums[i++] = nums[j];
            nums[j--] = tmp;
        }
        return nums;
    }
}
