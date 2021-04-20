package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.info.Difficulty;
import com.hkllyx.solution.info.Solution;
import com.hkllyx.solution.struct.ListNode;
import com.hkllyx.solution.util.Test;
import com.hkllyx.solution.util.TestUtils;

/**
 * @author hkllyx
 * @date 2021/04/14
 */
@Solution(no = 148, difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/sort-list/")
public class SortList {

    public static void main(String[] args) {
        TestUtils.assertion(SortList.class, ListNode.of(1, 2, 3, 4), ListNode.of(4, 2, 1, 3));
        TestUtils.assertion(SortList.class, ListNode.of(-1, 0, 3, 4, 5), ListNode.of(-1, 5, 3, 4, 0));
    }

    @Test
    /** 归并排序 */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode middle = middle(head);
        head = sortList(head);
        middle = sortList(middle);
        return merge(head, middle);
    }

    private ListNode middle(ListNode head) {
        // sortList() 中已判定 head != null && head.next != null
        ListNode once = head;
        ListNode twice = head.next;
        while (twice != null && twice.next != null && twice.next.next != null) {
            once = once.next;
            twice = twice.next.next;
        }
        ListNode middle = once.next;
        once.next = null;
        return middle;
    }

    private ListNode merge(ListNode left, ListNode right) {
        // sortList() 中已判定 head != null && head.next != null
        ListNode sentinel = new ListNode();
        ListNode current = sentinel;
        while (true) {
            if (left != null && right != null) {
                if (left.val < right.val) {
                    current.next = left;
                    left = left.next;
                } else {
                    current.next = right;
                    right = right.next;
                }
                current = current.next;
            } else if (left != null) {
                current.next = left;
                left = left.next;
                current = current.next;
            } else if (right != null) {
                current.next = right;
                right = right.next;
                current = current.next;
            } else {
                break;
            }
        }
        return sentinel.next;
    }
}
