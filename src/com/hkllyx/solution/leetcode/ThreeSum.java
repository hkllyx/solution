package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.info.Difficulty;
import com.hkllyx.solution.info.Solution;
import com.hkllyx.solution.util.Test;
import com.hkllyx.solution.util.TestUtils;

import java.util.*;

/**
 * @author xiaoyong3
 * @date 2021/05/10
 */
@Solution(no = "15", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/3sum/")
public class ThreeSum {

    public static void main(String[] args) {
        TestUtils.assertion(ThreeSum.class,
                Arrays.asList(Arrays.asList(-2, -1, 3), Arrays.asList(-2, 0, 2), Arrays.asList(-1, 0, 1)),
                new int[]{3, 0, -2, -1, 1, 2});
        TestUtils.assertion(ThreeSum.class, Arrays.asList(Arrays.asList(-1, 0, 1), Arrays.asList(-1, -1, 2)),
                new int[]{-1, 0, 1, 2, -1, -4});
        TestUtils.assertion(ThreeSum.class, Collections.singletonList(Arrays.asList(0, 0, 0)), new int[]{0, 0, 0, 0});
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
                            j++;
                            p1 = n1;
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
