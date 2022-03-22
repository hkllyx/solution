package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <p>Given an array&nbsp;of <code>intervals</code>&nbsp;where <code>intervals[i] = [start<sub>i</sub>, end<sub>i</sub>]</code>, merge all overlapping intervals, and return <em>an array of the non-overlapping intervals that cover all the intervals in the input</em>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> intervals = [[1,3],[2,6],[8,10],[15,18]]
 * <strong>Output:</strong> [[1,6],[8,10],[15,18]]
 * <strong>Explanation:</strong> Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> intervals = [[1,4],[4,5]]
 * <strong>Output:</strong> [[1,5]]
 * <strong>Explanation:</strong> Intervals [1,4] and [4,5] are considered overlapping.
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= intervals.length &lt;= 10<sup>4</sup></code></li>
 * 	<li><code>intervals[i].length == 2</code></li>
 * 	<li><code>0 &lt;= start<sub>i</sub> &lt;= end<sub>i</sub> &lt;= 10<sup>4</sup></code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>数组</li><li>排序</li></div></div><br><div><li>👍 1373</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2022/03/15
 */
@Solution(no = "56", title = "Merge Intervals", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/merge-intervals/")
public class MergeIntervals {

    public static void main(String[] args) {
        Assertions.assertExpect(new int[][]{{2,4},{5,5}}, (Object) new int[][]{{2,2},{5,5},{2,3},{3,4},{3,4}});
        Assertions.assertExpect(new int[][]{{0,0},{1,4}}, (Object) new int[][]{{1,4},{0,0}});
        Assertions.assertExpect(new int[][]{{1,4},{5,6}}, (Object) new int[][]{{1,4},{5,6}});
        Assertions.assertExpect(new int[][]{{1,6},{8,10},{15,18}}, (Object) new int[][]{{1,3},{2,6},{8,10},{15,18}});
        Assertions.assertExpect(new int[][]{{1, 4}}, (Object) new int[][]{{1, 4}, {2, 3}});
    }

    @Test(mills = 7, memory = 46.5)
    public int[][] merge(int[][] intervals) {
        // 按起点升序排序
        Arrays.sort(intervals, Comparator.comparingInt(e -> e[0]));
        int i = 0;
        for (int j = 1, len = intervals.length; j < len; j++) {
            // 如果i的重点 >= j的起点，说明有重合
            if (intervals[i][1] >= intervals[j][0]) {
                // 将i的重点设为最大
                intervals[i][1] = Math.max(intervals[i][1], intervals[j][1]);
            } else {
                // 上一个interval合并完成
                intervals[++i] = intervals[j];
            }
        }
        return Arrays.copyOf(intervals, i + 1);
    }

    @Test(helped = true, mills = 1, active = false)
    public int[][] merge1(int[][] intervals) {
        // 桶排序
        int min = Integer.MAX_VALUE, max = -1;
        for (int[] interval : intervals) {
            min = Math.min(interval[0], min);
            max = Math.max(interval[1], max);
        }
        // bucket[i]记录start = i + min的最长interval
        int[] bucket = new int[max - min + 1];
        for (int[] interval : intervals) {
            int length = interval[1] - interval[0] + 1;
            bucket[interval[0] - min] = Math.max(bucket[interval[0] - min], length);
        }
        int index = 0;
        for (int i = 0; i < bucket.length; ) {
            if (bucket[i] > 0) {
                // right表示当前interval可达最大处
                int right = i + bucket[i];
                for (int j = i + 1; j < right; j++) {
                    right = Math.max(right, j + bucket[j]);
                }
                intervals[index][0] = i + min;
                intervals[index][1] = min + right - 1;
                index++;
                i = right;
            } else {
                i++;
            }
        }
        return Arrays.copyOf(intervals, index);
    }
}
