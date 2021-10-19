package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.struct.TreeNode;
import com.hkllyx.solution.util.test.Test;
import com.hkllyx.solution.util.test.TestUtils;

import java.util.Stack;

/**
 * @author hkllyx
 * @date 2021-10-17
 */
@Solution(no = "230", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/")
public class KthSmallestElementInABst {

    public static void main(String[] args) {
        TestUtils.assertion(3, TreeNode.of(5, 3, 6, 2, 4, null, null, 1), 3);
        TestUtils.assertion(1, TreeNode.of(3, 1, 4, null, 2), 1);
    }

    @Test(value = "最小堆", active = false, mills = 6)
    public int kthSmallest(TreeNode root, int k) {
        int res = -1;
        for (int i = 0; i < k; i++) {
            buildMinHeap(root);
            res = root.val;
            root.val = Integer.MAX_VALUE;
        }
        return res;
    }

    @Test("中序")
    public int kthSmallest1(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (--k == 0) {
                return root.val;
            }
            root = root.right;
        }
        return -1;
    }

    private TreeNode buildMinHeap(TreeNode root) {
        if (root != null) {
            change(root, buildMinHeap(root.left));
            change(root, buildMinHeap(root.right));
        }
        return root;
    }

    private void change(TreeNode root, TreeNode child) {
        if (child != null && child.val < root.val) {
            int tmp = child.val;
            child.val = root.val;
            root.val = tmp;
        }
    }
}
