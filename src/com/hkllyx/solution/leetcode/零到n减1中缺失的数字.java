package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Test;

/**
 * <p>一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1:</strong></p>
 *
 * <pre><strong>输入:</strong> [0,1,3]
 * <strong>输出:</strong> 2
 * </pre>
 *
 * <p><strong>示例&nbsp;2:</strong></p>
 *
 * <pre><strong>输入:</strong> [0,1,2,3,4,5,6,7,9]
 * <strong>输出:</strong> 8</pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>限制：</strong></p>
 *
 * <p><code>1 &lt;= 数组长度 &lt;= 10000</code></p>
 * <div><div>Related Topics</div><div><li>位运算</li><li>数组</li><li>哈希表</li><li>数学</li><li>二分查找</li></div></div><br><div><li>👍 204</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2022/01/05
 */
@Solution(no = "剑指 Offer 53 - II", title = "0～n-1中缺失的数字", difficulty = Difficulty.EASY, url = "https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof/")
public class 零到n减1中缺失的数字 {

    @Test(value = "等差数列")
    public int missingNumber(int[] nums) {
        // (0 + 1 + ... + n) * (n + 1) = n * (n + 1) / 2
        int n = nums.length;
        int sum = (n * (n + 1)) / 2;
        for (int num : nums) {
            sum -= num;
        }
        return sum;
    }

    @Test(value = "二分")
    public int missingNumber1(int[] nums) {
        int l = 0, r = nums.length;
        if (nums[l] != 0) {
            return 0;
        }
        if (nums[r - 1] != r) {
            return r;
        }
        while (l + 1 < r) {
            int m = (l + r) >> 1;
            if (nums[m] - nums[l] == m - l) {
                l = m;
            } else {
                r = m;
            }
        }
        return (nums[l] + nums[r]) >> 1;
    }

    @Test(value = "位运算")
    public int missingNumber2(int[] nums) {
        int res = 0, len = nums.length;
        for (int i = 0; i < len; i++) {
            res ^= i;
            res ^= nums[i];
        }
        res ^= len;
        return res;
    }
}
