package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.struct.Node;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <p>You are given a <strong>perfect binary tree</strong> where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:</p>
 *
 * <pre>
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * </pre>
 *
 * <p>Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to <code>NULL</code>.</p>
 *
 * <p>Initially, all next pointers are set to <code>NULL</code>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2019/02/14/116_sample.png" style="width: 500px; height: 171px;" />
 * <pre>
 * <strong>Input:</strong> root = [1,2,3,4,5,6,7]
 * <strong>Output:</strong> [1,#,2,3,#,4,5,6,7,#]
 * <strong>Explanation: </strong>Given the above perfect binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> root = []
 * <strong>Output:</strong> []
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 *  <li>The number of nodes in the tree is in the range <code>[0, 2<sup>12</sup> - 1]</code>.</li>
 *  <li><code>-1000 &lt;= Node.val &lt;= 1000</code></li>
 * </ul>
 *
 * <p>&nbsp;</p>
 * <p><strong>Follow-up:</strong></p>
 *
 * <ul>
 *  <li>You may only use constant extra space.</li>
 *  <li>The recursive approach is fine. You may assume implicit stack space does not count as extra space for this problem.</li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>树</li><li>深度优先搜索</li><li>广度优先搜索</li><li>链表</li><li>二叉树</li></div></div><br><div><li>👍 886</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2022/10/21
 */
@Solution(no = "116", title = "Populating Next Right Pointers in Each Node", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/")
public class PopulatingNextRightPointersInEachNode {

    public static void main(String[] args) {
        Node node = Node.of(1,2,3,4,5,6,7);
        Assertions.assertExpect(node, node);
    }

    @Test
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        // 作为各层的分隔符
        queue.offer(new Node(Integer.MAX_VALUE));
        Node prev = null;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (Integer.MAX_VALUE == node.val) {
                if (!queue.isEmpty()) {
                    queue.offer(node);
                }
                prev = null;
                continue;
            }
            if (prev != null) {
                prev.next = node;
            }
            prev = node;
            // 有左子树就一定有右子树
            if (node.left != null) {
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return root;
    }
}
