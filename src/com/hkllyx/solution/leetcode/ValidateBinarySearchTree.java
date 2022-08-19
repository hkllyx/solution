package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.struct.TreeNode;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

/**
 * <p>Given the <code>root</code> of a binary tree, <em>determine if it is a valid binary search tree (BST)</em>.</p>
 *
 * <p>A <strong>valid BST</strong> is defined as follows:</p>
 *
 * <ul>
 *  <li>The left subtree of a node contains only nodes with keys <strong>less than</strong> the node's key.</li>
 *  <li>The right subtree of a node contains only nodes with keys <strong>greater than</strong> the node's key.</li>
 *  <li>Both the left and right subtrees must also be binary search trees.</li>
 * </ul>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/12/01/tree1.jpg" style="width: 302px; height: 182px;" />
 * <pre>
 * <strong>Input:</strong> root = [2,1,3]
 * <strong>Output:</strong> true
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/12/01/tree2.jpg" style="width: 422px; height: 292px;" />
 * <pre>
 * <strong>Input:</strong> root = [5,1,4,null,null,3,6]
 * <strong>Output:</strong> false
 * <strong>Explanation:</strong> The root node's value is 5 but its right child's value is 4.
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 *  <li>The number of nodes in the tree is in the range <code>[1, 10<sup>4</sup>]</code>.</li>
 *  <li><code>-2<sup>31</sup> &lt;= Node.val &lt;= 2<sup>31</sup> - 1</code></li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>树</li><li>深度优先搜索</li><li>二叉搜索树</li><li>二叉树</li></div></div><br><div><li>👍 1724</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2022/08/19
 */
@Solution(no = "98", title = "Validate Binary Search Tree", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/validate-binary-search-tree/")
public class ValidateBinarySearchTree {

    public static void main(String[] args) {
        Assertions.assertExpect(false, TreeNode.of(5,1,4,null,null,3,6));
    }

    @Test
    public boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }

    private boolean validate(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) {
            return true;
        }
        if (min != null && root.val < min.val) {
            return false;
        }
        if (max != null && root.val > max.val) {
            return false;
        }
        return validate(root.left, min, root) && validate(root.right, root, max);
    }
}
