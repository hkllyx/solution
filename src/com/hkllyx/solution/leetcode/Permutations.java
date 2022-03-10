package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Given an array <code>nums</code> of distinct integers, return <em>all the possible permutations</em>. You can return the answer in <strong>any order</strong>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 * <pre><strong>Input:</strong> nums = [1,2,3]
 * <strong>Output:</strong> [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * </pre><p><strong>Example 2:</strong></p>
 * <pre><strong>Input:</strong> nums = [0,1]
 * <strong>Output:</strong> [[0,1],[1,0]]
 * </pre><p><strong>Example 3:</strong></p>
 * <pre><strong>Input:</strong> nums = [1]
 * <strong>Output:</strong> [[1]]
 * </pre>
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= nums.length &lt;= 6</code></li>
 * 	<li><code>-10 &lt;= nums[i] &lt;= 10</code></li>
 * 	<li>All the integers of <code>nums</code> are <strong>unique</strong>.</li>
 * </ul>
 * <div><div>Related Topics</div><div><li>数组</li><li>回溯</li></div></div><br><div><li>👍 1830</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2022/03/10
 */
@Solution(no = "46", title = "Permutations", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/permutations/")
public class Permutations {

    public static void main(String[] args) {
        Assertions.assertExpect(0, (Object) new int[]{1, 2, 3});
    }

    @Test(value = "DFS", mills = 0, memory = 41.7)
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>(factorial(len));
        int[] trace = new int[len];
        dfs(nums, trace, 0, res);
        return res;
    }

    private void dfs(int[] nums, int[] trace, int level, List<List<Integer>> res) {
        if (level == trace.length) {
            List<Integer> list = new ArrayList<>(level);
            for (int i : trace) {
                list.add(i);
            }
            res.add(list);
        }
        for (int i = 0; i < nums.length; i++) {
            int tmp = nums[i];
            if (nums[i] <= 10) {
                trace[level] = nums[i];
                nums[i] = Integer.MAX_VALUE;
                dfs(nums, trace, level + 1, res);
            }
            nums[i] = tmp;
        }
    }

    private int factorial(int n) {
        int res = 1;
        for (int i = 2; i <= n; i++) {
            res *= i;
        }
        return res;
    }
}
