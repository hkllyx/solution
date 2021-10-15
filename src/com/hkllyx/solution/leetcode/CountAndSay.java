package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Test;
import com.hkllyx.solution.util.test.TestUtils;

/**
 * @author xiaoyong3
 * @date 2021/10/15
 */
@Solution(no = "38", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/count-and-say/")
public class CountAndSay {

    public static void main(String[] args) {
        TestUtils.assertion("1", 1);
        TestUtils.assertion("11", 2);
        TestUtils.assertion("21", 3);
        TestUtils.assertion("1211", 4);
        TestUtils.assertion("111221", 5);
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
