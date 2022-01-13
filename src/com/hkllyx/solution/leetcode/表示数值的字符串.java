package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

/**
 * <p>请实现一个函数用来判断字符串是否表示<strong>数值</strong>（包括整数和小数）。</p>
 *
 * <p><strong>数值</strong>（按顺序）可以分成以下几个部分：</p>
 *
 * <ol>
 * 	<li>若干空格</li>
 * 	<li>一个 <strong>小数</strong> 或者 <strong>整数</strong></li>
 * 	<li>（可选）一个 <code>'e'</code> 或 <code>'E'</code> ，后面跟着一个 <strong>整数</strong></li>
 * 	<li>若干空格</li>
 * </ol>
 *
 * <p><strong>小数</strong>（按顺序）可以分成以下几个部分：</p>
 *
 * <ol>
 * 	<li>（可选）一个符号字符（<code>'+'</code> 或 <code>'-'</code>）</li>
 * 	<li>下述格式之一：
 * 	<ol>
 * 		<li>至少一位数字，后面跟着一个点 <code>'.'</code></li>
 * 		<li>至少一位数字，后面跟着一个点 <code>'.'</code> ，后面再跟着至少一位数字</li>
 * 		<li>一个点 <code>'.'</code> ，后面跟着至少一位数字</li>
 * 	</ol>
 * 	</li>
 * </ol>
 *
 * <p><strong>整数</strong>（按顺序）可以分成以下几个部分：</p>
 *
 * <ol>
 * 	<li>（可选）一个符号字符（<code>'+'</code> 或 <code>'-'</code>）</li>
 * 	<li>至少一位数字</li>
 * </ol>
 *
 * <p>部分<strong>数值</strong>列举如下：</p>
 *
 * <ul>
 * 	<li><code>["+100", "5e2", "-123", "3.1416", "-1E-16", "0123"]</code></li>
 * </ul>
 *
 * <p>部分<strong>非数值</strong>列举如下：</p>
 *
 * <ul>
 * 	<li><code>["12e", "1a3.14", "1.2.3", "+-5", "12e+5.4"]</code></li>
 * </ul>
 *
 * <p> </p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>s = "0"
 * <strong>输出：</strong>true
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>s = "e"
 * <strong>输出：</strong>false
 * </pre>
 *
 * <p><strong>示例 3：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>s = "."
 * <strong>输出：</strong>false</pre>
 *
 * <p><strong>示例 4：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>s = "    .1  "
 * <strong>输出：</strong>true
 * </pre>
 *
 * <p> </p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * 	<li><code>1 <= s.length <= 20</code></li>
 * 	<li><code>s</code> 仅含英文字母（大写和小写），数字（<code>0-9</code>），加号 <code>'+'</code> ，减号 <code>'-'</code> ，空格 <code>' '</code> 或者点 <code>'.'</code> 。</li>
 * </ul>
 * <div><div>Related Topics</div><div><li>字符串</li></div></div><br><div><li>👍 270</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2021/06/03
 */
@Solution(no = "剑指 Offer 20", title = "表示数值的字符串", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof/")
public class 表示数值的字符串 {

    public static void main(String[] args) {
        for (String s : new String[]{"+100", "5e2", "-123", "3.1416", "-1E-16", "0123", ".1", "3.", "   1.   "}) {
            Assertions.assertExpect(表示数值的字符串.class, true, s);
        }
        for (String s : new String[]{"12e", "1a3.14", "1.2.3", "+-5", "12e+5.4", "E9", "1 1", ".-4"}) {
            Assertions.assertExpect(表示数值的字符串.class, false, s);
        }
    }

    @Test
    public boolean isNumber(String s) {
        int from = 0, to = s.length();
        while (from < to && s.charAt(from) == ' ') {
            from++;
        }
        while (from < to && s.charAt(to - 1) == ' ') {
            to--;
        }
        return isNumber(s, from, to, true, true);
    }

    private boolean isNumber(String s, int from, int to, boolean acceptDot, boolean acceptE) {
        boolean acceptSign = true, hasNumber = false;
        for (int i = from; i < to; i++) {
            char c = s.charAt(i);
            if (c == '+' || c == '-') {
                if (acceptSign) {
                    acceptSign = false;
                } else {
                    return false;
                }
            } else if (c == '.') {
                if (acceptDot) {
                    acceptDot = false;
                    acceptSign = false;
                } else {
                    return false;
                }
            } else if (c >= '0' && c <= '9') {
                acceptSign = false;
                hasNumber = true;
            } else if (c == 'E' || c == 'e') {
                return hasNumber && acceptE && isNumber(s, i + 1, to, false, false);
            } else {
                return false;
            }
        }
        return hasNumber;
    }
}
