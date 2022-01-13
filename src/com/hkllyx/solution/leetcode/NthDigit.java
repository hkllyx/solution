package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

import java.util.Arrays;

/**
 * <p>Given an integer <code>n</code>, return the <code>n<sup>th</sup></code> digit of the infinite integer sequence <code>[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...]</code>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> n = 3
 * <strong>Output:</strong> 3
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> n = 11
 * <strong>Output:</strong> 0
 * <strong>Explanation:</strong> The 11<sup>th</sup> digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is part of the number 10.
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= n &lt;= 2<sup>31</sup> - 1</code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>数学</li><li>二分查找</li></div></div><br><div><li>👍 284</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2021/12/31
 */
@Solution(no = "400", title = "Nth Digit", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/nth-digit/")
public class NthDigit {

    public static void main(String[] args) {
        initDp();
        Assertions.assertExpect(2, 2147483647);
        Assertions.assertExpect(1, 1000000000);
        Assertions.assertExpect(1, 10);
        Assertions.assertExpect(1, 12);
        Assertions.assertExpect(8, 187);
        Assertions.assertExpect(1, 1);
        Assertions.assertExpect(9, 9);
        Assertions.assertExpect(9, 188);
    }

    public static final long[] PREFIX_SUM = {0, 10, 190, 2890, 38890, 488890, 5888890, 68888890, 788888890, 8888888890L};

    /**
     * 0 1 2 3 4 5 6 7 8 9 1  0  1  1  1  2  1  3  1  4  1  5  1  6  1  7  1  8  ... 9   8   9   9
     * 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 ... 186 187 188 189
     */
    @Test(active = false)
    public int findNthDigit(int n) {
        // 用前缀和数组确定n所在位置对应的数字的位数
        int i = 1;
        while (PREFIX_SUM[i] <= n) {
            i++;
        }
        // 个位数直接返回
        if (i == 1) {
            return n;
        }
        // 减去小于此位数的长度
        n -= PREFIX_SUM[i - 1];
        // 确定当前数以及对应的第几位（从左到右，0开始）
        int cur = n / i, digit = n % i;
        int ans = reverseDigitAt(cur, i - digit);
        // 对于i > 1，因为减去了前缀和，最大位应该+1
        return digit == 0 ? ans + 1 : ans;
    }


    @Test
    public int findNthDigit1(int n) {
        int i = 1, j = 9;
        long k;
        while (n > (k = (long) i * j)) {
            n -= k;
            i++;
            j *= 10;
        }
        n--;
        // 确定当前数以及对应的第几位（从左到右，0开始）
        int cur = n / i, digit = n % i;
        int ans = reverseDigitAt(cur, i - digit);
        // 对于i > 1，因为减去了前缀和，最大位应该+1
        return digit == 0 ? ans + 1 : ans;
    }

    /** 获取数字的倒数第几位数，从1开始 */
    private int reverseDigitAt(int num, int rd) {
        while (--rd > 0 && num != 0) {
            num /= 10;
        }
        return num % 10;
    }

    /**
     * n(i)表示位数为 = i的所有数字的个数
     * n(i) = 9 * 10^(i - 1), i > 0
     *
     * f(i)表示位数 <= i的所有数字序列的长度，0是特殊值
     * f(i) = 10, i = 1
     *      = f(i - 1) + (i * n(i)), i > 1
     */
    private static void initDp() {
        // int最长为10位数
        long[] dp = new long[10];
        dp[1] = 10;
        long n = 9;
        for (int i = 2; i < dp.length; i++) {
            n *= 10;
            long cur = dp[i - 1] + i * n;
            dp[i] = cur;
        }
        System.out.println(Arrays.toString(dp));
    }
}
