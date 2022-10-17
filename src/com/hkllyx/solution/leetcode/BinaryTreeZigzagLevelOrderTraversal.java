package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.struct.TreeNode;

import java.util.*;

/**
 * <p>Given the <code>root</code> of a binary tree, return <em>the zigzag level order traversal of its nodes' values</em>. (i.e., from left to right, then right to left for the next level and alternate between).</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/02/19/tree1.jpg" style="width: 277px; height: 302px;" />
 * <pre>
 * <strong>Input:</strong> root = [3,9,20,null,null,15,7]
 * <strong>Output:</strong> [[3],[20,9],[15,7]]
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> root = [1]
 * <strong>Output:</strong> [[1]]
 * </pre>
 *
 * <p><strong class="example">Example 3:</strong></p>
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
 *  <li>The number of nodes in the tree is in the range <code>[0, 2000]</code>.</li>
 *  <li><code>-100 &lt;= Node.val &lt;= 100</code></li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>树</li><li>广度优先搜索</li><li>二叉树</li></div></div><br><div><li>👍 704</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2022/10/11
 */
@Solution(no = "103", title = "Binary Tree Zigzag Level Order Traversal", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/")
public class BinaryTreeZigzagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> positive = new LinkedList<>(), reverse = new LinkedList<>();
        positive.offer(root);
        while (!positive.isEmpty() || !reverse.isEmpty()) {
            List<Integer> list;
            if (!positive.isEmpty()) {
                list = new ArrayList<>(positive.size());
                while (!positive.isEmpty()) {
                    TreeNode node = positive.poll();
                    list.add(node.val);
                    if (node.left != null) {
                        reverse.push(node.left);
                    }
                    if (node.right != null) {
                        reverse.push(node.right);
                    }
                }
            } else {
                list = new ArrayList<>(reverse.size());
                while (!reverse.isEmpty()) {
                    TreeNode node = reverse.pop();
                    list.add(node.val);
                    if (node.right != null) {
                        positive.push(node.right);
                    }
                    if (node.left != null) {
                        positive.push(node.left);
                    }
                }
            }
            res.add(list);
        }
        return res;
    }
}
