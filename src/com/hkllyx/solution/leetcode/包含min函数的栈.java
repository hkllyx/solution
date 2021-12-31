package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;

/**
 * <p>定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例:</strong></p>
 *
 * <pre>MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.min();   --&gt; 返回 -3.
 * minStack.pop();
 * minStack.top();      --&gt; 返回 0.
 * minStack.min();   --&gt; 返回 -2.
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ol>
 * 	<li>各函数的调用总次数不超过 20000 次</li>
 * </ol>
 *
 * <p>&nbsp;</p>
 *
 * <p>注意：本题与主站 155 题相同：<a href="https://leetcode-cn.com/problems/min-stack/">https://leetcode-cn.com/problems/min-stack/</a></p>
 * <div><div>Related Topics</div><div><li>栈</li><li>设计</li></div></div><br><div><li>👍 254</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2021/06/07
 */
@Solution(no = "剑指 Offer 30", difficulty = Difficulty.SIMPLE, url = "https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/")
public class 包含min函数的栈 extends MinStack {

    public int min() {
        return super.getMin();
    }
}
