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
@Solution(no = "", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/")
@Tags({Tag.RECURSION, Tag.TREE})
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

    public static void main(String[] args) {
        TestUtils.assertion(ConstructBinaryTreeFromInorderAndPostorderTraversal.class,
                new TreeNode(3), new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
        TestUtils.assertion(ConstructBinaryTreeFromInorderAndPostorderTraversal.class,
                new TreeNode(3), new int[]{1, 9, 2, 3, 15, 20, 7}, new int[]{1, 2, 9, 15, 7, 20, 3});
        TestUtils.assertion(ConstructBinaryTreeFromInorderAndPostorderTraversal.class,
                new TreeNode(3), new int[]{1, 9, 3}, new int[]{1, 9, 3});
        TestUtils.assertion(ConstructBinaryTreeFromInorderAndPostorderTraversal.class,
                new TreeNode(3), new int[]{3, 9, 1}, new int[]{1, 9, 3});
    }
    @Test
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return getNode(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode getNode(int[] inorder, int iFrom, int iTo, int[] postorder, int pFrom, int pTo) {
        if (iFrom > iTo) {
            return null;
        }
        if (iFrom == iTo) {
            return new TreeNode(inorder[iFrom]);
        }
        // postorder最后出现的元素就是树的顶点
        int val = postorder[pTo];
        // inorder中，顶点的左边就是左子树的元素，右边则是右子树的元素
        int i = iFrom;
        for (; i <= iTo; i++) {
            if (inorder[i] == val) {
                break;
            }
        }
        // 同inorder，postorder前(iTo - i) - 1个是左子树的元素
        int j = pTo - (iTo - i);
        TreeNode node = new TreeNode(val);
        node.left = getNode(inorder, iFrom, i - 1, postorder, pFrom, j - 1);
        node.right = getNode(inorder, i + 1, iTo, postorder, j, pTo - 1);
        return node;
    }
}
