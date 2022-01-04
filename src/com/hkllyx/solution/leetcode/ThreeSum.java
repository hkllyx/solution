package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

import java.util.*;

/**
 * <p>Given an integer array nums, return all the triplets <code>[nums[i], nums[j], nums[k]]</code> such that <code>i != j</code>, <code>i != k</code>, and <code>j != k</code>, and <code>nums[i] + nums[j] + nums[k] == 0</code>.</p>
 *
 * <p>Notice that the solution set must not contain duplicate triplets.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 * <pre><strong>Input:</strong> nums = [-1,0,1,2,-1,-4]
 * <strong>Output:</strong> [[-1,-1,2],[-1,0,1]]
 * </pre><p><strong>Example 2:</strong></p>
 * <pre><strong>Input:</strong> nums = []
 * <strong>Output:</strong> []
 * </pre><p><strong>Example 3:</strong></p>
 * <pre><strong>Input:</strong> nums = [0]
 * <strong>Output:</strong> []
 * </pre>
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>0 &lt;= nums.length &lt;= 3000</code></li>
 * 	<li><code>-10<sup>5</sup> &lt;= nums[i] &lt;= 10<sup>5</sup></code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>数组</li><li>双指针</li><li>排序</li></div></div><br><div><li>👍 4154</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2021/05/10
 */
@Solution(no = "15", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/3sum/")
public class ThreeSum {

    public static void main(String[] args) {
        Assertions.assertExpect(ThreeSum.class,
                Arrays.asList(Arrays.asList(-2, -1, 3), Arrays.asList(-2, 0, 2), Arrays.asList(-1, 0, 1)),
                new int[]{3, 0, -2, -1, 1, 2});
        Assertions.assertExpect(ThreeSum.class, Arrays.asList(Arrays.asList(-1, 0, 1), Arrays.asList(-1, -1, 2)),
                new int[]{-1, 0, 1, 2, -1, -4});
        Assertions.assertExpect(ThreeSum.class, Collections.singletonList(Arrays.asList(0, 0, 0)),
                new int[]{0, 0, 0, 0});
    }

    public List<List<Integer>> threeSum1(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<>(0);
        }
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int p0 = 1;
        for (int i = 0, n0; i < nums.length && (n0 = nums[i]) <= 0; i++) {
            if (p0 != n0) {
                int p1 = n0 - 1;
                HashSet<Integer> hash = new HashSet<>();
                for (int j = nums.length - 1; j > i; j--) {
                    int n1 = nums[j];
                    if (hash.contains(p1) || p1 != n1) {
                        int n2 = -n0 - n1;
                        if (hash.remove(n2)) {
                            result.add(Arrays.asList(n0, n1, n2));
                        } else {
                            hash.add(n1);
                        }
                        p1 = n1;
                    }
                }
                p0 = n0;
            }
        }
        return result;
    }

    @Test
    public List<List<Integer>> threeSum2(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<>(0);
        }
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int p0 = 1;
        for (int i = 0, n0; i < nums.length && (n0 = nums[i]) <= 0; i++) {
            if (p0 != n0) {
                int p1 = n0 - 1;
                for (int j = i + 1, k = nums.length - 1; j < k; ) {
                    int n1 = nums[j];
                    if (p1 != n1) {
                        int n2 = nums[k];
                        int sum = n0 + n1 + n2;
                        if (sum == 0) {
                            result.add(Arrays.asList(n0, n1, n2));
                            j++;
                            k--;
                            p1 = n1;
                        } else if (sum < 0) {
                            p1 = n1;
                            j++;
                        } else {
                            k--;
                        }
                    } else {
                        j++;
                    }
                }
                p0 = n0;
            }
        }
        return result;
    }
}
