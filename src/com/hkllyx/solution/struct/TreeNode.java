package com.hkllyx.solution.struct;

import java.util.Objects;

/**
 * @author xiaoyong3
 * @date 2021/05/18
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TreeNode ot = (TreeNode) o;
        if (val != ot.val) {
            return false;
        }
        return Objects.equals(left, ot.left) && Objects.equals(right, ot.right);
    }

    @Override
    public int hashCode() {
        int result = val;
        result = 31 * result + (left != null ? left.hashCode() : 0);
        result = 31 * result + (right != null ? right.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "{" + val + "-[" + (left == null ? '#' : left) + ':' + (right == null ? '#' : right) + "]}";
    }
}
