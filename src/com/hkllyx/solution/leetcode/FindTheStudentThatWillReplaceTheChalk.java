package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

/**
 * <p>There are <code>n</code> students in a class numbered from <code>0</code> to <code>n - 1</code>. The teacher will give each student a problem starting with the student number <code>0</code>, then the student number <code>1</code>, and so on until the teacher reaches the student number <code>n - 1</code>. After that, the teacher will restart the process, starting with the student number <code>0</code> again.</p>
 *
 * <p>You are given a <strong>0-indexed</strong> integer array <code>chalk</code> and an integer <code>k</code>. There are initially <code>k</code> pieces of chalk. When the student number <code>i</code> is given a problem to solve, they will use <code>chalk[i]</code> pieces of chalk to solve that problem. However, if the current number of chalk pieces is <strong>strictly less</strong> than <code>chalk[i]</code>, then the student number <code>i</code> will be asked to <strong>replace</strong> the chalk.</p>
 *
 * <p>Return <em>the <strong>index</strong> of the student that will <strong>replace</strong> the chalk</em>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> chalk = [5,1,5], k = 22
 * <strong>Output:</strong> 0
 * <strong>Explanation: </strong>The students go in turns as follows:
 * - Student number 0 uses 5 chalk, so k = 17.
 * - Student number 1 uses 1 chalk, so k = 16.
 * - Student number 2 uses 5 chalk, so k = 11.
 * - Student number 0 uses 5 chalk, so k = 6.
 * - Student number 1 uses 1 chalk, so k = 5.
 * - Student number 2 uses 5 chalk, so k = 0.
 * Student number 0 does not have enough chalk, so they will have to replace it.</pre>
 *
 * <p><strong>Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> chalk = [3,4,1,2], k = 25
 * <strong>Output:</strong> 1
 * <strong>Explanation: </strong>The students go in turns as follows:
 * - Student number 0 uses 3 chalk so k = 22.
 * - Student number 1 uses 4 chalk so k = 18.
 * - Student number 2 uses 1 chalk so k = 17.
 * - Student number 3 uses 2 chalk so k = 15.
 * - Student number 0 uses 3 chalk so k = 12.
 * - Student number 1 uses 4 chalk so k = 8.
 * - Student number 2 uses 1 chalk so k = 7.
 * - Student number 3 uses 2 chalk so k = 5.
 * - Student number 0 uses 3 chalk so k = 2.
 * Student number 1 does not have enough chalk, so they will have to replace it.
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>chalk.length == n</code></li>
 * 	<li><code>1 &lt;= n &lt;= 10<sup>5</sup></code></li>
 * 	<li><code>1 &lt;= chalk[i] &lt;= 10<sup>5</sup></code></li>
 * 	<li><code>1 &lt;= k &lt;= 10<sup>9</sup></code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>数组</li><li>二分查找</li><li>前缀和</li><li>模拟</li></div></div><br><div><li>👍 80</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2021/09/11
 */
@Solution(no = "1894", title = "Find the Student that Will Replace the Chalk", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/find-the-student-that-will-replace-the-chalk/")
public class FindTheStudentThatWillReplaceTheChalk {

    public static void main(String[] args) {
        Assertions.assertExpect(1, new int[]{3, 4, 1, 2}, 25);
    }

    @Test
    public int chalkReplacer(int[] chalk, int k) {
        // 考虑溢出。。。
        long sum = 0;
        for (int i : chalk) {
            sum += i;
        }
        k %= sum;
        for (int i = 0; i < chalk.length; i++) {
            k -= chalk[i];
            if (k < 0) {
                return i;
            }
        }
        return 0;
    }
}
