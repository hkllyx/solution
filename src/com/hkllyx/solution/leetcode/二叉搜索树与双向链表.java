package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <p>输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p>为了让您更好地理解问题，以下面的二叉搜索树为例：</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><img src="https://assets.leetcode.com/uploads/2018/10/12/bstdlloriginalbst.png"></p>
 *
 * <p>&nbsp;</p>
 *
 * <p>我们希望将这个二叉搜索树转化为双向循环链表。链表中的每个节点都有一个前驱和后继指针。对于双向循环链表，第一个节点的前驱是最后一个节点，最后一个节点的后继是第一个节点。</p>
 *
 * <p>下图展示了上面的二叉搜索树转化成的链表。&ldquo;head&rdquo; 表示指向链表中有最小元素的节点。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><img src="https://assets.leetcode.com/uploads/2018/10/12/bstdllreturndll.png"></p>
 *
 * <p>&nbsp;</p>
 *
 * <p>特别地，我们希望可以就地完成转换操作。当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继。还需要返回链表中的第一个节点的指针。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>注意：</strong>本题与主站 426 题相同：<a href="https://leetcode-cn.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/">https://leetcode-cn.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/</a></p>
 *
 * <p><strong>注意：</strong>此题对比原题有改动。</p>
 * <div><div>Related Topics</div><div><li>栈</li><li>树</li><li>深度优先搜索</li><li>二叉搜索树</li><li>链表</li><li>二叉树</li><li>双向链表</li></div></div><br><div><li>👍 367</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2021/11/06
 */
@Solution(no = "剑指 Offer 36", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/")
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
