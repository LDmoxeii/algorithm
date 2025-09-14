package com.only4.algorithm.version4j.leetcode;

public class NumIslands {

    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int islandCount = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == '1') {
                    markIslandAsVisited(grid, row, col);
                    islandCount++;
                }
            }
        }

        return islandCount;
    }

    private void markIslandAsVisited(char[][] grid, int row, int col) {
        if (!isValidPosition(grid, row, col) || grid[row][col] == '0') {
            return;
        }

        grid[row][col] = '0';

        for (int[] direction : DIRECTIONS) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            markIslandAsVisited(grid, newRow, newCol);
        }
    }

    private boolean isValidPosition(char[][] grid, int row, int col) {
        return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length;
    }
}
