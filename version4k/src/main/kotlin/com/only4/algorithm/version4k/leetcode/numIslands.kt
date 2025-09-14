package com.only4.algorithm.version4k.leetcode

fun numIslands(oceanGrid: Array<CharArray>): Int {
    if (oceanGrid.isEmpty() || oceanGrid[0].isEmpty()) return 0

    val totalRows = oceanGrid.size
    val totalCols = oceanGrid[0].size

    // 四个方向的探索向量：上、下、左、右
    val landExplorationDirections = arrayOf(
        Pair(-1, 0), Pair(1, 0), Pair(0, -1), Pair(0, 1)
    )

    var discoveredIslandCount = 0

    /**
     * 检查给定坐标是否在海洋网格的有效范围内
     */
    fun isValidGridPosition(targetRow: Int, targetCol: Int): Boolean =
        targetRow in 0 until totalRows && targetCol in 0 until totalCols

    /**
     * 深度优先搜索：探索并标记整个岛屿的所有连通陆地
     */
    fun exploreAndMarkEntireIsland(landRow: Int, landCol: Int) {
        // 边界检查和水域检查
        if (!isValidGridPosition(landRow, landCol) || oceanGrid[landRow][landCol] != '1') {
            return
        }

        // 将当前陆地标记为已访问（沉没为水域）
        oceanGrid[landRow][landCol] = '0'

        // 向四个方向继续探索连通的陆地
        landExplorationDirections.forEach { (rowDelta, colDelta) ->
            exploreAndMarkEntireIsland(landRow + rowDelta, landCol + colDelta)
        }
    }

    // 遍历海洋网格寻找未探索的岛屿
    for (currentRow in 0 until totalRows) {
        for (currentCol in 0 until totalCols) {
            if (oceanGrid[currentRow][currentCol] == '1') {
                discoveredIslandCount++
                exploreAndMarkEntireIsland(currentRow, currentCol)
            }
        }
    }

    return discoveredIslandCount
}
