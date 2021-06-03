package com.hkllyx.solution.struct;

import java.util.Objects;
import java.util.StringJoiner;

/**
 *
 * @author hkllyx
 * @date 2021/03/26
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public static ListNode of(int... nodes) {
        if (nodes.length < 1) {
            return new ListNode();
        }
        ListNode head = new ListNode(nodes[0]);
        ListNode refHead = head;
        for (int i = 1; i < nodes.length; i++) {
            refHead.next = new ListNode(nodes[i]);
            refHead = refHead.next;
        }
        return head;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ListNode ol = (ListNode) o;
        if (val != ol.val) {
            return false;
        }
        return Objects.equals(next, ol.next);
    }

    @Override
    public int hashCode() {
        int result = val;
        result = 31 * result + (next != null ? next.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(", ", "[", "]");
        for (ListNode cur = this; cur != null; cur = cur.next) {
            stringJoiner.add(String.valueOf(cur.val));
        }
        return stringJoiner.toString();
    }
}
