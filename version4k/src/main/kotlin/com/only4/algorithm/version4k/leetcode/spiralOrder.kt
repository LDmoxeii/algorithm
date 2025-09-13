package com.only4.algorithm.version4k.leetcode

fun spiralOrder(matrix: Array<IntArray>): List<Int> {
    if (matrix.isEmpty()) return emptyList()

    val result = mutableListOf<Int>()
    var top = 0
    var bottom = matrix.lastIndex
    var left = 0
    var right = matrix[0].lastIndex

    while (top <= bottom && left <= right) {
        // 1. 从左到右遍历上边界
        for (col in left..right) {
            result.add(matrix[top][col])
        }
        top++

        // 2. 从上到下遍历右边界
        for (row in top..bottom) {
            result.add(matrix[row][right])
        }
        right--

        // 3. 从右到左遍历下边界（如果存在剩余行）
        if (top <= bottom) {
            for (col in right downTo left) {
                result.add(matrix[bottom][col])
            }
            bottom--
        }

        // 4. 从下到上遍历左边界（如果存在剩余列）
        if (left <= right) {
            for (row in bottom downTo top) {
                result.add(matrix[row][left])
            }
            left++
        }
    }

    return result
}
