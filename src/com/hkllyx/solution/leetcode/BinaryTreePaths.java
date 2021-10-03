package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.struct.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author xiaoyong3
 * @date 2021/09/29
 */
@Solution(no = "257", difficulty = Difficulty.SIMPLE, url = "https://leetcode-cn.com/problems/binary-tree-paths/")
public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new LinkedList<>();
        pathSum(root, new StringBuilder(), paths);
        return paths;
    }

    private void pathSum(TreeNode root, StringBuilder trace, List<String> paths) {
        if (root == null) {
            return;
        }
        int size = trace.length();
        if (size != 0) {
            trace.append("->");
        }
        trace.append(root.val);
        if (root.left == null && root.right == null) {
            paths.add(trace.toString());
        }
        pathSum(root.left, trace, paths);
        pathSum(root.right, trace, paths);
        trace.delete(size, trace.length());
    }
}
