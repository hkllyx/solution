package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xiaoyong3
 * @date 2021/11/08
 */
@Solution(no = "299", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/bulls-and-cows/")
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
