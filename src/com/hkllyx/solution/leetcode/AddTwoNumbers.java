package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.struct.ListNode;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

/**
 * <p>You are given two <strong>non-empty</strong> linked lists representing two non-negative integers. The digits are stored in <strong>reverse order</strong>, and each of their nodes contains a single digit. Add the two numbers and return the sum&nbsp;as a linked list.</p>
 *
 * <p>You may assume the two numbers do not contain any leading zero, except the number 0 itself.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/10/02/addtwonumber1.jpg" style="width: 483px; height: 342px;" />
 * <pre>
 * <strong>Input:</strong> l1 = [2,4,3], l2 = [5,6,4]
 * <strong>Output:</strong> [7,0,8]
 * <strong>Explanation:</strong> 342 + 465 = 807.
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> l1 = [0], l2 = [0]
 * <strong>Output:</strong> [0]
 * </pre>
 *
 * <p><strong>Example 3:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * <strong>Output:</strong> [8,9,9,9,0,0,0,1]
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li>The number of nodes in each linked list is in the range <code>[1, 100]</code>.</li>
 * 	<li><code>0 &lt;= Node.val &lt;= 9</code></li>
 * 	<li>It is guaranteed that the list represents a number that does not have leading zeros.</li>
 * </ul>
 * <div><div>Related Topics</div><div><li>递归</li><li>链表</li><li>数学</li></div></div><br><div><li>👍 7300</li><li>👎 0</li></div>
 *
 * @author hkllyx
 * @date 2021/03/26
 */
@Solution(no = "2", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/add-two-numbers/")
public class AddTwoNumbers {

    public static void main(String[] args) {
        Assertions.assertExpect(AddTwoNumbers.class, ListNode.of(7, 0, 8), ListNode.of(2, 4, 3), ListNode.of(5, 6, 4));
        Assertions.assertExpect(AddTwoNumbers.class, ListNode.of(8, 9, 9, 9, 0, 0, 0, 1),
                ListNode.of(9, 9, 9, 9, 9, 9, 9),
                ListNode.of(9, 9, 9, 9));
    }

    /**
     * 利用哨兵节点
     */
    @Test
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sentinel = new ListNode(0);
        ListNode cur = sentinel;
        int plus = 0;
        int val;
        while (true) {
            if (l1 != null && l2 != null) {
                val = l1.val + l2.val + plus;
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1 != null) {
                val = l1.val + plus;
                l1 = l1.next;
            } else if (l2 != null) {
                val = l2.val + plus;
                l2 = l2.next;
            } else {
                break;
            }
            plus = val / 10;
            val = val % 10;
            cur.next = new ListNode(val);
            cur = cur.next;
        }
        if (plus != 0) {
            cur.next = new ListNode(plus);
        }
        return sentinel.next;
    }
}
