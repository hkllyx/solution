package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

import java.util.Arrays;

/**
 * <p>You are given a 2D <code>matrix</code> of size <code>m x n</code>, consisting of non-negative integers. You are also given an integer <code>k</code>.</p>
 *
 * <p>The <strong>value</strong> of coordinate <code>(a, b)</code> of the matrix is the XOR of all <code>matrix[i][j]</code> where <code>0 &lt;= i &lt;= a &lt; m</code> and <code>0 &lt;= j &lt;= b &lt; n</code> <strong>(0-indexed)</strong>.</p>
 *
 * <p>Find the <code>k<sup>th</sup></code> largest value <strong>(1-indexed)</strong> of all the coordinates of <code>matrix</code>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> matrix = [[5,2],[1,6]], k = 1
 * <strong>Output:</strong> 7
 * <strong>Explanation:</strong> The value of coordinate (0,1) is 5 XOR 2 = 7, which is the largest value.
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> matrix = [[5,2],[1,6]], k = 2
 * <strong>Output:</strong> 5
 * <strong>Explanation:</strong> The value of coordinate (0,0) is 5 = 5, which is the 2nd largest value.
 * </pre>
 *
 * <p><strong>Example 3:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> matrix = [[5,2],[1,6]], k = 3
 * <strong>Output:</strong> 4
 * <strong>Explanation:</strong> The value of coordinate (1,0) is 5 XOR 1 = 4, which is the 3rd largest value.</pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>m == matrix.length</code></li>
 * 	<li><code>n == matrix[i].length</code></li>
 * 	<li><code>1 &lt;= m, n &lt;= 1000</code></li>
 * 	<li><code>0 &lt;= matrix[i][j] &lt;= 10<sup>6</sup></code></li>
 * 	<li><code>1 &lt;= k &lt;= m * n</code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>位运算</li><li>数组</li><li>分治</li><li>矩阵</li><li>前缀和</li><li>快速选择</li><li>堆（优先队列）</li></div></div><br><div><li>👍 82</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2021/05/20
 */
@Solution(no = "1738", title = "Find Kth Largest XOR Coordinate Value", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/find-kth-largest-xor-coordinate-value/")
public class FindKthLargestXorCoordinateValue {

    public static void main(String[] args) {
        Assertions.assertExpect(FindKthLargestXorCoordinateValue.class, 7, new int[][]{{5, 2}, {1, 6}}, 1);
    }

    @Test
    public int kthLargestValue(int[][] matrix, int k) {
        int width, height;
        if ((height = matrix.length) <= 0 || (width = matrix[0].length) <= 0) {
            return 0;
        }
        int[] arr = new int[width * height];
        int n = 0;
        arr[n++] = matrix[0][0];
        for (int i = 1; i < height; i++) {
            arr[n++] = (matrix[i][0] ^= matrix[i - 1][0]);
        }
        for (int j = 1; j < width; j++) {
            arr[n++] = (matrix[0][j] ^= matrix[0][j - 1]);
        }
        for (int i = 1; i < height; i++) {
            for (int j = 1; j < width; j++) {
                arr[n++] = (matrix[i][j] ^= (matrix[i - 1][j] ^ matrix[i][j - 1] ^ matrix[i - 1][j - 1]));
            }
        }
        Arrays.sort(arr);
        return arr[arr.length - k];
    }
}
