package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;

import java.util.PriorityQueue;

/**
 * /**
 * <p>The <strong>median</strong> is the middle value in an ordered integer list. If the size of the list is even, there is no middle value and the median is the mean of the two middle values.</p>
 *
 * <ul>
 * 	<li>For example, for <code>arr = [2,3,4]</code>, the median is <code>3</code>.</li>
 * 	<li>For example, for <code>arr = [2,3]</code>, the median is <code>(2 + 3) / 2 = 2.5</code>.</li>
 * </ul>
 *
 * <p>Implement the MedianFinder class:</p>
 *
 * <ul>
 * 	<li><code>MedianFinder()</code> initializes the <code>MedianFinder</code> object.</li>
 * 	<li><code>void addNum(int num)</code> adds the integer <code>num</code> from the data stream to the data structure.</li>
 * 	<li><code>double findMedian()</code> returns the median of all elements so far. Answers within <code>10<sup>-5</sup></code> of the actual answer will be accepted.</li>
 * </ul>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input</strong>
 * [&quot;MedianFinder&quot;, &quot;addNum&quot;, &quot;addNum&quot;, &quot;findMedian&quot;, &quot;addNum&quot;, &quot;findMedian&quot;]
 * [[], [1], [2], [], [3], []]
 * <strong>Output</strong>
 * [null, null, null, 1.5, null, 2.0]
 *
 * <strong>Explanation</strong>
 * MedianFinder medianFinder = new MedianFinder();
 * medianFinder.addNum(1);    // arr = [1]
 * medianFinder.addNum(2);    // arr = [1, 2]
 * medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
 * medianFinder.addNum(3);    // arr[1, 2, 3]
 * medianFinder.findMedian(); // return 2.0
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>-10<sup>5</sup> &lt;= num &lt;= 10<sup>5</sup></code></li>
 * 	<li>There will be at least one element in the data structure before calling <code>findMedian</code>.</li>
 * 	<li>At most <code>5 * 10<sup>4</sup></code> calls will be made to <code>addNum</code> and <code>findMedian</code>.</li>
 * </ul>
 *
 * <p>&nbsp;</p>
 * <p><strong>Follow up:</strong></p>
 *
 * <ul>
 * 	<li>If all integer numbers from the stream are in the range <code>[0, 100]</code>, how would you optimize your solution?</li>
 * 	<li>If <code>99%</code> of all integer numbers from the stream are in the range <code>[0, 100]</code>, how would you optimize your solution?</li>
 * </ul>
 * <div><div>Related Topics</div><div><li>设计</li><li>双指针</li><li>数据流</li><li>排序</li><li>堆（优先队列）</li></div></div><br><div><li>👍 609</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2021/06/28
 */
@Solution(no = "295", difficulty = Difficulty.HARD, url = "https://leetcode-cn.com/problems/find-median-from-data-stream/")
public class FindMedianFromDataStream {

    public static void main(String[] args) {
        MedianFinder finder = new MedianFinder();
        finder.addNum(1);
        finder.addNum(2);
        System.out.println(finder.findMedian());
        finder.addNum(3);
        System.out.println(finder.findMedian());
    }
}

class MedianFinder {
    private final PriorityQueue<Integer> left, right;

    public MedianFinder() {
        left = new PriorityQueue<>((i, j) -> Integer.compare(j, i));
        right = new PriorityQueue<>(Integer::compare);
    }

    public void addNum(int num) {
        if (left.isEmpty()) {
            left.add(num);
        } else if (left.peek() > num) {
            // 左侧 > 右侧，向右侧添加
            if (left.size() > right.size()) {
                right.add(left.poll());
            }
            left.add(num);
        } else {
            right.add(num);
            // 两侧数量相等，右侧添加后 > 左侧，向左侧添加
            if (left.size() < right.size()) {
                left.add(right.poll());
            }
        }
    }

    public double findMedian() {
        if (left.isEmpty()) {
            return 0;
        } else if (left.size() > right.size()) {
            return left.peek();
        } else {
            return (left.peek() + right.peek()) / 2.0;
        }
    }
}