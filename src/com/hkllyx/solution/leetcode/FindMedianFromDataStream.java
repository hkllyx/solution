package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;

import java.util.LinkedList;
import java.util.Random;

/**
 * @author xiaoyong3
 * @date 2021/06/28
 */
@Solution(no = "295", difficulty = Difficulty.HARD, url = "https://leetcode-cn.com/problems/find-median-from-data-stream/", failed = true)
public class FindMedianFromDataStream {
    LinkedList<Integer> list = new LinkedList<>();

    public FindMedianFromDataStream() {
    }

    public static void main(String[] args) {
        Random random = new Random(47);
        FindMedianFromDataStream stream = new FindMedianFromDataStream();
        for (int i = 0; i < 10; i++) {
            stream.addNum(random.nextInt(100));
            System.out.print(stream.findMedian());
            System.out.println(stream.list);
        }
    }

    public void addNum(int num) {
        int i = 0;
        for (; i < list.size(); i++) {
            if (list.get(i) >= num) {
                break;
            }
        }
        list.add(i, num);
    }

    public double findMedian() {
        int size = list.size();
        if (size <= 0) {
            return 0;
        }
        int median = size / 2;
        if (size % 2 == 0) {
            return (list.get(median) + list.get(median - 1)) / 2.0;
        } else {
            return list.get(median);
        }
    }
}