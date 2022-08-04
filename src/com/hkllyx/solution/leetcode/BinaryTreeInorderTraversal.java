package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.struct.TreeNode;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>Given the <code>root</code> of a binary tree, return <em>the inorder traversal of its nodes' values</em>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/09/15/inorder_1.jpg" style="width: 125px; height: 200px;" />
 * <pre>
 * <strong>Input:</strong> root = [1,null,2,3]
 * <strong>Output:</strong> [1,3,2]
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> root = []
 * <strong>Output:</strong> []
 * </pre>
 *
 * <p><strong>Example 3:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> root = [1]
 * <strong>Output:</strong> [1]
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 *  <li>The number of nodes in the tree is in the range <code>[0, 100]</code>.</li>
 *  <li><code>-100 &lt;= Node.val &lt;= 100</code></li>
 * </ul>
 *
 * <p>&nbsp;</p>
 * <strong>Follow up:</strong> Recursive solution is trivial, could you do it iteratively?
 *
 * <div><div>Related Topics</div><div><li>栈</li><li>树</li><li>深度优先搜索</li><li>二叉树</li></div></div><br><div><li>👍 1519</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2022/08/04
 */
@Solution(no = "94", title = "Binary Tree Inorder Traversal", difficulty = Difficulty.EASY, url = "https://leetcode-cn.com/problems/binary-tree-inorder-traversal/")
public class BinaryTreeInorderTraversal {

    public static void main(String[] args) {
        Assertions.assertExpect("[1, 3, 2]", TreeNode.of(1,null,2,3));
        Assertions.assertExpect("[4, 2, 5, 1, 6, 3, 7]", TreeNode.of(1,2,3,4,5,6,7));
    }

    @Test(active = false)
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.peek();
            if (cur.left != null) {
                stack.push(cur.left);
                cur.left = null;
            } else {
                res.add(cur.val);
                stack.pop();
                if (cur.right != null) {
                    stack.push(cur.right);
                }
            }
        }
        return res;
    }

    @Test
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }

    private void dfs(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        dfs(root.left, res);
        res.add(root.val);
        dfs(root.right, res);
    }
}
