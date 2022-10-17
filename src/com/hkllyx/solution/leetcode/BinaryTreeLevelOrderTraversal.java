package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.struct.TreeNode;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

import java.util.*;

/**
 * <p>Given the <code>root</code> of a binary tree, return <em>the level order traversal of its nodes&#39; values</em>. (i.e., from left to right, level by level).</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/02/19/tree1.jpg" style="width: 277px; height: 302px;" />
 * <pre>
 * <strong>Input:</strong> root = [3,9,20,null,null,15,7]
 * <strong>Output:</strong> [[3],[9,20],[15,7]]
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> root = [1]
 * <strong>Output:</strong> [[1]]
 * </pre>
 *
 * <p><strong>Example 3:</strong></p>
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
 * 	<li>The number of nodes in the tree is in the range <code>[0, 2000]</code>.</li>
 * 	<li><code>-1000 &lt;= Node.val &lt;= 1000</code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>树</li><li>广度优先搜索</li><li>二叉树</li></div></div><br><div><li>👍 1141</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2021/06/08
 */
@Solution(no = "102", title = "Binary Tree Level Order Traversal", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/binary-tree-level-order-traversal/")
public class BinaryTreeLevelOrderTraversal {

    public static void main(String[] args) {
        Assertions.assertExpect(BinaryTreeLevelOrderTraversal.class,
                Arrays.asList(Arrays.asList(3), Arrays.asList(9, 20), Arrays.asList(15, 7)),
                TreeNode.of(3, 9, 20, null, null, 15, 7));
    }

    @Test
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>(size);
            for (int i = 1; i <= size; i++) {
                TreeNode cur = queue.remove();
                level.add(cur.val);
                TreeNode child;
                if ((child = cur.left) != null) {
                    queue.add(child);
                }
                if ((child = cur.right) != null) {
                    queue.add(child);
                }
            }
            res.add(level);
        }
        return res;
    }
}
