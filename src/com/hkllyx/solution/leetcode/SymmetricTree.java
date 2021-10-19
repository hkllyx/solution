package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.struct.TreeNode;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
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
