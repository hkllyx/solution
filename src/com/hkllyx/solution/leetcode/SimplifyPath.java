package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.StringJoiner;

/**
 * <p>Given a string <code>path</code>, which is an <strong>absolute path</strong> (starting with a slash <code>&#39;/&#39;</code>) to a file or directory in a Unix-style file system, convert it to the simplified <strong>canonical path</strong>.</p>
 *
 * <p>In a Unix-style file system, a period <code>&#39;.&#39;</code> refers to the current directory, a double period <code>&#39;..&#39;</code> refers to the directory up a level, and any multiple consecutive slashes (i.e. <code>&#39;//&#39;</code>) are treated as a single slash <code>&#39;/&#39;</code>. For this problem, any other format of periods such as <code>&#39;...&#39;</code> are treated as file/directory names.</p>
 *
 * <p>The <strong>canonical path</strong> should have the following format:</p>
 *
 * <ul>
 * 	<li>The path starts with a single slash <code>&#39;/&#39;</code>.</li>
 * 	<li>Any two directories are separated by a single slash <code>&#39;/&#39;</code>.</li>
 * 	<li>The path does not end with a trailing <code>&#39;/&#39;</code>.</li>
 * 	<li>The path only contains the directories on the path from the root directory to the target file or directory (i.e., no period <code>&#39;.&#39;</code> or double period <code>&#39;..&#39;</code>)</li>
 * </ul>
 *
 * <p>Return <em>the simplified <strong>canonical path</strong></em>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> path = &quot;/home/&quot;
 * <strong>Output:</strong> &quot;/home&quot;
 * <strong>Explanation:</strong> Note that there is no trailing slash after the last directory name.
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> path = &quot;/../&quot;
 * <strong>Output:</strong> &quot;/&quot;
 * <strong>Explanation:</strong> Going one level up from the root directory is a no-op, as the root level is the highest level you can go.
 * </pre>
 *
 * <p><strong>Example 3:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> path = &quot;/home//foo/&quot;
 * <strong>Output:</strong> &quot;/home/foo&quot;
 * <strong>Explanation:</strong> In the canonical path, multiple consecutive slashes are replaced by a single one.
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= path.length &lt;= 3000</code></li>
 * 	<li><code>path</code> consists of English letters, digits, period <code>&#39;.&#39;</code>, slash <code>&#39;/&#39;</code> or <code>&#39;_&#39;</code>.</li>
 * 	<li><code>path</code> is a valid absolute Unix path.</li>
 * </ul>
 * <div><div>Related Topics</div><div><li>栈</li><li>字符串</li></div></div><br><div><li>👍 483</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2022/05/12
 */
@Solution(no = "71", title = "Simplify Path", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/simplify-path/")
public class SimplifyPath {

    public static void main(String[] args) {
        Assertions.assertExpect("/c", "/a/./b/../../c/");
        Assertions.assertExpect("/", "/");
        Assertions.assertExpect("/home", "/home/");
        Assertions.assertExpect("/", "/../");
        Assertions.assertExpect("/home/foo", "/home//foo");
        Assertions.assertExpect("/home/foo", "/home/foo/");
        Assertions.assertExpect("/home/foo", "/home//foo////.");
        Assertions.assertExpect("/home/foo", "/home//foo////./");
        Assertions.assertExpect("/home", "/home//foo////./..");
        Assertions.assertExpect("/", "/home//foo////./../../..");
        Assertions.assertExpect("/home/foo", "/../../home/./foo/");
    }

    @Test(value = "Stack", mills = 4, memory = 41.4, active = false)
    public String simplifyPath(String path) {
        if (path.length() < 2) {
            return path;
        }
        Deque<String> stack = new ArrayDeque<>();
        boolean dots = true;
        for (int i = 0, j = 0; j <= path.length(); j++) {
            if (j == path.length() || path.charAt(j) == '/') {
                if (!dots || j - i - 1 > 2) {
                    stack.push(path.substring(i + 1, j));
                    dots = true;
                } else if (j - i - 1 == 2 && !stack.isEmpty()) {
                    stack.pop();
                }
                i = j;
            } else if (path.charAt(j) != '.') {
                dots = false;
            }
        }
        StringJoiner joiner = new StringJoiner("/", "/", "");
        for (Iterator<String> itr = stack.descendingIterator(); itr.hasNext(); ) {
            joiner.add(itr.next());
        }
        return joiner.toString();
    }

    @Test(value = "Stack & Array", mills = 2, memory = 41.6)
    public String simplifyPath2(String path) {
        char[] chars = path.toCharArray();
        // 存放'/'的位置
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        // 两个'/'之间只有'.'时'.'的数量，如果不全是'.'则记为-1
        int dotNum = 0;
        for (int i = 1, j = 1; i < path.length(); i++, j++) {
            chars[j] = path.charAt(i);
            if (path.charAt(i) != '/') {
                if (path.charAt(i) == '.' && dotNum != -1) {
                    dotNum++;
                } else {
                    dotNum = -1;
                }
                if (i != path.length() - 1) {
                    continue;
                } else {
                    // 最后一位不是'/'，在后面虚拟一个'/'保证stack存的都是'/'的位置
                    j++;
                }
            }
            // 如果两个'/'之间有字符而且不是1或2个点，入栈
            if (dotNum < 0 || dotNum > 2) {
                stack.push(j);
            } else {
                // 两个'.'，先出栈上一个'/'，即".."前的那个'/'（栈底元素不允许出栈）
                if (dotNum == 2 && stack.size() > 1) {
                    stack.pop();
                }
                j = stack.element();
            }
            dotNum = 0;
        }
        return new String(chars, 0, Math.max(1, stack.element()));
    }
}
