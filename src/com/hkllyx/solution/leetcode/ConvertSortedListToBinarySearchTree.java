package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.struct.ListNode;
import com.hkllyx.solution.util.struct.TreeNode;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

/**
 * <p>Given the <code>head</code> of a singly linked list where elements are <strong>sorted in ascending order</strong>, convert it to a height balanced BST.</p>
 *
 * <p>For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of <em>every</em> node never differ by more than 1.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/08/17/linked.jpg" style="width: 500px; height: 388px;" />
 * <pre>
 * <strong>Input:</strong> head = [-10,-3,0,5,9]
 * <strong>Output:</strong> [0,-3,9,-10,null,5]
 * <strong>Explanation:</strong> One possible answer is [0,-3,9,-10,null,5], which represents the shown height balanced BST.
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
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
 *  <li>The number of nodes in <code>head</code> is in the range <code>[0, 2 * 10<sup>4</sup>]</code>.</li>
 *  <li><code>-10<sup>5</sup> &lt;= Node.val &lt;= 10<sup>5</sup></code></li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>树</li><li>二叉搜索树</li><li>链表</li><li>分治</li><li>二叉树</li></div></div><br><div><li>👍 771</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2022/10/14
 */
@Solution(no = "109", title = "Convert Sorted List to Binary Search Tree", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree/")
public class ConvertSortedListToBinarySearchTree {

    public static void main(String[] args) {
        Assertions.assertExpect(TreeNode.of(0, -3, 9, -10, null, 5), ListNode.of(-10, -3, 0, 5, 9));
    }

    @Test
    public TreeNode sortedListToBST(ListNode head) {
        return partition(new ListNode(0, head));
    }

    public TreeNode partition(ListNode prev) {
        if (prev.next == null) {
            return null;
        }
        ListNode p1 = prev, p2 = prev;
        while (p2.next != null && p2.next.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        ListNode partition = p1.next;
        p1.next = null;
        TreeNode node = new TreeNode(partition.val);
        node.left = partition(prev);
        node.right = partition(partition);
        return node;
    }
}
