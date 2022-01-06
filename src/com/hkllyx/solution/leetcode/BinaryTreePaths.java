package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.struct.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * <p>Given the <code>root</code> of a binary tree, return <em>all root-to-leaf paths in <strong>any order</strong></em>.</p>
 *
 * <p>A <strong>leaf</strong> is a node with no children.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/03/12/paths-tree.jpg" style="width: 207px; height: 293px;" />
 * <pre>
 * <strong>Input:</strong> root = [1,2,3,null,5]
 * <strong>Output:</strong> [&quot;1-&gt;2-&gt;5&quot;,&quot;1-&gt;3&quot;]
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> root = [1]
 * <strong>Output:</strong> [&quot;1&quot;]
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li>The number of nodes in the tree is in the range <code>[1, 100]</code>.</li>
 * 	<li><code>-100 &lt;= Node.val &lt;= 100</code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>树</li><li>深度优先搜索</li><li>字符串</li><li>二叉树</li></div></div><br><div><li>👍 630</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2021/09/29
 */
@Solution(no = "257", difficulty = Difficulty.EASY, url = "https://leetcode-cn.com/problems/binary-tree-paths/")
public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new LinkedList<>();
        pathSum(root, new StringBuilder(), paths);
        return paths;
    }

    private void pathSum(TreeNode root, StringBuilder trace, List<String> paths) {
        if (root == null) {
            return;
        }
        int size = trace.length();
        if (size != 0) {
            trace.append("->");
        }
        trace.append(root.val);
        if (root.left == null && root.right == null) {
            paths.add(trace.toString());
        }
        pathSum(root.left, trace, paths);
        pathSum(root.right, trace, paths);
        trace.delete(size, trace.length());
    }
}
