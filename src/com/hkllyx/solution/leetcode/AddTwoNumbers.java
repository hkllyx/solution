package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.struct.ListNode;
import com.hkllyx.solution.util.test.Test;
import com.hkllyx.solution.util.test.TestUtils;

/**
 * @author hkllyx
 * @date 2021/03/26
 */
@Solution(no = "2", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/add-two-numbers/")
public class AddTwoNumbers {

    public static void main(String[] args) {
        TestUtils.assertion(AddTwoNumbers.class, ListNode.of(7, 0, 8), ListNode.of(2, 4, 3), ListNode.of(5, 6, 4));
        TestUtils.assertion(AddTwoNumbers.class, ListNode.of(8, 9, 9, 9, 0, 0, 0, 1), ListNode.of(9, 9, 9, 9, 9, 9, 9),
                ListNode.of(9, 9, 9, 9));
    }

    /**
     * 利用哨兵节点
     */
    @Test
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sentinel = new ListNode(0);
        ListNode cur = sentinel;
        int plus = 0;
        int val;
        while (true) {
            if (l1 != null && l2 != null) {
                val = l1.val + l2.val + plus;
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1 != null) {
                val = l1.val + plus;
                l1 = l1.next;
            } else if (l2 != null) {
                val = l2.val + plus;
                l2 = l2.next;
            } else {
                break;
            }
            plus = val / 10;
            val = val % 10;
            cur.next = new ListNode(val);
            cur = cur.next;
        }
        if (plus != 0) {
            cur.next = new ListNode(plus);
        }
        return sentinel.next;
    }
}
