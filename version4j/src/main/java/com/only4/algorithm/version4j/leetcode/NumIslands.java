package com.only4.algorithm.version4j.leetcode;

public class NumIslands {

    // 四个方向：上、下、右、左（用于DFS遍历相邻陆地）
    private static final int[][] LAND_EXPLORATION_DIRECTIONS = {
            {-1, 0}, {1, 0}, {0, 1}, {0, -1}
    };

    public int numIslands(char[][] oceanGrid) {
        if (oceanGrid == null || oceanGrid.length == 0 || oceanGrid[0].length == 0) {
            return 0;
        }

        int discoveredIslandCount = 0;
        int totalRows = oceanGrid.length;
        int totalCols = oceanGrid[0].length;

        // 遍历海洋网格中的每个位置
        for (int currentRow = 0; currentRow < totalRows; currentRow++) {
            for (int currentCol = 0; currentCol < totalCols; currentCol++) {
                // 发现新的未探索陆地，开始岛屿探索
                if (oceanGrid[currentRow][currentCol] == '1') {
                    exploreAndMarkEntireIsland(oceanGrid, currentRow, currentCol);
                    discoveredIslandCount++;
                }
            }
        }

        return discoveredIslandCount;
    }

    /**
     * 深度优先搜索：探索并标记整个岛屿的所有连通陆地
     * 将已访问的陆地标记为水('0')以避免重复计算
     */
    private void exploreAndMarkEntireIsland(char[][] oceanGrid, int landRow, int landCol) {
        // 边界检查：超出网格范围或已经是水域
        if (!isValidGridPosition(oceanGrid, landRow, landCol) || oceanGrid[landRow][landCol] == '0') {
            return;
        }

        // 将当前陆地标记为已访问（沉没为水域）
        oceanGrid[landRow][landCol] = '0';

        // 向四个方向继续探索连通的陆地
        for (int[] explorationDirection : LAND_EXPLORATION_DIRECTIONS) {
            int neighborRow = landRow + explorationDirection[0];
            int neighborCol = landCol + explorationDirection[1];
            exploreAndMarkEntireIsland(oceanGrid, neighborRow, neighborCol);
        }
    }

    /**
     * 检查给定坐标是否在网格的有效范围内
     */
    private boolean isValidGridPosition(char[][] oceanGrid, int targetRow, int targetCol) {
        return targetRow >= 0 && targetRow < oceanGrid.length &&
                targetCol >= 0 && targetCol < oceanGrid[0].length;
    }
}
