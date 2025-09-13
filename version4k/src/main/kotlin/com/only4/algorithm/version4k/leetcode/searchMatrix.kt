package com.only4.algorithm.version4k.leetcode

fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
    if (matrix.isEmpty() || matrix[0].isEmpty()) return false

    val rows = matrix.size
    val cols = matrix[0].size

    var row = 0
    var col = cols - 1

    while (row < rows && col >= 0) {
        when {
            matrix[row][col] == target -> return true
            matrix[row][col] > target -> col--
            else -> row++
        }
    }
    return false
}
