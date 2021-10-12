package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Test;

/**
 * @author hkllyx
 * @date 2021-09-07
 */
@Solution(no = "1221", difficulty = Difficulty.SIMPLE, url = "https://leetcode-cn.com/problems/split-a-string-in-balanced-strings/")
public class SplitAStringInBalancedStrings {

    @Test
    public int balancedStringSplit(String s) {
        int lc = 0, rc = 0, res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'L') {
                lc++;
            } else if (c == 'R') {
                rc++;
            }
            if (lc !=0 && lc == rc) {
                res++;
                lc = rc = 0;
            }
        }
        return res;
    }

    @Test
    public int balancedStringSplit1(String s) {
        int counter = 0, res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'L') {
                counter++;
            } else {
                counter--;
            }
            if (counter == 0) {
                res++;
            }
        }
        return res;
    }
}
