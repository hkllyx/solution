package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xiaoyong3
 * @date 2021/10/13
 */
@Solution(no = "22", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/generate-parentheses/")
public class GenerateParentheses {

    public static void main(String[] args) {
        Assertions.assertExpect(Arrays.asList("((()))", "(()())", "(())()", "()(())", "()()()"), 3);
        Assertions.assertExpect(Collections.singletonList("()"), 1);
    }

    @Test(value = "DFS", mills = 0, space = 38.7)
    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();
        char[] arr = new char[n << 1];
        Arrays.fill(arr, ')');
        dfs(res, arr, 0, 0, n);
        return res;
    }

    /**
     * @param res   结果
     * @param arr   数组
     * @param index 数则下标
     * @param open  剩余未和')'匹配的'('的数量，大于0的时候才允许放')'
     * @param left  剩余未使用的'('数量
     */
    private void dfs(List<String> res, char[] arr, int index, int open, int left) {
        if (left == 0) {
            res.add(new String(arr));
            return;
        }
        if (open > 0) {
            dfs(res, arr, index + 1, open - 1, left);
        }
        arr[index] = '(';
        dfs(res, arr, index + 1, open + 1, left - 1);
        arr[index] = ')';
    }

    @Test(value = "DP", active = false, mills = 21)
    public List<String> generateParenthesis1(int n) {
        List<String> result = new LinkedList<>();
        if (n == 0) {
            return result;
        }
        if (n == 1) {
            result.add("()");
            return result;
        }
        List<String> previous = generateParenthesis1(n - 1);
        for (String cur : previous) {
            for (int j = cur.length() / 2; j <= cur.length(); j++) {
                String tmp = cur.substring(0, j) + "()" + cur.substring(j);
                result.remove(tmp);
                result.add(tmp);
            }
        }
        return result;
    }
}
