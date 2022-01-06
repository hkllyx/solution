package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Test;

/**
 * <p>字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串&quot;abcdefg&quot;和数字2，该函数将返回左旋转两位得到的结果&quot;cdefgab&quot;。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre><strong>输入:</strong> s = &quot;abcdefg&quot;, k = 2
 * <strong>输出:&nbsp;</strong>&quot;cdefgab&quot;
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre><strong>输入:</strong> s = &quot;lrloseumgh&quot;, k = 6
 * <strong>输出:&nbsp;</strong>&quot;umghlrlose&quot;
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>限制：</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= k &lt; s.length &lt;= 10000</code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>数学</li><li>双指针</li><li>字符串</li></div></div><br><div><li>👍 184</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2022/01/05
 */
@Solution(no = "剑指 Offer 58 - II", difficulty = Difficulty.EASY, url = "https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/")
public class 左旋转字符串 {

    @Test(active = false)
    public String reverseLeftWords(String s, int n) {
        int len = s.length();
        char[] arr = new char[len];
        int k = 0;
        for (int i = n; i < len; i++) {
            arr[k++] = s.charAt(i);
        }
        for (int i = 0; k < len; i++) {
            arr[k++] = s.charAt(i);
        }
        return new String(arr);
    }

    @Test
    public String reverseLeftWords1(String s, int n) {
        return (s + s).substring(n, n + s.length());
    }
}
