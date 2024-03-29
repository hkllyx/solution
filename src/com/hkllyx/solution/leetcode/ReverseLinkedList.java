package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.struct.ListNode;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

/**
 * <p>Given the <code>head</code> of a singly linked list, reverse the list, and return <em>the reversed list</em>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/02/19/rev1ex1.jpg" style="width: 542px; height: 222px;" />
 * <pre>
 * <strong>Input:</strong> head = [1,2,3,4,5]
 * <strong>Output:</strong> [5,4,3,2,1]
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/02/19/rev1ex2.jpg" style="width: 182px; height: 222px;" />
 * <pre>
 * <strong>Input:</strong> head = [1,2]
 * <strong>Output:</strong> [2,1]
 * </pre>
 *
 * <p><strong>Example 3:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> head = []
 * <strong>Output:</strong> []
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li>The number of nodes in the list is the range <code>[0, 5000]</code>.</li>
 * 	<li><code>-5000 &lt;= Node.val &lt;= 5000</code></li>
 * </ul>
 *
 * <p>&nbsp;</p>
 * <p><strong>Follow up:</strong> A linked list can be reversed either iteratively or recursively. Could you implement both?</p>
 * <div><div>Related Topics</div><div><li>递归</li><li>链表</li></div></div><br><div><li>👍 2181</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2021/06/04
 */
@Solution(no = "206", title = "Reverse Linked List", difficulty = Difficulty.EASY, url = "https://leetcode-cn.com/problems/reverse-linked-list/")
public class ReverseLinkedList {

    public static void main(String[] args) {
        Assertions.assertExpect(ReverseLinkedList.class, ListNode.of(1), ListNode.of(1));
        Assertions.assertExpect(ReverseLinkedList.class, ListNode.of(5, 4, 3, 2, 1), ListNode.of(1, 2, 3, 4, 5));
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
