package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.info.Status;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * <p>请定义一个队列并实现函数 <code>max_value</code> 得到队列里的最大值，要求函数<code>max_value</code>、<code>push_back</code> 和 <code>pop_front</code> 的<strong>均摊</strong>时间复杂度都是O(1)。</p>
 *
 * <p>若队列为空，<code>pop_front</code> 和 <code>max_value</code>&nbsp;需要返回 -1</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre><strong>输入:</strong>
 * [&quot;MaxQueue&quot;,&quot;push_back&quot;,&quot;push_back&quot;,&quot;max_value&quot;,&quot;pop_front&quot;,&quot;max_value&quot;]
 * [[],[1],[2],[],[],[]]
 * <strong>输出:&nbsp;</strong>[null,null,null,2,1,2]
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre><strong>输入:</strong>
 * [&quot;MaxQueue&quot;,&quot;pop_front&quot;,&quot;max_value&quot;]
 * [[],[],[]]
 * <strong>输出:&nbsp;</strong>[null,-1,-1]
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>限制：</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= push_back,pop_front,max_value的总操作数&nbsp;&lt;= 10000</code></li>
 * 	<li><code>1 &lt;= value &lt;= 10^5</code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>设计</li><li>队列</li><li>单调队列</li></div></div><br><div><li>👍 302</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2022/01/07
 */
@Solution(no = "剑指 Offer 59 - II", title = "队列的最大值", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof/", status = Status.FAILED)
public class 队列的最大值 {
}

class MaxQueue {
    private final Queue<Integer> data = new LinkedList<>();
    private final Deque<Integer> max = new LinkedList<>();

    public MaxQueue() {
    }

    public int max_value() {
        return max.isEmpty() ? -1 : max.element();
    }

    public void push_back(int value) {
        data.offer(value);
        while (!max.isEmpty() && value > max.getLast()) {
            max.pollLast();
        }
        max.offerLast(value);
    }

    public int pop_front() {
        if (data.isEmpty()) {
            return -1;
        }
        int value = data.poll();
        if (value == max.getFirst()) {
            max.removeFirst();
        }
        return value;
    }
}