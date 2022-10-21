package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.struct.TreeNode;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

/**
 * <p>Given a binary tree, find its minimum depth.</p>
 *
 * <p>The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.</p>
 *
 * <p><strong>Note:</strong>&nbsp;A leaf is a node with no children.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/10/12/ex_depth.jpg" style="width: 432px; height: 302px;" />
 * <pre>
 * <strong>Input:</strong> root = [3,9,20,null,null,15,7]
 * <strong>Output:</strong> 2
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> root = [2,null,3,null,4,null,5,null,6]
 * <strong>Output:</strong> 5
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 *  <li>The number of nodes in the tree is in the range <code>[0, 10<sup>5</sup>]</code>.</li>
 *  <li><code>-1000 &lt;= Node.val &lt;= 1000</code></li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>树</li><li>深度优先搜索</li><li>广度优先搜索</li><li>二叉树</li></div></div><br><div><li>👍 856</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2022/10/17
 */
@Solution(no = "111", title = "Minimum Depth of Binary Tree", difficulty = Difficulty.EASY, url = "https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/")
public class MinimumDepthOfBinaryTree {

    public static void main(String[] args) {
        Assertions.assertExpect(5, TreeNode.of(2, null, 3, null, 4, null, 5, null, 6));
    }

    @Test
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = 1;
        if (root.left != null && root.right != null) {
            depth += Math.min(minDepth(root.left), minDepth(root.right));
        } else if (root.left != null) {
            depth += minDepth(root.left);
        } else if (root.right != null) {
            depth += minDepth(root.right);
        }
        return depth;
    }
}
