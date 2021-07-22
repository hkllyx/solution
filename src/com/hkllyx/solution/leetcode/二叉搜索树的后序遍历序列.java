package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.info.Difficulty;
import com.hkllyx.solution.info.Solution;
import com.hkllyx.solution.util.Test;
import com.hkllyx.solution.util.TestUtils;

/**
 * @author xiaoyong3
 * @date 2021/06/10
 */
@Solution(no = "剑指 Offer 33", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/")
public class 二叉搜索树的后序遍历序列 {

    public static void main(String[] args) {
        TestUtils.assertion(二叉搜索树的后序遍历序列.class, false, (Object) new int[]{1, 6, 3, 2, 5});
        TestUtils.assertion(二叉搜索树的后序遍历序列.class, true, (Object) new int[]{1, 3, 2, 6, 5});
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
