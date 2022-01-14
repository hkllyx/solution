package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.struct.TreeNode;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

/**
 * <p>Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.</p>
 *
 * <p>According to the <a href="https://en.wikipedia.org/wiki/Lowest_common_ancestor" target="_blank">definition of LCA on Wikipedia</a>: &ldquo;The lowest common ancestor is defined between two nodes <code>p</code> and <code>q</code> as the lowest node in <code>T</code> that has both <code>p</code> and <code>q</code> as descendants (where we allow <b>a node to be a descendant of itself</b>).&rdquo;</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2018/12/14/binarysearchtree_improved.png" style="width: 200px; height: 190px;" />
 * <pre>
 * <strong>Input:</strong> root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * <strong>Output:</strong> 6
 * <strong>Explanation:</strong> The LCA of nodes 2 and 8 is 6.
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2018/12/14/binarysearchtree_improved.png" style="width: 200px; height: 190px;" />
 * <pre>
 * <strong>Input:</strong> root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * <strong>Output:</strong> 2
 * <strong>Explanation:</strong> The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
 * </pre>
 *
 * <p><strong>Example 3:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> root = [2,1], p = 2, q = 1
 * <strong>Output:</strong> 2
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li>The number of nodes in the tree is in the range <code>[2, 10<sup>5</sup>]</code>.</li>
 * 	<li><code>-10<sup>9</sup> &lt;= Node.val &lt;= 10<sup>9</sup></code></li>
 * 	<li>All <code>Node.val</code> are <strong>unique</strong>.</li>
 * 	<li><code>p != q</code></li>
 * 	<li><code>p</code> and <code>q</code> will exist in the BST.</li>
 * </ul>
 * <div><div>Related Topics</div><div><li>树</li><li>深度优先搜索</li><li>二叉搜索树</li><li>二叉树</li></div></div><br><div><li>👍 738</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2022/01/13
 */
@Solution(no = "235", title = "Lowest Common Ancestor of a Binary Search Tree", difficulty = Difficulty.EASY, url = "https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/")
public class LowestCommonAncestorOfABinarySearchTree {

    public static void main(String[] args) {
        TreeNode node = TreeNode.of("[6,2,8,0,4,7,9,null,null,3,5]");
        Assertions.assertExpect(node, node, node.left, node.right);
    }

    @Test
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > q.val) {
            return lowestCommonAncestor(root, q, p);
        }
        while (true) {
            if (root.val >= p.val && root.val <= q.val) {
                return root;
            } else if (root.val > q.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
    }
}
