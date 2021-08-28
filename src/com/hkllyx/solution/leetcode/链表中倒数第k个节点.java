package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.Test;
import com.hkllyx.solution.util.TestUtils;
import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.struct.ListNode;

/**
 * @author xiaoyong3
 * @date 2021/06/04
 */
@Solution(no = "剑指Offer 22", difficulty = Difficulty.SIMPLE, url = "https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/")
public class 链表中倒数第k个节点 {

    public static void main(String[] args) {
        TestUtils.assertion(链表中倒数第k个节点.class, ListNode.of(4, 5, 6), ListNode.of(1, 2, 3, 4, 5, 6), 3);
    }

    @Test
    public ListNode getKthFromEnd(ListNode head, int k) {
        // ref先走k步
        ListNode ref = head;
        while (k-- > 0) {
            if (ref == null) {
                return null;
            } else {
                ref = ref.next;
            }
        }
        // ref走到最后一个节点之后，head就是倒数第k个节点
        while (ref != null) {
            ref = ref.next;
            head = head.next;
        }
        return head;
    }
}
