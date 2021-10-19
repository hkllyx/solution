package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.info.Status;

/**
 * @author hkllyx
 * @date 2021-10-16
 */
@Solution(no = "282", difficulty = Difficulty.HARD, url = "https://leetcode-cn.com/problems/expression-add-operators/", status = Status.FAILED)
public class ExpressionAddOperators {

    // public List<String> addOperators(String num, int target) {
    //     List<String> res = new LinkedList<>();
    //     dfs(res, num, 0, new char[(num.length() << 1) - 1], 0, 0, 0, target);
    //     return res;
    // }
    //
    // private void dfs(List<String> res, String num, int index, char[] arr, int arrLen, int preTarget, int preNum,int operatorType, int target) {
    //     if (index == num.length() - 1) {
    //         if (preTarget == target) {
    //             res.add(new String(arr, 0, arrLen));
    //         }
    //         return;
    //     }
    //     char cur = num.charAt(index);
    //     if (preT)
    // }
}
