package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;

import java.util.HashMap;

/**
 * <p>在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。</p>
 *
 * <p><strong>示例 1:</strong></p>
 *
 * <pre>
 * 输入：s = "abaccdeff"
 * 输出：'b'
 * </pre>
 *
 * <p><strong>示例 2:</strong></p>
 *
 * <pre>
 * 输入：s = ""
 * 输出：' '
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>限制：</strong></p>
 *
 * <p><code>0 &lt;= s 的长度 &lt;= 50000</code></p>
 * <div><div>Related Topics</div><div><li>队列</li><li>哈希表</li><li>字符串</li><li>计数</li></div></div><br><div><li>👍 170</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2022/01/01
 */
@Solution(no = "剑指 Offer 50", title = "第一个只出现一次的字符", difficulty = Difficulty.EASY, url = "https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/")
public class 第一个只出现一次的字符 {


    public char firstUniqChar(String s) {
        HashMap<Character, Boolean> unique = new HashMap<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            unique.put(c, !unique.containsKey(c));
        }
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (unique.get(c)) {
                return c;
            }
        }
        return ' ';
    }
}
