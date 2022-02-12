package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.struct.ListNode;
import com.hkllyx.solution.util.test.Test;

/**
 * <p>Given a&nbsp;linked list, swap every two adjacent nodes and return its head. You must solve the problem without&nbsp;modifying the values in the list&#39;s nodes (i.e., only nodes themselves may be changed.)</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/10/03/swap_ex1.jpg" style="width: 422px; height: 222px;" />
 * <pre>
 * <strong>Input:</strong> head = [1,2,3,4]
 * <strong>Output:</strong> [2,1,4,3]
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> head = []
 * <strong>Output:</strong> []
 * </pre>
 *
 * <p><strong>Example 3:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> head = [1]
 * <strong>Output:</strong> [1]
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li>The number of nodes in the&nbsp;list&nbsp;is in the range <code>[0, 100]</code>.</li>
 * 	<li><code>0 &lt;= Node.val &lt;= 100</code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>递归</li><li>链表</li></div></div><br><div><li>👍 1230</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2022/02/11
 */
@Solution(no = "24", title = "Swap Nodes in Pairs", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/swap-nodes-in-pairs/")
public class SwapNodesInPairs {

    @Test
    public ListNode swapPairs(ListNode head) {
        ListNode sentinel = new ListNode();
        sentinel.next = head;
        for (ListNode cur = sentinel, n1, n2; (n1 = cur.next) != null && (n2 = n1.next) != null; cur = n1) {
            n1.next = n2.next;
            n2.next = n1;
            cur.next = n2;
        }
        return sentinel.next;
    }
}
