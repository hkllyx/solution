package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Given an integer array <code>nums</code> that may contain duplicates, return <em>all possible subsets (the power set)</em>.</p>
 *
 * <p>The solution set <strong>must not</strong> contain duplicate subsets. Return the solution in <strong>any order</strong>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 * <pre><strong>Input:</strong> nums = [1,2,2]
 * <strong>Output:</strong> [[],[1],[1,2],[1,2,2],[2],[2,2]]
 * </pre>
 * <p><strong>Example 2:</strong></p>
 * <pre><strong>Input:</strong> nums = [0]
 * <strong>Output:</strong> [[],[0]]
 * </pre>
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 *  <li><code>1 &lt;= nums.length &lt;= 10</code></li>
 *  <li><code>-10 &lt;= nums[i] &lt;= 10</code></li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>位运算</li><li>数组</li><li>回溯</li></div></div><br><div><li>👍 888</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2022/07/28
 */
@Solution(no = "90", title = "Subsets II", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/subsets-ii/")
public class SubsetsII {

    public static void main(String[] args) {
        Assertions.assertExpect("[[], [1], [1, 2], [1, 2, 2], [2], [2, 2]]", (Object) new int[]{1,2,2});
    }

    @Test
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, res, 0, new int[nums.length], 0);
        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res, int index, int[] subset, int level) {
        List<Integer> list = new ArrayList<>(level);
        for (int i = 0; i < level; i++) {
            list.add(subset[i]);
        }
        res.add(list);
        if (level >= nums.length) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            subset[level] = nums[i];
            dfs(nums, res, i + 1, subset, level + 1);
        }
    }
}
