package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

import java.util.*;

/**
 * <p>Given a collection of candidate numbers (<code>candidates</code>) and a target number (<code>target</code>), find all unique combinations in <code>candidates</code>&nbsp;where the candidate numbers sum to <code>target</code>.</p>
 *
 * <p>Each number in <code>candidates</code>&nbsp;may only be used <strong>once</strong> in the combination.</p>
 *
 * <p><strong>Note:</strong>&nbsp;The solution set must not contain duplicate combinations.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> candidates = [10,1,2,7,6,1,5], target = 8
 * <strong>Output:</strong>
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> candidates = [2,5,2,1,2], target = 5
 * <strong>Output:</strong>
 * [
 * [1,2,2],
 * [5]
 * ]
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;=&nbsp;candidates.length &lt;= 100</code></li>
 * 	<li><code>1 &lt;=&nbsp;candidates[i] &lt;= 50</code></li>
 * 	<li><code>1 &lt;= target &lt;= 30</code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>数组</li><li>回溯</li></div></div><br><div><li>👍 837</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2022/01/19
 */
@Solution(no = "40", title = "Combination Sum II", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/combination-sum-ii/")
public class CombinationSumII {

    public static void main(String[] args) {
        Assertions.assertExpect(Arrays.asList(Arrays.asList(1, 2, 2), Collections.singletonList(5)),
                (Object) new int[]{2, 5, 2, 1,}, 5);
    }

    @Test
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // 排序
        Arrays.sort(candidates);
        // trace
        int[] trace = new int[candidates.length];
        // 回溯
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < candidates.length; i++) {
            if (i == 0 || candidates[i] != candidates[i - 1]) {
                traceBack(candidates, target, i, 0, trace, 0, res);
            }
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
            for (int start = level + 1, i = start; i < candidates.length; i++) {
                // 预先保证sum不超出target，减少递归次数
                if (diff >= candidates[i]) {
                    if (i == start || candidates[i] != candidates[i - 1]) {
                        traceBack(candidates, target, i, sum, trace, len, res);
                    }
                }
            }
        }
    }
}
