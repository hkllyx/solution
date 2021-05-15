package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.info.Difficulty;
import com.hkllyx.solution.info.Solution;
import com.hkllyx.solution.util.Test;
import com.hkllyx.solution.util.TestUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xiaoyong3
 * @date 2021/05/15
 */
@Solution(no = "17", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/")
public class LetterCombinationsOfAPhoneNumber {
    public static final char[][] PANEL = new char[][]{
            {'a', 'b', 'c'}, {'d', 'e', 'f'},
            {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}
    };

    public static void main(String[] args) {
        TestUtils.assertion(LetterCombinationsOfAPhoneNumber.class, Arrays.asList("w","x","y","z"), "9");
        TestUtils.assertion(LetterCombinationsOfAPhoneNumber.class, Arrays.asList("ad","ae","af","bd","be","bf","cd","ce","cf"), "23");
    }

    public List<String> letterCombinations1(String digits) {
        if (digits == null || digits.isEmpty()) {
            return new ArrayList<>(0);
        }
        List<char[]> combinations = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            char[] letters = PANEL[digits.charAt(i) - '2'];
            if (i == 0) {
                for (char letter : letters) {
                    char[] combination = new char[digits.length()];
                    combination[i] = letter;
                    combinations.add(combination);
                }
            } else {
                for (int j = 0; j < combinations.size(); j += letters.length) {
                    char[] combination = combinations.get(j);
                    for (int k = 0; k < letters.length; k++) {
                        if (k == 0) {
                            combination[i] = letters[k];
                        } else {
                            char[] newCombination = Arrays.copyOf(combination, combination.length);
                            newCombination[i] = letters[k];
                            combinations.add(j + k, newCombination);
                        }
                    }
                }
            }
        }
        return combinations.stream().map(String::valueOf).collect(Collectors.toList());
    }

    @Test
    public List<String> letterCombinations2(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() < 1) {
            return result;
        }
        backTrace(digits, 0, new char[digits.length()], result);
        return result;
    }

    private void backTrace(String digits, int index, char[] chars, List<String> result) {
        if (index == chars.length) {
            result.add(new String(chars));
        } else {
            for (char letter : PANEL[digits.charAt(index) - '2']) {
                chars[index] = letter;
                backTrace(digits, index + 1, chars, result);
            }
        }
    }
}
