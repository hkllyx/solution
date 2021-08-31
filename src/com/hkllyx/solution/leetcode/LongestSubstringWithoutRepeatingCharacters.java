package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.info.Tag;
import com.hkllyx.solution.util.info.Tags;
import com.hkllyx.solution.util.test.Test;
import com.hkllyx.solution.util.test.TestUtils;

import java.util.HashSet;

/**
 * @author hkllyx
 * @date 2021/04/19
 */
@Solution(no = "3", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/")
@Tags({Tag.HASH_TABLE, Tag.TWO_POINTERS, Tag.STRING, Tag.SLIDING_WINDOW})
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        TestUtils.assertion(LongestSubstringWithoutRepeatingCharacters.class, 3, "dvdf");
        TestUtils.assertion(LongestSubstringWithoutRepeatingCharacters.class, 3, "abcabcbb");
        TestUtils.assertion(LongestSubstringWithoutRepeatingCharacters.class, 1, "bbbbbbb");
        TestUtils.assertion(LongestSubstringWithoutRepeatingCharacters.class, 3, "pwwkew");
        TestUtils.assertion(LongestSubstringWithoutRepeatingCharacters.class, 5, "abcde");
    }

    @Test
    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        HashSet<Character> set = new HashSet<>(length);
        int max = 0;
        for (int i = 0, j = 0; j < length; j++) {
            char jc = s.charAt(j);
            if (!set.add(jc)) {
                max = Math.max(max, set.size());
                // 将 i 移到和 j 处相同字符位之后
                while (i < j) {
                    char ic = s.charAt(i++);
                    if (ic == jc) {
                        break;
                    }
                    set.remove(ic);
                }
                if (max >= length - i) {
                    return max;
                }
            }
        }
        return Math.max(max, set.size());
    }
}
