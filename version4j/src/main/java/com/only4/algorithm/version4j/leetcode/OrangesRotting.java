package com.only4.algorithm.version4j.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

public class OrangesRotting {

    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    private static final int EMPTY = 0;
    private static final int FRESH = 1;
    private static final int ROTTEN = 2;

    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        int freshCount = 0;
        Queue<int[]> rottenQueue = new ArrayDeque<>();
        int minutes = 0;

        // 统计新鲜橘子数量并将腐烂橘子加入队列
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == FRESH) {
                    freshCount++;
                } else if (grid[row][col] == ROTTEN) {
                    rottenQueue.offer(new int[]{row, col});
                }
            }
        }

        // 如果没有新鲜橘子，直接返回0
        if (freshCount == 0) {
            return 0;
        }

        // BFS模拟腐烂过程
        while (!rottenQueue.isEmpty() && freshCount > 0) {
            int queueSize = rottenQueue.size();

            // 处理当前分钟所有腐烂的橘子
            for (int i = 0; i < queueSize; i++) {
                int[] current = rottenQueue.poll();
                int currentRow = current[0];
                int currentCol = current[1];

                // 检查四个方向
                for (int[] direction : DIRECTIONS) {
                    int newRow = currentRow + direction[0];
                    int newCol = currentCol + direction[1];

                    if (isValidPosition(rows, cols, newRow, newCol) &&
                            grid[newRow][newCol] == FRESH) {
                        grid[newRow][newCol] = ROTTEN;
                        freshCount--;
                        rottenQueue.offer(new int[]{newRow, newCol});
                    }
                }
            }
            minutes++;
        }

        return freshCount == 0 ? minutes : -1;
    }

    private boolean isValidPosition(int rows, int cols, int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }
}
