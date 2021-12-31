package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;

/**
 * <p>用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 <code>appendTail</code> 和 <code>deleteHead</code> ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，<code>deleteHead</code>&nbsp;操作返回 -1 )</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre><strong>输入：</strong>
 * [&quot;CQueue&quot;,&quot;appendTail&quot;,&quot;deleteHead&quot;,&quot;deleteHead&quot;]
 * [[],[3],[],[]]
 * <strong>输出：</strong>[null,null,3,-1]
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre><strong>输入：</strong>
 * [&quot;CQueue&quot;,&quot;deleteHead&quot;,&quot;appendTail&quot;,&quot;appendTail&quot;,&quot;deleteHead&quot;,&quot;deleteHead&quot;]
 * [[],[],[5],[2],[],[]]
 * <strong>输出：</strong>[null,-1,null,null,5,2]
 * </pre>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= values &lt;= 10000</code></li>
 * <li><code>最多会对&nbsp;appendTail、deleteHead 进行&nbsp;10000&nbsp;次调用</code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>栈</li><li>设计</li><li>队列</li></div></div><br><div><li>👍 391</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2021/05/22
 */
@Solution(no = "剑指 Offer 09", difficulty = Difficulty.SIMPLE, url = "https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/")
public class 用两个栈实现队列 {

    public static class CQueue {
        private final int[] stack1;
        private final int[] stack2;
        private int p1, p2;

        public CQueue() {
            stack1 = new int[10000];
            stack2 = new int[10000];
        }

        public void appendTail(int value) {
            stack1[p1++] = value;
        }

        public int deleteHead() {
            if (p2 == 0) {
                if (p1 == 0) {
                    return -1;
                }
                while (p1 > 0) {
                    stack2[p2++] = stack1[--p1];
                }
            }
            return stack2[--p2];
        }
    }
}
