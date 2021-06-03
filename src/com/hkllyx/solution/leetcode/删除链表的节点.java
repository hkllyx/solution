package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.info.Difficulty;
import com.hkllyx.solution.info.Solution;
import com.hkllyx.solution.struct.ListNode;

/**
 * @author xiaoyong3
 * @date 2021/06/01
 */
@Solution(no = "剑指 Offer 18", difficulty = Difficulty.SIMPLE, url = "https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/")
public class 删除链表的节点 {

    public ListNode deleteNode(ListNode head, int val) {
        ListNode sentinel = new ListNode();
        sentinel.next = head;
        ListNode prev = sentinel;
        while (head != null) {
            if (head.val == val) {
                prev.next = head.next;
                break;
            }
            prev = head;
            head = head.next;
        }
        return sentinel.next;
    }
}
