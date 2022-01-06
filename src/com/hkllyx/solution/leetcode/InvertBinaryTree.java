package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.struct.TreeNode;

/**
 * <p>Given the <code>root</code> of a binary tree, invert the tree, and return <em>its root</em>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/03/14/invert1-tree.jpg" style="width: 500px; height: 165px;" />
 * <pre>
 * <strong>Input:</strong> root = [4,2,7,1,3,6,9]
 * <strong>Output:</strong> [4,7,2,9,6,3,1]
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/03/14/invert2-tree.jpg" style="width: 500px; height: 120px;" />
 * <pre>
 * <strong>Input:</strong> root = [2,1,3]
 * <strong>Output:</strong> [2,3,1]
 * </pre>
 *
 * <p><strong>Example 3:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> root = []
 * <strong>Output:</strong> []
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li>The number of nodes in the tree is in the range <code>[0, 100]</code>.</li>
 * 	<li><code>-100 &lt;= Node.val &lt;= 100</code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>树</li><li>深度优先搜索</li><li>广度优先搜索</li><li>二叉树</li></div></div><br><div><li>👍 1120</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2021/06/05
 */
@Solution(no = "226", difficulty = Difficulty.EASY, url = "https://leetcode-cn.com/problems/invert-binary-tree/")
public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        return dfs(root);
    }

    public TreeNode mirrorTree(TreeNode root) {
        return invertTree(root);
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
