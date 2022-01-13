package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.struct.TreeNode;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

/**
 * <p>Given a binary tree, determine if it is height-balanced.</p>
 *
 * <p>For this problem, a height-balanced binary tree is defined as:</p>
 *
 * <blockquote>
 * <p>a binary tree in which the left and right subtrees of <em>every</em> node differ in height by no more than 1.</p>
 * </blockquote>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/10/06/balance_1.jpg" style="width: 342px; height: 221px;" />
 * <pre>
 * <strong>Input:</strong> root = [3,9,20,null,null,15,7]
 * <strong>Output:</strong> true
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/10/06/balance_2.jpg" style="width: 452px; height: 301px;" />
 * <pre>
 * <strong>Input:</strong> root = [1,2,2,3,3,null,null,4,4]
 * <strong>Output:</strong> false
 * </pre>
 *
 * <p><strong>Example 3:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> root = []
 * <strong>Output:</strong> true
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li>The number of nodes in the tree is in the range <code>[0, 5000]</code>.</li>
 * 	<li><code>-10<sup>4</sup> &lt;= Node.val &lt;= 10<sup>4</sup></code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>树</li><li>深度优先搜索</li><li>二叉树</li></div></div><br><div><li>👍 853</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2022/01/06
 */
@Solution(no = "110", title = "Balanced Binary Tree", difficulty = Difficulty.EASY, url = "https://leetcode-cn.com/problems/balanced-binary-tree/")
public class BalancedBinaryTree {

    public static void main(String[] args) {
        Assertions.assertExpect(true, TreeNode.of("[1,2,3,4,5,6,null,8]"));
        Assertions.assertExpect(false, TreeNode.of("[1,null,2,null,3]"));
        Assertions.assertExpect(true, TreeNode.of("[3,9,20,null,null,15,7]"));
        Assertions.assertExpect(false, TreeNode.of("[1,2,21,3,31,null,null,4,41]"));
    }

    @Test(active = false)
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return (Math.abs(depth(root.left) - depth(root.right)) <= 1)
                && isBalanced(root.left) && isBalanced(root.right);
    }

    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }

    @Test
    public boolean isBalanced1(TreeNode root) {
        return depthAndBalance(root) != -1;
    }

    public int depthAndBalance(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int ld = depthAndBalance(root.left);
        int rd = depthAndBalance(root.right);
        if (ld == -1 || rd == -1 || Math.abs(ld - rd) > 1) {
            return -1;
        }
        return Math.max(ld, rd) + 1;
    }
}
