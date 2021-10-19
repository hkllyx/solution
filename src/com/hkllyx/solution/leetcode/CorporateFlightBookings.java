package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

/**
 * @author xiaoyong3
 * @date 2021/08/31
 */
@Solution(no = "1109", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/corporate-flight-bookings/")
public class CorporateFlightBookings {
    public static void main(String[] args) {
        Assertions.assertExpect(new int[]{10, 55, 45, 25, 25}, (Object) new int[][]{{1, 2, 10}, {2, 3, 20}, {2, 5, 25}},
                5);
    }

    @Test(value = "暴力解法", active = false)
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] res = new int[n];
        for (int[] booking : bookings) {
            for (int i = booking[0] - 1; i < booking[1]; i++) {
                res[i] += booking[2];
            }
        }
        return res;
    }

    @Test(value = "前缀求和/差分数组")
    public int[] corpFlightBookings1(int[][] bookings, int n) {
        int[] res = new int[n];
        for (int[] booking : bookings) {
            int start = booking[0] - 1, end = booking[1], delta = booking[2];
            // start后的数都加delta
            res[start] += delta;
            // end开始的数都不加delta，所以减去delta抵消前面的加delta
            if (end < n) {
                res[end] -= delta;
            }
        }
        // 差分求和，res[i] = SUM(res[j]) (j <= i)
        for (int i = 1; i < res.length; i++) {
            res[i] += res[i - 1];
        }
        return res;
    }
}
