package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>请实现 <code>copyRandomList</code> 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 <code>next</code> 指针指向下一个节点，还有一个 <code>random</code> 指针指向链表中的任意节点或者 <code>null</code>。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/01/09/e1.png"></p>
 *
 * <pre><strong>输入：</strong>head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * <strong>输出：</strong>[[7,null],[13,0],[11,4],[10,2],[1,0]]
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/01/09/e2.png"></p>
 *
 * <pre><strong>输入：</strong>head = [[1,1],[2,1]]
 * <strong>输出：</strong>[[1,1],[2,1]]
 * </pre>
 *
 * <p><strong>示例 3：</strong></p>
 *
 * <p><strong><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/01/09/e3.png"></strong></p>
 *
 * <pre><strong>输入：</strong>head = [[3,null],[3,0],[3,null]]
 * <strong>输出：</strong>[[3,null],[3,0],[3,null]]
 * </pre>
 *
 * <p><strong>示例 4：</strong></p>
 *
 * <pre><strong>输入：</strong>head = []
 * <strong>输出：</strong>[]
 * <strong>解释：</strong>给定的链表为空（空指针），因此返回 null。
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * 	<li><code>-10000 &lt;= Node.val &lt;= 10000</code></li>
 * 	<li><code>Node.random</code>&nbsp;为空（null）或指向链表中的节点。</li>
 * 	<li>节点数目不超过 1000 。</li>
 * </ul>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>注意：</strong>本题与主站 138 题相同：<a href="https://leetcode-cn.com/problems/copy-list-with-random-pointer/">https://leetcode-cn.com/problems/copy-list-with-random-pointer/</a></p>
 *
 * <p>&nbsp;</p>
 * <div><div>Related Topics</div><div><li>哈希表</li><li>链表</li></div></div><br><div><li>👍 374</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2021/06/28
 */
@Solution(no = "剑指 Offer 35", title = "复杂链表的复制", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/")
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
