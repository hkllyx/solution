package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.info.Status;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

/**
 * @author xiaoyong3
 * @date 2021/10/14
 */
@Solution(no = "32", difficulty = Difficulty.HARD, url = "https://leetcode-cn.com/problems/longest-valid-parentheses/", status = Status.FAILED)
public class LongestValidParentheses {

    public static void main(String[] args) {
        Assertions.assertExpect(22, ")(((((()())()()))()(()))(");
        Assertions.assertExpect(4, ")()())");
    }

    @Test(value = "DP，超出时间限制", active = false)
    public int longestValidParentheses(String s) {
        int strLen = s.length();
        if (strLen == 0) {
            return 0;
        }
        // dp[i][j]表示i~j是否为有效括号子串，dp[i][j] = false, i >= j || j - i = 2n
        boolean[][] dp = new boolean[strLen][strLen];
        int maxGap = 0;
        for (int gap = 1; gap < strLen; gap += 2) {
            for (int i = 0; i < strLen - gap; i++) {
                int j = i + gap;
                dp[i][j] = (s.charAt(i) == '(' && s.charAt(j) == ')' && (gap == 1 || dp[i + 1][j - 1]));
                for (int subGap = 1; !dp[i][j] && subGap < gap; subGap += 2) {
                    dp[i][j] = dp[i][i + subGap] && dp[i + subGap + 1][j];
                }
                if (dp[i][j] && gap > maxGap) {
                    maxGap = gap;
                }
            }
        }
        return maxGap == 0 ? 0 : maxGap + 1;
    }

    @Test
    public int longestValidParentheses1(String s) {
        int strLen = s.length();
        if (strLen == 0) {
            return 0;
        }
        // dp[i][j]表示i~j是否为有效括号子串，dp[i][j] = false, i >= j || j - i = 2n
        boolean[][] dp = new boolean[strLen][strLen];
        int maxGap = 0;
        for (int gap = 1; gap < strLen; gap += 2) {
            for (int i = 0; i < strLen - gap; i++) {
                int j = i + gap;
                dp[i][j] = (s.charAt(i) == '(' && s.charAt(j) == ')' && (gap == 1 || dp[i + 1][j - 1]));
                for (int subGap = 1; !dp[i][j] && subGap < gap; subGap += 2) {
                    dp[i][j] = dp[i][i + subGap] && dp[i + subGap + 1][j];
                }
                if (dp[i][j] && gap > maxGap) {
                    maxGap = gap;
                }
            }
        }
        return maxGap == 0 ? 0 : maxGap + 1;
    }

    private void print(String s, boolean[][] dp) {
        System.out.print("  ");
        for (int i = 0; i < s.length(); i++) {
            System.out.print(i % 10 + " ");
        }
        System.out.print("\n  ");
        for (int i = 0; i < s.length(); i++) {
            System.out.print(s.charAt(i) + " ");
        }
        System.out.println();
        int i = 0;
        for (boolean[] row : dp) {
            System.out.print(i++ % 10 + " ");
            for (boolean b : row) {
                System.out.print(b ? "o " : "- ");
            }
            System.out.println();
        }
    }
}
