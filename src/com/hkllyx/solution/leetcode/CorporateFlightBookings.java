package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

/**
 * <p>There are <code>n</code> flights that are labeled from <code>1</code> to <code>n</code>.</p>
 *
 * <p>You are given an array of flight bookings <code>bookings</code>, where <code>bookings[i] = [first<sub>i</sub>, last<sub>i</sub>, seats<sub>i</sub>]</code> represents a booking for flights <code>first<sub>i</sub></code> through <code>last<sub>i</sub></code> (<strong>inclusive</strong>) with <code>seats<sub>i</sub></code> seats reserved for <strong>each flight</strong> in the range.</p>
 *
 * <p>Return <em>an array </em><code>answer</code><em> of length </em><code>n</code><em>, where </em><code>answer[i]</code><em> is the total number of seats reserved for flight </em><code>i</code>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
 * <strong>Output:</strong> [10,55,45,25,25]
 * <strong>Explanation:</strong>
 * Flight labels:        1   2   3   4   5
 * Booking 1 reserved:  10  10
 * Booking 2 reserved:      20  20
 * Booking 3 reserved:      25  25  25  25
 * Total seats:         10  55  45  25  25
 * Hence, answer = [10,55,45,25,25]
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> bookings = [[1,2,10],[2,2,15]], n = 2
 * <strong>Output:</strong> [10,25]
 * <strong>Explanation:</strong>
 * Flight labels:        1   2
 * Booking 1 reserved:  10  10
 * Booking 2 reserved:      15
 * Total seats:         10  25
 * Hence, answer = [10,25]
 *
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= n &lt;= 2 * 10<sup>4</sup></code></li>
 * 	<li><code>1 &lt;= bookings.length &lt;= 2 * 10<sup>4</sup></code></li>
 * 	<li><code>bookings[i].length == 3</code></li>
 * 	<li><code>1 &lt;= first<sub>i</sub> &lt;= last<sub>i</sub> &lt;= n</code></li>
 * 	<li><code>1 &lt;= seats<sub>i</sub> &lt;= 10<sup>4</sup></code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>数组</li><li>前缀和</li></div></div><br><div><li>👍 295</li><li>👎 0</li></div>
 *
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
