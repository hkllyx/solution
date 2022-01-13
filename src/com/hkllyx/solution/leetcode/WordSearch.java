package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

/**
 * <p>Given an <code>m x n</code> grid of characters <code>board</code> and a string <code>word</code>, return <code>true</code> <em>if</em> <code>word</code> <em>exists in the grid</em>.</p>
 *
 * <p>The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/11/04/word2.jpg" style="width: 322px; height: 242px;" />
 * <pre>
 * <strong>Input:</strong> board = [[&quot;A&quot;,&quot;B&quot;,&quot;C&quot;,&quot;E&quot;],[&quot;S&quot;,&quot;F&quot;,&quot;C&quot;,&quot;S&quot;],[&quot;A&quot;,&quot;D&quot;,&quot;E&quot;,&quot;E&quot;]], word = &quot;ABCCED&quot;
 * <strong>Output:</strong> true
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/11/04/word-1.jpg" style="width: 322px; height: 242px;" />
 * <pre>
 * <strong>Input:</strong> board = [[&quot;A&quot;,&quot;B&quot;,&quot;C&quot;,&quot;E&quot;],[&quot;S&quot;,&quot;F&quot;,&quot;C&quot;,&quot;S&quot;],[&quot;A&quot;,&quot;D&quot;,&quot;E&quot;,&quot;E&quot;]], word = &quot;SEE&quot;
 * <strong>Output:</strong> true
 * </pre>
 *
 * <p><strong>Example 3:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/10/15/word3.jpg" style="width: 322px; height: 242px;" />
 * <pre>
 * <strong>Input:</strong> board = [[&quot;A&quot;,&quot;B&quot;,&quot;C&quot;,&quot;E&quot;],[&quot;S&quot;,&quot;F&quot;,&quot;C&quot;,&quot;S&quot;],[&quot;A&quot;,&quot;D&quot;,&quot;E&quot;,&quot;E&quot;]], word = &quot;ABCB&quot;
 * <strong>Output:</strong> false
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>m == board.length</code></li>
 * 	<li><code>n = board[i].length</code></li>
 * 	<li><code>1 &lt;= m, n &lt;= 6</code></li>
 * 	<li><code>1 &lt;= word.length &lt;= 15</code></li>
 * 	<li><code>board</code> and <code>word</code> consists of only lowercase and uppercase English letters.</li>
 * </ul>
 *
 * <p>&nbsp;</p>
 * <p><strong>Follow up:</strong> Could you use search pruning to make your solution faster with a larger <code>board</code>?</p>
 * <div><div>Related Topics</div><div><li>数组</li><li>回溯</li><li>矩阵</li></div></div><br><div><li>👍 1137</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2021/05/24
 */
@Solution(no = "79", title = "Word Search", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/word-search/")
public class WordSearch {

    public static void main(String[] args) {
        Assertions.assertExpect(WordSearch.class, true,
                new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCCED");
        Assertions.assertExpect(WordSearch.class, true,
                new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "SEE");
        Assertions.assertExpect(WordSearch.class, false,
                new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCB");
    }

    @Test
    public boolean exist(char[][] board, String word) {
        int h = board.length, w = board[0].length;
        char[] chars = word.toCharArray();
        char head = chars[0];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (head == board[i][j]) {
                    if (exists(board, chars, 0, i, j)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean exists(char[][] board, char[] chars, int level, int i, int j) {
        if (level == chars.length) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }
        char c = board[i][j];
        if (chars[level] == c) {
            board[i][j] = 0;
            if (exists(board, chars, ++level, i + 1, j)
                    || exists(board, chars, level, i - 1, j)
                    || exists(board, chars, level, i, j + 1)
                    || exists(board, chars, level, i, j - 1)) {
                return true;
            }
            board[i][j] = c;
        }
        return false;
    }
}
