package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.info.Difficulty;
import com.hkllyx.solution.info.Solution;
import com.hkllyx.solution.struct.ListNode;
import com.hkllyx.solution.util.Test;
import com.hkllyx.solution.util.TestUtils;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list
 *
 * @author hkllyx
 * @date 2021/03/26
 */
@Solution(no = 83, difficulty = Difficulty.SIMPLE, url = "")
public class RemoveDuplicatesFromSortedList {

    public static void main(String[] args) {
        TestUtils.assertion(RemoveDuplicatesFromSortedList.class, ListNode.of(1), ListNode.of(1, 1, 1));
    }

    @Test
    public ListNode deleteDuplicates(ListNode head) {
        ListNode c = head;
        while (c != null) {
            ListNode n = c.next;
            if (n != null && c.val == n.val) {
                c.next = n.next;
            } else {
                c = n;
            }
        }
        return head;
    }
}
