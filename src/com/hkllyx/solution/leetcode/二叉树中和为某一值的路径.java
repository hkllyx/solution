package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;

/**
 * <p>给你二叉树的根节点 <code>root</code> 和一个整数目标和 <code>targetSum</code> ，找出所有 <strong>从根节点到叶子节点</strong> 路径总和等于给定目标和的路径。</p>
 *
 * <p><strong>叶子节点</strong> 是指没有子节点的节点。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <p><img alt="" src="https://assets.leetcode.com/uploads/2021/01/18/pathsumii1.jpg" /></p>
 *
 * <pre>
 * <strong>输入：</strong>root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * <strong>输出：</strong>[[5,4,11,2],[5,8,4,5]]
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <p><img alt="" src="https://assets.leetcode.com/uploads/2021/01/18/pathsum2.jpg" /></p>
 *
 * <pre>
 * <strong>输入：</strong>root = [1,2,3], targetSum = 5
 * <strong>输出：</strong>[]
 * </pre>
 *
 * <p><strong>示例 3：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>root = [1,2], targetSum = 0
 * <strong>输出：</strong>[]
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * 	<li>树中节点总数在范围 <code>[0, 5000]</code> 内</li>
 * 	<li><code>-1000 &lt;= Node.val &lt;= 1000</code></li>
 * 	<li><code>-1000 &lt;= targetSum &lt;= 1000</code></li>
 * </ul>
 *
 * <p>注意：本题与主站 113&nbsp;题相同：<a href="https://leetcode-cn.com/problems/path-sum-ii/">https://leetcode-cn.com/problems/path-sum-ii/</a></p>
 * <div><div>Related Topics</div><div><li>树</li><li>深度优先搜索</li><li>回溯</li><li>二叉树</li></div></div><br><div><li>👍 272</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2021/11/06
 */
@Solution(no = "剑指 Offer 34", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/")
public class 二叉树中和为某一值的路径 extends PathSumII {
}
