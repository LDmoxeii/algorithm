package com.only4.algorithm.version4k.leetcode

fun solveNQueens(chessboardSize: Int): List<List<String>> {
    val allValidSolutions = mutableListOf<List<String>>()
    val chessboard = MutableList(chessboardSize) { ".".repeat(chessboardSize) }

    // 优化冲突检测：预计算冲突数组
    val occupiedColumns = BooleanArray(chessboardSize)
    val occupiedMainDiagonals = BooleanArray(2 * chessboardSize - 1)
    val occupiedAntiDiagonals = BooleanArray(2 * chessboardSize - 1)

    /**
     * 使用回溯算法递归寻找所有有效的皇后放置方案
     * @param currentRow 当前处理的行
     */
    fun findAllQueenPlacementsByBacktracking(currentRow: Int) {
        // 所有皇后都已成功放置，保存当前解决方案
        if (currentRow == chessboardSize) {
            allValidSolutions.add(chessboard.toList())
            return
        }

        // 尝试在当前行的每一列放置皇后
        for (candidateColumn in 0 until chessboardSize) {
            val mainDiagonalIndex = currentRow + candidateColumn
            val antiDiagonalIndex = currentRow - candidateColumn + chessboardSize - 1

            // 检查是否与已放置的皇后冲突
            if (occupiedColumns[candidateColumn] ||
                occupiedMainDiagonals[mainDiagonalIndex] ||
                occupiedAntiDiagonals[antiDiagonalIndex]
            ) {
                continue
            }

            // 放置皇后并标记冲突区域
            val rowWithQueen = StringBuilder(chessboard[currentRow]).apply {
                setCharAt(candidateColumn, 'Q')
            }.toString()
            chessboard[currentRow] = rowWithQueen
            occupiedColumns[candidateColumn] = true
            occupiedMainDiagonals[mainDiagonalIndex] = true
            occupiedAntiDiagonals[antiDiagonalIndex] = true

            // 递归处理下一行
            findAllQueenPlacementsByBacktracking(currentRow + 1)

            // 回溯：移除皇后并解除标记
            val rowWithoutQueen = StringBuilder(chessboard[currentRow]).apply {
                setCharAt(candidateColumn, '.')
            }.toString()
            chessboard[currentRow] = rowWithoutQueen
            occupiedColumns[candidateColumn] = false
            occupiedMainDiagonals[mainDiagonalIndex] = false
            occupiedAntiDiagonals[antiDiagonalIndex] = false
        }
    }

    findAllQueenPlacementsByBacktracking(0)
    return allValidSolutions
}
