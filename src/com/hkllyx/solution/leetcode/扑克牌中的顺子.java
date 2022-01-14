package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.ops.ArrayOps;
import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;

/**
 * <p>从<strong>若干副扑克牌</strong>中随机抽 <code>5</code> 张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例&nbsp;1:</strong></p>
 *
 * <pre>
 * <strong>输入:</strong> [1,2,3,4,5]
 * <strong>输出:</strong> True</pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例&nbsp;2:</strong></p>
 *
 * <pre>
 * <strong>输入:</strong> [0,0,1,2,5]
 * <strong>输出:</strong> True</pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>限制：</strong></p>
 *
 * <p>数组长度为 5&nbsp;</p>
 *
 * <p>数组的数取值为 [0, 13] .</p>
 * <div><div>Related Topics</div><div><li>数组</li><li>排序</li></div></div><br><div><li>👍 189</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2022/01/13
 */
@Solution(no = "剑指 Offer 61", title = "扑克牌中的顺子", difficulty = Difficulty.EASY, url = "https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof/")
public class 扑克牌中的顺子 implements ArrayOps {

    public boolean isStraight(int[] nums) {
        int min = 14;
        for (int num : nums) {
            if (num != 0) {
                min = Math.min(min, num);
            }
        }
        int i = 0, j;
        while (i < 5) {
            if (nums[i] == 0 || (j = nums[i] - min) == i) {
                i++;
                continue;
            }
            if (j > 4 || nums[j] == nums[i]) {
                return false;
            }
            swap(nums, i, j);
        }
        return true;
    }
}
