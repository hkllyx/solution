package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

/**
 * <p>Given a positive integer <code>n</code>, generate an <code>n x n</code> <code>matrix</code> filled with elements from <code>1</code> to <code>n<sup>2</sup></code> in spiral order.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/11/13/spiraln.jpg" style="width: 242px; height: 242px;" />
 * <pre>
 * <strong>Input:</strong> n = 3
 * <strong>Output:</strong> [[1,2,3],[8,9,4],[7,6,5]]
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> n = 1
 * <strong>Output:</strong> [[1]]
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= n &lt;= 20</code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>数组</li><li>矩阵</li><li>模拟</li></div></div><br><div><li>👍 636</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2022/03/21
 */
@Solution(no = "59", title = "Spiral Matrix II", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/spiral-matrix-ii/")
public class SpiralMatrixII {

    public static void main(String[] args) {
        Assertions.assertExpect(new int[][]{}, 4);
    }

    @Test(mills = 0)
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int num = 1;
        int begin = 0, end = n - 1;
        while (begin < end) {
            int x = begin, y = begin;
            while (y < end) {
                res[x][y++] = num++;
            }
            while (x < end) {
                res[x++][y] = num++;
            }
            while (y > begin) {
                res[x][y--] = num++;
            }
            while (x > begin) {
                res[x--][y] = num++;
            }
            begin++;
            end--;
        }
        if (begin == end) {
            res[begin][begin] = num;
        }
        return res;
    }
}
