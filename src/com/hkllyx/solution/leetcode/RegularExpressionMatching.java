package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;

/**
 * @author xiaoyong3
 * @date 2021/06/01
 */
@Solution(no = "10", difficulty = Difficulty.HARD, url = "https://leetcode-cn.com/problems/regular-expression-matching/", failed = true)
public class RegularExpressionMatching {

    public boolean isMatch(String s, String p) {
        int sl = s.length(), pl = p.length();
        if (pl > 0 && p.charAt(0) == '*') {
            return false;
        }
        int[] match = new int[sl];
        return true;
    }
}
