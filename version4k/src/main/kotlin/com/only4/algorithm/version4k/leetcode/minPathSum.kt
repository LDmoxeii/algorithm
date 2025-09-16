package com.only4.algorithm.version4k.leetcode

fun minPathSum(grid: Array<IntArray>): Int {
    val totalRows = grid.size
    val totalCols = grid[0].size
    // minPathSumToPosition[row][col] 表示到达位置(row, col)的最小路径和
    val minPathSumToPosition = Array(totalRows) { IntArray(totalCols) }

    // 起始位置的最小路径和就是起始位置的值
    minPathSumToPosition[0][0] = grid[0][0]

    // 初始化第一列：只能从上方到达，累加所有上方位置的值
    for (rowIndex in 1 until totalRows) {
        val currentCellValue = grid[rowIndex][0]
        val pathSumFromAbove = minPathSumToPosition[rowIndex - 1][0]
        minPathSumToPosition[rowIndex][0] = pathSumFromAbove + currentCellValue
    }

    // 初始化第一行：只能从左侧到达，累加所有左侧位置的值
    for (colIndex in 1 until totalCols) {
        val currentCellValue = grid[0][colIndex]
        val pathSumFromLeft = minPathSumToPosition[0][colIndex - 1]
        minPathSumToPosition[0][colIndex] = pathSumFromLeft + currentCellValue
    }

    // 计算其他位置的最小路径和：选择上方和左方较小的路径和，加上当前位置的值
    for (rowIndex in 1 until totalRows) {
        for (colIndex in 1 until totalCols) {
            val currentCellValue = grid[rowIndex][colIndex]
            val pathSumFromAbove = minPathSumToPosition[rowIndex - 1][colIndex]
            val pathSumFromLeft = minPathSumToPosition[rowIndex][colIndex - 1]
            val minPathSumFromNeighbors = minOf(pathSumFromAbove, pathSumFromLeft)
            minPathSumToPosition[rowIndex][colIndex] = minPathSumFromNeighbors + currentCellValue
        }
    }

    // 返回到达右下角的最小路径和
    return minPathSumToPosition[totalRows - 1][totalCols - 1]
}
