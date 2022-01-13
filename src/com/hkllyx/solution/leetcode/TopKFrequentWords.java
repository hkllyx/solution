package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>Given an array of strings <code>words</code> and an integer <code>k</code>, return <em>the </em><code>k</code><em> most frequent strings</em>.</p>
 *
 *  <p>Return the answer <strong>sorted</strong> by <strong>the frequency</strong> from highest to lowest. Sort the words with the same frequency by their <strong>lexicographical order</strong>.</p>
 *
 *  <p>&nbsp;</p>
 *  <p><strong>Example 1:</strong></p>
 *
 *  <pre>
 *  <strong>Input:</strong> words = [&quot;i&quot;,&quot;love&quot;,&quot;leetcode&quot;,&quot;i&quot;,&quot;love&quot;,&quot;coding&quot;], k = 2
 *  <strong>Output:</strong> [&quot;i&quot;,&quot;love&quot;]
 *  <strong>Explanation:</strong> &quot;i&quot; and &quot;love&quot; are the two most frequent words.
 *  Note that &quot;i&quot; comes before &quot;love&quot; due to a lower alphabetical order.
 *  </pre>
 *
 *  <p><strong>Example 2:</strong></p>
 *
 *  <pre>
 *  <strong>Input:</strong> words = [&quot;the&quot;,&quot;day&quot;,&quot;is&quot;,&quot;sunny&quot;,&quot;the&quot;,&quot;the&quot;,&quot;the&quot;,&quot;sunny&quot;,&quot;is&quot;,&quot;is&quot;], k = 4
 *  <strong>Output:</strong> [&quot;the&quot;,&quot;is&quot;,&quot;sunny&quot;,&quot;day&quot;]
 *  <strong>Explanation:</strong> &quot;the&quot;, &quot;is&quot;, &quot;sunny&quot; and &quot;day&quot; are the four most frequent words, with the number of occurrence being 4, 3, 2 and 1 respectively.
 *  </pre>
 *
 *  <p>&nbsp;</p>
 *  <p><strong>Constraints:</strong></p>
 *
 *  <ul>
 *  <li><code>1 &lt;= words.length &lt;= 500</code></li>
 *  <li><code>1 &lt;= words[i] &lt;= 10</code></li>
 *  <li><code>words[i]</code> consists of lowercase English letters.</li>
 *  <li><code>k</code> is in the range <code>[1, The number of <strong>unique</strong> words[i]]</code></li>
 *  </ul>
 *
 *  <p>&nbsp;</p>
 *  <p><strong>Follow-up:</strong> Could you solve it in <code>O(n log(k))</code> time and <code>O(n)</code> extra space?</p>
 *  <div><div>Related Topics</div><div><li>字典树</li><li>哈希表</li><li>字符串</li><li>桶排序</li><li>计数</li><li>排序</li><li>堆（优先队列）</li></div></div><br><div><li>👍 420</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2021/05/20
 */
@Solution(no = "692", title = "Top K Frequent Words", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/top-k-frequent-words/")
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
