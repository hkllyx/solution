package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Test;
import com.hkllyx.solution.util.test.TestUtils;

import java.util.Arrays;

/**
 * @author hkllyx
 * @date 2021/03/29
 */
@Solution(no = "767", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/reorganize-string/")
public class ReorganizeString {

    public static void main(String[] args) {
        TestUtils.assertion(ReorganizeString.class, "", "bbbbbbb");
        TestUtils.assertion(ReorganizeString.class, "babab", "baabb");
        TestUtils.assertion(ReorganizeString.class, "vlvov", "vvvlo");
        TestUtils.assertion(ReorganizeString.class, "", "aabbaa");
    }

    @Test
    public String reorganizeString(String s) {
        if (s.length() < 3) {
            return s;
        }
        char[] src = s.toCharArray();
        Arrays.sort(src);
        boolean half = false;
        char hc = 0;
        int count = 1;
        for (int i = 1; i < src.length; i++) {
            if (src[i] == src[i - 1]) {
                count++;
                // 超过一半 (3 << 1) > (4 + 1), (4 << 1) > (5 + 1)
                if (count << 1 > src.length + 1) {
                    return "";
                }
                // 一半 (2 << 1) = 4, (3 << 1) > 5
                if (count << 1 >= src.length) {
                    half = true;
                    hc = src[i];
                }
            } else {
                count = 1;
            }
        }
        char[] dest = new char[src.length];
        int k = 0;
        for (int i = 0; i < dest.length; i += 2) {
            dest[i] = half ? hc : src[k++];
        }
        for (int i = 1; i < dest.length; i += 2) {
            char cc = src[k++];
            if (half) {
                while (cc == hc) {
                    cc = src[k++];
                }
            }
            dest[i] = cc;
        }
        return new String(dest);
    }
}
