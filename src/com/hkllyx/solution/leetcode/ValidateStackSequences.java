package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

/**
 * <p>Given two integer arrays <code>pushed</code> and <code>popped</code> each with distinct values, return <code>true</code><em> if this could have been the result of a sequence of push and pop operations on an initially empty stack, or </em><code>false</code><em> otherwise.</em></p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 * <strong>Output:</strong> true
 * <strong>Explanation:</strong> We might do the following sequence:
 * push(1), push(2), push(3), push(4),
 * pop() -&gt; 4,
 * push(5),
 * pop() -&gt; 5, pop() -&gt; 3, pop() -&gt; 2, pop() -&gt; 1
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
 * <strong>Output:</strong> false
 * <strong>Explanation:</strong> 1 cannot be popped before 2.
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= pushed.length &lt;= 1000</code></li>
 * 	<li><code>0 &lt;= pushed[i] &lt;= 1000</code></li>
 * 	<li>All the elements of <code>pushed</code> are <strong>unique</strong>.</li>
 * 	<li><code>popped.length == pushed.length</code></li>
 * 	<li><code>popped</code> is a permutation of <code>pushed</code>.</li>
 * </ul>
 * <div><div>Related Topics</div><div><li>栈</li><li>数组</li><li>模拟</li></div></div><br><div><li>👍 215</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2021/06/07
 */
@Solution(no = "946", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/validate-stack-sequences/")
public class ValidateStackSequences {

    public static void main(String[] args) {
        Assertions.assertExpect(ValidateStackSequences.class, true, new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1});
        Assertions.assertExpect(ValidateStackSequences.class, false, new int[]{1, 2, 3, 4, 5},
                new int[]{4, 3, 5, 1, 2});
    }

    @Test
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int length = pushed.length;
        if (length != popped.length) {
            return false;
        }
        int[] stack = new int[length];
        int p = -1, i = 0, j = 0;
        while (j < length) {
            if (p >= 0 && stack[p] == popped[j]) {
                p--;
                j++;
            } else if (i < length) {
                stack[++p] = pushed[i++];
            } else {
                return false;
            }
        }
        return true;
    }
}
