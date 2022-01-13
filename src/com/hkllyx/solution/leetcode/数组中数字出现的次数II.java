package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.info.Status;
import com.hkllyx.solution.util.test.Test;

/**
 * <p>在一个数组 <code>nums</code> 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre><strong>输入：</strong>nums = [3,4,3,3]
 * <strong>输出：</strong>4
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre><strong>输入：</strong>nums = [9,1,7,9,7,9,7]
 * <strong>输出：</strong>1</pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>限制：</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= nums.length &lt;= 10000</code></li>
 * 	<li><code>1 &lt;= nums[i] &lt; 2^31</code></li>
 * </ul>
 *
 * <p>&nbsp;</p>
 * <div><div>Related Topics</div><div><li>位运算</li><li>数组</li></div></div><br><div><li>👍 262</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2022/01/04
 */
@Solution(no = "剑指 Offer 56 - II", title = "数组中数字出现的次数 II", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof/", status = Status.HELPED)
public class 数组中数字出现的次数II {

    @Test(value = "bit位统计")
    public int singleNumber(int[] nums) {
        int[] counts = new int[32];
        for (int num : nums) {
            for (int j = 0; j < 32; j++) {
                counts[j] += num & 1;
                num >>>= 1;
            }
        }
        int res = 0, m = 3;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            res |= counts[31 - i] % m;
        }
        return res;
    }

    @Test(value = "有限状态机")
    public int singleNumber1(int[] nums) {
        // 根据题意，想要一个数重复3次变为0，重复四次为本身，对应为每个bit也是如此
        // 那么，存在3种状态，即：0 -> 1 -> 2 -> 重复，不管0还是1重复变换3次都会变为0，第四次为其本身

        // 转换为位运算，使用2个bit（two one）来保存，则其状态转换为：0 0 -> 0 1 -> 1 0 -> 重复
        // 可见，one在变换状态3次后为0，4次后为其本身

        /* 设输入为n（bit）
        计算one：
        if (two == 0) {
            if (n == 0) {    ┐
                one = one;   |
            } else {         |> one = one ^ n  ┐
                one = ~one;  |                 |
            }                ┘                 |
        } else {                               |> one = one ^ n & ~two
            one = 0;                           |
        }                                      ┘

        计算two：
        if (one == 1) {
            if (n == 0) {    ┐
                two = two;   |
            } else {         |> two = two ^ n  ┐
                two = ~two;  |                 |
            }                ┘                 |
        } else {                               |> two = two ^ n & ~one
            two = 0;                           |
        }                                      ┘
        */

        // ones表示32个one，twos同理
        int ones = 0, twos = 0;
        for(int num : nums){
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
        }
        return ones;
    }
}
