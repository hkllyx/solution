package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

/**
 * @author xiaoyong3
 * @date 2021/09/11
 */
@Solution(no = "1894", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/find-the-student-that-will-replace-the-chalk/")
public class FindTheStudentThatWillReplaceTheChalk {

    public static void main(String[] args) {
        Assertions.assertExpect(1, new int[]{3, 4, 1, 2}, 25);
    }

    @Test
    public int chalkReplacer(int[] chalk, int k) {
        // 考虑溢出。。。
        long sum = 0;
        for (int i : chalk) {
            sum += i;
        }
        k %= sum;
        for (int i = 0; i < chalk.length; i++) {
            k -= chalk[i];
            if (k < 0) {
                return i;
            }
        }
        return 0;
    }
}
