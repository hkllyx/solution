package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Given two integers <code>n</code> and <code>k</code>, return <em>all possible combinations of</em> <code>k</code> <em>numbers out of the range</em> <code>[1, n]</code>.</p>
 *
 * <p>You may return the answer in <strong>any order</strong>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> n = 4, k = 2
 * <strong>Output:</strong>
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> n = 1, k = 1
 * <strong>Output:</strong> [[1]]
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= n &lt;= 20</code></li>
 * 	<li><code>1 &lt;= k &lt;= n</code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>回溯</li></div></div><br><div><li>👍 1049</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2022/07/13
 */
@Solution(no = "77", title = "Combinations", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/combinations/")
public class Combinations {

    public static void main(String[] args) {
        Assertions.assertExpect(0, 5, 3);
        Assertions.assertExpect(0, 4, 3);
        Assertions.assertExpect(0, 4, 2);
    }

    @Test
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        int[] combination = new int[k];
        dfs(result, combination, 0, 1, n);
        return result;
    }

    private void dfs(List<List<Integer>> result, int[] combination, int level, int start, int end) {
        if (level == combination.length) {
            List<Integer> list = new ArrayList<>(level);
            for (int num : combination) {
                list.add(num);
            }
            result.add(list);
            return;
        }
        for (int i = start; i <= end; i++) {
            combination[level] = i;
            dfs(result, combination, level + 1, i + 1, end);
        }
    }
}
