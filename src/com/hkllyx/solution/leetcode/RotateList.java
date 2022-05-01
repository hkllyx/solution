package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.struct.ListNode;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

/**
 * <p>Given the <code>head</code> of a linked&nbsp;list, rotate the list to the right by <code>k</code> places.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/11/13/rotate1.jpg" style="width: 450px; height: 191px;" />
 * <pre>
 * <strong>Input:</strong> head = [1,2,3,4,5], k = 2
 * <strong>Output:</strong> [4,5,1,2,3]
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/11/13/roate2.jpg" style="width: 305px; height: 350px;" />
 * <pre>
 * <strong>Input:</strong> head = [0,1,2], k = 4
 * <strong>Output:</strong> [2,0,1]
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li>The number of nodes in the list is in the range <code>[0, 500]</code>.</li>
 * 	<li><code>-100 &lt;= Node.val &lt;= 100</code></li>
 * 	<li><code>0 &lt;= k &lt;= 2 * 10<sup>9</sup></code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>链表</li><li>双指针</li></div></div><br><div><li>👍 742</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2022/03/23
 */
@Solution(no = "61", title = "Rotate List", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/rotate-list/")
public class RotateList {

    public static void main(String[] args) {
        Assertions.assertExpect(ListNode.of(2,1),ListNode.of(1,2), 1);
        Assertions.assertExpect(ListNode.of(1),ListNode.of(1), 0);
        Assertions.assertExpect(ListNode.of(1),ListNode.of(1), 1);
        Assertions.assertExpect(ListNode.of(1),ListNode.of(1), 10);
        Assertions.assertExpect(ListNode.of(1,2,3,4,5),ListNode.of(1,2,3,4,5), 0);
        Assertions.assertExpect(ListNode.of(4,5,1,2,3),ListNode.of(1,2,3,4,5), 2);
        Assertions.assertExpect(ListNode.of(1,2,3,4,5),ListNode.of(1,2,3,4,5), 5);
        Assertions.assertExpect(ListNode.of(4,5,1,2,3),ListNode.of(1,2,3,4,5), 7);
        Assertions.assertExpect(ListNode.of(4,5,1,2,3),ListNode.of(1,2,3,4,5), 12);
    }

    @Test(mills = 0)
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int size = 0;
        ListNode p0 = head;
        // p0先走k步，
        while (k-- > 0) {
            size++;
            p0 = p0.next;
            // p0走到最后，k > 链表长度，取模减少重复次数，然后p0重新开始
            if (p0 == null) {
                k %= size;
                p0 = head;
            }
        }
        // p0没有走或者重新走到head，不用选择，或者说整个旋转（还是自身）
        if (p0 == head) {
            return head;
        }
        // p0和p1同时走，p0走到最后一位，p1之后的就是需要选择的k个结点
        ListNode p1 = head;
        while (p0.next != null) {
            p0 = p0.next;
            p1 = p1.next;
        }
        p0.next = head;
        head = p1.next;
        p1.next = null;
        return head;
    }
}
