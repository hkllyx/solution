package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>Alice has <code>n</code> candies, where the <code>i<sup>th</sup></code> candy is of type <code>candyType[i]</code>. Alice noticed that she started to gain weight, so she visited a doctor.</p>
 *
 * <p>The doctor advised Alice to only eat <code>n / 2</code> of the candies she has (<code>n</code> is always even). Alice likes her candies very much, and she wants to eat the maximum number of different types of candies while still following the doctor&#39;s advice.</p>
 *
 * <p>Given the integer array <code>candyType</code> of length <code>n</code>, return <em>the <strong>maximum</strong> number of different types of candies she can eat if she only eats </em><code>n / 2</code><em> of them</em>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> candyType = [1,1,2,2,3,3]
 * <strong>Output:</strong> 3
 * <strong>Explanation:</strong> Alice can only eat 6 / 2 = 3 candies. Since there are only 3 types, she can eat one of each type.
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> candyType = [1,1,2,3]
 * <strong>Output:</strong> 2
 * <strong>Explanation:</strong> Alice can only eat 4 / 2 = 2 candies. Whether she eats types [1,2], [1,3], or [2,3], she still can only eat 2 different types.
 * </pre>
 *
 * <p><strong>Example 3:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> candyType = [6,6,6,6]
 * <strong>Output:</strong> 1
 * <strong>Explanation:</strong> Alice can only eat 4 / 2 = 2 candies. Even though she can eat 2 candies, she only has 1 type.
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>n == candyType.length</code></li>
 * 	<li><code>2 &lt;= n &lt;= 10<sup>4</sup></code></li>
 * 	<li><code>n</code>&nbsp;is even.</li>
 * 	<li><code>-10<sup>5</sup> &lt;= candyType[i] &lt;= 10<sup>5</sup></code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>数组</li><li>哈希表</li></div></div><br><div><li>👍 196</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2021/11/01
 */
@Solution(no = "575", difficulty = Difficulty.EASY, url = "https://leetcode-cn.com/problems/distribute-candies/")
public class DistributeCandies {

    public int distributeCandies(int[] candyType) {
        int limit = candyType.length >> 1;
        Set<Integer> unique = new HashSet<>(limit);
        for (int type : candyType) {
            if (unique.size() >= limit) {
                return limit;
            }
            unique.add(type);
        }
        return unique.size();
    }
}
