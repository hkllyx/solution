package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.struct.TreeNode;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * <p>给定一棵二叉搜索树，请找出其中第 <code>k</code> 大的节点的值。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1:</strong></p>
 *
 * <pre>
 * <strong>输入:</strong> root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 * &nbsp;  2
 * <strong>输出:</strong> 4</pre>
 *
 * <p><strong>示例 2:</strong></p>
 *
 * <pre>
 * <strong>输入:</strong> root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * <strong>输出:</strong> 4</pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>限制：</strong></p>
 *
 * <ul>
 * 	<li>1 ≤ k ≤ 二叉搜索树元素个数</li>
 * </ul>
 * <div><div>Related Topics</div><div><li>树</li><li>深度优先搜索</li><li>二叉搜索树</li><li>二叉树</li></div></div><br><div><li>👍 229</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2022/01/06
 */
@Solution(no = "剑指 Offer 54", difficulty = Difficulty.EASY, url = "https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/")
public class 二叉搜索树的第k大节点 {

    public static void main(String[] args) {
        Assertions.assertExpect(4, TreeNode.of("[5,3,6,2,4,null,null,1]"), 3);
        Assertions.assertExpect(4, TreeNode.of("[3,1,4,null,2]"), 1);
    }

    @Test
    public int kthLargest(TreeNode root, int k) {
        int res = 0;
        Deque<TreeNode> stack = new LinkedList<>();
        Set<TreeNode> removed = new HashSet<>();
        stack.add(root);
        while (k > 0) {
            TreeNode cur = stack.getLast();
            if (cur.right != null && !removed.contains(cur.right)) {
                stack.add(cur.right);
            } else {
                k--;
                res = stack.removeLast().val;
                removed.add(cur);
                if (cur.left != null) {
                    stack.add(cur.left);
                }
            }
        }
        return res;
    }
}
