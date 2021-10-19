package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.info.Status;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

/**
 * @author hkllyx
 * @date 2021-09-12
 */
@Solution(no = "678", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/valid-parenthesis-string/", status = Status.FAILED)
public class ValidParenthesisString {

    public static void main(String[] args) {
        Assertions.assertExpect(true, "()");
        Assertions.assertExpect(true, "(*)");
        Assertions.assertExpect(false, ")(");
        Assertions.assertExpect(true, "(*))");
        Assertions.assertExpect(false,
                "(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())");
    }

    @Test
    public boolean checkValidString(String s) {
        int length = s.length(), left = 0, star = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                left++;
            } else if (c == '*') {
                star++;
            } else if (left > 0) {
                left--;
            } else if (star > 0) {
                star--;
            } else {
                return false;
            }
        }
        return star >= left;
    }
}
