package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.struct.TreeNode;

/**
 * <p>Given the <code>root</code> of a binary tree, flatten the tree into a "linked list":</p>
 *
 * <ul>
 *  <li>The "linked list" should use the same <code>TreeNode</code> class where the <code>right</code> child pointer points to the next node in the list and the <code>left</code> child pointer is always <code>null</code>.</li>
 *  <li>The "linked list" should be in the same order as a <a href="https://en.wikipedia.org/wiki/Tree_traversal#Pre-order,_NLR" target="_blank"><strong>pre-order</strong><strong> traversal</strong></a> of the binary tree.</li>
 * </ul>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/01/14/flaten.jpg" style="width: 500px; height: 226px;" />
 * <pre>
 * <strong>Input:</strong> root = [1,2,5,3,4,null,6]
 * <strong>Output:</strong> [1,null,2,null,3,null,4,null,5,null,6]
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> root = []
 * <strong>Output:</strong> []
 * </pre>
 *
 * <p><strong class="example">Example 3:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> root = [0]
 * <strong>Output:</strong> [0]
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
 * <p>&nbsp;</p>
 * <strong>Follow up:</strong> Can you flatten the tree in-place (with
 * <code>O(1)</code> extra space)?
 *
 * <div><div>Related Topics</div><div><li>栈</li><li>树</li><li>深度优先搜索</li><li>链表</li><li>二叉树</li></div></div><br><div><li>👍 1323</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2022/10/17
 */
@Solution(no = "114", title = "Flatten Binary Tree to Linked List", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/")
public class FlattenBinaryTreeToLinkedList {

    public void flatten(TreeNode root) {
        if (root != null) {
            dfs(root);
        }
    }

    /* dfs返回平铺后的最后一个结点 */
    private TreeNode dfs(TreeNode root) {
        if (root.left != null && root.right != null) {
            // 先平铺root左侧部分
            TreeNode leftLast = dfs(root.left);
            // 左侧最后指向root右结点
            leftLast.right = root.right;
            // root左结点作为新的root右结点
            root.right = root.left;
            // 然后root左结点设为null
            root.left = null;
            // 继续迭代原右侧结点
            return dfs(leftLast.right);
        } else if (root.left != null) {
            // 先平铺root左侧部分
            TreeNode leftLast = dfs(root.left);
            // root左结点作为新的root右结点
            root.right = root.left;
            // 然后root左结点设为null
            root.left = null;
            return leftLast;
        } else if (root.right != null) {
            return dfs(root.right);
        } else {
            return root;
        }
    }
}
