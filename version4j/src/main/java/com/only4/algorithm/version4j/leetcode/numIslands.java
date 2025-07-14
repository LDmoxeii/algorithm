package com.only4.algorithm.version4j.leetcode;

/**
 * @author zhenyu.jiang
 */
public class numIslands {

    int[][] direction = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public int numIslands(char[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    result++;
                }
            }
        }
        return result;
    }

    public void dfs(char[][] grid, int x, int y) {
        if (!isValid(grid.length, grid[0].length, x, y) || grid[x][y] == '0') return;
        grid[x][y] = '0';

        for (int[] ints : direction) {
            dfs(grid, x + ints[0], y + ints[1]);
        }
    }

    public boolean isValid(int boundaryX, int boundaryY, int x, int y) {
        return x > -1 && x < boundaryX && y > -1 && y < boundaryY;
    }
}
