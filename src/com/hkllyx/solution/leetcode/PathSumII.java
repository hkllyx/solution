package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.struct.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * <p>Given the <code>root</code> of a binary tree and an integer <code>targetSum</code>, return <em>all <strong>root-to-leaf</strong> paths where the sum of the node values in the path equals </em><code>targetSum</code><em>. Each path should be returned as a list of the node <strong>values</strong>, not node references</em>.</p>
 *
 * <p>A <strong>root-to-leaf</strong> path is a path starting from the root and ending at any leaf node. A <strong>leaf</strong> is a node with no children.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/01/18/pathsumii1.jpg" style="width: 500px; height: 356px;" />
 * <pre>
 * <strong>Input:</strong> root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * <strong>Output:</strong> [[5,4,11,2],[5,8,4,5]]
 * <strong>Explanation:</strong> There are two paths whose sum equals targetSum:
 * 5 + 4 + 11 + 2 = 22
 * 5 + 8 + 4 + 5 = 22
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/01/18/pathsum2.jpg" style="width: 212px; height: 181px;" />
 * <pre>
 * <strong>Input:</strong> root = [1,2,3], targetSum = 5
 * <strong>Output:</strong> []
 * </pre>
 *
 * <p><strong>Example 3:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> root = [1,2], targetSum = 0
 * <strong>Output:</strong> []
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li>The number of nodes in the tree is in the range <code>[0, 5000]</code>.</li>
 * 	<li><code>-1000 &lt;= Node.val &lt;= 1000</code></li>
 * 	<li><code>-1000 &lt;= targetSum &lt;= 1000</code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>树</li><li>深度优先搜索</li><li>回溯</li><li>二叉树</li></div></div><br><div><li>👍 646</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2021/09/28
 */
@Solution(no = "113", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/path-sum-ii/")
public class PathSumII {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> paths = new LinkedList<>();
        pathSum(root, targetSum, new LinkedList<>(), paths);
        return paths;
    }

    private void pathSum(TreeNode root, int remain, LinkedList<Integer> trace, List<List<Integer>> paths) {
        if (root == null) {
            return;
        }
        remain -= root.val;
        trace.add(root.val);
        if (root.left == null && root.right == null && remain == 0) {
            paths.add(new LinkedList<>(trace));
        }
        pathSum(root.left, remain, trace, paths);
        pathSum(root.right, remain, trace, paths);
        trace.pollLast();
    }
}
