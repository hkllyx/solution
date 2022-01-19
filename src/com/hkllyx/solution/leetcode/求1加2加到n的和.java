package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.info.Status;

/**
 * <p>求 <code>1+2+...+n</code> ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre><strong>输入:</strong> n = 3
 * <strong>输出:&nbsp;</strong>6
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre><strong>输入:</strong> n = 9
 * <strong>输出:&nbsp;</strong>45
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>限制：</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= n&nbsp;&lt;= 10000</code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>位运算</li><li>递归</li><li>脑筋急转弯</li></div></div><br><div><li>👍 422</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2022/01/19
 */
@Solution(no = "剑指 Offer 64", title = "求1+2+…+n", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/qiu-12n-lcof/", status = Status.HELPED)
public class 求1加2加到n的和 {

    public int sumNums(int n) {
        boolean flag = n > 0 && (n += sumNums(n - 1)) > 0;
        return n;
    }

    public int sumNums1(int n) {
        // 等差数列求和：1+2+…+n = (1+n)*n/2
        return quickMulti(n, n + 1) >> 1;
    }

    private int quickMulti(int a, int b) {
        int ans = 0;
        // for (; b > 0; b >>= 1, a <<= 1) {
        //     // 位为1时才对结果有影响
        //     if ((b & 1) == 1) {
        //         ans += a;
        //     }
        // }
        // return ans;

        // 不允许使用for和if，自己展开。题目数据范围n为[1,10000]，所以n二进制展开最多不会超过14位
        boolean flag = ((b & 1) > 0) && (ans += a) > 0;
        a <<= 1;
        b >>= 1;

        flag = ((b & 1) > 0) && (ans += a) > 0;
        a <<= 1;
        b >>= 1;

        flag = ((b & 1) > 0) && (ans += a) > 0;
        a <<= 1;
        b >>= 1;

        flag = ((b & 1) > 0) && (ans += a) > 0;
        a <<= 1;
        b >>= 1;

        flag = ((b & 1) > 0) && (ans += a) > 0;
        a <<= 1;
        b >>= 1;

        flag = ((b & 1) > 0) && (ans += a) > 0;
        a <<= 1;
        b >>= 1;

        flag = ((b & 1) > 0) && (ans += a) > 0;
        a <<= 1;
        b >>= 1;

        flag = ((b & 1) > 0) && (ans += a) > 0;
        a <<= 1;
        b >>= 1;

        flag = ((b & 1) > 0) && (ans += a) > 0;
        a <<= 1;
        b >>= 1;

        flag = ((b & 1) > 0) && (ans += a) > 0;
        a <<= 1;
        b >>= 1;

        flag = ((b & 1) > 0) && (ans += a) > 0;
        a <<= 1;
        b >>= 1;

        flag = ((b & 1) > 0) && (ans += a) > 0;
        a <<= 1;
        b >>= 1;

        flag = ((b & 1) > 0) && (ans += a) > 0;
        a <<= 1;
        b >>= 1;

        flag = ((b & 1) > 0) && (ans += a) > 0;
        a <<= 1;
        b >>= 1;

        return ans;
    }
}
