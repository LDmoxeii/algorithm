package com.only4.algorithm.version4k.leetcode

fun solveNQueens(n: Int): List<List<String>> {
    val result = mutableListOf<List<String>>()
    val board = MutableList(n) { ".".repeat(n) }

    fun isValidPosition(row: Int, col: Int): Boolean {
        for (i in 0 until row) {
            if (board[i][col] == 'Q') return false
        }

        var r = row - 1
        var c = col + 1
        while (r >= 0 && c < n) {
            if (board[r][c] == 'Q') return false
            r--
            c++
        }

        r = row - 1
        c = col - 1
        while (r >= 0 && c >= 0) {
            if (board[r][c] == 'Q') return false
            r--
            c--
        }

        return true
    }

    fun backtrack(row: Int) {
        if (row == n) {
            result.add(board.toList())
            return
        }

        for (col in 0 until n) {
            if (!isValidPosition(row, col)) continue

            val newRow = StringBuilder(board[row]).apply {
                setCharAt(col, 'Q')
            }.toString()
            board[row] = newRow

            backtrack(row + 1)

            val resetRow = StringBuilder(board[row]).apply {
                setCharAt(col, '.')
            }.toString()
            board[row] = resetRow
        }
    }
    backtrack(0)
    return result
}
