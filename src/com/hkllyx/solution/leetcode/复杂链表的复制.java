package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xiaoyong3
 * @date 2021/06/28
 */
@Solution(no = "剑指Offer 35", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/")
public class 复杂链表的复制 {

    public Node copyRandomList(Node head) {
        Node sentinel = new Node(0);
        Node pre = sentinel;
        Map<Node, Node> map = new HashMap<>();
        while (head != null) {
            Node cur = new Node(head.val);
            cur.random = head.random;
            pre.next = cur;
            map.put(head, cur);
            pre = cur;
            head = head.next;
        }
        pre = sentinel.next;
        while (pre != null) {
            if (pre.random != null) {
                pre.random = map.get(pre.random);
            }
            pre = pre.next;
        }
        return sentinel.next;
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
