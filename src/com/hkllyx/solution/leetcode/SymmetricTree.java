package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.struct.TreeNode;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <p>Given the <code>root</code> of a binary tree, <em>check whether it is a mirror of itself</em> (i.e., symmetric around its center).</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/02/19/symtree1.jpg" style="width: 354px; height: 291px;" />
 * <pre>
 * <strong>Input:</strong> root = [1,2,2,3,4,4,3]
 * <strong>Output:</strong> true
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/02/19/symtree2.jpg" style="width: 308px; height: 258px;" />
 * <pre>
 * <strong>Input:</strong> root = [1,2,2,null,3,null,3]
 * <strong>Output:</strong> false
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li>The number of nodes in the tree is in the range <code>[1, 1000]</code>.</li>
 * 	<li><code>-100 &lt;= Node.val &lt;= 100</code></li>
 * </ul>
 *
 * <p>&nbsp;</p>
 * <strong>Follow up:</strong> Could you solve it both recursively and iteratively?<div><div>Related Topics</div><div><li>树</li><li>深度优先搜索</li><li>广度优先搜索</li><li>二叉树</li></div></div><br><div><li>👍 1686</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2021/06/05
 */
@Solution(no = "101", difficulty = Difficulty.SIMPLE, url = "https://leetcode-cn.com/problems/symmetric-tree/")
public class SymmetricTree {

    public static void main(String[] args) {
        Assertions.assertExpect(SymmetricTree.class, false,
                TreeNode.of(9, -42, -42, null, 76, 76, null, null, 13, null, 13));
    }

    /**
     * 递归
     */
    public boolean isSymmetric(TreeNode root) {
        return root == null || eq(root.left, root.right);
    }

    private boolean eq(TreeNode n1, TreeNode n2) {
        if (n1 != null && n2 != null) {
            return n1.val == n2.val && eq(n1.left, n2.right) && eq(n1.right, n2.left);
        } else {
            return n1 == null && n2 == null;
        }
    }

    /**
     * 迭代
     */
    @Test
    public boolean isSymmetric1(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);
        while (!queue.isEmpty()) {
            TreeNode n1 = queue.poll(), n2 = queue.poll();
            if (n1 != null && n2 != null && n1.val == n2.val) {
                // 对称位置节点成对出入队
                queue.offer(n1.left);
                queue.offer(n2.right);
                queue.offer(n1.right);
                queue.offer(n2.left);
            } else if (n1 != null || n2 != null) {
                return false;
            }
        }
        return true;
    }
}
