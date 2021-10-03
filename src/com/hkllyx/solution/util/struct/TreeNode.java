package com.hkllyx.solution.util.struct;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.StringJoiner;

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

    public static TreeNode of(Integer... vals) {
        int size;
        if (vals == null || (size = vals.length) <= 0) {
            return null;
        }
        TreeNode root = new TreeNode(vals[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (i < size) {
            TreeNode parent = queue.remove();
            Integer val;
            if ((val = vals[i++]) != null) {
                TreeNode child = new TreeNode(val);
                queue.add(child);
                parent.left = child;
            }
            if (i < size && (val = vals[i++]) != null) {
                TreeNode child = new TreeNode(val);
                queue.add(child);
                parent.right = child;
            }
        }
        return root;
    }

    public int height() {
        return height(this);
    }

    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(height(node.left), height(node.right)) + 1;
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
        StringJoiner sj = new StringJoiner(", ", "[", "]");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(this);
        // 当前层非null节点的数量
        int count = 1;
        while (count > 0) {
            int nextCount = 0;
            while (count > 0) {
                TreeNode node = queue.remove();
                if (node == null) {
                    sj.add(null);
                } else {
                    count--;
                    sj.add(String.valueOf(node.val));
                    TreeNode child;
                    if ((child = node.left) != null) {
                        count++;
                    }
                    queue.offer(child);
                    if ((child = node.right) != null) {
                        nextCount++;
                    }
                    queue.offer(child);
                }
            }
            count = nextCount;
        }
        return sj.toString();
    }
}
