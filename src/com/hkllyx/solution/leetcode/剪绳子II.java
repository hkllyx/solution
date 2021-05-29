package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.info.Difficulty;
import com.hkllyx.solution.info.Fail;
import com.hkllyx.solution.info.Failure;
import com.hkllyx.solution.info.Solution;

/**
 * @author xiaoyong3
 * @date 2021/05/27
 */
@Solution(no = "剑指 Offer 14-II", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/jian-sheng-zi-ii-lcof/", sameAs = "343")
@Fail(Failure.NOT_FINISHED)
public class 剪绳子II extends IntegerBreak {

    public int cuttingRope(int n) {
        int[] res = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            res[i] = i == n ? i - 1 : i;
            for (int j = 1; j <= i >> 1; j++) {
                res[i] = Math.max(res[i], res[j] * res[i - j]);
            }
        }
        return res[n];
    }

    public int cuttingRope1(int n) {
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        int a = n / 3;
        int b = n % 3;
        if (b == 0) {
            return (int) Math.pow(3, a);
        } else if (b == 1) {
            return (int) Math.pow(3, a - 1) * 4;
        } else {
            return (int) Math.pow(3, a) * 2;
        }
    }
}
