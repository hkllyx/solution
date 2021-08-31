package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.TestUtils;

/**
 * @author xiaoyong3
 * @date 2021/04/20
 */
@Solution(no = "28", difficulty = Difficulty.SIMPLE, url = "https://leetcode-cn.com/problems/implement-strstr/")
public class ImplementStrStr {

    public static void main(String[] args) {
        TestUtils.assertion(ImplementStrStr.class, 1, "mississippi", "issi");
        TestUtils.assertion(ImplementStrStr.class, -1, "aaa", "aaaa");
        TestUtils.assertion(ImplementStrStr.class, 0, "", "");
        TestUtils.assertion(ImplementStrStr.class, -1, "aaaa", "bba");
        TestUtils.assertion(ImplementStrStr.class, 2, "hello", "ll");
    }

    public int strStr1(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }
        if (needle.isEmpty()) {
            return 0;
        }
        char n0 = needle.charAt(0);
        int hl = haystack.length();
        int nl = needle.length();
        int dl = hl - nl; // i + (nl - 1) < hl ==> i + (nl - 1) <= hl - 1
        for (int i = 0; i < hl && i <= dl; ) {
            int ni = i;
            int j;
            for (j = 0; j < nl; j++) {
                int k = i + j;
                char h = haystack.charAt(k);
                char n = needle.charAt(j);
                if (i == ni && h == n0) {
                    ni = k;
                }
                if (h != n) {
                    i = i == ni ? i + 1 : ni;
                    break;
                }
            }
            if (j == nl) {
                return i;
            }
        }
        return -1;
    }

    public int strStr2(String haystack, String needle) {
        int i = 0, j = 0;
        while (i < haystack.length() && j < needle.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }
        return j == needle.length() ? i - j : -1;
    }
}
