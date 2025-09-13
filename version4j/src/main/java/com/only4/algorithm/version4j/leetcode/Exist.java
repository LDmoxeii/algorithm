package com.only4.algorithm.version4j.leetcode;

/**
 * @author zhenyu.jiang
 */
public class Exist {
    int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (backtrack(board, word, row, col, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean backtrack(char[][] board, String word, int row, int col, int index, boolean[][] visited) {
        if (word.charAt(index) != board[row][col]) return false;
        if (index == word.length() - 1) return true;

        visited[row][col] = true;
        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            if (isValidPosition(board.length, board[0].length, newRow, newCol, visited)) {
                if (backtrack(board, word, newRow, newCol, index + 1, visited)) {
                    return true;
                }
            }
        }
        visited[row][col] = false;
        return false;
    }

    public boolean isValidPosition(int maxRow, int maxCol, int row, int col, boolean[][] visited) {
        return row >= 0 && row < maxRow && col >= 0 && col < maxCol && !visited[row][col];
    }
}
