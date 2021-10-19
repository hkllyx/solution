package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

/**
 * @author xiaoyong3
 * @date 2021/05/24
 */
@Solution(no = "79", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/word-search/")
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
