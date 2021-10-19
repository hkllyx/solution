package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

/**
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
