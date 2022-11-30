package com.hkllyx.solution.util.struct;

import java.util.LinkedList;
import java.util.Queue;
import java.util.StringJoiner;

/**
 * @author xiaoyong3
 * @date 2022/10/21
 */
public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node left, Node right, Node next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }

    public static Node of(Integer... data) {
        int size;
        if (data == null || (size = data.length) <= 0) {
            return null;
        }
        Node root = new Node(data[0]);
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        for (int i = 1; i < size; ) {
            Node parent = queue.remove();
            Integer val;
            if ((val = data[i++]) != null) {
                Node child = new Node(val);
                queue.add(child);
                parent.left = child;
            }
            if (i < size && (val = data[i++]) != null) {
                Node child = new Node(val);
                queue.add(child);
                parent.right = child;
            }
        }
        return root;
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(",", "[", "]");
        Node levelHead = this, node = this;
        while (node != null) {
            sj.add(Integer.toString(node.val));
            node = node.next;
            if (node == null) {
                sj.add("#");
                node = levelHead = levelHead.left;
            }
        }
        return sj.toString();
    }
}
