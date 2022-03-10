package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Given a collection of numbers, <code>nums</code>,&nbsp;that might contain duplicates, return <em>all possible unique permutations <strong>in any order</strong>.</em></p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> nums = [1,1,2]
 * <strong>Output:</strong>
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> nums = [1,2,3]
 * <strong>Output:</strong> [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= nums.length &lt;= 8</code></li>
 * 	<li><code>-10 &lt;= nums[i] &lt;= 10</code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>数组</li><li>回溯</li></div></div><br><div><li>👍 969</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2022/03/10
 */
@Solution(no = "47", title = "Permutations II", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/permutations-ii/")
public class PermutationsII {

    @Test(value = "DFS", mills = 1, memory = 41.8)
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
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
            if (i == 0 || nums[i] != nums[i - 1]) {
                int tmp = nums[i];
                if (nums[i] <= 10) {
                    trace[level] = nums[i];
                    nums[i] = Integer.MAX_VALUE;
                    dfs(nums, trace, level + 1, res);
                }
                nums[i] = tmp;
            }
        }
    }
}
