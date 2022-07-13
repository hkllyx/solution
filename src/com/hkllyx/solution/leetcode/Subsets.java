package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Given an integer array <code>nums</code> of <strong>unique</strong> elements, return <em>all possible subsets (the power set)</em>.</p>
 *
 * <p>The solution set <strong>must not</strong> contain duplicate subsets. Return the solution in <strong>any order</strong>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> nums = [1,2,3]
 * <strong>Output:</strong> [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> nums = [0]
 * <strong>Output:</strong> [[],[0]]
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= nums.length &lt;= 10</code></li>
 * 	<li><code>-10 &lt;= nums[i] &lt;= 10</code></li>
 * 	<li>All the numbers of&nbsp;<code>nums</code> are <strong>unique</strong>.</li>
 * </ul>
 * <div><div>Related Topics</div><div><li>位运算</li><li>数组</li><li>回溯</li></div></div><br><div><li>👍 1707</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2022/07/13
 */
@Solution(no = "78", title = "Subsets", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/subsets/")
public class Subsets {

    public static void main(String[] args) {
        Assertions.assertExpect(0, (Object) new int[]{1, 2, 3});
    }

    @Test
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int[] combination = new int[nums.length];
        for (int i = 0; i <= nums.length; i++) {
            dfs(nums, 0, combination, 0, i, result);
        }
        return result;
    }

    private void dfs(int[] nums, int index, int[] combination, int level, int len, List<List<Integer>> result) {
        if (level == len) {
            List<Integer> list = new ArrayList<>(len);
            for (int i = 0; i < len; i++) {
                list.add(combination[i]);
            }
            result.add(list);
            return;
        }
        for (int i = index; i < nums.length; i++) {
            combination[level] = nums[i];
            dfs(nums, i + 1, combination, level + 1, len, result);
        }
    }
}
