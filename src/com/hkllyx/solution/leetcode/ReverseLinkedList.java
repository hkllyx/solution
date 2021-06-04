package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.info.Difficulty;
import com.hkllyx.solution.info.Solution;
import com.hkllyx.solution.struct.ListNode;
import com.hkllyx.solution.util.Test;
import com.hkllyx.solution.util.TestUtils;

/**
 * @author xiaoyong3
 * @date 2021/06/04
 */
@Solution(no = "206", difficulty = Difficulty.SIMPLE, url = "https://leetcode-cn.com/problems/reverse-linked-list/")
public class ReverseLinkedList {

    public static void main(String[] args) {
        TestUtils.assertion(ReverseLinkedList.class, ListNode.of(1), ListNode.of(1));
        TestUtils.assertion(ReverseLinkedList.class, ListNode.of(5, 4, 3, 2, 1), ListNode.of(1, 2, 3, 4, 5));
    }

    @Test
    public ListNode reverseList(ListNode head) {
        ListNode sentinel = new ListNode();
        sentinel.next = head;
        ListNode next;
        while (head != null && (next = head.next) != null) {
            head.next = next.next;
            next.next = sentinel.next;
            sentinel.next = next;
        }
        return sentinel.next;
    }
}
