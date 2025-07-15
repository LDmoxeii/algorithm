package com.only4.algorithm.version4j.leetcode;

/**
 * @author zhenyu.jiang
 */
public class Exist {
    int[][] direction = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public boolean exist(char[][] board, String word) {
        boolean[][] used = new boolean[board.length][board[0].length];
        boolean result;
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[0].length; y++) {
                result = dfs(board, word, x, y, 0, used);
                if (result) return true;
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, int x, int y, int find, boolean[][] used) {
        if (word.charAt(find) != board[x][y]) return false;
        if (find == word.length() - 1) return true;
        used[x][y] = true;
        for (int[] offset : direction) {
            int deltaX = x + offset[0];
            int deltaY = y + offset[1];
            if (isValid(board.length, board[0].length, deltaX, deltaY, used)) {
                if (dfs(board, word, deltaX, deltaY, find + 1, used)) return true;
            }
        }
        used[x][y] = false;
        return false;
    }

    public boolean isValid(int boundaryX, int boundaryY, int x, int y, boolean[][] used) {
        return (-1 < x && x < boundaryX) && (-1 < y && y < boundaryY) && !used[x][y];
    }
}
