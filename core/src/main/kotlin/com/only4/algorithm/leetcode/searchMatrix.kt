package com.only4.algorithm.leetcode

/**
 * [240. 搜索二维矩阵 II](https://leetcode.com/problems/search-a-2d-matrix-ii/)
 *
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
 * - 每行的元素从左到右升序排列
 * - 每列的元素从上到下升序排列
 *
 * 解题思路：
 * 从矩阵的右上角开始搜索，利用矩阵的排序特性进行高效查找：
 * 1. 如果当前元素等于目标值，返回true
 * 2. 如果当前元素大于目标值，说明当前列的所有元素都大于目标值，向左移动一列
 * 3. 如果当前元素小于目标值，说明当前行的所有元素都小于目标值，向下移动一行
 * 4. 重复上述过程直到找到目标值或超出矩阵边界
 *
 * 时间复杂度：O(m + n)，其中m是矩阵的行数，n是矩阵的列数
 * 空间复杂度：O(1)，只使用了常数级别的额外空间
 */
fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
    if (matrix.isEmpty() || matrix[0].isEmpty()) return false

    val rows = matrix.size
    val cols = matrix[0].size

    // 从右上角开始搜索
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
