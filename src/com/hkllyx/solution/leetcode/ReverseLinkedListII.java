package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.struct.ListNode;

/**
 * <p>Given the <code>head</code> of a singly linked list and two integers <code>left</code> and <code>right</code> where <code>left &lt;= right</code>, reverse the nodes of the list from position <code>left</code> to position <code>right</code>, and return <em>the reversed list</em>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/02/19/rev2ex2.jpg" style="width: 542px; height: 222px;" />
 * <pre>
 * <strong>Input:</strong> head = [1,2,3,4,5], left = 2, right = 4
 * <strong>Output:</strong> [1,4,3,2,5]
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> head = [5], left = 1, right = 1
 * <strong>Output:</strong> [5]
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 *  <li>The number of nodes in the list is <code>n</code>.</li>
 *  <li><code>1 &lt;= n &lt;= 500</code></li>
 *  <li><code>-500 &lt;= Node.val &lt;= 500</code></li>
 *  <li><code>1 &lt;= left &lt;= right &lt;= n</code></li>
 * </ul>
 *
 * <p>&nbsp;</p>
 * <strong>Follow up:</strong> Could you do it in one pass?
 *
 * <div><div>Related Topics</div><div><li>链表</li></div></div><br><div><li>👍 1358</li><li>👎 0</li></div>
 *
 *  @author xiaoyong3
 * @date 2022/08/02
 */
@Solution(no = "92", title = "Reverse Linked List II", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/reverse-linked-list-ii/")
public class ReverseLinkedListII {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left >= right) {
            return head;
        }
        ListNode sentinel = new ListNode();
        sentinel.next = head;
        // 找到left的前一个和left
        ListNode prev = sentinel;
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }
        ListNode leftNode = prev.next;
        // 反转
        while (left++ < right) {
            ListNode cur = leftNode.next;
            leftNode.next = cur.next;
            cur.next = prev.next;
            prev.next = cur;
        }
        return sentinel.next;
    }
}
