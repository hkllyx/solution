package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author xiaoyong3
 * @date 2021/11/06
 */
@Solution(no = "剑指 Offer 36", title = "二叉搜索树与双向链表", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/")
public class 二叉搜索树与双向链表 {

    public static void main(String[] args) {
        Assertions.assertExpect(true, Node.of(4, 2, 5, 1, 3));
    }

    @Test
    public Node treeToDoublyList(Node root) {
        return dfs(root);
    }

    private Node dfs(Node node) {
        if (node == null) {
            return null;
        }
        Node leftHead = dfs(node.left);
        Node rightHead = dfs(node.right);
        node.left = node;
        node.right = node;
        // 接上左侧链表
        node = concat(leftHead, node);
        // 接上右侧链表
        return concat(node, rightHead);
    }

    private Node concat(Node leftHead, Node rightHead) {
        if (leftHead == null) {
            return rightHead;
        }
        if (rightHead == null) {
            return leftHead;
        }
        Node leftTail = leftHead.left;
        Node rightTail = rightHead.left;
        leftTail.right = rightHead;
        rightHead.left = leftTail;
        leftHead.left = rightTail;
        rightTail.right = leftHead;
        return leftHead;
    }

    private static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }

        public static Node of(Integer... vals) {
            int size;
            if (vals == null || (size = vals.length) <= 0) {
                return null;
            }
            Node root = new Node(vals[0]);
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            int i = 1;
            while (i < size) {
                Node parent = queue.remove();
                Integer val;
                if ((val = vals[i++]) != null) {
                    Node child = new Node(val);
                    queue.add(child);
                    parent.left = child;
                }
                if (i < size && (val = vals[i++]) != null) {
                    Node child = new Node(val);
                    queue.add(child);
                    parent.right = child;
                }
            }
            return root;
        }

        @Override
        public String toString() {
            return getClass().getSimpleName() + val;
        }
    }
}
