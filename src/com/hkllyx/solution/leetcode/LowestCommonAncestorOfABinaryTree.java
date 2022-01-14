package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.struct.TreeNode;
import com.hkllyx.solution.util.test.Test;

/**
 * <p>Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.</p>
 *
 * <p>According to the <a href="https://en.wikipedia.org/wiki/Lowest_common_ancestor" target="_blank">definition of LCA on Wikipedia</a>: &ldquo;The lowest common ancestor is defined between two nodes <code>p</code> and <code>q</code> as the lowest node in <code>T</code> that has both <code>p</code> and <code>q</code> as descendants (where we allow <b>a node to be a descendant of itself</b>).&rdquo;</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2018/12/14/binarytree.png" style="width: 200px; height: 190px;" />
 * <pre>
 * <strong>Input:</strong> root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * <strong>Output:</strong> 3
 * <strong>Explanation:</strong> The LCA of nodes 5 and 1 is 3.
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2018/12/14/binarytree.png" style="width: 200px; height: 190px;" />
 * <pre>
 * <strong>Input:</strong> root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * <strong>Output:</strong> 5
 * <strong>Explanation:</strong> The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
 * </pre>
 *
 * <p><strong>Example 3:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> root = [1,2], p = 1, q = 2
 * <strong>Output:</strong> 1
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
 * 	<li><code>p</code> and <code>q</code> will exist in the tree.</li>
 * </ul>
 * <div><div>Related Topics</div><div><li>树</li><li>深度优先搜索</li><li>二叉树</li></div></div><br><div><li>👍 1482</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2022/01/13
 */
@Solution(no = "236", title = "Lowest Common Ancestor of a Binary Tree", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/")
public class LowestCommonAncestorOfABinaryTree {

    @Test
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode holder = new TreeNode();
        dfs(root, p, q, holder);
        return holder.left;
    }

    private int dfs(TreeNode node, TreeNode p, TreeNode q, TreeNode holder) {
        if (node == null) {
            return 0;
        }
        int res = node.val == p.val || node.val == q.val ? 1 : 0;
        res += dfs(node.left, p, q, holder);
        res += dfs(node.right, p, q, holder);
        if (res == 2 && holder.left == null) {
            holder.left = node;
        }
        return res;
    }
}
