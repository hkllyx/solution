package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

/**
 * <p>The set <code>[1, 2, 3, ...,&nbsp;n]</code> contains a total of <code>n!</code> unique permutations.</p>
 *
 * <p>By listing and labeling all of the permutations in order, we get the following sequence for <code>n = 3</code>:</p>
 *
 * <ol>
 * 	<li><code>&quot;123&quot;</code></li>
 * 	<li><code>&quot;132&quot;</code></li>
 * 	<li><code>&quot;213&quot;</code></li>
 * 	<li><code>&quot;231&quot;</code></li>
 * 	<li><code>&quot;312&quot;</code></li>
 * 	<li><code>&quot;321&quot;</code></li>
 * </ol>
 *
 * <p>Given <code>n</code> and <code>k</code>, return the <code>k<sup>th</sup></code> permutation sequence.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 * <pre><strong>Input:</strong> n = 3, k = 3
 * <strong>Output:</strong> "213"
 * </pre><p><strong>Example 2:</strong></p>
 * <pre><strong>Input:</strong> n = 4, k = 9
 * <strong>Output:</strong> "2314"
 * </pre><p><strong>Example 3:</strong></p>
 * <pre><strong>Input:</strong> n = 3, k = 1
 * <strong>Output:</strong> "123"
 * </pre>
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= n &lt;= 9</code></li>
 * 	<li><code>1 &lt;= k &lt;= n!</code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>递归</li><li>数学</li></div></div><br><div><li>👍 651</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2022/04/07
 */
@Solution(no = "60", title = "Permutation Sequence", difficulty = Difficulty.HARD, url = "https://leetcode-cn.com/problems/permutation-sequence/")
public class PermutationSequence {

    public static void main(String[] args) {
        Assertions.assertExpect("21", 2, 2);
        Assertions.assertExpect("132", 3, 2);
        Assertions.assertExpect("231", 3, 4);
        Assertions.assertExpect("123", 3, 7);
    }

    @Test
    public String getPermutation(int n, int k) {
        char[] res = new char[n];
        // 对k减1，方便后续操作
        k--;
        // 备选数字
        char[] candidate = new char[n];
        for (int i = 0; i < n; i++) {
            candidate[i] = (char) ('1' + i);
        }
        // n个不同的数排序，排序方式有n!（阶乘）种
        // 先去除超出最大排序的部分
        k %= factorial(n);
        for (int i = 0; i < n; i++) {
            // 确定第i位数字，即是第几个n - i位数的排序方式树
            int f = factorial(n - i - 1);
            int j = k / f;
            // 找到第j个未使用的数
            int m = 0;
            while (m < n) {
                if (candidate[m] != '.') {
                    j--;
                }
                if (j < 0) {
                    break;
                }
                m++;
            }
            res[i] = candidate[m];
            candidate[m] = '.';
            // 下一步
            k %= f;
        }
        return new String(res);
    }

    private int factorial(int i) {
        int res = 1;
        while (i > 0) {
            res *= i--;
        }
        return res;
    }
}
