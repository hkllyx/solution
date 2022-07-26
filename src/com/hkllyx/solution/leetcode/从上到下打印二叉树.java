package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.struct.TreeNode;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

/**
 * <p>从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p>例如:<br>
 * 给定二叉树:&nbsp;<code>[3,9,20,null,null,15,7]</code>,</p>
 *
 * <pre>
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * </pre>
 *
 * <p>返回：</p>
 *
 * <pre>[3,9,20,15,7]
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ol>
 * 	<li><code>节点总数 &lt;= 1000</code></li>
 * </ol>
 * <div><div>Related Topics</div><div><li>树</li><li>广度优先搜索</li><li>二叉树</li></div></div><br><div><li>👍 150</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2021/06/07
 */
@Solution(no = "剑指 Offer 32 - I", title = "从上到下打印二叉树", difficulty = Difficulty.EASY, url = "https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/")
public class 从上到下打印二叉树 {

    public static void main(String[] args) {
        Assertions.assertExpect(new int[]{3, 9, 20, 15, 7}, TreeNode.of(3, 9, 20, null, null, 15, 7));
    }

    @Test
    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        ListTreeNode sentinel = new ListTreeNode(null);
        sentinel.next = new ListTreeNode(root);
        ListTreeNode lp = sentinel.next;
        ListTreeNode rp = sentinel.next;
        int size = 0;
        // rp先走，lp后走，类似Queue
        while (lp != null) {
            size++;
            TreeNode node;
            if ((node = lp.val.left) != null) {
                rp = rp.next = new ListTreeNode(node);
            }
            if ((node = lp.val.right) != null) {
                rp = rp.next = new ListTreeNode(node);
            }
            lp = lp.next;
        }
        int[] res = new int[size];
        int i = 0;
        while ((sentinel = sentinel.next) != null) {
            res[i++] = sentinel.val.val;
        }
        return res;
    }

    public static class ListTreeNode {
        TreeNode val;
        ListTreeNode next;

        public ListTreeNode(TreeNode val) {
            this.val = val;
        }
    }
}
