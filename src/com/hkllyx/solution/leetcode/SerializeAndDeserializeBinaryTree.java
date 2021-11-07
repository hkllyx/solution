package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.struct.TreeNode;
import com.hkllyx.solution.util.test.Assertions;

import java.util.LinkedList;
import java.util.Queue;
import java.util.StringJoiner;

/**
 * @author hkllyx
 * @date 2021-11-07
 */
@Solution(no = "297", difficulty = Difficulty.HARD, url = "https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/")
public class SerializeAndDeserializeBinaryTree {

    public static void main(String[] args) {
        SerializeAndDeserializeBinaryTree obj = new SerializeAndDeserializeBinaryTree();
        Assertions.assertEquals("[]", obj.serialize(obj.deserialize("[]")));
        Assertions.assertEquals("[1,2,3,null,null,4,5]", obj.serialize(obj.deserialize("[1,2,3,null,null,4,5]")));
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringJoiner sj = new StringJoiner(",", "[", "]");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        // 当前层非null节点的数量
        for (int count = root == null ? 0 : 1, nextCount = 0; count > 0; ) {
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

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() <= 2) {
            return null;
        }
        Integer[] arrData = toIntegerArray(data);
        TreeNode root = new TreeNode(arrData[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        for (int i = 1, size = arrData.length; i < size; ) {
            TreeNode parent = queue.remove();
            Integer val;
            if ((val = arrData[i++]) != null) {
                TreeNode child = new TreeNode(val);
                queue.add(child);
                parent.left = child;
            }
            if (i < size && (val = arrData[i++]) != null) {
                TreeNode child = new TreeNode(val);
                queue.add(child);
                parent.right = child;
            }
        }
        return root;
    }

    private Integer[] toIntegerArray(String data) {
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

    private Integer toInteger(String data, int beginIndex, int endIndex) {
        int num = 0;
        boolean positive = true;
        while (beginIndex <= endIndex) {
            char c = data.charAt(beginIndex++);
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
}
