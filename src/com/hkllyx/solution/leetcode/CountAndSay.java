package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

/**
 * <p>The <strong>count-and-say</strong> sequence is a sequence of digit strings defined by the recursive formula:</p>
 *
 * <ul>
 * 	<li><code>countAndSay(1) = &quot;1&quot;</code></li>
 * 	<li><code>countAndSay(n)</code> is the way you would &quot;say&quot; the digit string from <code>countAndSay(n-1)</code>, which is then converted into a different digit string.</li>
 * </ul>
 *
 * <p>To determine how you &quot;say&quot; a digit string, split it into the <strong>minimal</strong> number of groups so that each group is a contiguous section all of the <strong>same character.</strong> Then for each group, say the number of characters, then say the character. To convert the saying into a digit string, replace the counts with a number and concatenate every saying.</p>
 *
 * <p>For example, the saying and conversion for digit string <code>&quot;3322251&quot;</code>:</p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/10/23/countandsay.jpg" style="width: 581px; height: 172px;" />
 * <p>Given a positive integer <code>n</code>, return <em>the </em><code>n<sup>th</sup></code><em> term of the <strong>count-and-say</strong> sequence</em>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> n = 1
 * <strong>Output:</strong> &quot;1&quot;
 * <strong>Explanation:</strong> This is the base case.
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> n = 4
 * <strong>Output:</strong> &quot;1211&quot;
 * <strong>Explanation:</strong>
 * countAndSay(1) = &quot;1&quot;
 * countAndSay(2) = say &quot;1&quot; = one 1 = &quot;11&quot;
 * countAndSay(3) = say &quot;11&quot; = two 1&#39;s = &quot;21&quot;
 * countAndSay(4) = say &quot;21&quot; = one 2 + one 1 = &quot;12&quot; + &quot;11&quot; = &quot;1211&quot;
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= n &lt;= 30</code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>字符串</li></div></div><br><div><li>👍 855</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2021/10/15
 */
@Solution(no = "38", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/count-and-say/")
public class CountAndSay {

    public static void main(String[] args) {
        Assertions.assertExpect("1", 1);
        Assertions.assertExpect("11", 2);
        Assertions.assertExpect("21", 3);
        Assertions.assertExpect("1211", 4);
        Assertions.assertExpect("111221", 5);
    }

    @Test
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String pre = countAndSay(n - 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0, last = pre.length() - 1, counter = 1; i <= last; i++) {
            char c = pre.charAt(i);
            if (i != last && c == pre.charAt(i + 1)) {
                counter++;
            } else {
                sb.append((char) (counter + '0')).append(c);
                counter = 1;
            }
        }
        return sb.toString();
    }
}
