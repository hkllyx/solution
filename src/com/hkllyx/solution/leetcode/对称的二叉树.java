package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;

/**
 * <p>请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。</p>
 *
 * <p>例如，二叉树&nbsp;[1,2,2,3,4,4,3] 是对称的。</p>
 *
 * <p><code>&nbsp; &nbsp; 1<br>
 * &nbsp; &nbsp;/ \<br>
 * &nbsp; 2 &nbsp; 2<br>
 * &nbsp;/ \ / \<br>
 * 3 &nbsp;4 4 &nbsp;3</code><br>
 * 但是下面这个&nbsp;[1,2,2,null,3,null,3] 则不是镜像对称的:</p>
 *
 * <p><code>&nbsp; &nbsp; 1<br>
 * &nbsp; &nbsp;/ \<br>
 * &nbsp; 2 &nbsp; 2<br>
 * &nbsp; &nbsp;\ &nbsp; \<br>
 * &nbsp; &nbsp;3 &nbsp; &nbsp;3</code></p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre><strong>输入：</strong>root = [1,2,2,3,4,4,3]
 * <strong>输出：</strong>true
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre><strong>输入：</strong>root = [1,2,2,null,3,null,3]
 * <strong>输出：</strong>false</pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>限制：</strong></p>
 *
 * <p><code>0 &lt;= 节点个数 &lt;= 1000</code></p>
 *
 * <p>注意：本题与主站 101 题相同：<a href="https://leetcode-cn.com/problems/symmetric-tree/">https://leetcode-cn.com/problems/symmetric-tree/</a></p>
 * <div><div>Related Topics</div><div><li>树</li><li>深度优先搜索</li><li>广度优先搜索</li><li>二叉树</li></div></div><br><div><li>👍 268</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2021/06/05
 */
@Solution(no = "剑指 Offer 28", difficulty = Difficulty.SIMPLE, url = "https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof/")
public class 对称的二叉树 extends SymmetricTree {
}
