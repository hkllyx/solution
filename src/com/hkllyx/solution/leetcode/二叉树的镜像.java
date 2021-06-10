package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.info.Difficulty;
import com.hkllyx.solution.info.Solution;
import com.hkllyx.solution.struct.TreeNode;

/**
 * @author xiaoyong3
 * @date 2021/06/05
 */
@Solution(no = "剑指 Offer 27", difficulty = Difficulty.SIMPLE, url = "https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/submissions/")
public class 二叉树的镜像 extends InvertBinaryTree {

    public TreeNode mirrorTree(TreeNode root) {
        return super.invertTree(root);
    }
}
