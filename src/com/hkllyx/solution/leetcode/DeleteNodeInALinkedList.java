package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.struct.ListNode;

/**
 * @author xiaoyong3
 * @date 2021/11/02
 */
@Solution(no = "237", difficulty = Difficulty.SIMPLE, url = "https://leetcode-cn.com/problems/delete-node-in-a-linked-list/")
public class DeleteNodeInALinkedList {

    public void deleteNode(ListNode node) {
        ListNode next = node.next;
        node.val = next.val;
        node.next = next.next;
        next.next = null;
    }
}
