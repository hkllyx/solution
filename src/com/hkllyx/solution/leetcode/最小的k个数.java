package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.ops.ArrayOps;
import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

import java.util.Arrays;

/**
 * <p>输入整数数组 <code>arr</code> ，找出其中最小的 <code>k</code> 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre><strong>输入：</strong>arr = [3,2,1], k = 2
 * <strong>输出：</strong>[1,2] 或者 [2,1]
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre><strong>输入：</strong>arr = [0,1,2,1], k = 1
 * <strong>输出：</strong>[0]</pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>限制：</strong></p>
 *
 * <ul>
 * 	<li><code>0 &lt;= k &lt;= arr.length &lt;= 10000</code></li>
 * 	<li><code>0 &lt;= arr[i]&nbsp;&lt;= 10000</code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>数组</li><li>分治</li><li>快速选择</li><li>排序</li><li>堆（优先队列）</li></div></div><br><div><li>👍 339</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2021/06/28
 */
@Solution(no = "剑指 Offer 40", title = "最小的k个数", difficulty = Difficulty.EASY, url = "https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/")
public class 最小的k个数 implements ArrayOps {

    public static void main(String[] args) {
        Assertions.assertExpect(最小的k个数.class,
                new int[]{},
                new int[]{3, 2, 1},
                2);
    }

    /** 选择 */
    @Deprecated
    public int[] getLeastNumbers(int[] arr, int k) {
        for (int i = 0; i < k; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    swap(arr, i, j);
                }
            }
        }
        return Arrays.copyOf(arr, k);
    }

    /** 完整快排 */
    public int[] getLeastNumbers1(int[] arr, int k) {
        quickSort(arr, 0, arr.length - 1);
        return Arrays.copyOf(arr, k);
    }

    private void quickSort(int[] arr, int l, int r) {
        if (r - l < 1) {
            return;
        }
        int i = l;
        for (int j = l; j < r; j++) {
            if (arr[j] < arr[r]) {
                swap(arr, i++, j);
            }
        }
        swap(arr, i, r);
        quickSort(arr, l, i - 1);
        quickSort(arr, i + 1, r);
    }

    /** 快排变形 */
    @Test
    public int[] getLeastNumbers2(int[] arr, int k) {
        int l = 0, r = arr.length - 1, p = 0;
        while (k != p) {
            p = partition(arr, l, r);
            if (p < k) {
                l = p + 1;
            } else {
                r = p - 1;
            }
        }
        return Arrays.copyOf(arr, k);
    }

    private int partition(int[] arr, int l, int r) {
        if (l >= r) {
            return l;
        }
        int i = l;
        for (int j = l; j < r; j++) {
            if (arr[j] < arr[r]) {
                swap(arr, i++, j);
            }
        }
        swap(arr, i, r);
        return i;
    }
}
