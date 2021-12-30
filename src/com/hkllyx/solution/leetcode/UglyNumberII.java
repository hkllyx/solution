package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.info.Status;
import com.hkllyx.solution.util.test.Test;

import java.util.*;

/**
 * @author xiaoyong3
 * @date 2021/12/27
 */
@Solution(no = "264", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/ugly-number-ii/", status = Status.HELPED)
public class UglyNumberII {

    @Test(value = "最小堆 + hash", active = false)
    public int nthUglyNumber(int n) {
        HashSet<Long> set = new HashSet<>(n);
        PriorityQueue<Long> heap = new PriorityQueue<>(n);
        set.add(1L);
        heap.offer(1L);
        int ugly = 1;
        int[] factors = {2, 3, 5};
        for (int i = 0; i < n; i++) {
            long cur = heap.poll();
            ugly = (int) cur;
            for (int factor : factors) {
                long next = cur * factor;
                if (set.add(next)) {
                    heap.offer(next);
                }
            }
        }
        return ugly;
    }

    @Test(value = "DP + 三指针，和上边【堆 + hash】解法相比，预先排序")
    public int nthUglyNumber1(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;
        for (int i = 1; i < n; i++) {
            int num2 = dp[p2] * 2, num3 = dp[p3] * 3, num5 = dp[p5] * 5;
            // 下一个为最小的那个
            int next = Math.min(Math.min(num2, num3), num5);
            // 移动指针，防止生成重复的值
            if (num2 == next) {
                p2++;
            }
            if (num3 == next) {
                p3++;
            }
            if (num5 == next) {
                p5++;
            }
            dp[i] = next;
        }
        return dp[n - 1];
    }
}
