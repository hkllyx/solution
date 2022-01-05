package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>输入一个正整数 <code>target</code> ，输出所有和为 <code>target</code> 的连续正整数序列（至少含有两个数）。</p>
 *
 * <p>序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre><strong>输入：</strong>target = 9
 * <strong>输出：</strong>[[2,3,4],[4,5]]
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre><strong>输入：</strong>target = 15
 * <strong>输出：</strong>[[1,2,3,4,5],[4,5,6],[7,8]]
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>限制：</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= target &lt;= 10^5</code></li>
 * </ul>
 *
 * <p>&nbsp;</p>
 * <div><div>Related Topics</div><div><li>数学</li><li>双指针</li><li>枚举</li></div></div><br><div><li>👍 357</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2022/01/04
 */
@Solution(no = "剑指 Offer 57 - II", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/")
public class 和为s的连续正数序列 {

    @Test(value = "数学方法 + 枚举")
    public int[][] findContinuousSequence(int target) {
        if (target < 3) {
            return new int[0][0];
        }
        List<int[]> res = new ArrayList<>();
        // x, x + 1, ..., x + n = (2x + n) * (n + 1) / 2 = target, 其中x > 0, n > 0
        // x和n成反比，当n = 1时x取得最大，此时x = (target - 1) / 2, x + 1 = (target + 1) / 2
        int ceil = (target + 1) >> 1;
        // 递增数组用于复制tmp[i] = i
        int[] tmp = new int[ceil + 2];
        for (int i = 1; i < tmp.length; i++) {
            tmp[i] = i;
        }
        target <<= 1;
        // x = ((2 * target / (n + 1)) - n) / 2
        for (int n = ceil; n > 0; n--) {
            int mod = target % (n + 1);
            if (mod != 0) {
                continue;
            }
            int x = target / (n + 1) - n;
            if (x <= 0 || (x & 1) != 0) {
                continue;
            }
            x >>= 1;
            res.add(Arrays.copyOfRange(tmp, x, x + n + 1));
        }
        return res.toArray(new int[res.size()][]);
    }

    @Test(value = "双指针")
    public int[][] findContinuousSequence1(int target) {
        List<int[]> vec = new ArrayList<>();
        for (int l = 1, r = 2; l < r;) {
            int sum = (l + r) * (r - l + 1) / 2;
            if (sum == target) {
                int[] res = new int[r - l + 1];
                for (int i = l; i <= r; ++i) {
                    res[i - l] = i;
                }
                vec.add(res);
                l++;
            } else if (sum < target) {
                r++;
            } else {
                l++;
            }
        }
        return vec.toArray(new int[vec.size()][]);
    }
}
