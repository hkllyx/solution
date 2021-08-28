package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.struct.TreeNode;

/**
 * @author xiaoyong3
 * @date 2021/06/05
 */
@Solution(no = "226", difficulty = Difficulty.SIMPLE, url = "https://leetcode-cn.com/problems/invert-binary-tree/")
public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        return dfs(root);
    }

    private TreeNode dfs(TreeNode node) {
        if (node != null) {
            TreeNode tmp = dfs(node.left);
            node.left = dfs(node.right);
            node.right = tmp;
        }
        return node;
    }
}
