package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author hkllyx
 * @date 2021-10-28
 */
@Solution(no = "869", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/reordered-power-of-2/")
public class ReorderedPowerOf2 {
    private final Set<String> sortedPowerOf2 = new HashSet<>(32);
    private final char[] tmp = new char[10];

    {
        for (int i = 0; i < 31; i++) {
            sortedPowerOf2.add(getSortedString(1 << i));
        }
    }

    public static void main(String[] args) {
        Assertions.assertExpect(true, 46);
        Assertions.assertExpect(true, 1);
    }

    @Test
    public boolean reorderedPowerOf2(int n) {
        return sortedPowerOf2.contains(getSortedString(n));
    }

    private String getSortedString(int n) {
        int i = 0;
        while (n != 0) {
            tmp[i++] = (char) (n % 10 + '0');
            n /= 10;
        }
        Arrays.sort(tmp, 0, i);
        return new String(tmp, 0, i);
    }
}
