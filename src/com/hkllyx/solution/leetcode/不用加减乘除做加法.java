package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;

/**
 * <p>写一个函数，求两个整数之和，要求在函数体内不得使用 &ldquo;+&rdquo;、&ldquo;-&rdquo;、&ldquo;*&rdquo;、&ldquo;/&rdquo; 四则运算符号。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例:</strong></p>
 *
 * <pre><strong>输入:</strong> a = 1, b = 1
 * <strong>输出:</strong> 2</pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * 	<li><code>a</code>,&nbsp;<code>b</code>&nbsp;均可能是负数或 0</li>
 * 	<li>结果不会溢出 32 位整数</li>
 * </ul>
 * <div><div>Related Topics</div><div><li>位运算</li><li>数学</li></div></div><br><div><li>👍 251</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2022/01/13
 */
@Solution(no = "剑指 Offer 65", title = "不用加减乘除做加法", difficulty = Difficulty.EASY, url = "https://leetcode-cn.com/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof/")
public class 不用加减乘除做加法 {

    public int add(int a, int b) {
        return a == 0 ? b : add((a & b) << 1, a ^ b);
    }
}
