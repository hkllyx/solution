package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;

/**
 * <p>Given two sorted arrays <code>nums1</code> and <code>nums2</code> of size <code>m</code> and <code>n</code> respectively, return <strong>the median</strong> of the two sorted arrays.</p>
 *
 * <p>The overall run time complexity should be <code>O(log (m+n))</code>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> nums1 = [1,3], nums2 = [2]
 * <strong>Output:</strong> 2.00000
 * <strong>Explanation:</strong> merged array = [1,2,3] and median is 2.
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> nums1 = [1,2], nums2 = [3,4]
 * <strong>Output:</strong> 2.50000
 * <strong>Explanation:</strong> merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>nums1.length == m</code></li>
 * 	<li><code>nums2.length == n</code></li>
 * 	<li><code>0 &lt;= m &lt;= 1000</code></li>
 * 	<li><code>0 &lt;= n &lt;= 1000</code></li>
 * 	<li><code>1 &lt;= m + n &lt;= 2000</code></li>
 * 	<li><code>-10<sup>6</sup> &lt;= nums1[i], nums2[i] &lt;= 10<sup>6</sup></code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>数组</li><li>二分查找</li><li>分治</li></div></div><br><div><li>👍 4900</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2022/01/22
 */
@Solution(no = "4", title = "Median of Two Sorted Arrays", difficulty = Difficulty.HARD, url = "https://leetcode-cn.com/problems/median-of-two-sorted-arrays/")
public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length, len = len1 + len2, half = len >> 1;
        boolean even = (len & 1) == 0;
        int i = 0, j = 0, k = 0, pre = 0, cur = 0;
        while (k++ <= half) {
            pre = cur;
            cur = (i < len1 && j < len2 ? nums1[i] < nums2[j] : i < len1) ? nums1[i++] : nums2[j++];
        }
        return (len & 1) == 1 ? cur : (pre + cur) / 2.0;
    }
}
