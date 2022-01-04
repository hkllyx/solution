package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.info.Status;

/**
 * <p>Given a string <code>num</code> that contains only digits and an integer <code>target</code>, return <em><strong>all possibilities</strong> to insert the binary operators </em><code>&#39;+&#39;</code><em>, </em><code>&#39;-&#39;</code><em>, and/or </em><code>&#39;*&#39;</code><em> between the digits of </em><code>num</code><em> so that the resultant expression evaluates to the </em><code>target</code><em> value</em>.</p>
 *
 * <p>Note that operands in the returned expressions <strong>should not</strong> contain leading zeros.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> num = &quot;123&quot;, target = 6
 * <strong>Output:</strong> [&quot;1*2*3&quot;,&quot;1+2+3&quot;]
 * <strong>Explanation:</strong> Both &quot;1*2*3&quot; and &quot;1+2+3&quot; evaluate to 6.
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> num = &quot;232&quot;, target = 8
 * <strong>Output:</strong> [&quot;2*3+2&quot;,&quot;2+3*2&quot;]
 * <strong>Explanation:</strong> Both &quot;2*3+2&quot; and &quot;2+3*2&quot; evaluate to 8.
 * </pre>
 *
 * <p><strong>Example 3:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> num = &quot;3456237490&quot;, target = 9191
 * <strong>Output:</strong> []
 * <strong>Explanation:</strong> There are no expressions that can be created from &quot;3456237490&quot; to evaluate to 9191.
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= num.length &lt;= 10</code></li>
 * 	<li><code>num</code> consists of only digits.</li>
 * 	<li><code>-2<sup>31</sup> &lt;= target &lt;= 2<sup>31</sup> - 1</code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>数学</li><li>字符串</li><li>回溯</li></div></div><br><div><li>👍 366</li><li>👎 0</li></div>
 *
 * @author hkllyx
 * @date 2021-10-16
 */
@Solution(no = "282", difficulty = Difficulty.HARD, url = "https://leetcode-cn.com/problems/expression-add-operators/", status = Status.FAILED)
public class ExpressionAddOperators {

    // public List<String> addOperators(String num, int target) {
    //     List<String> res = new LinkedList<>();
    //     dfs(res, num, 0, new char[(num.length() << 1) - 1], 0, 0, 0, target);
    //     return res;
    // }
    //
    // private void dfs(List<String> res, String num, int index, char[] arr, int arrLen, int preTarget, int preNum,int operatorType, int target) {
    //     if (index == num.length() - 1) {
    //         if (preTarget == target) {
    //             res.add(new String(arr, 0, arrLen));
    //         }
    //         return;
    //     }
    //     char cur = num.charAt(index);
    //     if (preT)
    // }
}
