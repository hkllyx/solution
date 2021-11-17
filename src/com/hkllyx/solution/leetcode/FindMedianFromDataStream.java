package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;

import java.util.PriorityQueue;

/**
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