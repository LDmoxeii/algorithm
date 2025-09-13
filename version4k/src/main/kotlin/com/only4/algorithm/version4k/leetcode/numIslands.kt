package com.only4.algorithm.version4k.leetcode

fun numIslands(grid: Array<CharArray>): Int {
    if (grid.isEmpty() || grid[0].isEmpty()) return 0

    val rows = grid.size
    val cols = grid[0].size
    val directions = arrayOf(Pair(-1, 0), Pair(1, 0), Pair(0, -1), Pair(0, 1))
    var islandCount = 0

    fun isValidPosition(row: Int, col: Int) = row in 0 until rows && col in 0 until cols

    fun markIslandAsVisited(row: Int, col: Int) {
        if (!isValidPosition(row, col) || grid[row][col] != '1') return

        grid[row][col] = '0'

        directions.forEach { (deltaRow, deltaCol) ->
            markIslandAsVisited(row + deltaRow, col + deltaCol)
        }
    }

    for (row in 0 until rows) {
        for (col in 0 until cols) {
            if (grid[row][col] == '1') {
                islandCount++
                markIslandAsVisited(row, col)
            }
        }
    }

    return islandCount
}
