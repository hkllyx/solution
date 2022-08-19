package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

/**
 * <p>Given strings <code>s1</code>, <code>s2</code>, and <code>s3</code>, find whether <code>s3</code> is formed by an <strong>interleaving</strong> of <code>s1</code> and <code>s2</code>.</p>
 *
 * <p>An <strong>interleaving</strong> of two strings <code>s</code> and <code>t</code> is a configuration where <code>s</code> and <code>t</code> are divided into <code>n</code> and <code>m</code> <strong>non-empty</strong> substrings respectively, such that:</p>
 *
 * <ul>
 *  <li><code>s = s<sub>1</sub> + s<sub>2</sub> + ... + s<sub>n</sub></code></li>
 *  <li><code>t = t<sub>1</sub> + t<sub>2</sub> + ... + t<sub>m</sub></code></li>
 *  <li><code>|n - m| &lt;= 1</code></li>
 *  <li>The <strong>interleaving</strong> is <code>s<sub>1</sub> + t<sub>1</sub> + s<sub>2</sub> + t<sub>2</sub> + s<sub>3</sub> + t<sub>3</sub> + ...</code> or <code>t<sub>1</sub> + s<sub>1</sub> + t<sub>2</sub> + s<sub>2</sub> + t<sub>3</sub> + s<sub>3</sub> + ...</code></li>
 * </ul>
 *
 * <p><strong>Note:</strong> <code>a + b</code> is the concatenation of strings <code>a</code> and <code>b</code>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/09/02/interleave.jpg" style="width: 561px; height: 203px;" />
 * <pre>
 * <strong>Input:</strong> s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * <strong>Output:</strong> true
 * <strong>Explanation:</strong> One way to obtain s3 is:
 * Split s1 into s1 = "aa" + "bc" + "c", and s2 into s2 = "dbbc" + "a".
 * Interleaving the two splits, we get "aa" + "dbbc" + "bc" + "a" + "c" = "aadbbcbcac".
 * Since s3 can be obtained by interleaving s1 and s2, we return true.
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * <strong>Output:</strong> false
 * <strong>Explanation:</strong> Notice how it is impossible to interleave s2 with any other string to obtain s3.
 * </pre>
 *
 * <p><strong>Example 3:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> s1 = "", s2 = "", s3 = ""
 * <strong>Output:</strong> true
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 *  <li><code>0 &lt;= s1.length, s2.length &lt;= 100</code></li>
 *  <li><code>0 &lt;= s3.length &lt;= 200</code></li>
 *  <li><code>s1</code>, <code>s2</code>, and <code>s3</code> consist of lowercase English letters.</li>
 * </ul>
 *
 * <p>&nbsp;</p>
 * <p><strong>Follow up:</strong> Could you solve it using only <code>O(s2.length)</code> additional memory space?</p>
 *
 * <div><div>Related Topics</div><div><li>字符串</li><li>动态规划</li></div></div><br><div><li>👍 752</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2022/08/19
 */
@Solution(no = "97", title = "Interleaving String", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/interleaving-string/")
public class InterleavingString {

    public static void main(String[] args) {
        Assertions.assertExpect(true, "a", "", "a");
        Assertions.assertExpect(false, "", "", "a");
        Assertions.assertExpect(true, "", "", "");
        Assertions.assertExpect(true, "aabcc", "dbbca", "aadbbcbcac");
        Assertions.assertExpect(false, "aabcc", "dbbca", "aadbbbaccc");
    }

    @Test
    public boolean isInterleave(String s1, String s2, String s3) {
        int w = s1.length(), h = s2.length();
        if (w + h != s3.length()) {
            return false;
        }
        boolean[][] dp = new boolean[h + 1][w + 1];
        dp[0][0] = true;
        for (int i = 1; i <= w; i++) {
            if (s3.charAt(i - 1) == s1.charAt(i - 1)) {
                dp[0][i] = true;
            } else {
                break;
            }
        }
        for (int i = 1; i <= h; i++) {
            if (s3.charAt(i - 1) == s2.charAt(i - 1)) {
                dp[i][0] = true;
            } else {
                break;
            }
        }
        for (int i = 1; i <= h; i++) {
            for (int j = 1; j <= w; j++) {
                dp[i][j] = (dp[i - 1][j] && s3.charAt(i + j - 1) == s2.charAt(i - 1))
                        || (dp[i][j - 1] && s3.charAt(i + j - 1) == s1.charAt(j - 1));
            }
        }
        return dp[h][w];
    }
}
