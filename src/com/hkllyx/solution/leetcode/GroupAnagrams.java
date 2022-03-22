package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>Given an array of strings <code>strs</code>, group <strong>the anagrams</strong> together. You can return the answer in <strong>any order</strong>.</p>
 *
 * <p>An <strong>Anagram</strong> is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 * <pre><strong>Input:</strong> strs = ["eat","tea","tan","ate","nat","bat"]
 * <strong>Output:</strong> [["bat"],["nat","tan"],["ate","eat","tea"]]
 * </pre><p><strong>Example 2:</strong></p>
 * <pre><strong>Input:</strong> strs = [""]
 * <strong>Output:</strong> [[""]]
 * </pre><p><strong>Example 3:</strong></p>
 * <pre><strong>Input:</strong> strs = ["a"]
 * <strong>Output:</strong> [["a"]]
 * </pre>
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= strs.length &lt;= 10<sup>4</sup></code></li>
 * 	<li><code>0 &lt;= strs[i].length &lt;= 100</code></li>
 * 	<li><code>strs[i]</code> consists of lowercase English letters.</li>
 * </ul>
 * <div><div>Related Topics</div><div><li>哈希表</li><li>字符串</li><li>排序</li></div></div><br><div><li>👍 1047</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2022/03/14
 */
@Solution(no = "49", title = "Group Anagrams", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/group-anagrams/")
public class GroupAnagrams {

    public static void main(String[] args) {
        Assertions.assertExpect(new String[][]{{"bat"},{"nat","tan"},{"ate","eat","tea"}},
                (Object) new String[]{"eat","tea","tan","ate","nat","bat"});
    }

    @Test(mills = 74, memory = 48.5)
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Arrays.stream(strs).collect(Collectors.groupingBy(this::key)).forEach((k, v) -> res.add(v));
        return res;
    }

    private Map<Character, Integer> key(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
        }
        return map;
    }
}
