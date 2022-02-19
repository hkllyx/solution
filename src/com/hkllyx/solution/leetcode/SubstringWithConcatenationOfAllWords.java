package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

import java.util.*;

/**
 * <p>You are given a string <code>s</code> and an array of strings <code>words</code> of <strong>the same length</strong>. Return&nbsp;all starting indices of substring(s) in <code>s</code>&nbsp;that is a concatenation of each word in <code>words</code> <strong>exactly once</strong>, <strong>in any order</strong>,&nbsp;and <strong>without any intervening characters</strong>.</p>
 *
 * <p>You can return the answer in <strong>any order</strong>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> s = &quot;barfoothefoobarman&quot;, words = [&quot;foo&quot;,&quot;bar&quot;]
 * <strong>Output:</strong> [0,9]
 * <strong>Explanation:</strong> Substrings starting at index 0 and 9 are &quot;barfoo&quot; and &quot;foobar&quot; respectively.
 * The output order does not matter, returning [9,0] is fine too.
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> s = &quot;wordgoodgoodgoodbestword&quot;, words = [&quot;word&quot;,&quot;good&quot;,&quot;best&quot;,&quot;word&quot;]
 * <strong>Output:</strong> []
 * </pre>
 *
 * <p><strong>Example 3:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> s = &quot;barfoofoobarthefoobarman&quot;, words = [&quot;bar&quot;,&quot;foo&quot;,&quot;the&quot;]
 * <strong>Output:</strong> [6,9,12]
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= s.length &lt;= 10<sup>4</sup></code></li>
 * 	<li><code>s</code> consists of lower-case English letters.</li>
 * 	<li><code>1 &lt;= words.length &lt;= 5000</code></li>
 * 	<li><code>1 &lt;= words[i].length &lt;= 30</code></li>
 * 	<li><code>words[i]</code>&nbsp;consists of lower-case English letters.</li>
 * </ul>
 * <div><div>Related Topics</div><div><li>哈希表</li><li>字符串</li><li>滑动窗口</li></div></div><br><div><li>👍 601</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2022/02/17
 */
@Solution(no = "30", title = "Substring with Concatenation of All Words", difficulty = Difficulty.HARD, url = "https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words/")
public class SubstringWithConcatenationOfAllWords {

    public static void main(String[] args) {
        Assertions.assertExpect(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10), "aaaaaaaaaaaaaa", (Object) new String[]{"aa", "aa"});
        Assertions.assertExpect(Collections.singletonList(8), "wordgoodgoodgoodbestword", (Object) new String[]{"word", "good", "best", "good"});
        Assertions.assertExpect(Arrays.asList(6, 9, 12), "barfoofoobarthefoobarman", (Object) new String[]{"foo", "bar", "the"});
        Assertions.assertExpect(Collections.emptyList(), "wordgoodgoodgoodbestword", (Object) new String[]{"word", "good", "best", "word"});
        Assertions.assertExpect(Arrays.asList(0, 9), "barfoothefoobarman", (Object) new String[]{"foo", "bar"});
    }

    @Test(mills = 8)
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();

        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        int sLen = s.length(), wordLen = words[0].length(), wordNum = words.length;
        for (int k = 0, sliceNum; k < wordLen && (sliceNum = (sLen - k) / wordLen) >= wordNum; k++) {
            // 分片，并在末尾新加一位，用于判断窗口是否已满
            String[] slices = new String[sliceNum + 1];
            for (int i = 0, j = k; i < sliceNum; i++, j += wordLen) {
                slices[i] = s.substring(j, j + wordLen);
            }

            for (int i = 0, j = 0; i <= sliceNum; i++) {
                // 窗口已满
                if (i - j == wordNum) {
                    res.add(k + j * wordLen);
                    // 平移
                    if (slices[j].equals(slices[i])) {
                        j++;
                        continue;
                    }
                }

                // 添加到窗口
                int count = map.getOrDefault(slices[i], -1);
                if (count > 0) {
                    // 符合条件，直接添加
                    map.put(slices[i], count - 1);
                } else {
                    // 属于word但已达添加数量，左侧窗口移动到最左侧相同word后一位
                    // 不属于words，直接从i的下一位开始
                    while (j < i && !slices[j].equals(slices[i])) {
                        map.put(slices[j], map.get(slices[j]) + 1);
                        j++;
                    }
                    j++;
                }
            }
        }

        Collections.sort(res);
        return res;
    }
}
