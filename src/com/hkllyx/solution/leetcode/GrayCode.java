package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>An <strong>n-bit gray code sequence</strong> is a sequence of <code>2<sup>n</sup></code> integers where:</p>
 *
 * <ul>
 *  <li>Every integer is in the <strong>inclusive</strong> range <code>[0, 2<sup>n</sup> - 1]</code>,</li>
 *  <li>The first integer is <code>0</code>,</li>
 *  <li>An integer appears <strong>no more than once</strong> in the sequence,</li>
 *  <li>The binary representation of every pair of <strong>adjacent</strong> integers differs by <strong>exactly one bit</strong>, and</li>
 *  <li>The binary representation of the <strong>first</strong> and <strong>last</strong> integers differs by <strong>exactly one bit</strong>.</li>
 * </ul>
 *
 * <p>Given an integer <code>n</code>, return <em>any valid <strong>n-bit gray code sequence</strong></em>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> n = 2
 * <strong>Output:</strong> [0,1,3,2]
 * <strong>Explanation:</strong>
 * The binary representation of [0,1,3,2] is [00,01,11,10].
 * - 0<u>0</u> and 0<u>1</u> differ by one bit
 * - <u>0</u>1 and <u>1</u>1 differ by one bit
 * - 1<u>1</u> and 1<u>0</u> differ by one bit
 * - <u>1</u>0 and <u>0</u>0 differ by one bit
 * [0,2,3,1] is also a valid gray code sequence, whose binary representation is [00,10,11,01].
 * - <u>0</u>0 and <u>1</u>0 differ by one bit
 * - 1<u>0</u> and 1<u>1</u> differ by one bit
 * - <u>1</u>1 and <u>0</u>1 differ by one bit
 * - 0<u>1</u> and 0<u>0</u> differ by one bit
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> n = 1
 * <strong>Output:</strong> [0,1]
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 *  <li><code>1 &lt;= n &lt;= 16</code></li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>位运算</li><li>数学</li><li>回溯</li></div></div><br><div><li>👍 526</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2022/07/28
 */
@Solution(no = "89", title = "Gray Code", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/gray-code/")
public class GrayCode {

    public static void main(String[] args) {
        Assertions.assertExpect(Arrays.asList(0, 1, 3, 2), 2);
    }

    @Test(active = false)
    public List<Integer> grayCode(int n) {
        int num = 1 << n;
        List<Integer> res = new ArrayList<>(num);
        res.add(0);
        boolean[] trace = new boolean[num];
        trace[0] = true;
        dfs(res, trace, 1);
        return res;
    }

    private boolean dfs(List<Integer> res, boolean[] trace, int level) {
        if (level == trace.length) {
            return true;
        }
        int prev = res.get(level - 1);
        for (int i = 1; i < trace.length; i <<= 1) {
            // 0 ^ 1 = 1，1 ^ 1 = 0 可以有效获得某一位相反的数
            int cur = prev ^ i;
            if (!trace[cur]) {
                trace[cur] = true;
                res.add(cur);
                // 可行
                if (dfs(res, trace, level + 1)) {
                    return true;
                }
                // 不可行，恢复
                trace[cur] = false;
                res.remove(level);
            }
        }
        return false;
    }

    @Test(value = "无聊的二进制技巧", helped = true)
    public List<Integer> grayCode1(int n) {
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < 1 << n; i++) {
            ret.add((i >> 1) ^ i);
        }
        return ret;
    }
}
