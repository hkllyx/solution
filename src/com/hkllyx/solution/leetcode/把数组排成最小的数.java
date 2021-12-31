package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * <p>输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1:</strong></p>
 *
 * <pre><strong>输入:</strong> <code>[10,2]</code>
 * <strong>输出:</strong> &quot;<code>102&quot;</code></pre>
 *
 * <p><strong>示例&nbsp;2:</strong></p>
 *
 * <pre><strong>输入:</strong> <code>[3,30,34,5,9]</code>
 * <strong>输出:</strong> &quot;<code>3033459&quot;</code></pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示:</strong></p>
 *
 * <ul>
 * 	<li><code>0 &lt; nums.length &lt;= 100</code></li>
 * </ul>
 *
 * <p><strong>说明: </strong></p>
 *
 * <ul>
 * 	<li>输出结果可能非常大，所以你需要返回一个字符串而不是整数</li>
 * 	<li>拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0</li>
 * </ul>
 * <div><div>Related Topics</div><div><li>贪心</li><li>字符串</li><li>排序</li></div></div><br><div><li>👍 345</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2021/12/27
 */
@Solution(no = "剑指 Offer 45", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/")
public class 把数组排成最小的数 {

    public String minNumber(int[] nums) {
        return Arrays.stream(nums).mapToObj(String::valueOf)
                .sorted((s1, s2) -> (s1 + s2).compareTo(s2 + s1)).collect(Collectors.joining());
    }
}
