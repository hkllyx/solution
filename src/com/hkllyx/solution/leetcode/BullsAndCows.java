package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>You are playing the <strong><a href="https://en.wikipedia.org/wiki/Bulls_and_Cows" target="_blank">Bulls and Cows</a></strong> game with your friend.</p>
 *
 * <p>You write down a secret number and ask your friend to guess what the number is. When your friend makes a guess, you provide a hint with the following info:</p>
 *
 * <ul>
 * 	<li>The number of &quot;bulls&quot;, which are digits in the guess that are in the correct position.</li>
 * 	<li>The number of &quot;cows&quot;, which are digits in the guess that are in your secret number but are located in the wrong position. Specifically, the non-bull digits in the guess that could be rearranged such that they become bulls.</li>
 * </ul>
 *
 * <p>Given the secret number <code>secret</code> and your friend&#39;s guess <code>guess</code>, return <em>the hint for your friend&#39;s guess</em>.</p>
 *
 * <p>The hint should be formatted as <code>&quot;xAyB&quot;</code>, where <code>x</code> is the number of bulls and <code>y</code> is the number of cows. Note that both <code>secret</code> and <code>guess</code> may contain duplicate digits.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> secret = &quot;1807&quot;, guess = &quot;7810&quot;
 * <strong>Output:</strong> &quot;1A3B&quot;
 * <strong>Explanation:</strong> Bulls are connected with a &#39;|&#39; and cows are underlined:
 * &quot;1807&quot;
 *   |
 * &quot;<u>7</u>8<u>10</u>&quot;</pre>
 *
 * <p><strong>Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> secret = &quot;1123&quot;, guess = &quot;0111&quot;
 * <strong>Output:</strong> &quot;1A1B&quot;
 * <strong>Explanation:</strong> Bulls are connected with a &#39;|&#39; and cows are underlined:
 * &quot;1123&quot;        &quot;1123&quot;
 *   |      or     |
 * &quot;01<u>1</u>1&quot;        &quot;011<u>1</u>&quot;
 * Note that only one of the two unmatched 1s is counted as a cow since the non-bull digits can only be rearranged to allow one 1 to be a bull.
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= secret.length, guess.length &lt;= 1000</code></li>
 * 	<li><code>secret.length == guess.length</code></li>
 * 	<li><code>secret</code> and <code>guess</code> consist of digits only.</li>
 * </ul>
 * <div><div>Related Topics</div><div><li>哈希表</li><li>字符串</li><li>计数</li></div></div><br><div><li>👍 232</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2021/11/08
 */
@Solution(no = "299", title = "Bulls and Cows", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/bulls-and-cows/")
public class BullsAndCows {

    public String getHint(String secret, String guess) {
        int a = 0, b = 0, len = secret.length();
        Map<Character, Integer> counter = new HashMap<>(10);
        for (int i = 0; i < len; i++) {
            char sc = secret.charAt(i), gc = guess.charAt(i);
            if (sc == gc) {
                a++;
            } else {
                counter.put(sc, counter.getOrDefault(sc, 0) + 1);
            }
        }
        for (int i = 0; i < len; i++) {
            char sc = secret.charAt(i), gc = guess.charAt(i);
            int count = counter.getOrDefault(gc, 0);
            if (sc != gc && count > 0) {
                b++;
                counter.put(gc, count - 1);
            }
        }
        return a + "A" + b + "B";
    }

    public String getHint1(String secret, String guess) {
        int a = 0, b = 0, len = secret.length();
        int[] counter = new int[10];
        for (int i = 0; i < len; i++) {
            int sc = secret.charAt(i) - '0', gc = guess.charAt(i) - '0';
            if (sc == gc) {
                a++;
            }
            counter[sc]++;
        }
        for (int i = 0; i < len; i++) {
            int gc = guess.charAt(i) - '0';
            if (counter[gc] > 0) {
                b++;
                counter[gc]--;
            }
        }
        return a + "A" + (b - a) + "B";
    }
}
