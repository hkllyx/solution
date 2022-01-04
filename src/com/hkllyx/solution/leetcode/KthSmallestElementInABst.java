package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.struct.TreeNode;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

import java.util.Stack;

/**
 * <p>Given the <code>root</code> of a binary search tree, and an integer <code>k</code>, return <em>the</em> <code>k<sup>th</sup></code> <em>smallest value (<strong>1-indexed</strong>) of all the values of the nodes in the tree</em>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/01/28/kthtree1.jpg" style="width: 212px; height: 301px;" />
 * <pre>
 * <strong>Input:</strong> root = [3,1,4,null,2], k = 1
 * <strong>Output:</strong> 1
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/01/28/kthtree2.jpg" style="width: 382px; height: 302px;" />
 * <pre>
 * <strong>Input:</strong> root = [5,3,6,2,4,null,null,1], k = 3
 * <strong>Output:</strong> 3
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li>The number of nodes in the tree is <code>n</code>.</li>
 * 	<li><code>1 &lt;= k &lt;= n &lt;= 10<sup>4</sup></code></li>
 * 	<li><code>0 &lt;= Node.val &lt;= 10<sup>4</sup></code></li>
 * </ul>
 *
 * <p>&nbsp;</p>
 * <p><strong>Follow up:</strong> If the BST is modified often (i.e., we can do insert and delete operations) and you need to find the kth smallest frequently, how would you optimize?</p>
 * <div><div>Related Topics</div><div><li>树</li><li>深度优先搜索</li><li>二叉搜索树</li><li>二叉树</li></div></div><br><div><li>👍 549</li><li>👎 0</li></div>
 *
 * @author hkllyx
 * @date 2021-10-17
 */
@Solution(no = "230", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/")
public class KthSmallestElementInABst {

    public static void main(String[] args) {
        Assertions.assertExpect(3, TreeNode.of(5, 3, 6, 2, 4, null, null, 1), 3);
        Assertions.assertExpect(1, TreeNode.of(3, 1, 4, null, 2), 1);
    }

    @Test(value = "最小堆", active = false, mills = 6)
    public int kthSmallest(TreeNode root, int k) {
        int res = -1;
        for (int i = 0; i < k; i++) {
            buildMinHeap(root);
            res = root.val;
            root.val = Integer.MAX_VALUE;
        }
        return res;
    }

    @Test("中序")
    public int kthSmallest1(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (--k == 0) {
                return root.val;
            }
            root = root.right;
        }
        return -1;
    }

    private TreeNode buildMinHeap(TreeNode root) {
        if (root != null) {
            change(root, buildMinHeap(root.left));
            change(root, buildMinHeap(root.right));
        }
        return root;
    }

    private void change(TreeNode root, TreeNode child) {
        if (child != null && child.val < root.val) {
            int tmp = child.val;
            child.val = root.val;
            root.val = tmp;
        }
    }
}
