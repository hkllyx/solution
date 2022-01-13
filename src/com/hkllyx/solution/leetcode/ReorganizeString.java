package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

import java.util.Arrays;

/**
 * <p>Given a string <code>s</code>, rearrange the characters of <code>s</code> so that any two adjacent characters are not the same.</p>
 *
 * <p>Return <em>any possible rearrangement of</em> <code>s</code> <em>or return</em> <code>&quot;&quot;</code> <em>if not possible</em>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 * <pre><strong>Input:</strong> s = "aab"
 * <strong>Output:</strong> "aba"
 * </pre><p><strong>Example 2:</strong></p>
 * <pre><strong>Input:</strong> s = "aaab"
 * <strong>Output:</strong> ""
 * </pre>
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= s.length &lt;= 500</code></li>
 * 	<li><code>s</code> consists of lowercase English letters.</li>
 * </ul>
 * <div><div>Related Topics</div><div><li>贪心</li><li>哈希表</li><li>字符串</li><li>计数</li><li>排序</li><li>堆（优先队列）</li></div></div><br><div><li>👍 379</li><li>👎 0</li></div>
 *
 * @author hkllyx
 * @date 2021/03/29
 */
@Solution(no = "767", title = "Reorganize String", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/reorganize-string/")
public class ReorganizeString {

    public static void main(String[] args) {
        Assertions.assertExpect(ReorganizeString.class, "", "bbbbbbb");
        Assertions.assertExpect(ReorganizeString.class, "babab", "baabb");
        Assertions.assertExpect(ReorganizeString.class, "vlvov", "vvvlo");
        Assertions.assertExpect(ReorganizeString.class, "", "aabbaa");
    }

    @Test
    public String reorganizeString(String s) {
        if (s.length() < 2) {
            return s;
        }
        char[] src = s.toCharArray();
        Arrays.sort(src);
        boolean half = false;
        char hc = 0;
        int count = 1;
        for (int i = 1; i < src.length; i++) {
            if (src[i] == src[i - 1]) {
                count++;
                // 超过一半 (3 << 1) > (4 + 1), (4 << 1) > (5 + 1)
                if ((count << 1) > src.length + 1) {
                    return "";
                }
                // 一半 (2 << 1) = 4, (3 << 1) > 5
                if ((count << 1) >= src.length) {
                    half = true;
                    hc = src[i];
                }
            } else {
                count = 1;
            }
        }
        char[] dest = new char[src.length];
        int k = 0;
        for (int i = 0; i < dest.length; i += 2) {
            dest[i] = half ? hc : src[k++];
        }
        for (int i = 1; i < dest.length; i += 2) {
            char cc = src[k++];
            if (half) {
                while (cc == hc) {
                    cc = src[k++];
                }
            }
            dest[i] = cc;
        }
        return new String(dest);
    }
}
