package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.struct.TreeNode;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p>例如:<br>
 * 给定二叉树:&nbsp;<code>[3,9,20,null,null,15,7]</code>,</p>
 *
 * <pre>    3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * </pre>
 *
 * <p>返回其层次遍历结果：</p>
 *
 * <pre>[
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ol>
 * 	<li><code>节点总数 &lt;= 1000</code></li>
 * </ol>
 * <div><div>Related Topics</div><div><li>树</li><li>广度优先搜索</li><li>二叉树</li></div></div><br><div><li>👍 165</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2021/06/10
 */
@Solution(no = "剑指 Offer 32-III", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/")
public class 从上到下打印二叉树III {

    public static void main(String[] args) {
        Assertions.assertExpect(从上到下打印二叉树III.class,
                Arrays.asList(Arrays.asList(1), Arrays.asList(3, 2), Arrays.asList(4, 5)),
                TreeNode.of(1, 2, 3, 4, null, null, 5));
        Assertions.assertExpect(从上到下打印二叉树III.class,
                Arrays.asList(Arrays.asList(3), Arrays.asList(20, 9), Arrays.asList(15, 7)),
                TreeNode.of(3, 9, 20, null, null, 15, 7));
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        List<TreeNode> list = new LinkedList<>();
        list.add(root);
        boolean reverse = false;
        while (!list.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = list.get(i), child;
                if ((child = cur.left) != null) {
                    list.add(child);
                }
                if ((child = cur.right) != null) {
                    list.add(child);
                }
            }
            for (int i = size - 1; i >= 0; i--) {
                level.add(list.remove(reverse ? i : 0).val);
            }
            res.add(level);
            reverse = !reverse;
        }
        return res;
    }

    @Test
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        List<TreeNode> list = new LinkedList<>();
        list.add(root);
        boolean reverse = false;
        while (!list.isEmpty()) {
            List<Integer> level = new LinkedList<>();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = list.remove(0), child;
                if (reverse) {
                    level.add(0, cur.val);
                } else {
                    level.add(cur.val);
                }
                if ((child = cur.left) != null) {
                    list.add(child);
                }
                if ((child = cur.right) != null) {
                    list.add(child);
                }
            }
            res.add(level);
            reverse = !reverse;
        }
        return res;
    }
}
