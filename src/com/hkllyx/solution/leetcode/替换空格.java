package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;

/**
 * @author xiaoyong3
 * @date 2021/05/22
 */
@Solution(no = "剑指 Offer 05", difficulty = Difficulty.SIMPLE, url = "https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/")
public class 替换空格 {

    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder(s.length());
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
