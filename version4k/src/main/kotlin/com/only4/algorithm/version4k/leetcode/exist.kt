package com.only4.algorithm.version4k.leetcode

fun exist(board: Array<CharArray>, word: String): Boolean {
    val directions = arrayOf(intArrayOf(-1, 0), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(0, 1))

    fun backtrack(row: Int, col: Int, index: Int): Boolean {
        if (board[row][col] != word[index]) return false
        if (index == word.lastIndex) return true

        val originalChar = board[row][col]
        board[row][col] = '0' // 标记为已访问

        for ((deltaRow, deltaCol) in directions) {
            val newRow = row + deltaRow
            val newCol = col + deltaCol

            if (newRow in board.indices && newCol in board[0].indices &&
                backtrack(newRow, newCol, index + 1)
            ) {
                return true
            }
        }
        board[row][col] = originalChar // 恢复原字符
        return false
    }

    for (row in board.indices) {
        for (col in board[0].indices) {
            if (backtrack(row, col, 0)) {
                return true
            }
        }
    }
    return false
}
