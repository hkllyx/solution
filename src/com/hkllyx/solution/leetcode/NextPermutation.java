package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.ops.ArrayOps;
import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

/**
 * <p>Implement <strong>next permutation</strong>, which rearranges numbers into the lexicographically next greater permutation of numbers.</p>
 *
 * <p>If such an arrangement is impossible, it must rearrange it to the lowest possible order (i.e., sorted in ascending order).</p>
 *
 * <p>The replacement must be <strong><a href="http://en.wikipedia.org/wiki/In-place_algorithm" target="_blank">in place</a></strong> and use only constant extra memory.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> nums = [1,2,3]
 * <strong>Output:</strong> [1,3,2]
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> nums = [3,2,1]
 * <strong>Output:</strong> [1,2,3]
 * </pre>
 *
 * <p><strong>Example 3:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> nums = [1,1,5]
 * <strong>Output:</strong> [1,5,1]
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= nums.length &lt;= 100</code></li>
 * 	<li><code>0 &lt;= nums[i] &lt;= 100</code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>数组</li><li>双指针</li></div></div><br><div><li>👍 1467</li><li>👎 0</li></div>
 *
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
        // 将i之后的排序倒转，变成递增（最小）
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
