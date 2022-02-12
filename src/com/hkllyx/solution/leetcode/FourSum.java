package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * <p>Given an array <code>nums</code> of <code>n</code> integers, return <em>an array of all the <strong>unique</strong> quadruplets</em> <code>[nums[a], nums[b], nums[c], nums[d]]</code> such that:</p>
 *
 * <ul>
 * 	<li><code>0 &lt;= a, b, c, d&nbsp;&lt; n</code></li>
 * 	<li><code>a</code>, <code>b</code>, <code>c</code>, and <code>d</code> are <strong>distinct</strong>.</li>
 * 	<li><code>nums[a] + nums[b] + nums[c] + nums[d] == target</code></li>
 * </ul>
 *
 * <p>You may return the answer in <strong>any order</strong>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> nums = [1,0,-1,0,-2,2], target = 0
 * <strong>Output:</strong> [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> nums = [2,2,2,2,2], target = 8
 * <strong>Output:</strong> [[2,2,2,2]]
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= nums.length &lt;= 200</code></li>
 * 	<li><code>-10<sup>9</sup> &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
 * 	<li><code>-10<sup>9</sup> &lt;= target &lt;= 10<sup>9</sup></code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>数组</li><li>双指针</li><li>排序</li></div></div><br><div><li>👍 1092</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2022/01/29
 */
@Solution(no = "18", title = "4Sum", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/4sum/")
public class FourSum {

    public static void main(String[] args) {
        Assertions.assertExpect(Collections.singletonList(Arrays.asList(-5,-4,-3,1)), new int[]{1,-2,-5,-4,-3,3,3,5}, -11);
        Assertions.assertExpect(Arrays.asList(Arrays.asList(-2,-1,1,2), Arrays.asList(-1,-1,1,1)), new int[]{-2,-1,-1,1,1,2,2}, 0);
        Assertions.assertExpect(Collections.singletonList(Arrays.asList(0,0,0,0)), new int[]{0,0,0,0}, 0);
        Assertions.assertExpect(Arrays.asList(Arrays.asList(-2,-1,1,2), Arrays.asList(-2,0,0,2), Arrays.asList(-1,0,0,1)), new int[]{1,0,-1,0,-2,2}, 0);
        Assertions.assertExpect(Collections.singletonList(Arrays.asList(2, 2, 2, 2)), new int[]{2,2,2,2,2}, 8);
    }

    @Test
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int p0 = 1, len = nums.length;
        for (int i = 0, il = len - 3; i < il; i++) {
            if (p0 == nums[i]) {
                continue;
            }
            p0 = nums[i];
            int p1 = p0 - 1;
            for (int j = i + 1, jl = len - 2; j <= jl; j++) {
                if (p1 == nums[j]) {
                    continue;
                }
                p1 = nums[j];
                int p2 = p1 - 1;
                for (int m = j + 1, n = len - 1; m < n; ) {
                    if (p2 == nums[m]) {
                        m++;
                        continue;
                    }
                    int sum = nums[i] + nums[j] + nums[m] + nums[n];
                    if (sum < target) {
                        p2 = nums[m];
                        m++;
                    } else if (sum > target) {
                        n--;
                    } else {
                        res.add(Arrays.asList(nums[i], nums[j], nums[m], nums[n]));
                        p2 = nums[m];
                        m++;
                        n--;
                    }
                }
            }
        }
        return res;
    }
}
