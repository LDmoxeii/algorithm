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

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        boolean[] columns = new boolean[n];
        boolean[] mainDiagonal = new boolean[2 * n - 1];
        boolean[] antiDiagonal = new boolean[2 * n - 1];

        backtrack(board, 0, result, columns, mainDiagonal, antiDiagonal);
        return result;
    }

    private void backtrack(char[][] board, int row, List<List<String>> result,
                           boolean[] columns, boolean[] mainDiagonal, boolean[] antiDiagonal) {
        int n = board.length;
        if (row == n) {
            List<String> solution = new ArrayList<>();
            for (char[] rowChars : board) {
                solution.add(new String(rowChars));
            }
            result.add(solution);
            return;
        }

        for (int col = 0; col < n; col++) {
            int mainDiagIndex = row + col;
            int antiDiagIndex = row - col + n - 1;

            if (columns[col] || mainDiagonal[mainDiagIndex] || antiDiagonal[antiDiagIndex]) {
                continue;
            }

            board[row][col] = 'Q';
            columns[col] = true;
            mainDiagonal[mainDiagIndex] = true;
            antiDiagonal[antiDiagIndex] = true;

            backtrack(board, row + 1, result, columns, mainDiagonal, antiDiagonal);

            board[row][col] = '.';
            columns[col] = false;
            mainDiagonal[mainDiagIndex] = false;
            antiDiagonal[antiDiagIndex] = false;
        }
    }
}
