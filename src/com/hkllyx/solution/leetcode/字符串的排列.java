package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.ops.ArrayOps;
import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @author xiaoyong3
 * @date 2021/11/16
 */
@Solution(no = "剑指 Offer 38", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/")
public class 字符串的排列 implements ArrayOps {

    public static void main(String[] args) {
        Assertions.assertExpect("", "abc");
    }

    @Test(value = "DFS", mills = 9, memory = 43)
    public String[] permutation(String s) {
        List<String> collector = new LinkedList<>();
        int[] counter = new int[26];
        int length = s.length();
        for (int i = 0; i < length; i++) {
            counter[s.charAt(i) - 'a']++;
        }
        dfs(collector, counter, new char[length], 0, length);
        return collector.toArray(new String[0]);
    }

    private void dfs(List<String> collector, int[] counter, char[] trace, int level, int length) {
        if (level == length) {
            collector.add(new String(trace));
            return;
        }
        for (int i = 0; i < 26; i++) {
            if (counter[i] > 0) {
                counter[i]--;
                trace[level] = (char) (i + 'a');
                dfs(collector, counter, trace, level + 1, length);
                counter[i]++;
            }
        }
    }

    @Test(value = "参考NextPermutation", mills = 9, memory = 43.2, active = false)
    public String[] permutation1(String s) {
        List<String> collector = new LinkedList<>();
        collector.add(s);
        char[] chars = s.toCharArray();
        while (true) {
            nextPermutation(chars);
            String ns = new String(chars);
            if (ns.equals(s)) {
                break;
            }
            collector.add(ns);
        }
        return collector.toArray(new String[0]);
    }

    public void nextPermutation(char[] chars) {
        // i之后为递减，说明i之后已经是最大的排序
        int i = chars.length - 2;
        while (i >= 0 && chars[i] >= chars[i + 1]) {
            i--;
        }
        // 将i之后的排序倒转，编程递增
        for (int m = i + 1, n = chars.length - 1; m < n; m++, n--) {
            swap(chars, m, n);
        }
        if (i >= 0) {
            // 找到第一个比i大的
            int j = i + 1;
            while (j < chars.length && chars[i] >= chars[j]) {
                j++;
            }
            swap(chars, i, j);
        }
    }
}
