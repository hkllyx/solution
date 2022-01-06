package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

/**
 * <p>找出数组中重复的数字。</p>
 *
 * <p><br>
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre><strong>输入：</strong>
 * [2, 3, 1, 0, 2, 5, 3]
 * <strong>输出：</strong>2 或 3
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>限制：</strong></p>
 *
 * <p><code>2 &lt;= n &lt;= 100000</code></p>
 * <div><div>Related Topics</div><div><li>数组</li><li>哈希表</li><li>排序</li></div></div><br><div><li>👍 655</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2021/05/22
 */
@Solution(no = "剑指 Offer 03", difficulty = Difficulty.EASY, url = "https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/")
public class 数组中重复的数字 {

    public static void main(String[] args) {
        Assertions.assertExpect(数组中重复的数字.class, 2, new int[]{2, 3, 1, 0, 2, 5, 3});
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
