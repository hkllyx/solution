package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.info.Difficulty;
import com.hkllyx.solution.info.Solution;
import com.hkllyx.solution.util.Test;
import com.hkllyx.solution.util.TestUtils;

/**
 * @author hkllyx
 * @date 2021/03/24
 */
@Solution(no = 1717, difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/maximum-score-from-removing-substrings/")
public class MaximumScoreFromRemovingSubstrings {

    public static void main(String[] args) {
        TestUtils.assertion(MaximumScoreFromRemovingSubstrings.class, 19, "cdbcbbaaabab", 4, 5);
        TestUtils.assertion(MaximumScoreFromRemovingSubstrings.class, 20, "aabbaaxybbaabb", 5, 4);
    }

    /**
     * 贪心算法：每次都认为先删除更高分的子字符串未最优解<br/>
     * 全局最优保证：无论是怎么匹配 "ab"、"ba"，匹配的次数都是一样多的<br/>
     * 缺点：String.subString() 耗时长导致超时，后者也耗费空间
     */
    @Test
    public int maximumGain1(String s, int x, int y) {
        int gain = 0;
        String gs;
        String ls;
        if (x > y) {
            gs = "ab";
            ls = "ba";
        } else {
            gs = "ba";
            ls = "ab";
            int tmp = x;
            x = y;
            y = tmp;
        }
        boolean flag = true;
        int index = -1;
        do {
            index = s.indexOf(gs, index);
            if (index < 0) {
                index = s.indexOf(ls, index);
                if (index < 0) {
                    flag = false;
                } else {
                    gain += y;
                    s = s.substring(0, index) + s.substring(index + 2);
                }
            } else {
                gain += x;
                s = s.substring(0, index) + s.substring(index + 2);
            }
            // 防止 "aabb" 这种匹配了 "ab" 后 index 为 1，后续匹配不到 "ab" 的可能
            index--;
        } while (flag);
        return gain;
    }

    /**
     * 基于 Solution1， 使用 System.arraycopy() 代替 subString() 减少消耗
     */
    @Test
    public int maximumGain2(String s, int x, int y) {
        int gain = 0;
        char leader;
        char follower;
        if (x > y) {
            leader = 'a';
            follower = 'b';
        } else {
            leader = 'b';
            follower = 'a';
            int tmp = x;
            x = y;
            y = tmp;
        }
        char[] cs = s.toCharArray();
        int end = cs.length;
        int cur = 0;
        while (cur + 1 < end) {
            if (cs[cur] == leader && cs[cur + 1] == follower) {
                gain += x;
                end -= 2;
                System.arraycopy(cs, cur + 2, cs, cur, end - cur);
                if (cur > 0) {
                    // 防止 "aabb" 这种匹配了 "ab" 后 cur 为 1，后续匹配不到 "ab" 的可能
                    cur--;
                }
            } else {
                cur++;
            }
        }
        cur = 0;
        while (cur + 1 < end) {
            if (cs[cur] == follower && cs[cur + 1] == leader) {
                gain += y;
                end -= 2;
                System.arraycopy(cs, cur + 2, cs, cur, end - cur);
                if (cur > 0) {
                    // 防止 "aabb" 这种匹配了 "ab" 后 cur 为 1，后续匹配不到 "ab" 的可能
                    cur--;
                }
            } else {
                cur++;
            }
        }
        return gain;
    }

    /**
     * 最佳
     */
    @Test
    public int maximumGain3(String s, int x, int y) {
        int gain = 0;
        char a = 'a';
        char b = 'b';
        if (x < y) {
            a = 'b';
            b = 'a';
            int tmp = x;
            x = y;
            y = tmp;
        }
        int ac = 0;
        int bc = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 如果当前字符是 b
            if (c == b) {
                // 如果前面已经有 a 了，就可以组成 ab 加 x 分
                // 这一步也可以保证当前 a、b 连续片段中出现的 ab 立马被消除（一出现 b，但前面有 a，a 一定是在 i - 1 位，这样就可以消除 ab）
                if (ac > 0) {
                    gain += x;
                    ac--;
                } else {
                    bc++;
                }
            } else if (c == a) {
                ac++;
            } else {
                // a、b 连续片段结束，前面保证 ab 被消除，所以只可能剩下 ba
                gain += Math.min(ac, bc) * y;
                ac = bc = 0;
            }
        }
        // 将最后 a、b 连续片段搞定
        gain += Math.min(ac, bc) * y;
        return gain;
    }
}