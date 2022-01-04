package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.struct.TreeNode;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

/**
 * <p>Given two integer arrays <code>preorder</code> and <code>inorder</code> where <code>preorder</code> is the preorder traversal of a binary tree and <code>inorder</code> is the inorder traversal of the same tree, construct and return <em>the binary tree</em>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/02/19/tree.jpg" style="width: 277px; height: 302px;" />
 * <pre>
 * <strong>Input:</strong> preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * <strong>Output:</strong> [3,9,20,null,null,15,7]
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> preorder = [-1], inorder = [-1]
 * <strong>Output:</strong> [-1]
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= preorder.length &lt;= 3000</code></li>
 * 	<li><code>inorder.length == preorder.length</code></li>
 * 	<li><code>-3000 &lt;= preorder[i], inorder[i] &lt;= 3000</code></li>
 * 	<li><code>preorder</code> and <code>inorder</code> consist of <strong>unique</strong> values.</li>
 * 	<li>Each value of <code>inorder</code> also appears in <code>preorder</code>.</li>
 * 	<li><code>preorder</code> is <strong>guaranteed</strong> to be the preorder traversal of the tree.</li>
 * 	<li><code>inorder</code> is <strong>guaranteed</strong> to be the inorder traversal of the tree.</li>
 * </ul>
 * <div><div>Related Topics</div><div><li>树</li><li>数组</li><li>哈希表</li><li>分治</li><li>二叉树</li></div></div><br><div><li>👍 1362</li><li>👎 0</li></div>
 *
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
