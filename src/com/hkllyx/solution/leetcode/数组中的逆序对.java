package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1:</strong></p>
 *
 * <pre><strong>输入</strong>: [7,5,6,4]
 * <strong>输出</strong>: 5</pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>限制：</strong></p>
 *
 * <p><code>0 &lt;= 数组长度 &lt;= 50000</code></p>
 * <div><div>Related Topics</div><div><li>树状数组</li><li>线段树</li><li>数组</li><li>二分查找</li><li>分治</li><li>有序集合</li><li>归并排序</li></div></div><br><div><li>👍 579</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2022/01/01
 */
@Solution(no = "剑指 Offer 51", difficulty = Difficulty.HARD, url = "https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/")
public class 数组中的逆序对 {

    public static void main(String[] args) {
        Assertions.assertExpect(5, (Object) new int[] {7, 5, 6, 4});
    }

    @Test(value = "超出时间限制", active = false)
    public int reversePairs(int[] nums) {
        int res = 0;
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
                if (entry.getKey() > num) {
                    res += entry.getValue();
                }
            }
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        return res;
    }

    @Test(value = "归并排序思想", active = false)
    public int reversePairs1(int[] nums) {
        return divideAndConquer(nums, 0, nums.length);
    }

    /** 归并排序 包括from，但不包括to */
    private int divideAndConquer(int[] nums, int from, int to) {
        int res = 0;
        if (to - from <= 1) {
            return res;
        }
        // 二分
        int divide = (from + to) >> 1;
        res += divideAndConquer(nums, from, divide);
        res += divideAndConquer(nums, divide, to);
        // 拷贝
        int lLen = divide - from, rLen = to - divide;
        int[] lArr = new int[lLen], rArr = new int[rLen];
        System.arraycopy(nums, from, lArr, 0, lLen);
        System.arraycopy(nums, divide, rArr, 0, rLen);
        // 归并排序
        int l = 0, r = 0, i = from;
        while (l < lLen || r < rLen) {
            if (l < lLen && r < rLen) {
                if (lArr[l] <= rArr[r]) {
                    nums[i++] = lArr[l++];
                } else {
                    nums[i++] = rArr[r++];
                    // 说明lArr[l]及之后的数，都大于rArr[r]
                    res += (lLen - l);
                }
            } else if (l < lLen) {
                System.arraycopy(lArr, l, nums, i, lLen - l);
                l = lLen;
            } else {
                System.arraycopy(rArr, r, nums, i, rLen - r);
                r = rLen;
            }
        }
        return res;
    }

    @Test(value = "归并排序思想 + 优化")
    public int reversePairs2(int[] nums) {
        return divideAndConquer2(nums, new int[nums.length], 0, nums.length);
    }

    /** 使用一个tmp[]减少重复创建数组 */
    private int divideAndConquer2(int[] nums, int[] tmp, int from, int to) {
        int res = 0;
        if (to - from <= 1) {
            return res;
        }
        // 二分
        int divide = (from + to) >> 1;
        res += divideAndConquer2(nums, tmp, from, divide);
        res += divideAndConquer2(nums, tmp, divide, to);
        // 拷贝
        System.arraycopy(nums, from, tmp, from, divide - from);
        System.arraycopy(nums, divide, tmp, divide, to - divide);
        // 归并排序
        int i = from, j = divide, k = from;
        while (i < divide || j < to) {
            if (i < divide && j < to) {
                if (tmp[i] <= tmp[j]) {
                    nums[k++] = tmp[i++];
                } else {
                    nums[k++] = tmp[j++];
                    // 说明tmp[i] ~ tmp[divide - 1]的数，都大于tmp[j]
                    res += (divide - i);
                }
            } else if (i < divide) {
                System.arraycopy(tmp, i, nums, k, divide - i);
                i = divide;
            } else {
                System.arraycopy(tmp, j, nums, k, to - j);
                j = to;
            }
        }
        return res;
    }
}
