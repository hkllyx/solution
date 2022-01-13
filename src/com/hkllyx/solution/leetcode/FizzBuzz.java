package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Given an integer <code>n</code>, return <em>a string array </em><code>answer</code><em> (<strong>1-indexed</strong>) where</em>:</p>
 *
 * <ul>
 * 	<li><code>answer[i] == &quot;FizzBuzz&quot;</code> if <code>i</code> is divisible by <code>3</code> and <code>5</code>.</li>
 * 	<li><code>answer[i] == &quot;Fizz&quot;</code> if <code>i</code> is divisible by <code>3</code>.</li>
 * 	<li><code>answer[i] == &quot;Buzz&quot;</code> if <code>i</code> is divisible by <code>5</code>.</li>
 * 	<li><code>answer[i] == i</code> (as a string) if none of the above conditions are true.</li>
 * </ul>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 * <pre><strong>Input:</strong> n = 3
 * <strong>Output:</strong> ["1","2","Fizz"]
 * </pre><p><strong>Example 2:</strong></p>
 * <pre><strong>Input:</strong> n = 5
 * <strong>Output:</strong> ["1","2","Fizz","4","Buzz"]
 * </pre><p><strong>Example 3:</strong></p>
 * <pre><strong>Input:</strong> n = 15
 * <strong>Output:</strong> ["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]
 * </pre>
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= n &lt;= 10<sup>4</sup></code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>数学</li><li>字符串</li><li>模拟</li></div></div><br><div><li>👍 163</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2021/10/13
 */
@Solution(no = "412", title = "Fizz Buzz", difficulty = Difficulty.EASY, url = "https://leetcode-cn.com/problems/fizz-buzz/")
public class FizzBuzz {

    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) {
                res.add("FizzBuzz");
            } else if (i % 5 == 0) {
                res.add("Buzz");
            } else if (i % 3 == 0) {
                res.add("Fizz");
            } else {
                res.add(Integer.toString(i));
            }
        }
        return res;
    }
}
