package com.only4.algorithm.leetcode

/**
 * [51. N 皇后](https://leetcode.com/problems/n-queens/)
 *
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 给你一个整数 n ，返回所有不同的 n 皇后问题的解决方案。
 * 每一种解法包含一个不同的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 * 解题思路：
 * 使用回溯算法，逐行放置皇后。对于每一行，尝试在不同列放置皇后，并检查是否有效。
 * 有效性检查包括：
 * 1. 同一列上不能有其他皇后
 * 2. 左上到右下的对角线上不能有其他皇后
 * 3. 右上到左下的对角线上不能有其他皇后
 *
 * 时间复杂度：O(n!)，其中n是棋盘大小
 * 空间复杂度：O(n)，递归调用栈的深度最大为n
 */
fun solveNQueens(n: Int): List<List<String>> {
    val result = mutableListOf<List<String>>()
    val board = MutableList(n) { ".".repeat(n) }

    /**
     * 检查在指定位置放置皇后是否有效
     *
     * @param row 当前行
     * @param col 当前列
     * @return 在该位置放置皇后是否有效
     */
    fun isValid(row: Int, col: Int): Boolean {
        // 检查同一列上是否有皇后
        for (i in 0 until row) {
            if (board[i][col] == 'Q') return false
        }

        // 检查左上到右下对角线
        var x = row - 1
        var y = col + 1
        while (x >= 0 && y < n) {
            if (board[x][y] == 'Q') return false
            x--
            y++
        }

        // 检查右上到左下对角线
        x = row - 1
        y = col - 1
        while (x >= 0 && y >= 0) {
            if (board[x][y] == 'Q') return false
            x--
            y--
        }

        return true
    }

    /**
     * 回溯函数，逐行放置皇后
     *
     * @param row 当前处理的行
     */
    fun backtrack(row: Int) {
        // 如果所有行都已放置皇后，将当前棋盘状态添加到结果中
        if (row == n) {
            result.add(board.toList())
            return
        }

        // 尝试在当前行的每一列放置皇后
        for (col in 0 until n) {
            if (!isValid(row, col)) continue

            // 放置皇后
            val newRow = StringBuilder(board[row]).apply {
                setCharAt(col, 'Q')
            }.toString()
            board[row] = newRow

            // 递归处理下一行
            backtrack(row + 1)

            // 回溯，移除皇后
            val resetRow = StringBuilder(board[row]).apply {
                setCharAt(col, '.')
            }.toString()
            board[row] = resetRow
        }
    }

    backtrack(0)
    return result
}
