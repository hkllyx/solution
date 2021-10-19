package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.struct.TreeNode;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

/**
 * @author xiaoyong3
 * @date 2021/05/24
 */
@Solution(no = "105", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/")
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public static void main(String[] args) {
        Assertions.assertExpect(ConstructBinaryTreeFromPreorderAndInorderTraversal.class, 0, new int[]{1, 2},
                new int[]{2, 1});
    }

    @Test
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return getNode(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode getNode(int[] preorder, int pb, int pe, int[] inorder, int ib, int ie) {
        if (pb > pe) {
            return null;
        }
        // preorder第一个节点就是树的顶点
        if (pb == pe) {
            return new TreeNode(preorder[pb]);
        }
        int val = preorder[pb];
        // inorder中，顶点左边是左子树元素，顶点右边是右子树元素
        int i = ib;
        for (; i <= ie; i++) {
            if (inorder[i] == val) {
                break;
            }
        }
        // preorder中，顶点右侧先是左子树全部元素，而后是右子树全部元素
        int p = pb + (i - ib);
        TreeNode node = new TreeNode(val);
        node.left = getNode(preorder, pb + 1, p, inorder, ib, i - 1);
        node.right = getNode(preorder, p + 1, pe, inorder, i + 1, ie);
        return node;
    }
}
