package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.struct.ListNode;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

/**
 * @author xiaoyong3
 * @date 2021/06/04
 */
@Solution(no = "21", difficulty = Difficulty.SIMPLE, url = "https://leetcode-cn.com/problems/merge-two-sorted-lists/")
public class MergeTwoSortedLists {

    public static void main(String[] args) {
        Assertions.assertExpect(MergeTwoSortedLists.class, ListNode.of(1, 1, 2, 3, 4, 4),
                ListNode.of(1, 2, 4), ListNode.of(1, 3, 4));
    }

    @Test
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode sentinel = new ListNode(), prev = sentinel;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                prev = prev.next = l1;
                l1 = l1.next;
            } else {
                prev = prev.next = l2;
                l2 = l2.next;
            }
        }
        while (l1 != null) {
            prev = prev.next = l1;
            l1 = l1.next;
        }
        while (l2 != null) {
            prev.next = l2;
            prev = l2;
            l2 = l2.next;
        }
        return sentinel.next;
    }
}
