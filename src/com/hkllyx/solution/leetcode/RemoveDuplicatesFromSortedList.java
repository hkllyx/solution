package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.struct.ListNode;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

/**
 * <p>Given the <code>head</code> of a sorted linked list, <em>delete all duplicates such that each element appears only once</em>. Return <em>the linked list <strong>sorted</strong> as well</em>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/01/04/list1.jpg" style="width: 302px; height: 242px;" />
 * <pre>
 * <strong>Input:</strong> head = [1,1,2]
 * <strong>Output:</strong> [1,2]
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/01/04/list2.jpg" style="width: 542px; height: 222px;" />
 * <pre>
 * <strong>Input:</strong> head = [1,1,2,3,3]
 * <strong>Output:</strong> [1,2,3]
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
 * <div><div>Related Topics</div><div><li>链表</li></div></div><br><div><li>👍 706</li><li>👎 0</li></div>
 *
 * @author hkllyx
 * @date 2021/03/26
 */
@Solution(no = "83", difficulty = Difficulty.EASY, url = "https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list")
public class RemoveDuplicatesFromSortedList {

    public static void main(String[] args) {
        Assertions.assertExpect(RemoveDuplicatesFromSortedList.class, ListNode.of(1), ListNode.of(1, 1, 1));
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
