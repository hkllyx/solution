package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.struct.TreeNode;

/**
 * <p>Given an integer array <code>nums</code> where the elements are sorted in <strong>ascending order</strong>, convert <em>it to a <strong>height-balanced</strong> binary search tree</em>.</p>
 *
 * <p>A <strong>height-balanced</strong> binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/02/18/btree1.jpg" style="width: 302px; height: 222px;" />
 * <pre>
 * <strong>Input:</strong> nums = [-10,-3,0,5,9]
 * <strong>Output:</strong> [0,-3,9,-10,null,5]
 * <strong>Explanation:</strong> [0,-10,5,null,-3,null,9] is also accepted:
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/02/18/btree2.jpg" style="width: 302px; height: 222px;" />
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/02/18/btree.jpg" style="width: 342px; height: 142px;" />
 * <pre>
 * <strong>Input:</strong> nums = [1,3]
 * <strong>Output:</strong> [3,1]
 * <strong>Explanation:</strong> [1,null,3] and [3,1] are both height-balanced BSTs.
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 *  <li><code>1 &lt;= nums.length &lt;= 10<sup>4</sup></code></li>
 *  <li><code>-10<sup>4</sup> &lt;= nums[i] &lt;= 10<sup>4</sup></code></li>
 *  <li><code>nums</code> is sorted in a <strong>strictly increasing</strong> order.</li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>树</li><li>二叉搜索树</li><li>数组</li><li>分治</li><li>二叉树</li></div></div><br><div><li>👍 1160</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2022/10/12
 */
@Solution(no = "108", title = "Convert Sorted Array to Binary Search Tree", difficulty = Difficulty.EASY, url = "https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/")
public class ConvertSortedArrayToBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] nums) {
        return partition(nums, 0, nums.length);
    }

    private TreeNode partition(int[] nums, int begin, int end) {
        if (begin >= end) {
            return null;
        }
        // 切中间
        int partition = (begin + end) >> 1;
        TreeNode node = new TreeNode(nums[partition]);
        node.left = partition(nums, begin, partition);
        node.right = partition(nums, partition + 1, end);
        return node;
    }
}
