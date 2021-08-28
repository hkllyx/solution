package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.Test;
import com.hkllyx.solution.util.TestUtils;
import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.info.Tag;
import com.hkllyx.solution.util.info.Tags;

/**
 * @author xiaoyong3
 * @date 2021/04/21
 */
@Solution(no = "91", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/decode-ways/")
@Tags({Tag.DYNAMIC_PROGRAMMING, Tag.STRING})
public class DecodeWays {

    public static void main(String[] args) {
        TestUtils.assertion(DecodeWays.class, 1, "2101");
        TestUtils.assertion(DecodeWays.class, 1, "120");
        TestUtils.assertion(DecodeWays.class, 1, "101");
        TestUtils.assertion(DecodeWays.class, 3, "1201234");
        TestUtils.assertion(DecodeWays.class, 1, "99");
        TestUtils.assertion(DecodeWays.class, 0, "0");
        TestUtils.assertion(DecodeWays.class, 0, "06");
        TestUtils.assertion(DecodeWays.class, 3, "226");
        TestUtils.assertion(DecodeWays.class, 2, "12");
    }

    @Test
    public int numDecodings(String s) {
        if (s == null || s.isEmpty() || s.charAt(0) == '0') {
            return 0;
        }
        int p0 = 1;
        int p1 = 1;
        for (int i = 1; i < s.length(); i++) {
            char cur = s.charAt(i);
            char pre = s.charAt(i - 1);
            int p2;
            if (cur == '0' && pre != '1' && pre != '2') {
                return 0;
            } else if (cur == '0') {
                p2 = p0;
            } else if ((pre == '1' && (cur >= '1' && cur <= '9')) || (pre == '2' && (cur >= '1' && cur <= '6'))) {
                p2 = p0 + p1;
            } else {
                p2 = p1;
            }
            p0 = p1;
            p1 = p2;
        }
        return p1;
    }
}
