package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author xiaoyong3
 * @date 2021/05/20
 */
@Solution(no = "692", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/top-k-frequent-words/")
public class TopKFrequentWords {

    public static void main(String[] args) {
        Assertions.assertExpect(TopKFrequentWords.class, Arrays.asList("i", "love"),
                new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2);
    }

    @Test
    public List<String> topKFrequent(String[] words, int k) {
        if (words == null || words.length <= 0 || k <= 0) {
            return new ArrayList<>(0);
        }
        Map<String, Integer> frequencies = new HashMap<>();
        for (String word : words) {
            Integer frequency = frequencies.get(word);
            frequencies.put(word, frequency == null ? 1 : frequency + 1);
        }
        return frequencies.keySet().stream().sorted((s1, s2) -> {
            int compare = frequencies.get(s2).compareTo(frequencies.get(s1));
            if (compare == 0) {
                compare = s1.compareTo(s2);
            }
            return compare;
        }).limit(k).collect(Collectors.toList());
    }
}
