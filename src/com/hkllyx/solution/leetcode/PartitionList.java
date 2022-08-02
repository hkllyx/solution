package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.struct.ListNode;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

/**
 * <p>Given the <code>head</code> of a linked list and a value <code>x</code>, partition it such that all nodes <strong>less than</strong> <code>x</code> come before nodes <strong>greater than or equal</strong> to <code>x</code>.</p>
 *
 * <p>You should <strong>preserve</strong> the original relative order of the nodes in each of the two partitions.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/01/04/partition.jpg" style="width: 662px; height: 222px;" />
 * <pre>
 * <strong>Input:</strong> head = [1,4,3,2,5,2], x = 3
 * <strong>Output:</strong> [1,2,2,4,3,5]
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> head = [2,1], x = 2
 * <strong>Output:</strong> [1,2]
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 *  <li>The number of nodes in the list is in the range <code>[0, 200]</code>.</li>
 *  <li><code>-100 &lt;= Node.val &lt;= 100</code></li>
 *  <li><code>-200 &lt;= x &lt;= 200</code></li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>链表</li><li>双指针</li></div></div><br><div><li>👍 596</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2022/07/27
 */
@Solution(no = "86", title = "Partition List", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/partition-list/")
public class PartitionList {

    public static void main(String[] args) {
        Assertions.assertExpect(ListNode.of(1,2,2,2,4,3,5), ListNode.of(1,4,3,2,2,5,2), 3);
    }

    @Test
    public ListNode partition(ListNode head, int x) {
        ListNode sentinel = new ListNode();
        sentinel.next = head;
        ListNode partition = sentinel;
        head = sentinel;
        while (head.next != null) {
            if (head.next.val < x) {
                if (partition == head) {
                    head = head.next;
                    partition = head;
                } else {
                    ListNode target = head.next;
                    head.next = target.next;
                    target.next = partition.next;
                    partition.next = target;
                    partition = target;
                }
            } else {
                head = head.next;
            }
        }
        return sentinel.next;
    }
}
