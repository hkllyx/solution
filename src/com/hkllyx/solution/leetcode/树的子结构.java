package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.struct.TreeNode;

/**
 * @author xiaoyong3
 * @date 2021/06/04
 */
@Solution(no = "剑指Offer 26", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/")
public class 树的子结构 {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        return dfs(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean dfs(TreeNode source, TreeNode target) {
        if (target == null) {
            return true;
        }
        if (source == null || source.val != target.val) {
            return false;
        }
        return dfs(source.left, target.left) && dfs(source.right, target.right);
    }
}
