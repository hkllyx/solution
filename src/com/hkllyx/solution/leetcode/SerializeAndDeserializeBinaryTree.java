package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.struct.TreeNode;
import com.hkllyx.solution.util.test.Assertions;

import java.util.LinkedList;
import java.util.Queue;
import java.util.StringJoiner;

/**
 * <p>Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.</p>
 *
 * <p>Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.</p>
 *
 * <p><strong>Clarification:</strong> The input/output format is the same as <a href="/faq/#binary-tree" target="_blank">how LeetCode serializes a binary tree</a>. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/09/15/serdeser.jpg" style="width: 442px; height: 324px;" />
 * <pre>
 * <strong>Input:</strong> root = [1,2,3,null,null,4,5]
 * <strong>Output:</strong> [1,2,3,null,null,4,5]
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> root = []
 * <strong>Output:</strong> []
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li>The number of nodes in the tree is in the range <code>[0, 10<sup>4</sup>]</code>.</li>
 * 	<li><code>-1000 &lt;= Node.val &lt;= 1000</code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>树</li><li>深度优先搜索</li><li>广度优先搜索</li><li>设计</li><li>字符串</li><li>二叉树</li></div></div><br><div><li>👍 723</li><li>👎 0</li></div>
 *
 * @author hkllyx
 * @date 2021-11-07
 */
@Solution(no = "297", title = "Serialize and Deserialize Binary Tree", difficulty = Difficulty.HARD, url = "https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/")
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
