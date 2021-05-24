package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.info.Difficulty;
import com.hkllyx.solution.info.Solution;
import com.hkllyx.solution.struct.ListNode;

/**
 * @author xiaoyong3
 * @date 2021/05/22
 */
@Solution(no = "剑指 Offer 06", difficulty = Difficulty.SIMPLE, url = "https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/")
public class 从尾到头打印链表 {

    public int[] reversePrint(ListNode head) {
        int len = 0;
        for (ListNode node = head; node != null; node = node.next) {
            len++;
        }
        int[] res = new int[len];
        for (ListNode node = head; node != null; node = node.next) {
            res[--len] = node.val;
        }
        return res;
    }
}
