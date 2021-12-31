package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.struct.ListNode;

/**
 * <p>输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre><strong>输入：</strong>head = [1,3,2]
 * <strong>输出：</strong>[2,3,1]</pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>限制：</strong></p>
 *
 * <p><code>0 &lt;= 链表长度 &lt;= 10000</code></p>
 * <div><div>Related Topics</div><div><li>栈</li><li>递归</li><li>链表</li><li>双指针</li></div></div><br><div><li>👍 220</li><li>👎 0</li></div>
 *
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
