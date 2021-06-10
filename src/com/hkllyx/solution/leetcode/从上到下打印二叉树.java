package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.info.Difficulty;
import com.hkllyx.solution.info.Solution;
import com.hkllyx.solution.struct.TreeNode;

/**
 * @author xiaoyong3
 * @date 2021/06/07
 */
@Solution(no = "剑指 Offer 32-I", difficulty = Difficulty.SIMPLE, url = "https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/")
public class 从上到下打印二叉树 {

    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        ListNode sentinel = new ListNode(null);
        sentinel.next = new ListNode(root);
        ListNode lp = sentinel.next;
        ListNode rp = sentinel.next;
        int size = 0;
        while (lp != null) {
            size++;
            TreeNode node;
            if ((node = lp.val.left) != null) {
                rp = rp.next = new ListNode(node);
            }
            if ((node = lp.val.right) != null) {
                rp = rp.next = new ListNode(node);
            }
            lp = lp.next;
        }
        int[] res = new int[size];
        int i = 0;
        while ((sentinel = sentinel.next) != null) {
            res[i++] = sentinel.val.val;
        }
        return res;
    }

    public static class ListNode {
        TreeNode val;
        ListNode next;

        public ListNode(TreeNode val) {
            this.val = val;
        }
    }
}
