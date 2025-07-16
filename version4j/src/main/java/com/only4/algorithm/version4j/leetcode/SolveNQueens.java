package com.only4.algorithm.version4j.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhenyu.jiang
 */
public class SolveNQueens {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];

        // 初始化棋盘
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        // 使用三个数组标记列、主对角线、副对角线是否被占用
        boolean[] cols = new boolean[n];           // 列
        boolean[] diag1 = new boolean[2 * n - 1];  // 主对角线 (i+j)
        boolean[] diag2 = new boolean[2 * n - 1];  // 副对角线 (i-j+n-1)

        backtrack(board, 0, result, cols, diag1, diag2);
        return result;
    }

    private void backtrack(char[][] board, int row, List<List<String>> result,
                           boolean[] cols, boolean[] diag1, boolean[] diag2) {
        int n = board.length;

        // 所有行都已放置了皇后，找到一个解
        if (row == n) {
            List<String> solution = new ArrayList<>();
            for (char[] rowChars : board) {
                solution.add(new String(rowChars));
            }
            result.add(solution);
            return;
        }

        // 尝试在当前行的每一列放置皇后
        for (int col = 0; col < n; col++) {
            int d1 = row + col;            // 主对角线索引
            int d2 = row - col + n - 1;    // 副对角线索引

            // 检查是否可以放置皇后
            if (cols[col] || diag1[d1] || diag2[d2]) {
                continue;  // 当前位置被攻击，跳过
            }

            // 放置皇后
            board[row][col] = 'Q';
            cols[col] = true;
            diag1[d1] = true;
            diag2[d2] = true;

            // 递归到下一行
            backtrack(board, row + 1, result, cols, diag1, diag2);

            // 回溯，移除皇后
            board[row][col] = '.';
            cols[col] = false;
            diag1[d1] = false;
            diag2[d2] = false;
        }
    }
}
