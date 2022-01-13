package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.info.Status;
import com.hkllyx.solution.util.test.Test;

import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * <p>An <strong>ugly number</strong> is a positive integer whose prime factors are limited to <code>2</code>, <code>3</code>, and <code>5</code>.</p>
 *
 * <p>Given an integer <code>n</code>, return <em>the</em> <code>n<sup>th</sup></code> <em><strong>ugly number</strong></em>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> n = 10
 * <strong>Output:</strong> 12
 * <strong>Explanation:</strong> [1, 2, 3, 4, 5, 6, 8, 9, 10, 12] is the sequence of the first 10 ugly numbers.
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> n = 1
 * <strong>Output:</strong> 1
 * <strong>Explanation:</strong> 1 has no prime factors, therefore all of its prime factors are limited to 2, 3, and 5.
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= n &lt;= 1690</code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>哈希表</li><li>数学</li><li>动态规划</li><li>堆（优先队列）</li></div></div><br><div><li>👍 802</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2021/12/27
 */
@Solution(no = "264", title = "Ugly Number II", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/ugly-number-ii/", status = Status.HELPED)
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
