package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

import java.util.Arrays;

/**
 * <p>You are given an array of non-overlapping intervals <code>intervals</code> where <code>intervals[i] = [start<sub>i</sub>, end<sub>i</sub>]</code> represent the start and the end of the <code>i<sup>th</sup></code> interval and <code>intervals</code> is sorted in ascending order by <code>start<sub>i</sub></code>. You are also given an interval <code>newInterval = [start, end]</code> that represents the start and end of another interval.</p>
 *
 * <p>Insert <code>newInterval</code> into <code>intervals</code> such that <code>intervals</code> is still sorted in ascending order by <code>start<sub>i</sub></code> and <code>intervals</code> still does not have any overlapping intervals (merge overlapping intervals if necessary).</p>
 *
 * <p>Return <code>intervals</code><em> after the insertion</em>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> intervals = [[1,3],[6,9]], newInterval = [2,5]
 * <strong>Output:</strong> [[1,5],[6,9]]
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * <strong>Output:</strong> [[1,2],[3,10],[12,16]]
 * <strong>Explanation:</strong> Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>0 &lt;= intervals.length &lt;= 10<sup>4</sup></code></li>
 * 	<li><code>intervals[i].length == 2</code></li>
 * 	<li><code>0 &lt;= start<sub>i</sub> &lt;= end<sub>i</sub> &lt;= 10<sup>5</sup></code></li>
 * 	<li><code>intervals</code> is sorted by <code>start<sub>i</sub></code> in <strong>ascending</strong> order.</li>
 * 	<li><code>newInterval.length == 2</code></li>
 * 	<li><code>0 &lt;= start &lt;= end &lt;= 10<sup>5</sup></code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>数组</li></div></div><br><div><li>👍 563</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2022/03/21
 */
@Solution(no = "57", title = "Insert Interval", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/insert-interval/")
public class InsertInterval {

    public static void main(String[] args) {
        Assertions.assertExpect(new int[][]{{1,5},{6,9}}, new int[][]{{1,3},{6,9}}, new int[]{2,5});
    }

    @Test(mills = 1)
    public int[][] insert(int[][] intervals, int[] newInterval) {
        for (int i = 0; i <= intervals.length; i++) {
            if (i == intervals.length || newInterval[1] < intervals[i][0]) {
                int[][] res = new int[intervals.length + 1][2];
                System.arraycopy(intervals, 0, res, 0, i);
                res[i] = newInterval;
                System.arraycopy(intervals, i, res, i + 1, intervals.length - i);
                return res;
            } else if (newInterval[0] > intervals[i][1]) {
                continue;
            }
            intervals[i][0] = Math.min(intervals[i][0], newInterval[0]);
            intervals[i][1] = Math.max(intervals[i][1], newInterval[1]);
            for (int j = i + 1; j < intervals.length; j++) {
                if (intervals[j][0] <= intervals[i][1]) {
                    intervals[i][1] = Math.max(intervals[i][1], intervals[j][1]);
                } else {
                    intervals[++i] = intervals[j];
                }
            }
            return Arrays.copyOf(intervals, i + 1);
        }
        return intervals;
    }
}
