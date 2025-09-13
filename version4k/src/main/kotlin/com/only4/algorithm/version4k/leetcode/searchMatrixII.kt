package com.only4.algorithm.version4k.leetcode

fun searchMatrixII(matrix: Array<IntArray>, target: Int): Boolean {
    if (matrix.isEmpty() || matrix[0].isEmpty()) return false

    val rows = matrix.size
    val cols = matrix[0].size

    // 从右上角开始搜索
    var row = 0
    var col = cols - 1

    while (row < rows && col >= 0) {
        when {
            matrix[row][col] == target -> return true
            matrix[row][col] > target -> col-- // 当前值太大，向左移动
            else -> row++ // 当前值太小，向下移动
        }
    }

    return false
}
