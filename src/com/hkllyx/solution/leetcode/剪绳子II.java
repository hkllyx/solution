package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.info.Difficulty;
import com.hkllyx.solution.info.Fail;
import com.hkllyx.solution.info.Failure;
import com.hkllyx.solution.info.Solution;
import com.hkllyx.solution.util.Test;
import com.hkllyx.solution.util.TestUtils;

import java.math.BigInteger;

/**
 * @author xiaoyong3
 * @date 2021/05/27
 */
@Solution(no = "剑指 Offer 14-II", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/jian-sheng-zi-ii-lcof/")
@Fail(Failure.NOT_FINISHED)
public class 剪绳子II extends IntegerBreak {

    public static void main(String[] args) {
        TestUtils.assertion(剪绳子II.class, 324522920, 59);
    }

    /**
     * BigInteger 运算费时间
     */
    @Deprecated
    public int cuttingRope(int n) {
        BigInteger[] res = new BigInteger[n + 1];
        for (int i = 1; i <= n; i++) {
            res[i] = BigInteger.valueOf(i == n ? i - 1 : i);
            for (int j = 1; j <= i >> 1; j++) {
                BigInteger tmp = res[j].multiply(res[i - j]);
                if (tmp.compareTo(res[i]) > 0) {
                    res[i] = tmp;
                }
            }
        }
        return res[n].mod(BigInteger.valueOf(1000000007)).intValue();
    }

    /**
     * 贪心算法：尽可能把绳子分成长度为3的小段，这样乘积最大
     * 把数学算式解析，pow 改为循环
     */
    @Test
    public int cuttingRope1(int n) {
        if (n < 4) {
            return n - 1;
        }
        long res = 1;
        while (n > 4) {
            res = res * 3 % 1000000007;
            n -= 3;
        }
        return (int) (res * n % 1000000007);
    }
}
