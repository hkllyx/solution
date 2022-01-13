package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.struct.ListNode;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

/**
 * <p>输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。</p>
 *
 * <p>例如，一个链表有 <code>6</code> 个节点，从头节点开始，它们的值依次是 <code>1、2、3、4、5、6</code>。这个链表的倒数第 <code>3</code> 个节点是值为 <code>4</code> 的节点。</p>
 *
 * <p> </p>
 *
 * <p><strong>示例：</strong></p>
 *
 * <pre>
 * 给定一个链表: <strong>1->2->3->4->5</strong>, 和 <em>k </em><strong>= 2</strong>.
 *
 * 返回链表 4<strong>->5</strong>.</pre>
 * <div><div>Related Topics</div><div><li>链表</li><li>双指针</li></div></div><br><div><li>👍 309</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2021/06/04
 */
@Solution(no = "剑指 Offer 22", title = "链表中倒数第k个节点", difficulty = Difficulty.EASY, url = "https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/")
public class 链表中倒数第k个节点 {

    public static void main(String[] args) {
        Assertions.assertExpect(链表中倒数第k个节点.class, ListNode.of(4, 5, 6), ListNode.of(1, 2, 3, 4, 5, 6), 3);
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
