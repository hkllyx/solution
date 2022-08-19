package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.info.Status;
import com.hkllyx.solution.util.struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Given an integer <code>n</code>, return <em>all the structurally unique <strong>BST'</strong>s (binary search trees), which has exactly </em><code>n</code><em> nodes of unique values from</em> <code>1</code> <em>to</em> <code>n</code>. Return the answer in <strong>any order</strong>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/01/18/uniquebstn3.jpg" style="width: 600px; height: 148px;" />
 * <pre>
 * <strong>Input:</strong> n = 3
 * <strong>Output:</strong> [[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> n = 1
 * <strong>Output:</strong> [[1]]
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 *  <li><code>1 &lt;= n &lt;= 8</code></li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>树</li><li>二叉搜索树</li><li>动态规划</li><li>回溯</li><li>二叉树</li></div></div><br><div><li>👍 1275</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2022/08/16
 */
@Solution(no = "95", title = "Unique Binary Search Trees II", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/unique-binary-search-trees-ii/", status = Status.FAILED)
public class UniqueBinarySearchTreesII {

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> res = new ArrayList<>();
        boolean[] trace = new boolean[n];
        dfs(res, trace, null, null, 0, -1);
        return res;
    }

    private void dfs(List<TreeNode> res, boolean[] trace, TreeNode root, TreeNode cur, int level, int max) {
        if (level > trace.length) {
            res.add(clone(root));
            return;
        }
        // for (int i = 0; i < trace.length; i++) {
        //     if (!trace[i]) {
        //         TreeNode node = new TreeNode(i + 1);
        //         trace[i] = true;
        //         if (root == null) {
        //             dfs(res, trace, node, node, level + 1, node.val);
        //         } else if (cur.val < node.val) {
        //             cur.right = node;
        //             dfs(res, trace, root, node, level + 1);
        //         }
        //     }
        // }
    }

    private TreeNode clone(TreeNode src) {
        if (src == null) {
            return null;
        }
        TreeNode res = new TreeNode(src.val);
        res.left = clone(src.left);
        res.right = clone(src.right);
        return res;
    }
}
