package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

/**
 * @author xiaoyong3
 * @date 2021/10/13
 */
@Solution(no = "5", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/longest-palindromic-substring/")
public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        Assertions.assertExpect("bab", "babad");
        Assertions.assertExpect("bb", "bb");
        Assertions.assertExpect("bb", "cbbd");
        Assertions.assertExpect("a", "a");
        Assertions.assertExpect("a", "ac");
    }

    @Test(value = "暴力", active = false, mills = 316, space = 38.5)
    public String longestPalindrome(String s) {
        int longest = 1, begin = 0, end = 1;
        for (int i = 0; i < s.length() - longest; i++) {
            next:
            for (int j = i + longest; j < s.length(); j++) {
                for (int b = i, e = j; b <= e; b++, e--) {
                    if (s.charAt(b) != s.charAt(e)) {
                        continue next;
                    }
                }
                longest = j - i;
                begin = i;
                end = j + 1;
            }
        }
        return s.substring(begin, end);
    }

    @Test(value = "中心扩展", active = false, mills = 29, space = 38.3)
    public String longestPalindrome1(String s) {
        int begin = 0, end = 0;
        next:
        for (int i = 1; i <= s.length() * 2 - 3; i++) {
            for (int b = (i - 1) / 2, e = i - b; b >= 0 && e < s.length(); b--, e++) {
                if (s.charAt(b) != s.charAt(e)) {
                    continue next;
                } else if ((end - begin) < (e - b)) {
                    begin = b;
                    end = e;
                }
            }
        }
        return s.substring(begin, end + 1);
    }

    @Test(value = "DP", mills = 220, space = 42.5)
    public String longestPalindrome2(String s) {
        int strLen = s.length();
        // dp[i][j]表示s的i~j位是回文字符串
        boolean[][] dp = new boolean[strLen][strLen];
        for (int i = 0; i < strLen; i++) {
            // dp[i][i] = true
            dp[i][i] = true;
        }
        // l = j - i，即回文长度 - 1
        int maxGap = 0, begin = 0;
        for (int gap = 1; gap < strLen; gap++) {
            for (int i = 0; i < strLen - gap; i++) {
                int j = i + gap;
                if (s.charAt(i) == s.charAt(j)) {
                    // dp[i][i + 1] = true
                    // dp[i][j] = dp[i + 1][j - 1]
                    dp[i][j] = gap < 2 || dp[i + 1][j - 1];
                }
                if (dp[i][j] && maxGap < gap) {
                    maxGap = gap;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxGap + 1);
    }
}
