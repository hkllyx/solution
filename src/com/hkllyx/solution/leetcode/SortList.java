package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.struct.ListNode;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

/**
 * <p>Given the <code>head</code> of a linked list, return <em>the list after sorting it in <strong>ascending order</strong></em>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/09/14/sort_list_1.jpg" style="width: 450px; height: 194px;" />
 * <pre>
 * <strong>Input:</strong> head = [4,2,1,3]
 * <strong>Output:</strong> [1,2,3,4]
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/09/14/sort_list_2.jpg" style="width: 550px; height: 184px;" />
 * <pre>
 * <strong>Input:</strong> head = [-1,5,3,4,0]
 * <strong>Output:</strong> [-1,0,3,4,5]
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
 * 	<li>The number of nodes in the list is in the range <code>[0, 5 * 10<sup>4</sup>]</code>.</li>
 * 	<li><code>-10<sup>5</sup> &lt;= Node.val &lt;= 10<sup>5</sup></code></li>
 * </ul>
 *
 * <p>&nbsp;</p>
 * <p><strong>Follow up:</strong> Can you sort the linked list in <code>O(n logn)</code> time and <code>O(1)</code> memory (i.e. constant space)?</p>
 * <div><div>Related Topics</div><div><li>链表</li><li>双指针</li><li>分治</li><li>排序</li><li>归并排序</li></div></div><br><div><li>👍 1423</li><li>👎 0</li></div>
 *
 * @author hkllyx
 * @date 2021/04/14
 */
@Solution(no = "148", title = "Sort List", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/sort-list/")
public class SortList {

    public static void main(String[] args) {
        Assertions.assertExpect(SortList.class, ListNode.of(1, 2, 3, 4), ListNode.of(4, 2, 1, 3));
        Assertions.assertExpect(SortList.class, ListNode.of(-1, 0, 3, 4, 5), ListNode.of(-1, 5, 3, 4, 0));
    }

    @Test
    /** 归并排序 */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode middle = middle(head);
        head = sortList(head);
        middle = sortList(middle);
        return merge(head, middle);
    }

    private ListNode middle(ListNode head) {
        // sortList() 中已判定 head != null && head.next != null
        ListNode once = head;
        ListNode twice = head.next;
        while (twice != null && twice.next != null && twice.next.next != null) {
            once = once.next;
            twice = twice.next.next;
        }
        ListNode middle = once.next;
        once.next = null;
        return middle;
    }

    private ListNode merge(ListNode left, ListNode right) {
        // sortList() 中已判定 head != null && head.next != null
        ListNode sentinel = new ListNode();
        ListNode current = sentinel;
        while (true) {
            if (left != null && right != null) {
                if (left.val < right.val) {
                    current.next = left;
                    left = left.next;
                } else {
                    current.next = right;
                    right = right.next;
                }
                current = current.next;
            } else if (left != null) {
                current.next = left;
                left = left.next;
                current = current.next;
            } else if (right != null) {
                current.next = right;
                right = right.next;
                current = current.next;
            } else {
                break;
            }
        }
        return sentinel.next;
    }
}
