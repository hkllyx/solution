package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.struct.TreeNode;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

import java.util.*;

/**
 * @author xiaoyong3
 * @date 2021/06/08
 */
@Solution(no = "102", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/binary-tree-level-order-traversal/")
public class BinaryTreeLevelOrderTraversal {

    public static void main(String[] args) {
        Assertions.assertExpect(BinaryTreeLevelOrderTraversal.class,
                Arrays.asList(Arrays.asList(3), Arrays.asList(9, 20), Arrays.asList(15, 7)),
                TreeNode.of(3, 9, 20, null, null, 15, 7));
    }

    @Test
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 1; i <= size; i++) {
                TreeNode cur = queue.remove();
                level.add(cur.val);
                TreeNode child;
                if ((child = cur.left) != null) {
                    queue.add(child);
                }
                if ((child = cur.right) != null) {
                    queue.add(child);
                }
            }
            res.add(level);
        }
        return res;
    }
}
