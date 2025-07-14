package com.only4.algorithm.version4j.leetcode;

import java.util.ArrayDeque;

/**
 * [994. 腐烂的橘子](https://leetcode.com/problems/rotting-oranges/)
 * <p>
 * 在给定的 m x n 网格 grid 中，每个单元格可以有以下三个值之一：
 * - 值 0 代表空单元格；
 * - 值 1 代表新鲜橘子；
 * - 值 2 代表腐烂的橘子。
 *
 * <p>
 * 每分钟，腐烂的橘子会使上、下、左、右四个方向相邻的新鲜橘子腐烂。
 * 返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，则返回 -1。
 *
 * @author zhenyu.jiang
 */
public class OrangesRotting {
    public int orangesRotting(int[][] grid) {
        int freshCount = 0;
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        int minutes = 0;

        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                if (grid[x][y] == 1) {
                    freshCount++;
                } else if (grid[x][y] == 2) {
                    deque.add(new int[]{x, y});
                }
            }
        }

        while (!deque.isEmpty() && freshCount > 0) {
            int size = deque.size();
            while (size-- != 0) {
                int[] coordinate = deque.pollFirst();
                for (int[] direction : directions) {
                    int y = coordinate[1] + direction[1];
                    int x = coordinate[0] + direction[0];
                    if (isValid(grid.length, grid[0].length, x, y)) {
                        if (grid[x][y] == 1) {
                            freshCount--;
                            grid[x][y] = 2;
                            deque.addLast(new int[]{x, y});
                        }
                    }
                }
            }
            minutes++;
        }

        return freshCount == 0 ? minutes : -1;
    }

    public boolean isValid(int boundaryX, int boundaryY, int x, int y) {
        return x > -1 && x < boundaryX && y > -1 && y < boundaryY;
    }
}
