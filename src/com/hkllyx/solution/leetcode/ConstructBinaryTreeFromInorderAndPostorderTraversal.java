package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.struct.TreeNode;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

/**
 * <p>Given two integer arrays <code>inorder</code> and <code>postorder</code> where <code>inorder</code> is the inorder traversal of a binary tree and <code>postorder</code> is the postorder traversal of the same tree, construct and return <em>the binary tree</em>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/02/19/tree.jpg" style="width: 277px; height: 302px;" />
 * <pre>
 * <strong>Input:</strong> inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
 * <strong>Output:</strong> [3,9,20,null,null,15,7]
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> inorder = [-1], postorder = [-1]
 * <strong>Output:</strong> [-1]
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= inorder.length &lt;= 3000</code></li>
 * 	<li><code>postorder.length == inorder.length</code></li>
 * 	<li><code>-3000 &lt;= inorder[i], postorder[i] &lt;= 3000</code></li>
 * 	<li><code>inorder</code> and <code>postorder</code> consist of <strong>unique</strong> values.</li>
 * 	<li>Each value of <code>postorder</code> also appears in <code>inorder</code>.</li>
 * 	<li><code>inorder</code> is <strong>guaranteed</strong> to be the inorder traversal of the tree.</li>
 * 	<li><code>postorder</code> is <strong>guaranteed</strong> to be the postorder traversal of the tree.</li>
 * </ul>
 * <div><div>Related Topics</div><div><li>树</li><li>数组</li><li>哈希表</li><li>分治</li><li>二叉树</li></div></div><br><div><li>👍 646</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2021/05/18
 */
@Solution(no = "106", title = "Construct Binary Tree from Inorder and Postorder Traversal", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/")
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

    public static void main(String[] args) {
        Assertions.assertExpect(ConstructBinaryTreeFromInorderAndPostorderTraversal.class, new TreeNode(3),
                new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
        Assertions.assertExpect(ConstructBinaryTreeFromInorderAndPostorderTraversal.class, new TreeNode(3),
                new int[]{1, 9, 2, 3, 15, 20, 7}, new int[]{1, 2, 9, 15, 7, 20, 3});
        Assertions.assertExpect(ConstructBinaryTreeFromInorderAndPostorderTraversal.class, new TreeNode(3),
                new int[]{1, 9, 3}, new int[]{1, 9, 3});
        Assertions.assertExpect(ConstructBinaryTreeFromInorderAndPostorderTraversal.class, new TreeNode(3),
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
