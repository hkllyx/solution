package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.Test;
import com.hkllyx.solution.util.TestUtils;
import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.info.Tag;
import com.hkllyx.solution.util.info.Tags;

import java.util.Arrays;
import java.util.List;

/**
 * @author hkllyx
 * @date 2021/03/30
 */
@Solution(no = "1301", difficulty = Difficulty.HARD, url = "https://leetcode-cn.com/problems/number-of-paths-with-max-score/")
public class NumberOfPathsWithMaxScore {

    public static void main(String[] args) {
        TestUtils.assertion(NumberOfPathsWithMaxScore.class, new int[]{0, 1}, Arrays.asList("EX", "XS"));
        TestUtils.assertion(NumberOfPathsWithMaxScore.class, new int[]{0, 0}, Arrays.asList("E11", "XXX", "11S"));
        TestUtils.assertion(NumberOfPathsWithMaxScore.class, new int[]{4, 2}, Arrays.asList("E12", "1X1", "21S"));
        TestUtils.assertion(NumberOfPathsWithMaxScore.class, new int[]{7, 1}, Arrays.asList("E23", "2X2", "12S"));
        TestUtils.assertion(NumberOfPathsWithMaxScore.class, new int[]{1773, 690285631}, Arrays.asList(
                "E999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999",
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999",
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999",
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999",
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999",
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999",
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999",
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999",
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999",
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999",
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999",
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999",
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999",
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999",
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999",
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999",
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999",
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999",
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999",
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999",
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999",
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999",
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999",
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999",
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999",
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999",
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999",
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999",
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999",
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999",
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999",
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999",
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999",
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999",
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999",
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999",
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999",
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999",
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999",
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999",
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999",
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999",
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999",
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999",
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999",
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999",
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999",
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999",
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999",
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999",
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999",
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999",
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999",
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999",
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999",
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999",
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999",
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999",
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999",
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999",
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999",
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999",
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999",
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999",
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999",
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999",
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999",
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999",
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999",
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999",
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999",
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999",
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999",
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999",
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999",
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999",
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999",
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999",
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999",
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999",
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999",
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999",
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999",
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999",
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999",
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999",
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999",
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999",
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999",
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999",
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999",
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999",
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999",
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999",
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999",
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999",
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999",
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999",
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999",
                "999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999S"));
    }

    /**
     * 暴力枚举
     */
    @Deprecated
    public int[] pathsWithMaxScore1(List<String> board) {
        char[][] matrix = new char[board.size()][];
        int i = 0;
        for (String s : board) {
            matrix[i++] = s.toCharArray();
        }
        int[] result = new int[2];
        update1(matrix, 0, 0, 0, result);
        result[1] %= 1_000_000_007;
        return result;
    }

    private void update1(char[][] matrix, int r, int c, int gain, int[] result) {
        if (matrix[r][c] == 'S') {
            if (gain == result[0]) {
                result[1]++;
            } else if (gain > result[0]) {
                result[0] = gain;
                result[1] = 1;
            }
            return;
        }
        if (matrix[r][c] == 'X') {
            return;
        }
        if (matrix[r][c] != 'E') {
            gain += matrix[r][c] - '0';
        }
        if (r + 1 < matrix.length) {
            update1(matrix, r + 1, c, gain, result);
            if (c + 1 < matrix[0].length) {
                update1(matrix, r, c + 1, gain, result);
                update1(matrix, r + 1, c + 1, gain, result);
            }
        } else if (c + 1 < matrix[0].length) {
            update1(matrix, r, c + 1, gain, result);
        }
    }

    /**
     * DP，[i][j] 的前一步是 [i - 1][j], [i][j - 1], [i - 1][j - 1]
     */
    @Test
    @Tags(Tag.DYNAMIC_PROGRAMMING)
    public int[] pathsWithMaxScore2(List<String> board) {
        int row = board.size();
        int col = board.get(0).length();
        int[][] gain = new int[row][col];
        int[][] path = new int[row][col];
        // 计算初始分值
        for (int i = 0; i < row; i++) {
            String s = board.get(i);
            for (int j = 0; j < col; j++) {
                char c = s.charAt(j);
                gain[i][j] = c == 'X' ? -1 : c - '0';
            }
        }
        // 动态计算每一个单元格的最大得分和到达此单元格的路径数
        gain[0][0] = gain[row - 1][col - 1] = 0;
        path[0][0] = 1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (gain[i][j] == -1) {
                    continue;
                }
                if (i > 0 && j > 0) {
                    int maxGain = 0;
                    if (path[i - 1][j] > maxGain) {
                        path[i][j] = path[i - 1][j];
                        maxGain = gain[i - 1][j];
                    }
                    if (path[i][j - 1] > 0) {
                        if (gain[i][j - 1] > maxGain) {
                            maxGain = gain[i][j - 1];
                            path[i][j] = path[i][j - 1];
                        } else if (gain[i][j - 1] == maxGain) {
                            path[i][j] += path[i][j - 1];
                        }
                    }
                    if (path[i - 1][j - 1] > 0) {
                        if (gain[i - 1][j - 1] > maxGain) {
                            maxGain = gain[i - 1][j - 1];
                            path[i][j] = path[i - 1][j - 1];
                        } else if (gain[i - 1][j - 1] == maxGain) {
                            path[i][j] += path[i - 1][j - 1];
                        }
                    }
                    gain[i][j] += maxGain;
                } else if (i > 0 && path[i - 1][j] > 0) {
                    path[i][j] = path[i - 1][j];
                    gain[i][j] += gain[i - 1][j];
                } else if (j > 0 && path[i][j - 1] > 0) {
                    path[i][j] = path[i][j - 1];
                    gain[i][j] += gain[i][j - 1];
                }
                path[i][j] %= 1_000_000_007;
            }
        }
        return new int[]{gain[row - 1][col - 1], path[row - 1][col - 1]};
    }
}
