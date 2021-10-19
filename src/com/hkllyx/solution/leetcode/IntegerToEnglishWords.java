package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

import java.util.LinkedList;

/**
 * @author xiaoyong3
 * @date 2021/10/11
 */
@Solution(no = "273", difficulty = Difficulty.HARD, url = "https://leetcode-cn.com/problems/integer-to-english-words/")
public class IntegerToEnglishWords {
    private static final String[] SEPARATOR = {"Hundred", "Thousand", "Million", "Billion"};
    private static final String[] SINGLE = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    private static final String[] TEEN = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static final String[] TY = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public static void main(String[] args) {
        Assertions.assertExpect("One Hundred Twenty Three", 123);
        Assertions.assertExpect("Twelve Thousand Three Hundred Forty Five", 12345);
        Assertions.assertExpect("One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven", 1234567);
        Assertions.assertExpect(
                "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One",
                1234567891);
    }

    @Test
    public String numberToWords(int num) {
        if (num == 0) {
            return SINGLE[0];
        }
        LinkedList<String> res = new LinkedList<>();
        int[] digits = new int[3];
        for (int i = 0; i < SEPARATOR.length && num != 0; i++) {
            boolean empty = true;
            for (int j = digits.length - 1; j >= 0; j--, num /= 10) {
                digits[j] = num % 10;
                empty &= (digits[j] == 0);
            }
            if (empty) {
                continue;
            }
            if (i > 0) {
                res.addFirst(SEPARATOR[i]);
            }
            if (digits[2] != 0 && digits[1] == 0) {
                res.addFirst(SINGLE[digits[2]]);
            } else if (digits[1] == 1) {
                res.addFirst(TEEN[digits[2]]);
            } else if (digits[1] != 0) {
                if (digits[2] != 0) {
                    res.addFirst(SINGLE[digits[2]]);
                }
                res.addFirst(TY[digits[1]]);
            }
            if (digits[0] != 0) {
                res.addFirst(SEPARATOR[0]);
                res.addFirst(SINGLE[digits[0]]);
            }
        }
        return String.join(" ", res);
    }
}
