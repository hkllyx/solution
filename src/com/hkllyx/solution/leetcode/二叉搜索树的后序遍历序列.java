package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

/**
 * <p>输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回&nbsp;<code>true</code>，否则返回&nbsp;<code>false</code>。假设输入的数组的任意两个数字都互不相同。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p>参考以下这颗二叉搜索树：</p>
 *
 * <pre>     5
 *     / \
 *    2   6
 *   / \
 *  1   3</pre>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre><strong>输入: </strong>[1,6,3,2,5]
 * <strong>输出: </strong>false</pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre><strong>输入: </strong>[1,3,2,6,5]
 * <strong>输出: </strong>true</pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ol>
 * 	<li><code>数组长度 &lt;= 1000</code></li>
 * </ol>
 * <div><div>Related Topics</div><div><li>栈</li><li>树</li><li>二叉搜索树</li><li>递归</li><li>二叉树</li><li>单调栈</li></div></div><br><div><li>👍 397</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2021/06/10
 */
@Solution(no = "剑指 Offer 33", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/")
public class 二叉搜索树的后序遍历序列 {

    public static void main(String[] args) {
        Assertions.assertExpect(二叉搜索树的后序遍历序列.class, false, (Object) new int[]{1, 6, 3, 2, 5});
        Assertions.assertExpect(二叉搜索树的后序遍历序列.class, true, (Object) new int[]{1, 3, 2, 6, 5});
    }

    @Test
    public boolean verifyPostorder(int[] postorder) {
        return verifyPostorder(postorder, 0, postorder.length - 1);
    }

    private boolean verifyPostorder(int[] postorder, int l, int r) {
        if (r - l < 2) {
            return true;
        }
        // 顶点，二叉树 < 顶点的在左侧，> 顶点的在右侧
        int v = postorder[r];
        int lr = 0;
        for (int i = l; i <= r; i++) {
            if (postorder[i] >= v) {
                lr = i - 1;
                break;
            }
        }
        int rl = lr + 1;
        for (int i = rl; i <= r; i++) {
            if (postorder[i] < v) {
                return false;
            }
        }
        return verifyPostorder(postorder, l, lr) && verifyPostorder(postorder, rl, r - 1);
    }
}
