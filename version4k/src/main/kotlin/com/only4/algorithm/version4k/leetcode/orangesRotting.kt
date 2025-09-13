package com.only4.algorithm.version4k.leetcode

private const val EMPTY = 0
private const val FRESH = 1
private const val ROTTEN = 2

fun orangesRotting(grid: Array<IntArray>): Int {
    if (grid.isEmpty() || grid[0].isEmpty()) return 0

    val rows = grid.size
    val cols = grid[0].size
    val directions = arrayOf(Pair(-1, 0), Pair(1, 0), Pair(0, -1), Pair(0, 1))
    val rottenQueue = ArrayDeque<Pair<Int, Int>>()
    var freshCount = 0
    var minutes = 0

    fun isValidPosition(row: Int, col: Int) = row in 0 until rows && col in 0 until cols

    // 统计新鲜橘子数量并将腐烂橘子加入队列
    for (row in 0 until rows) {
        for (col in 0 until cols) {
            when (grid[row][col]) {
                FRESH -> freshCount++
                ROTTEN -> rottenQueue.add(Pair(row, col))
            }
        }
    }

    // 如果没有新鲜橘子，直接返回0
    if (freshCount == 0) return 0

    // BFS模拟腐烂过程
    while (rottenQueue.isNotEmpty() && freshCount > 0) {
        // 处理当前分钟所有腐烂的橘子
        repeat(rottenQueue.size) {
            val (currentRow, currentCol) = rottenQueue.removeFirst()

            // 检查四个方向的相邻位置
            for ((deltaRow, deltaCol) in directions) {
                val newRow = currentRow + deltaRow
                val newCol = currentCol + deltaCol

                // 检查新坐标是否在网格内且是新鲜橘子
                if (isValidPosition(newRow, newCol) && grid[newRow][newCol] == FRESH) {
                    // 将新鲜橘子标记为腐烂
                    grid[newRow][newCol] = ROTTEN
                    freshCount--
                    rottenQueue.add(Pair(newRow, newCol))
                }
            }
        }
        minutes++
    }

    return if (freshCount == 0) minutes else -1
}

