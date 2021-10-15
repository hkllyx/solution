package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaoyong3
 * @date 2021/10/13
 */
@Solution(no = "412", difficulty = Difficulty.SIMPLE, url = "https://leetcode-cn.com/problems/fizz-buzz/")
public class FizzBuzz {

    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) {
                res.add("FizzBuzz");
            } else if (i % 5 == 0) {
                res.add("Buzz");
            } else if (i % 3 == 0) {
                res.add("Fizz");
            } else {
                res.add(Integer.toString(i));
            }
        }
        return res;
    }
}
