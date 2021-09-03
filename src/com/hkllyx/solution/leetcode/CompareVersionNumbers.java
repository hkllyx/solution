package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Test;
import com.hkllyx.solution.util.test.TestUtils;

/**
 * @author xiaoyong3
 * @date 2021/09/01
 */
@Solution(no = "165", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/compare-version-numbers/")
public class CompareVersionNumbers {
    public static void main(String[] args) {
        TestUtils.assertion(0, "1.01", "1.001");
        TestUtils.assertion(0, "1.0", "1.0.0");
        TestUtils.assertion(-1, "0.1", "1.1");
        TestUtils.assertion(1, "1.0.1", "1");
    }

    @Test
    public int compareVersion(String version1, String version2) {
        return compare(version1, version1.length(), 0, version2, version2.length(), 0);
    }

    private int compare(String version1, int l1, int i1, String version2, int l2, int i2) {
        if (l1 <= i1 && l2 <= i2) {
            return 0;
        }
        int sv1 = 0, sv2 = 0;
        for (char c; i1 < l1 && (c = version1.charAt(i1)) != '.'; i1++) {
            sv1 = sv1 * 10 + c - '0';
        }
        for (char c; i2 < l2 && (c = version2.charAt(i2)) != '.'; i2++) {
            sv2 = sv2 * 10 + c - '0';
        }
        int compare = Integer.compare(sv1, sv2);
        return compare == 0 ? compare(version1, l1, i1 + 1, version2, l2, i2 + 1) : compare;
    }
}
