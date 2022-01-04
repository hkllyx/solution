package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.struct.ListNode;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

/**
 * <p>You are given the heads of two sorted linked lists <code>list1</code> and <code>list2</code>.</p>
 *
 * <p>Merge the two lists in a one <strong>sorted</strong> list. The list should be made by splicing together the nodes of the first two lists.</p>
 *
 * <p>Return <em>the head of the merged linked list</em>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/10/03/merge_ex1.jpg" style="width: 662px; height: 302px;" />
 * <pre>
 * <strong>Input:</strong> list1 = [1,2,4], list2 = [1,3,4]
 * <strong>Output:</strong> [1,1,2,3,4,4]
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> list1 = [], list2 = []
 * <strong>Output:</strong> []
 * </pre>
 *
 * <p><strong>Example 3:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> list1 = [], list2 = [0]
 * <strong>Output:</strong> [0]
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li>The number of nodes in both lists is in the range <code>[0, 50]</code>.</li>
 * 	<li><code>-100 &lt;= Node.val &lt;= 100</code></li>
 * 	<li>Both <code>list1</code> and <code>list2</code> are sorted in <strong>non-decreasing</strong> order.</li>
 * </ul>
 * <div><div>Related Topics</div><div><li>递归</li><li>链表</li></div></div><br><div><li>👍 2124</li><li>👎 0</li></div>
 *
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
