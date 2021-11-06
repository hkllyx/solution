package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.info.Status;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author xiaoyong3
 * @date 2021/10/14
 */
@Solution(no = "32", difficulty = Difficulty.HARD, url = "https://leetcode-cn.com/problems/longest-valid-parentheses/", status = Status.HELPED)
public class LongestValidParentheses {

    public static void main(String[] args) {
        Assertions.assertExpect(2, "(()(((()");
        Assertions.assertExpect(2, "()(()");
        Assertions.assertExpect(22, ")(((((()())()()))()(()))(");
        Assertions.assertExpect(4, ")()())");
    }

    @Test(value = "错误的DP，借鉴LongestPalindromicSubstring", active = false, mills = -1)
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

    @Test(value = "DP", mills = 1, memory = 38.5)
    public int longestValidParentheses1(String s) {
        int len = s.length(), max = 0;
        // dp[i]表示第i位前的有效括号的长度，即s[i - dp[i]] ~ s [i]是i位前最长有效括号长度
        int[] dp = new int[len];
        for (int i = 1; i < len; i++) {
            if (s.charAt(i) == '(') {
                continue;
            }
            // s[i] == ')'时，s[i - 1] == '('，则可以直接匹配到一个括号
            // s[i - 1] == ')'，则看匹配到s[i - 1]处的最前端的前一位s[i - dp[i - 1] - 1]是否可以匹配
            if (s.charAt(i - 1) == '(') {
                dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
            } else if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                dp[i] = (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0) + dp[i - 1] + 2;
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }

    @Test(value = "Stack", mills = 2, memory = 38.2, active = false)
    public int longestValidParentheses2(String s) {
        int max = 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);
        for (int i = 0, len = s.length(); i < len; i++) {
            if (s.charAt(i) == '(' || stack.isEmpty()) {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    // stack.peek() ~ i（左开右闭）即是本')'匹配到的有效括号
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }
}
