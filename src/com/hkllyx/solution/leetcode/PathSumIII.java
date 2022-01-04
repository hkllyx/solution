package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.struct.TreeNode;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * <p>Given the <code>root</code> of a binary tree and an integer <code>targetSum</code>, return <em>the number of paths where the sum of the values&nbsp;along the path equals</em>&nbsp;<code>targetSum</code>.</p>
 *
 * <p>The path does not need to start or end at the root or a leaf, but it must go downwards (i.e., traveling only from parent nodes to child nodes).</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/04/09/pathsum3-1-tree.jpg" style="width: 450px; height: 386px;" />
 * <pre>
 * <strong>Input:</strong> root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
 * <strong>Output:</strong> 3
 * <strong>Explanation:</strong> The paths that sum to 8 are shown.
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * <strong>Output:</strong> 3
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li>The number of nodes in the tree is in the range <code>[0, 1000]</code>.</li>
 * 	<li><code>-10<sup>9</sup> &lt;= Node.val &lt;= 10<sup>9</sup></code></li>
 * 	<li><code>-1000 &lt;= targetSum &lt;= 1000</code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>树</li><li>深度优先搜索</li><li>二叉树</li></div></div><br><div><li>👍 1184</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2021/09/29
 */
@Solution(no = "437", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/path-sum-iii/")
public class PathSumIII {

    public static void main(String[] args) {
        Assertions.assertExpect(2, TreeNode.of(1, null, 2, null, 3, null, 4, null, 5), 3);
    }

    @Test(active = false)
    public int pathSum(TreeNode root, int targetSum) {
        int num = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        while (root != null) {
            num += dfs(root, targetSum);
            if (root.left != null) {
                queue.add(root.left);
            }
            if (root.right != null) {
                queue.add(root.right);
            }
            root = queue.poll();
        }
        return num;
    }

    private int dfs(TreeNode root, int remain) {
        return root == null ? 0
                : ((remain -= root.val) == 0 ? 1 : 0)
                + dfs(root.left, remain)
                + dfs(root.right, remain);
    }

    /**
     * 前缀和：由根结点到当前结点的路径上所有节点的和
     */
    @Test
    public int pathSum1(TreeNode root, int targetSum) {
        // key是前缀和, value是大小为key的前缀和出现的次数
        Map<Integer, Integer> prefixSum2Count = new HashMap<>();
        // 前缀和为0的初始为1条，结点val == targetSum有用
        prefixSum2Count.put(0, 1);
        return dfsPrefix(root, targetSum, 0, prefixSum2Count);
    }

    private int dfsPrefix(TreeNode root, int targetSum, int sum, Map<Integer, Integer> prefixSum2Count) {
        int num = 0;
        if (root == null) {
            return num;
        }
        sum += root.val;
        // 当前结点的前缀和 - 前面结点前缀和 = targetSum，就是当前结点到前面结点距离为targetSum
        num += prefixSum2Count.getOrDefault(sum - targetSum, 0);
        prefixSum2Count.put(sum, prefixSum2Count.getOrDefault(sum, 0) + 1);
        num += dfsPrefix(root.left, targetSum, sum, prefixSum2Count);
        num += dfsPrefix(root.right, targetSum, sum, prefixSum2Count);
        // 回溯，遍历兄弟结点
        prefixSum2Count.put(sum, prefixSum2Count.get(sum) - 1);
        return num;
    }
}
