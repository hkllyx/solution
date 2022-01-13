package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>Given a string containing digits from <code>2-9</code> inclusive, return all possible letter combinations that the number could represent. Return the answer in <strong>any order</strong>.</p>
 *
 * <p>A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.</p>
 *
 * <p><img src="https://upload.wikimedia.org/wikipedia/commons/thumb/7/73/Telephone-keypad2.svg/200px-Telephone-keypad2.svg.png" style="width: 200px; height: 162px;" /></p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> digits = &quot;23&quot;
 * <strong>Output:</strong> [&quot;ad&quot;,&quot;ae&quot;,&quot;af&quot;,&quot;bd&quot;,&quot;be&quot;,&quot;bf&quot;,&quot;cd&quot;,&quot;ce&quot;,&quot;cf&quot;]
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> digits = &quot;&quot;
 * <strong>Output:</strong> []
 * </pre>
 *
 * <p><strong>Example 3:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> digits = &quot;2&quot;
 * <strong>Output:</strong> [&quot;a&quot;,&quot;b&quot;,&quot;c&quot;]
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>0 &lt;= digits.length &lt;= 4</code></li>
 * 	<li><code>digits[i]</code> is a digit in the range <code>[&#39;2&#39;, &#39;9&#39;]</code>.</li>
 * </ul>
 * <div><div>Related Topics</div><div><li>哈希表</li><li>字符串</li><li>回溯</li></div></div><br><div><li>👍 1673</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2021/05/15
 */
@Solution(no = "17", title = "Letter Combinations of a Phone Number", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/")
public class LetterCombinationsOfAPhoneNumber {
    public static final char[][] PANEL = new char[][]{
            {'a', 'b', 'c'}, {'d', 'e', 'f'},
            {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}
    };

    public static void main(String[] args) {
        Assertions.assertExpect(LetterCombinationsOfAPhoneNumber.class, Arrays.asList("w", "x", "y", "z"), "9");
        Assertions.assertExpect(LetterCombinationsOfAPhoneNumber.class,
                Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"), "23");
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
