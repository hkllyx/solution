package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.info.Status;

/**
 * <p>一个整型数组 <code>nums</code> 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre><strong>输入：</strong>nums = [4,1,4,6]
 * <strong>输出：</strong>[1,6] 或 [6,1]
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre><strong>输入：</strong>nums = [1,2,10,4,1,4,3,3]
 * <strong>输出：</strong>[2,10] 或 [10,2]</pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>限制：</strong></p>
 *
 * <ul>
 * 	<li><code>2 &lt;= nums.length &lt;= 10000</code></li>
 * </ul>
 *
 * <p>&nbsp;</p>
 * <div><div>Related Topics</div><div><li>位运算</li><li>数组</li></div></div><br><div><li>👍 512</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2022/01/04
 */
@Solution(no = "剑指 Offer 56 - I", title = "数组中数字出现的次数", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/", status = Status.HELPED)
public class 数组中数字出现的次数 {

    public int[] singleNumbers(int[] nums) {
        // 获取这两个数的异或值（因为n ^ n = 0，根据题意可知所有值的异或值就是这两个只出现一次的数的异或值）
        int xor = 0; // 0 ^ n = n
        for (int num : nums) {
            xor ^= num;
        }
        // xor bit = 1处即两个数不同之处
        int div = 1;
        while (div > 0 && (xor & div) == 0) {
            div <<= 1;
        }
        // 根据这俩分组
        int a = 0, b = 0;
        for (int num : nums) {
            if ((num & div) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        return new int[] {a, b};
    }
}
