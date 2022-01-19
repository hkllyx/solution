package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.info.Status;
import com.hkllyx.solution.util.test.Test;

import java.util.Arrays;

/**
 * <p>给定一个数组 <code>A[0,1,…,n-1]</code>，请构建一个数组 <code>B[0,1,…,n-1]</code>，其中 <code>B[i]</code> 的值是数组 <code>A</code> 中除了下标 <code>i</code> 以外的元素的积, 即 <code>B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]</code>。不能使用除法。</p>
 *
 * <p> </p>
 *
 * <p><strong>示例:</strong></p>
 *
 * <pre>
 * <strong>输入:</strong> [1,2,3,4,5]
 * <strong>输出:</strong> [120,60,40,30,24]</pre>
 *
 * <p> </p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * 	<li>所有元素乘积之和不会溢出 32 位整数</li>
 * 	<li><code>a.length <= 100000</code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>数组</li><li>前缀和</li></div></div><br><div><li>👍 183</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2022/01/19
 */
@Solution(no = "剑指 Offer 66", title = "构建乘积数组", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/gou-jian-cheng-ji-shu-zu-lcof/", status = Status.HELPED)
public class 构建乘积数组 {

    @Test(active = false, value = "超出时间限制")
    public int[] constructArr(int[] a) {
        int len = a.length;
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            int m = 1;
            for (int j = 0; j < len; j++) {
                if (i != j) {
                    m *= a[j];
                }
            }
            res[i] = m;
        }
        return res;
    }

    @Test(value = "结果集中任何一个元素 = 其左边所有元素的乘积 * 其右边所有元素的乘积")
    public int[] constructArr1(int[] a) {
        int len = a.length;
        // 使用DP数组记住两侧乘积
        int[] left = new int[len], right = new int[len];
        left[0] = right[len - 1] = 1;

        for (int i = 1; i < len; i++) {
            left[i] = left[i - 1] * a[i - 1];
        }
        for (int i = len - 2; i >= 0; i--) {
            right[i] = right[i + 1] * a[i + 1];
        }

        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = left[i] * right[i];
        }
        return res;
    }

    @Test(value = "DP，")
    public int[] constructArr2(int[] a) {
        int len = a.length;
        int[] res = new int[len];
        Arrays.fill(res, 1);
        for (int i = 0, left = 1, right = 1; i < len; i++) {
            // 其左边所有元素的乘积，
            res[i] *= left;
            left *= a[i];
            // 其右边所有元素的乘积
            int j = len - i - 1;
            res[j] *= right;
            right *= a[j];
        }
        return res;
    }
}
