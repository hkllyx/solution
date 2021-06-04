package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.info.Difficulty;
import com.hkllyx.solution.info.Solution;
import com.hkllyx.solution.util.Test;
import com.hkllyx.solution.util.TestUtils;

/**
 * @author xiaoyong3
 * @date 2021/04/28
 */
@Solution(no = "11", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/container-with-most-water/")
public class ContainerWithMostWater {

    public static void main(String[] args) {
        TestUtils.assertion(ContainerWithMostWater.class, 2, new int[]{1, 2, 1});
        TestUtils.assertion(ContainerWithMostWater.class, 16, new int[]{4, 3, 2, 1, 4});
        TestUtils.assertion(ContainerWithMostWater.class, 1, new int[]{1, 1});
        TestUtils.assertion(ContainerWithMostWater.class, 49, new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
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
