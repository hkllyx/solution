package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;

/**
 * <p>请实现一个函数，把字符串 <code>s</code> 中的每个空格替换成&quot;%20&quot;。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre><strong>输入：</strong>s = &quot;We are happy.&quot;
 * <strong>输出：</strong>&quot;We%20are%20happy.&quot;</pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>限制：</strong></p>
 *
 * <p><code>0 &lt;= s 的长度 &lt;= 10000</code></p>
 * <div><div>Related Topics</div><div><li>字符串</li></div></div><br><div><li>👍 193</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2021/05/22
 */
@Solution(no = "剑指 Offer 05", title = "替换空格", difficulty = Difficulty.EASY, url = "https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/")
public class 替换空格 {

    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder(s.length());
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
