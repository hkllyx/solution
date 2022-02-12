package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.struct.ListNode;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

/**
 * <p>You are given an array of <code>k</code> linked-lists <code>lists</code>, each linked-list is sorted in ascending order.</p>
 *
 * <p><em>Merge all the linked-lists into one sorted linked-list and return it.</em></p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> lists = [[1,4,5],[1,3,4],[2,6]]
 * <strong>Output:</strong> [1,1,2,3,4,4,5,6]
 * <strong>Explanation:</strong> The linked-lists are:
 * [
 *   1-&gt;4-&gt;5,
 *   1-&gt;3-&gt;4,
 *   2-&gt;6
 * ]
 * merging them into one sorted list:
 * 1-&gt;1-&gt;2-&gt;3-&gt;4-&gt;4-&gt;5-&gt;6
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> lists = []
 * <strong>Output:</strong> []
 * </pre>
 *
 * <p><strong>Example 3:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> lists = [[]]
 * <strong>Output:</strong> []
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>k == lists.length</code></li>
 * 	<li><code>0 &lt;= k &lt;= 10^4</code></li>
 * 	<li><code>0 &lt;= lists[i].length &lt;= 500</code></li>
 * 	<li><code>-10^4 &lt;= lists[i][j] &lt;= 10^4</code></li>
 * 	<li><code>lists[i]</code> is sorted in <strong>ascending order</strong>.</li>
 * 	<li>The sum of <code>lists[i].length</code> won&#39;t exceed <code>10^4</code>.</li>
 * </ul>
 * <div><div>Related Topics</div><div><li>链表</li><li>分治</li><li>堆（优先队列）</li><li>归并排序</li></div></div><br><div><li>👍 1746</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2022/02/11
 */
@Solution(no = "23", title = "Merge k Sorted Lists", difficulty = Difficulty.HARD, url = "https://leetcode-cn.com/problems/merge-k-sorted-lists/")
public class MergeKSortedLists {

    public static void main(String[] args) {
        Assertions.assertExpect(ListNode.of(1,1,2,3,4,4,5,6),
                (Object) new ListNode[]{ListNode.of(1,4,5), ListNode.of(1,3,4), ListNode.of(2,6)});
    }

    @Test(active = false, mills = 210)
    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        if (len <= 0) {
            return null;
        }
        ListNode sentinel = new ListNode(), point = sentinel;
        while (true) {
            int min = 0;
            ListNode minNode = lists[0];
            for (int i = 1; i < len; i++) {
                ListNode cur = lists[i];
                if (cur == null) {
                    continue;
                }
                if (minNode == null || minNode.val > cur.val) {
                    min = i;
                    minNode = cur;
                }
            }
            if (minNode == null) {
                break;
            }
            point.next = minNode;
            point = minNode;
            lists[min] = minNode.next;
        }
        return sentinel.next;
    }

    @Test(value = "分治", mills = 1)
    public ListNode mergeKLists1(ListNode[] lists) {
        if (lists.length < 1) {
            return null;
        }
        return mergeTwoLists(lists, 0, lists.length - 1);
    }

    public ListNode mergeTwoLists(ListNode[] lists, int from, int to) {
        if (from == to) {
            return lists[from];
        }
        int partition = (from + to) >> 1;
        ListNode left = mergeTwoLists(lists, from, partition);
        ListNode right = mergeTwoLists(lists, partition + 1, to);
        ListNode sentinel = new ListNode();
        for (ListNode cur = sentinel; left != null || right != null; cur = cur.next) {
            if (left == null) {
                cur.next = right;
                right = null;
            } else if (right == null) {
                cur.next = left;
                left = null;
            } else if (left.val > right.val) {
                cur.next = right;
                right = right.next;
            } else {
                cur.next = left;
                left = left.next;
            }
        }
        return sentinel.next;
    }
}
