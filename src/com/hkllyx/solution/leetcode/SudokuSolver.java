package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Write a program to solve a Sudoku puzzle by filling the empty cells.</p>
 *
 * <p>A sudoku solution must satisfy <strong>all of the following rules</strong>:</p>
 *
 * <ol>
 * 	<li>Each of the digits <code>1-9</code> must occur exactly once in each row.</li>
 * 	<li>Each of the digits <code>1-9</code> must occur exactly once in each column.</li>
 * 	<li>Each of the digits <code>1-9</code> must occur exactly once in each of the 9 <code>3x3</code> sub-boxes of the grid.</li>
 * </ol>
 *
 * <p>The <code>&#39;.&#39;</code> character indicates empty cells.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 * <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/f/ff/Sudoku-by-L2G-20050714.svg/250px-Sudoku-by-L2G-20050714.svg.png" style="height:250px; width:250px" />
 * <pre>
 * <strong>Input:</strong> board = [[&quot;5&quot;,&quot;3&quot;,&quot;.&quot;,&quot;.&quot;,&quot;7&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;],[&quot;6&quot;,&quot;.&quot;,&quot;.&quot;,&quot;1&quot;,&quot;9&quot;,&quot;5&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;],[&quot;.&quot;,&quot;9&quot;,&quot;8&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;6&quot;,&quot;.&quot;],[&quot;8&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;6&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;3&quot;],[&quot;4&quot;,&quot;.&quot;,&quot;.&quot;,&quot;8&quot;,&quot;.&quot;,&quot;3&quot;,&quot;.&quot;,&quot;.&quot;,&quot;1&quot;],[&quot;7&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;2&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;6&quot;],[&quot;.&quot;,&quot;6&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;2&quot;,&quot;8&quot;,&quot;.&quot;],[&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;4&quot;,&quot;1&quot;,&quot;9&quot;,&quot;.&quot;,&quot;.&quot;,&quot;5&quot;],[&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;8&quot;,&quot;.&quot;,&quot;.&quot;,&quot;7&quot;,&quot;9&quot;]]
 * <strong>Output:</strong> [[&quot;5&quot;,&quot;3&quot;,&quot;4&quot;,&quot;6&quot;,&quot;7&quot;,&quot;8&quot;,&quot;9&quot;,&quot;1&quot;,&quot;2&quot;],[&quot;6&quot;,&quot;7&quot;,&quot;2&quot;,&quot;1&quot;,&quot;9&quot;,&quot;5&quot;,&quot;3&quot;,&quot;4&quot;,&quot;8&quot;],[&quot;1&quot;,&quot;9&quot;,&quot;8&quot;,&quot;3&quot;,&quot;4&quot;,&quot;2&quot;,&quot;5&quot;,&quot;6&quot;,&quot;7&quot;],[&quot;8&quot;,&quot;5&quot;,&quot;9&quot;,&quot;7&quot;,&quot;6&quot;,&quot;1&quot;,&quot;4&quot;,&quot;2&quot;,&quot;3&quot;],[&quot;4&quot;,&quot;2&quot;,&quot;6&quot;,&quot;8&quot;,&quot;5&quot;,&quot;3&quot;,&quot;7&quot;,&quot;9&quot;,&quot;1&quot;],[&quot;7&quot;,&quot;1&quot;,&quot;3&quot;,&quot;9&quot;,&quot;2&quot;,&quot;4&quot;,&quot;8&quot;,&quot;5&quot;,&quot;6&quot;],[&quot;9&quot;,&quot;6&quot;,&quot;1&quot;,&quot;5&quot;,&quot;3&quot;,&quot;7&quot;,&quot;2&quot;,&quot;8&quot;,&quot;4&quot;],[&quot;2&quot;,&quot;8&quot;,&quot;7&quot;,&quot;4&quot;,&quot;1&quot;,&quot;9&quot;,&quot;6&quot;,&quot;3&quot;,&quot;5&quot;],[&quot;3&quot;,&quot;4&quot;,&quot;5&quot;,&quot;2&quot;,&quot;8&quot;,&quot;6&quot;,&quot;1&quot;,&quot;7&quot;,&quot;9&quot;]]
 * <strong>Explanation:</strong>&nbsp;The input board is shown above and the only valid solution is shown below:
 *
 * <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/3/31/Sudoku-by-L2G-20050714_solution.svg/250px-Sudoku-by-L2G-20050714_solution.svg.png" style="height:250px; width:250px" />
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>board.length == 9</code></li>
 * 	<li><code>board[i].length == 9</code></li>
 * 	<li><code>board[i][j]</code> is a digit or <code>&#39;.&#39;</code>.</li>
 * 	<li>It is <strong>guaranteed</strong> that the input board has only one solution.</li>
 * </ul>
 * <div><div>Related Topics</div><div><li>数组</li><li>回溯</li><li>矩阵</li></div></div><br><div><li>👍 1121</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2022/02/17
 */
