package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.info.Tag;
import com.hkllyx.solution.util.info.Tags;

import java.util.Arrays;
import java.util.Random;

/**
 * <p>Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.</p>
 *
 * <p>Implement the <code>MinStack</code> class:</p>
 *
 * <ul>
 * 	<li><code>MinStack()</code> initializes the stack object.</li>
 * 	<li><code>void push(int val)</code> pushes the element <code>val</code> onto the stack.</li>
 * 	<li><code>void pop()</code> removes the element on the top of the stack.</li>
 * 	<li><code>int top()</code> gets the top element of the stack.</li>
 * 	<li><code>int getMin()</code> retrieves the minimum element in the stack.</li>
 * </ul>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input</strong>
 * [&quot;MinStack&quot;,&quot;push&quot;,&quot;push&quot;,&quot;push&quot;,&quot;getMin&quot;,&quot;pop&quot;,&quot;top&quot;,&quot;getMin&quot;]
 * [[],[-2],[0],[-3],[],[],[],[]]
 *
 * <strong>Output</strong>
 * [null,null,null,null,-3,null,0,-2]
 *
 * <strong>Explanation</strong>
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin(); // return -3
 * minStack.pop();
 * minStack.top();    // return 0
 * minStack.getMin(); // return -2
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>-2<sup>31</sup> &lt;= val &lt;= 2<sup>31</sup> - 1</code></li>
 * 	<li>Methods <code>pop</code>, <code>top</code> and <code>getMin</code> operations will always be called on <strong>non-empty</strong> stacks.</li>
 * 	<li>At most <code>3 * 10<sup>4</sup></code> calls will be made to <code>push</code>, <code>pop</code>, <code>top</code>, and <code>getMin</code>.</li>
 * </ul>
 * <div><div>Related Topics</div><div><li>栈</li><li>设计</li></div></div><br><div><li>👍 1128</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2021/06/07
 */
@Solution(no = "155", difficulty = Difficulty.SIMPLE, url = "https://leetcode-cn.com/problems/min-stack/")
@Tags(Tag.DESIGN)
public class MinStack {
    private int[] elements;
    private int[] mins;
    private int point;

    public MinStack() {
        point = -1;
    }

    public static void main(String[] args) {
        Random random = new Random(47);
        MinStack stack = new MinStack();
        for (int i = 0; i < 32; i++) {
            stack.push(random.nextInt(100));
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(stack.top() + " " + stack.getMin());
            stack.pop();
        }
    }

    public void push(int val) {
        if (point < 0) {
            elements = new int[16];
            mins = new int[16];
            elements[++point] = val;
            mins[point] = val;
            return;
        }
        // 简单动态扩容
        int length = elements.length;
        if (point > length - 2) {
            int newLength = length > 0x3fffffff ? Integer.MAX_VALUE : length << 1;
            elements = Arrays.copyOf(elements, newLength);
            mins = Arrays.copyOf(mins, newLength);
        }
        int min = Math.min(mins[point], val);
        elements[++point] = val;
        mins[point] = min;
    }

    public void pop() {
        point--;
    }

    public int top() {
        return elements[point];
    }

    public int getMin() {
        return mins[point];
    }

    public int min() {
        return getMin();
    }
}
