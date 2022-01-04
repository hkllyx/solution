package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

/**
 * <p>You are given an array of integers <code>distance</code>.</p>
 *
 * <p>You start at point <code>(0,0)</code> on an <strong>X-Y</strong> plane and you move <code>distance[0]</code> meters to the north, then <code>distance[1]</code> meters to the west, <code>distance[2]</code> meters to the south, <code>distance[3]</code> meters to the east, and so on. In other words, after each move, your direction changes counter-clockwise.</p>
 *
 * <p>Return <code>true</code> if your path crosses itself, and <code>false</code> if it does not.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/03/14/selfcross1-plane.jpg" style="width: 400px; height: 435px;" />
 * <pre>
 * <strong>Input:</strong> distance = [2,1,1,2]
 * <strong>Output:</strong> true
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/03/14/selfcross2-plane.jpg" style="width: 400px; height: 435px;" />
 * <pre>
 * <strong>Input:</strong> distance = [1,2,3,4]
 * <strong>Output:</strong> false
 * </pre>
 *
 * <p><strong>Example 3:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/03/14/selfcross3-plane.jpg" style="width: 400px; height: 435px;" />
 * <pre>
 * <strong>Input:</strong> distance = [1,1,1,1]
 * <strong>Output:</strong> true
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;=&nbsp;distance.length &lt;= 10<sup>5</sup></code></li>
 * 	<li><code>1 &lt;=&nbsp;distance[i] &lt;= 10<sup>5</sup></code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>几何</li><li>数组</li><li>数学</li></div></div><br><div><li>👍 142</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2021/10/29
 */
@Solution(no = "335", difficulty = Difficulty.HARD, url = "https://leetcode-cn.com/problems/self-crossing/")
public class SelfCrossing {

    public static void main(String[] args) {
        Assertions.assertExpect(true, (Object) new int[]{1, 1, 2, 1, 1});
        Assertions.assertExpect(true, (Object) new int[]{2, 1, 3, 2, 2, 1});
        Assertions.assertExpect(true, (Object) new int[]{2, 1, 1, 2});
        Assertions.assertExpect(false, (Object) new int[]{1, 2, 3, 4});
        Assertions.assertExpect(true, (Object) new int[]{1, 1, 1, 1});
    }

    @Test
    public boolean isSelfCrossing(int[] distance) {
        for (int i = 3; i < distance.length; i++) {
            if (isSelfCrossing4(distance, i) || isSelfCrossing5(distance, i) || isSelfCrossing6(distance, i)) {
                return true;
            }
        }
        return false;
    }

    private boolean isSelfCrossing4(int[] distance, int e) {
        // [0] >= [2] && [3] >= [1]
        return e >= 3 && distance[e - 3] >= distance[e - 1] && distance[e] >= distance[e - 2];
    }

    private boolean isSelfCrossing5(int[] distance, int e) {
        // [0] + [4] >= [2] && [1] == [3]
        return e >= 4 && distance[e - 4] + distance[e] >= distance[e - 2] && distance[e - 3] == distance[e - 1];
    }

    private boolean isSelfCrossing6(int[] distance, int e) {
        // [0] >= [2] - [4] >= 0 && [5] >= [3] - [1] >= 0
        int tmp;
        return e >= 5 && distance[e - 5] >= (tmp = distance[e - 3] - distance[e - 1]) && tmp >= 0
                && distance[e] >= (tmp = distance[e - 2] - distance[e - 4]) && tmp >= 0;
    }
}
