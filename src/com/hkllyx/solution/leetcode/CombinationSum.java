package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

import java.util.*;

/**
 * <p>Given an array of <strong>distinct</strong> integers <code>candidates</code> and a target integer <code>target</code>, return <em>a list of all <strong>unique combinations</strong> of </em><code>candidates</code><em> where the chosen numbers sum to </em><code>target</code><em>.</em> You may return the combinations in <strong>any order</strong>.</p>
 *
 * <p>The <strong>same</strong> number may be chosen from <code>candidates</code> an <strong>unlimited number of times</strong>. Two combinations are unique if the frequency of at least one of the chosen numbers is different.</p>
 *
 * <p>It is <strong>guaranteed</strong> that the number of unique combinations that sum up to <code>target</code> is less than <code>150</code> combinations for the given input.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> candidates = [2,3,6,7], target = 7
 * <strong>Output:</strong> [[2,2,3],[7]]
 * <strong>Explanation:</strong>
 * 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
 * 7 is a candidate, and 7 = 7.
 * These are the only two combinations.
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> candidates = [2,3,5], target = 8
 * <strong>Output:</strong> [[2,2,2,2],[2,3,3],[3,5]]
 * </pre>
 *
 * <p><strong>Example 3:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> candidates = [2], target = 1
 * <strong>Output:</strong> []
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= candidates.length &lt;= 30</code></li>
 * 	<li><code>1 &lt;= candidates[i] &lt;= 200</code></li>
 * 	<li>All elements of <code>candidates</code> are <strong>distinct</strong>.</li>
 * 	<li><code>1 &lt;= target &lt;= 500</code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>数组</li><li>回溯</li></div></div><br><div><li>👍 1712</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2022/01/19
 */
@Solution(no = "39", title = "Combination Sum", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/combination-sum/")
public class CombinationSum {

    public static void main(String[] args) {
        Assertions.assertExpect(Arrays.asList(Arrays.asList(2, 2, 3), Collections.singletonList(7)),
                (Object) new int[]{2, 3, 6, 7}, 7);
    }

    @Test
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // 排序
        Arrays.sort(candidates);
        // trace
        int maxLen = target / candidates[0] + 1;
        int[] trace = new int[maxLen];
        // 回溯
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < candidates.length; i++) {
            traceBack(candidates, target, i, 0, trace, 0, res);
        }
        return res;
    }

    private void traceBack(int[] candidates, int target, int level, int sum, int[] trace, int len, List<List<Integer>> res) {
        sum += candidates[level];
        trace[len++] = candidates[level];
        if (sum == target) {
            List<Integer> list = new ArrayList<>(len);
            for (int i = 0; i < len; i++) {
                list.add(trace[i]);
            }
            res.add(list);
        } else {
            int diff = target - sum;
            for (int i = level; i < candidates.length; i++) {
                // 预先保证sum不超出target，减少递归次数
                if (diff >= candidates[i]) {
                    traceBack(candidates, target, i, sum, trace, len, res);
                }
            }
        }
    }
}
