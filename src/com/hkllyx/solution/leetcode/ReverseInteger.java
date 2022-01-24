package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

/**
 * <p>Given a signed 32-bit integer <code>x</code>, return <code>x</code><em> with its digits reversed</em>. If reversing <code>x</code> causes the value to go outside the signed 32-bit integer range <code>[-2<sup>31</sup>, 2<sup>31</sup> - 1]</code>, then return <code>0</code>.</p>
 *
 * <p><strong>Assume the environment does not allow you to store 64-bit integers (signed or unsigned).</strong></p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> x = 123
 * <strong>Output:</strong> 321
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> x = -123
 * <strong>Output:</strong> -321
 * </pre>
 *
 * <p><strong>Example 3:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> x = 120
 * <strong>Output:</strong> 21
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>-2<sup>31</sup> &lt;= x &lt;= 2<sup>31</sup> - 1</code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>数学</li></div></div><br><div><li>👍 3368</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2022/01/24
 */
@Solution(no = "7", title = "Reverse Integer", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/reverse-integer/")
public class ReverseInteger {

    public static void main(String[] args) {
        Assertions.assertExpect(321, 123);
        Assertions.assertExpect(0, Integer.MIN_VALUE);
        Assertions.assertExpect(0, Integer.MAX_VALUE);
    }

    @Test(active = false)
    public int reverse(int x) {
        boolean flag = false;
        if (x > 0) {
            x = -x;
            flag = true;
        }
        int res = 0, bound = Integer.MIN_VALUE / 10, tailBound = Integer.MIN_VALUE % 10;
        while (x != 0) {
            int tail = x % 10;
            if (res < bound || (res == bound && (tail < tailBound || (flag && tail == tailBound)))) {
                return 0;
            }
            res = (res * 10) + tail;
            x /= 10;
        }
        return flag ? -res : res;
    }

    @Test
    public int reverse1(int x) {
        int rev = 0, min = Integer.MIN_VALUE / 10, max = Integer.MAX_VALUE / 10;
        while (x != 0) {
            if (rev < min || rev > max) {
                return 0;
            }
            rev = rev * 10 + x % 10;
            x /= 10;
        }
        return rev;
    }
}
