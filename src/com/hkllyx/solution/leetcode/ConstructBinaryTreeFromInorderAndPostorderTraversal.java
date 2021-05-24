package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.info.Difficulty;
import com.hkllyx.solution.info.Solution;
import com.hkllyx.solution.info.Tag;
import com.hkllyx.solution.info.Tags;
import com.hkllyx.solution.struct.TreeNode;
import com.hkllyx.solution.util.Test;
import com.hkllyx.solution.util.TestUtils;

/**
 * @author xiaoyong3
 * @date 2021/05/18
 */
@Solution(no = "106", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/")
@Tags({Tag.RECURSION, Tag.TREE})
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

    public static void main(String[] args) {
        TestUtils.assertion(ConstructBinaryTreeFromInorderAndPostorderTraversal.class, new TreeNode(3),
                new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
        TestUtils.assertion(ConstructBinaryTreeFromInorderAndPostorderTraversal.class, new TreeNode(3),
                new int[]{1, 9, 2, 3, 15, 20, 7}, new int[]{1, 2, 9, 15, 7, 20, 3});
        TestUtils.assertion(ConstructBinaryTreeFromInorderAndPostorderTraversal.class, new TreeNode(3),
                new int[]{1, 9, 3}, new int[]{1, 9, 3});
        TestUtils.assertion(ConstructBinaryTreeFromInorderAndPostorderTraversal.class, new TreeNode(3),
                new int[]{3, 9, 1}, new int[]{1, 9, 3});
    }

    @Test
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return getNode(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode getNode(int[] inorder, int ib, int ie, int[] postorder, int pb, int pe) {
        if (ib > ie) {
            return null;
        }
        if (ib == ie) {
            return new TreeNode(inorder[ib]);
        }
        // postorder最后一个元素就是树的顶点
        int val = postorder[pe];
        // inorder中，顶点的左边是左子树元素，右边则是右子树元素
        int i = ib;
        for (; i <= ie; i++) {
            if (inorder[i] == val) {
                break;
            }
        }
        // postorder中，顶点左侧先是右子树全部元素，而后是左子树全部元素
        int p = pe - (ie - i);
        TreeNode node = new TreeNode(val);
        node.left = getNode(inorder, ib, i - 1, postorder, pb, p - 1);
        node.right = getNode(inorder, i + 1, ie, postorder, p, pe - 1);
        return node;
    }
}