@Solution(no = "37", title = "Sudoku Solver", difficulty = Difficulty.HARD, url = "https://leetcode-cn.com/problems/sudoku-solver/")
public class SudokuSolver {

    public static void main(String[] args) {
        Assertions.assertExpect(new char[][]{
                        {'5', '3', '4', '6', '7', '8', '9', '1', '2'},
                        {'6', '7', '2', '1', '9', '5', '3', '4', '8'},
                        {'1', '9', '8', '3', '4', '2', '5', '6', '7'},
                        {'8', '5', '9', '7', '6', '1', '4', '2', '3'},
                        {'4', '2', '6', '8', '5', '3', '7', '9', '1'},
                        {'7', '1', '3', '9', '2', '4', '8', '5', '6'},
                        {'9', '6', '1', '5', '3', '7', '2', '8', '4'},
                        {'2', '8', '7', '4', '1', '9', '6', '3', '5'},
                        {'3', '4', '5', '2', '8', '6', '1', '7', '9'}},
                (Object) new char[][]{
                        {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}});
    }

    @Test(value = "自己写的", mills = 3, active = false)
    public char[][] solveSudoku(char[][] board) {
        solve(board, 0, 0);
        return board;
    }

    public boolean solve(char[][] board, int i, int j) {
        if (j == 9) {
            // 走到右下角
            if (i == 8) {
                return true;
            }
            // 换行
            i++;
            j = 0;
        }
        if (board[i][j] != '.') {
            return solve(board, i, j + 1);
        }
        boolean[] candidate = findCandidate(board, i, j);
        for (int k = 0; k < 9; k++) {
            if (!candidate[k]) {
                board[i][j] = (char) (k + '1');
                if (solve(board, i, j + 1)) {
                    return true;
                }
            }
        }
        board[i][j] = '.';
        return false;
    }

    private boolean[] findCandidate(char[][] board, int i, int j) {
        boolean[] candidate = new boolean[9];
        for (int k = 0; k < 9; k++) {
            check(board[i][k], candidate);
            check(board[k][j], candidate);
        }
        for (int m = i / 3 * 3, ml = m + 3; m < ml; m++) {
            for (int n = j / 3 * 3, nl = n + 3; n < nl; n++) {
                check(board[m][n], candidate);
            }
        }
        return candidate;
    }

    private void check(char c, boolean[] candidate) {
        if (c != '.') {
            candidate[c - '1'] = true;
        }
    }

    /* ------------------------------------------------------------------------------------------------------- */

    private final int[] line = new int[9]; // 每行可用数字
    private final int[] column = new int[9]; // 每列可用数字
    private final int[][] block = new int[3][3]; // 每九宫格可用数字
    private final List<int[]> spaces = new ArrayList<>(); // 需要填充的坐标
    private boolean valid = false;

    @Test(value = "官方解答", mills = 0)
    public char[][] solveSudoku1(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int digit = board[i][j] - '1';
                    flip(i, j, digit);
                }
            }
        }
        while (true) {
            boolean modified = false;
            for (int i = 0; i < 9; ++i) {
                for (int j = 0; j < 9; ++j) {
                    if (board[i][j] == '.') {
                        int mask = ~(line[i] | column[j] | block[i / 3][j / 3]) & 0x1ff;
                        if ((mask & (mask - 1)) == 0) {
                            int digit = Integer.bitCount(mask - 1);
                            flip(i, j, digit);
                            board[i][j] = (char) (digit + '0' + 1);
                            modified = true;
                        }
                    }
                }
            }
            if (!modified) {
                break;
            }
        }
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] == '.') {
                    spaces.add(new int[]{i, j});
                }
            }
        }
        dfs(board, 0);
        return board;
    }

    private void dfs(char[][] board, int pos) {
        // 判断是否将所有空格填完
        if (pos == spaces.size()) {
            valid = true;
            return;
        }
        // 依次得到需要填入的空格在第i行，第j列
        int[] space = spaces.get(pos);
        int i = space[0], j = space[1];
        for (int mask = ~(line[i] | column[j] | block[i / 3][j / 3]) & 0x1ff; mask != 0 && !valid; mask &= (mask - 1)) {
            int digitMask = mask & (-mask);
            int digit = Integer.bitCount(digitMask - 1);
            flip(i, j, digit);
            board[i][j] = (char) (digit + '0' + 1);
            dfs(board, pos + 1);
            flip(i, j, digit);
        }
    }

    private void flip(int i, int j, int digit) {
        line[i] ^= (1 << digit);
        column[j] ^= (1 << digit);
        block[i / 3][j / 3] ^= (1 << digit);
    }
}
