package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.struct.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author xiaoyong3
 * @date 2021/09/28
 */
@Solution(no = "113", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/path-sum-ii/")
public class PathSumII {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> paths = new LinkedList<>();
        pathSum(root, targetSum, new LinkedList<>(), paths);
        return paths;
    }

    private void pathSum(TreeNode root, int remain, LinkedList<Integer> trace, List<List<Integer>> paths) {
        if (root == null) {
            return;
        }
        remain -= root.val;
        trace.add(root.val);
        if (root.left == null && root.right == null && remain == 0) {
            paths.add(new LinkedList<>(trace));
        }
        pathSum(root.left, remain, trace, paths);
        pathSum(root.right, remain, trace, paths);
        trace.pollLast();
    }
}
