package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.struct.TreeNode;

/**
 * <p>请完成一个函数，输入一个二叉树，该函数输出它的镜像。</p>
 *
 * <p>例如输入：</p>
 *
 * <p><code>&nbsp; &nbsp; &nbsp;4<br>
 * &nbsp; &nbsp;/ &nbsp; \<br>
 * &nbsp; 2 &nbsp; &nbsp; 7<br>
 * &nbsp;/ \ &nbsp; / \<br>
 * 1 &nbsp; 3 6 &nbsp; 9</code><br>
 * 镜像输出：</p>
 *
 * <p><code>&nbsp; &nbsp; &nbsp;4<br>
 * &nbsp; &nbsp;/ &nbsp; \<br>
 * &nbsp; 7 &nbsp; &nbsp; 2<br>
 * &nbsp;/ \ &nbsp; / \<br>
 * 9 &nbsp; 6 3&nbsp; &nbsp;1</code></p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre><strong>输入：</strong>root = [4,2,7,1,3,6,9]
 * <strong>输出：</strong>[4,7,2,9,6,3,1]
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>限制：</strong></p>
 *
 * <p><code>0 &lt;= 节点个数 &lt;= 1000</code></p>
 *
 * <p>注意：本题与主站 226 题相同：<a href="https://leetcode-cn.com/problems/invert-binary-tree/">https://leetcode-cn.com/problems/invert-binary-tree/</a></p>
 * <div><div>Related Topics</div><div><li>树</li><li>深度优先搜索</li><li>广度优先搜索</li><li>二叉树</li></div></div><br><div><li>👍 196</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2021/06/05
 */
@Solution(no = "剑指 Offer 27", difficulty = Difficulty.SIMPLE, url = "https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/submissions/")
public class 二叉树的镜像 extends InvertBinaryTree {

    public TreeNode mirrorTree(TreeNode root) {
        return super.invertTree(root);
    }
}
