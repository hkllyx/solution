package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

/**
 * @author hkllyx
 * @date 2021/03/29
 */
@Solution(no = "6", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/zigzag-conversion/")
public class ZigZagConversion {

    public static void main(String[] args) {
        Assertions.assertExpect(ZigZagConversion.class, "PAHNAPLSIIGYIR", "PAYPALISHIRING", 3);
        Assertions.assertExpect(ZigZagConversion.class, "PINALSIGYAHRPI", "PAYPALISHIRING", 4);
    }

    /**
     * 规律：Z 字形周期
     * 第一行和最后一行一个周期只有一个，其他行则有两个
     */
    @Test
    public String convert(String s, int numRows) {
        if (numRows < 2) {
            return s;
        }
        int period = (numRows << 1) - 2;
        char[] dest = new char[s.length()];
        int cur = 0;
        for (int row = 0; row < numRows; row++) {
            int idx = row;
            int dist1 = row << 1; // 当前行在一个周期内有两个节点时，前一周期第二个节点到后一周期第一个节点的距离
            int dist2 = period - dist1; // 一个周期内第二个节点到第一个节点的的距离
            boolean onlyOne = (row == 0) | (row == (numRows - 1)); // 当前行在一个周期内是否只有一个节点
            boolean isFirst = true; // 是否是周期内的第一个节点
            while (idx < s.length()) {
                dest[cur++] = s.charAt(idx);
                idx += onlyOne ? period : isFirst ? dist2 : dist1;
                isFirst = !isFirst;
            }
        }
        return new String(dest);
    }
}
