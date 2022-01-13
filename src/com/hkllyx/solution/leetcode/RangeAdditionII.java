package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;

/**
 * <p>You are given an <code>m x n</code> matrix <code>M</code> initialized with all <code>0</code>&#39;s and an array of operations <code>ops</code>, where <code>ops[i] = [a<sub>i</sub>, b<sub>i</sub>]</code> means <code>M[x][y]</code> should be incremented by one for all <code>0 &lt;= x &lt; a<sub>i</sub></code> and <code>0 &lt;= y &lt; b<sub>i</sub></code>.</p>
 *
 * <p>Count and return <em>the number of maximum integers in the matrix after performing all the operations</em>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/10/02/ex1.jpg" style="width: 750px; height: 176px;" />
 * <pre>
 * <strong>Input:</strong> m = 3, n = 3, ops = [[2,2],[3,3]]
 * <strong>Output:</strong> 4
 * <strong>Explanation:</strong> The maximum integer in M is 2, and there are four of it in M. So return 4.
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> m = 3, n = 3, ops = [[2,2],[3,3],[3,3],[3,3],[2,2],[3,3],[3,3],[3,3],[2,2],[3,3],[3,3],[3,3]]
 * <strong>Output:</strong> 4
 * </pre>
 *
 * <p><strong>Example 3:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> m = 3, n = 3, ops = []
 * <strong>Output:</strong> 9
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= m, n &lt;= 4 * 10<sup>4</sup></code></li>
 * 	<li><code>0 &lt;= ops.length &lt;= 10<sup>4</sup></code></li>
 * 	<li><code>ops[i].length == 2</code></li>
 * 	<li><code>1 &lt;= a<sub>i</sub> &lt;= m</code></li>
 * 	<li><code>1 &lt;= b<sub>i</sub> &lt;= n</code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>数组</li><li>数学</li></div></div><br><div><li>👍 150</li><li>👎 0</li></div>
 *
 * @author hkllyx
 * @date 2021-11-07
 */
@Solution(no = "598", title = "Range Addition II", difficulty = Difficulty.EASY, url = "https://leetcode-cn.com/problems/range-addition-ii/")
public class RangeAdditionII {

    public int maxCount(int m, int n, int[][] ops) {
        int m1 = m, n1 = n;
        for (int[] op : ops) {
            m1 = Math.min(op[0], m1);
            n1 = Math.min(op[1], n1);
        }
        return m1 * n1;
    }
}
