package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.struct.ListNode;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

/**
 * <p>Given the <code>head</code> of a sorted linked list, <em>delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list</em>. Return <em>the linked list <strong>sorted</strong> as well</em>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/01/04/linkedlist1.jpg" style="width: 500px; height: 142px;" />
 * <pre>
 * <strong>Input:</strong> head = [1,2,3,3,4,4,5]
 * <strong>Output:</strong> [1,2,5]
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/01/04/linkedlist2.jpg" style="width: 500px; height: 205px;" />
 * <pre>
 * <strong>Input:</strong> head = [1,1,1,2,3]
 * <strong>Output:</strong> [2,3]
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li>The number of nodes in the list is in the range <code>[0, 300]</code>.</li>
 * 	<li><code>-100 &lt;= Node.val &lt;= 100</code></li>
 * 	<li>The list is guaranteed to be <strong>sorted</strong> in ascending order.</li>
 * </ul>
 * <div><div>Related Topics</div><div><li>链表</li><li>双指针</li></div></div><br><div><li>👍 944</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2022/07/19
 */
@Solution(no = "82", title = "Remove Duplicates from Sorted List II", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/")
public class RemoveDuplicatesFromSortedListIi {

    public static void main(String[] args) {
        Assertions.assertExpect(ListNode.of(2, 3, 5), ListNode.of(1, 1, 1, 2, 3, 4, 4, 4, 5));
    }

    @Test
    public ListNode deleteDuplicates(ListNode head) {
        ListNode sentinel = new ListNode();
        sentinel.next = head;
        ListNode prev = sentinel;
        boolean duplicate = false;
        while (head != null) {
            if (head.next != null) {
                if (head.val == head.next.val) {
                    prev.next = head.next;
                    duplicate = true;
                } else if (duplicate) {
                    prev.next = head.next;
                    duplicate = false;
                } else {
                    prev = head;
                }
            } else if (duplicate) {
                prev.next = null;
            }
            head = head.next;
        }
        return sentinel.next;
    }
}
