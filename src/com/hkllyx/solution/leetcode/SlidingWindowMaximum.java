package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

import java.util.*;

/**
 * <p>You are given an array of integers&nbsp;<code>nums</code>, there is a sliding window of size <code>k</code> which is moving from the very left of the array to the very right. You can only see the <code>k</code> numbers in the window. Each time the sliding window moves right by one position.</p>
 *
 * <p>Return <em>the max sliding window</em>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> nums = [1,3,-1,-3,5,3,6,7], k = 3
 * <strong>Output:</strong> [3,3,5,5,6,7]
 * <strong>Explanation:</strong>
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       <strong>3</strong>
 *  1 [3  -1  -3] 5  3  6  7       <strong>3</strong>
 *  1  3 [-1  -3  5] 3  6  7      <strong> 5</strong>
 *  1  3  -1 [-3  5  3] 6  7       <strong>5</strong>
 *  1  3  -1  -3 [5  3  6] 7       <strong>6</strong>
 *  1  3  -1  -3  5 [3  6  7]      <strong>7</strong>
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> nums = [1], k = 1
 * <strong>Output:</strong> [1]
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
 * 	<li><code>-10<sup>4</sup> &lt;= nums[i] &lt;= 10<sup>4</sup></code></li>
 * 	<li><code>1 &lt;= k &lt;= nums.length</code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>队列</li><li>数组</li><li>滑动窗口</li><li>单调队列</li><li>堆（优先队列）</li></div></div><br><div><li>👍 1343</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2022/01/10
 */
@Solution(no = "239", title = "Sliding Window Maximum", difficulty = Difficulty.HARD, url = "https://leetcode-cn.com/problems/sliding-window-maximum/")
public class SlidingWindowMaximum {

    public static void main(String[] args) {
        Assertions.assertExpect(new int[]{1, -1}, new int[]{1, -1}, 1);
        Assertions.assertExpect(new int[]{3, 3, 5, 5, 6, 7}, new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
    }

    @Test(value = "单调队列")
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        // 维护一个单调递减的队列，最大值在头部
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0, j = 0; i < nums.length; i++) {
            if (i < k) {
                // 初始化
                // 如果最后的元素比当前小，不能维持单调递减，需要把这个元素去除
                // 去除之后，这个窗口及包含当前元素的窗口的最大值肯定是>=当前元素，因此不影响后续取最大值
                while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                    deque.pollLast();
                }
                deque.offerLast(nums[i]);
                // 第一个最大值
                res[j] = deque.getFirst();
            } else {
                // 窗口开始移动
                // 需要移除的元素num[i - k]，如果就是最大值，移除头部
                if (nums[i - k] == res[j]) {
                    deque.pollFirst();
                }
                // 后续入队
                while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                    deque.pollLast();
                }
                deque.offerLast(nums[i]);
                res[++j] = deque.getFirst();
            }
        }
        return res;
    }

    @Test(value = "优先级队列（堆）")
    public int[] maxSlidingWindow1(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        // 优先级队列保存两个值，值和index
        Queue<int[]> queue = new PriorityQueue<>(Comparator
                .<int[]>comparingInt(e -> e[0]).thenComparingInt(e -> e[1]).reversed());
        for (int i = 0, j = 0; i < nums.length; i++) {
            if (i < k) {
                // 初始化
                queue.offer(new int[]{nums[i], i});
                res[j] = queue.element()[0];
            } else {
                // 窗口开始移动
                queue.offer(new int[]{nums[i], i});
                // 获取最大值，先移除窗口外的
                int l = i - k;
                while (!queue.isEmpty() && queue.element()[1] <= l) {
                    queue.poll();
                }
                res[++j] = queue.element()[0];
            }
        }
        return res;
    }

    /** https://leetcode-cn.com/problems/sliding-window-maximum/solution/hua-dong-chuang-kou-zui-da-zhi-by-leetco-ki6m/ */
    @Test(value = "分块 + 预处理")
    public int[] maxSlidingWindow2(int[] nums, int k) {
        // 把nums分成k大小的块：1  3  -1 / -3  5  3 / 6  7 从前往后
        //                    1  3 / -1  -3  5 / 3  6  7 从后往前
        int n = nums.length;
        int[] prefixMax = new int[n];
        int[] suffixMax = new int[n];
        for (int i = 0; i < n; ++i) {
            if (i % k == 0) {
                prefixMax[i] = nums[i];
            } else {
                prefixMax[i] = Math.max(prefixMax[i - 1], nums[i]);
            }
        }
        for (int i = n - 1; i >= 0; --i) {
            if (i == n - 1 || (i + 1) % k == 0) {
                suffixMax[i] = nums[i];
            } else {
                suffixMax[i] = Math.max(suffixMax[i + 1], nums[i]);
            }
        }

        int[] ans = new int[n - k + 1];
        for (int i = 0; i <= n - k; ++i) {
            ans[i] = Math.max(suffixMax[i], prefixMax[i + k - 1]);
        }
        return ans;
    }
}
