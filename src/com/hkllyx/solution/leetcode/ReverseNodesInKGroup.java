package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.struct.ListNode;
import com.hkllyx.solution.util.test.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <p>Given the <code>head</code> of a linked list, reverse the nodes of the list <code>k</code> at a time, and return <em>the modified list</em>.</p>
 *
 * <p><code>k</code> is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of <code>k</code> then left-out nodes, in the end, should remain as it is.</p>
 *
 * <p>You may not alter the values in the list&#39;s nodes, only nodes themselves may be changed.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/10/03/reverse_ex1.jpg" style="width: 542px; height: 222px;" />
 * <pre>
 * <strong>Input:</strong> head = [1,2,3,4,5], k = 2
 * <strong>Output:</strong> [2,1,4,3,5]
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/10/03/reverse_ex2.jpg" style="width: 542px; height: 222px;" />
 * <pre>
 * <strong>Input:</strong> head = [1,2,3,4,5], k = 3
 * <strong>Output:</strong> [3,2,1,4,5]
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li>The number of nodes in the list is <code>n</code>.</li>
 * 	<li><code>1 &lt;= k &lt;= n &lt;= 5000</code></li>
 * 	<li><code>0 &lt;= Node.val &lt;= 1000</code></li>
 * </ul>
 *
 * <p>&nbsp;</p>
 * <p><strong>Follow-up:</strong> Can you solve the problem in <code>O(1)</code> extra memory space?</p>
 * <div><div>Related Topics</div><div><li>递归</li><li>链表</li></div></div><br><div><li>👍 1465</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2022/02/11
 */
@Solution(no = "25", title = "Reverse Nodes in k-Group", difficulty = Difficulty.HARD, url = "https://leetcode-cn.com/problems/reverse-nodes-in-k-group/")
public class ReverseNodesInKGroup {

    @Test(active = false, mills = 3, memory = 41.4)
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode sentinel = new ListNode();
        sentinel.next = head;
        Deque<ListNode> stack = new ArrayDeque<>(k);
        ListNode pre = sentinel;
        while (true) {
            while (stack.size() < k && head != null) {
                stack.push(head);
                head = head.next;
            }
            if (stack.size() < k) {
                pre.next = stack.peekLast();
                break;
            }
            while (!stack.isEmpty()) {
                pre.next = stack.pop();
                pre = pre.next;
            }
        }
        return sentinel.next;
    }

    @Test(mills = 1)
    public ListNode reverseKGroup1(ListNode head, int k) {
        if (k < 2) {
            return head;
        }

        ListNode cur = head;
        // 获取size
        int size = 0;
        while (cur != null) {
            size++;
            cur = cur.next;
        }
        // 计算需要反转的次数
        int times = size / k;

        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode pre = sentinel;
        for (int i = 0; i < times; i++) {
            // head为每次操作的头个node
            for (int j = 0; j < k - 1; j++) {
                cur = head.next;
                head.next = cur.next;
                cur.next = pre.next;
                pre.next = cur;
            }
            pre = head;
            head = head.next;
        }
        return sentinel.next;
    }
}
