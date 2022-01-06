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

    public static TreeNode of(Integer... data) {
        int size;
        if (data == null || (size = data.length) <= 0) {
            return null;
        }
        TreeNode root = new TreeNode(data[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        for (int i = 1; i < size; ) {
            TreeNode parent = queue.remove();
            Integer val;
            if ((val = data[i++]) != null) {
                TreeNode child = new TreeNode(val);
                queue.add(child);
                parent.left = child;
            }
            if (i < size && (val = data[i++]) != null) {
                TreeNode child = new TreeNode(val);
                queue.add(child);
                parent.right = child;
            }
        }
        return root;
    }

    public static TreeNode of(String data) {
        if (data == null || data.length() <= 2) {
            return null;
        }
        return of(toIntegerArray(data));
    }

    private static Integer[] toIntegerArray(String data) {
        int len = 1, sizeLen = data.length();
        for (int i = 1; i < sizeLen; i++) {
            if (data.charAt(i) == ',') {
                len++;
            }
        }
        Integer[] array = new Integer[len];
        for (int i = 0, j = 2, k = 0; j < sizeLen; j++) {
            if (data.charAt(j) == ',' || data.charAt(j) == ']') {
                array[k++] = toInteger(data, i + 1, j - 1);
                i = j;
            }
        }
        return array;
    }

    private static Integer toInteger(String data, int begin, int end) {
        int num = 0;
        boolean positive = true;
        while (begin <= end) {
            char c = data.charAt(begin++);
            if (c == 'n') {
                return null;
            } else if (c == '+') {
                positive = true;
            } else if (c == '-') {
                positive = false;
            } else {
                num = num * 10 + c - '0';
            }
        }
        return positive ? num : -num;
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
        StringJoiner sj = new StringJoiner(",", "[", "]");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(this);
        // 当前层非null节点的数量
        for (int count = 1, nextCount = 0; count > 0; ) {
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
            nextCount = 0;
        }
        return sj.toString();
    }
}
