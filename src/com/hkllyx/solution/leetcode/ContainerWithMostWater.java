package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

/**
 * <p>You are given an integer array <code>height</code> of length <code>n</code>. There are <code>n</code> vertical lines drawn such that the two endpoints of the <code>i<sup>th</sup></code> line are <code>(i, 0)</code> and <code>(i, height[i])</code>.</p>
 *
 * <p>Find two lines that together with the x-axis form a container, such that the container contains the most water.</p>
 *
 * <p>Return <em>the maximum amount of water a container can store</em>.</p>
 *
 * <p><strong>Notice</strong> that you may not slant the container.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 * <img alt="" src="https://s3-lc-upload.s3.amazonaws.com/uploads/2018/07/17/question_11.jpg" style="width: 600px; height: 287px;" />
 * <pre>
 * <strong>Input:</strong> height = [1,8,6,2,5,4,8,3,7]
 * <strong>Output:</strong> 49
 * <strong>Explanation:</strong> The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> height = [1,1]
 * <strong>Output:</strong> 1
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>n == height.length</code></li>
 * 	<li><code>2 &lt;= n &lt;= 10<sup>5</sup></code></li>
 * 	<li><code>0 &lt;= height[i] &lt;= 10<sup>4</sup></code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>贪心</li><li>数组</li><li>双指针</li></div></div><br><div><li>👍 3073</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2021/04/28
 */
@Solution(no = "11", title = "Container With Most Water", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/container-with-most-water/")
public class ContainerWithMostWater {

    public static void main(String[] args) {
        Assertions.assertExpect(ContainerWithMostWater.class, 2, (Object) new int[]{1, 2, 1});
        Assertions.assertExpect(ContainerWithMostWater.class, 16, (Object) new int[]{4, 3, 2, 1, 4});
        Assertions.assertExpect(ContainerWithMostWater.class, 1, (Object) new int[]{1, 1});
        Assertions.assertExpect(ContainerWithMostWater.class, 49, (Object) new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
    }

    /**
     * 双重 for 循环
     */
    @Test
    public int maxArea1(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                max = Math.max(max, Math.min(height[i], height[j]) * (j - i));
            }
        }
        return max;
    }

    /**
     * 如果想要l + 1 ~ r的体积 > l ~ r的体积，只能是前者的高度高于后者
     *
     * @deprecated 超时了。。
     */
    @Deprecated
    public int maxArea2(int[] height) {
        return max(height, 0, height.length - 1);
    }

    private int max(int[] height, int l, int r) {
        if (l >= r) {
            return 0;
        }
        int res = Math.min(height[l], height[r]) * (r - l);
        if (height[l] > height[r]) {
            while (l < r && height[r] > height[--r]) {
            }
            return Math.max(res, max(height, l, r));
        } else if (height[l] < height[r]) {
            while (l < r && height[l] > height[++l]) {
            }
            return Math.max(res, max(height, l, r));
        } else {
            int nr = r;
            while (l < nr && height[nr] > height[--nr]) {
            }
            res = Math.max(res, max(height, l, nr));
            int nl = l;
            while (nl < r && height[nl] > height[++nl]) {
            }
            return Math.max(res, max(height, nl, r));
        }
    }

    /**
     * 同理但粗暴，不过咋保证的，贪心算法真离谱
     */
    @Test
    public int maxArea3(int[] height) {
        int res = 0;
        int l = 0, r = height.length - 1;
        while (l < r) {
            int tmp = (r - l);
            if (height[l] > height[r]) {
                tmp *= height[r--];
            } else {
                tmp *= height[l++];
            }
            if (tmp > res) {
                res = tmp;
            }
        }
        return res;
    }
}
