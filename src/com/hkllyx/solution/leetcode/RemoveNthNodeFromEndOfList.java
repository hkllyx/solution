package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.struct.ListNode;

/**
 *
 * <p>Given the <code>head</code> of a linked list, remove the <code>n<sup>th</sup></code> node from the end of the list and return its head.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/10/03/remove_ex1.jpg" style="width: 542px; height: 222px;" />
 * <pre>
 * <strong>Input:</strong> head = [1,2,3,4,5], n = 2
 * <strong>Output:</strong> [1,2,3,5]
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> head = [1], n = 1
 * <strong>Output:</strong> []
 * </pre>
 *
 * <p><strong>Example 3:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> head = [1,2], n = 1
 * <strong>Output:</strong> [1]
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li>The number of nodes in the list is <code>sz</code>.</li>
 * 	<li><code>1 &lt;= sz &lt;= 30</code></li>
 * 	<li><code>0 &lt;= Node.val &lt;= 100</code></li>
 * 	<li><code>1 &lt;= n &lt;= sz</code></li>
 * </ul>
 *
 * <p>&nbsp;</p>
 * <p><strong>Follow up:</strong> Could you do this in one pass?</p>
 * <div><div>Related Topics</div><div><li>链表</li><li>双指针</li></div></div><br><div><li>👍 1768</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2022/01/24
 */
@Solution(no = "19", title = "Remove Nth Node From End of List", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/")
public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p0 = head, p1 = head;
        // p0先走n步
        while (n-- > 0) {
            p0 = p0.next;
        }
        // n == size，删除第一个
        if (p0 == null) {
            return head.next;
        }
        // 两个一起走，p0走到最后一个，p1就走到了倒数第n+1个
        while (p0.next != null) {
            p0 = p0.next;
            p1 = p1.next;
        }
        p1.next = p1.next.next;
        return head;
    }
}
