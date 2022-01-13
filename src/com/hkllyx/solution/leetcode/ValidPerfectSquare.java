package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

/**
 * <p>Given a <strong>positive</strong> integer <i>num</i>, write a function which returns True if <i>num</i> is a perfect square else False.</p>
 *
 * <p><b>Follow up:</b> <b>Do not</b> use any built-in library function such as <code>sqrt</code>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 * <pre><strong>Input:</strong> num = 16
 * <strong>Output:</strong> true
 * </pre><p><strong>Example 2:</strong></p>
 * <pre><strong>Input:</strong> num = 14
 * <strong>Output:</strong> false
 * </pre>
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= num &lt;= 2^31 - 1</code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>数学</li><li>二分查找</li></div></div><br><div><li>👍 336</li><li>👎 0</li></div>
 *
 * @author hkllyx
 * @date 2021-11-04
 */
@Solution(no = "367", title = "Valid Perfect Square", difficulty = Difficulty.EASY, url = "https://leetcode-cn.com/problems/valid-perfect-square/")
public class ValidPerfectSquare {

    public static void main(String[] args) {
        Assertions.assertExpect(false, 14);
        Assertions.assertExpect(true, 1);
        Assertions.assertExpect(true, 9);
        Assertions.assertExpect(true, 25);
        Assertions.assertExpect(false, 32);
    }

    @Test(value = "暴力", mills = -1, active = false)
    public boolean isPerfectSquare(int num) {
        for (int i = 0; i <= num; i++) {
            int s = i * i;
            if (s == num) {
                return true;
            } else if (s > num) {
                break;
            }
        }
        return false;
    }

    @Test(value = "二分法", mills = 0)
    public boolean isPerfectSquare1(int num) {
        if (num <= 1) {
            return true;
        }
        for (int i = num >> 1, j = num; i < j; ) {
            int k = num / i, m = i * k;
            if (i == k) {
                return m == num;
            }
            if (i > k) {
                j = i;
                i >>= 1;
            } else if (j == i + 1) {
                break;
            } else {
                i = (i + j) >> 1;
            }
        }
        return false;
    }
}
