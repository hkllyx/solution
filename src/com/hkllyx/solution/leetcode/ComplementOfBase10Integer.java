package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;

/**
 * <p>The <strong>complement</strong> of an integer is the integer you get when you flip all the <code>0</code>&#39;s to <code>1</code>&#39;s and all the <code>1</code>&#39;s to <code>0</code>&#39;s in its binary representation.</p>
 *
 * <ul>
 * 	<li>For example, The integer <code>5</code> is <code>&quot;101&quot;</code> in binary and its <strong>complement</strong> is <code>&quot;010&quot;</code> which is the integer <code>2</code>.</li>
 * </ul>
 *
 * <p>Given an integer <code>n</code>, return <em>its complement</em>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> n = 5
 * <strong>Output:</strong> 2
 * <strong>Explanation:</strong> 5 is &quot;101&quot; in binary, with complement &quot;010&quot; in binary, which is 2 in base-10.
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> n = 7
 * <strong>Output:</strong> 0
 * <strong>Explanation:</strong> 7 is &quot;111&quot; in binary, with complement &quot;000&quot; in binary, which is 0 in base-10.
 * </pre>
 *
 * <p><strong>Example 3:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> n = 10
 * <strong>Output:</strong> 5
 * <strong>Explanation:</strong> 10 is &quot;1010&quot; in binary, with complement &quot;0101&quot; in binary, which is 5 in base-10.
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>0 &lt;= n &lt; 10<sup>9</sup></code></li>
 * </ul>
 *
 * <p>&nbsp;</p>
 * <p><strong>Note:</strong> This question is the same as 476: <a href="https://leetcode.com/problems/number-complement/" target="_blank">https://leetcode.com/problems/number-complement/</a></p>
 * <div><div>Related Topics</div><div><li>位运算</li></div></div><br><div><li>👍 71</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2021/10/18
 */
@Solution(no = "1009", difficulty = Difficulty.SIMPLE, url = "https://leetcode-cn.com/problems/complement-of-base-10-integer/")
public class ComplementOfBase10Integer extends NumberComplement {

    public int bitwiseComplement(int n) {
        return findComplement(n);
    }
}
