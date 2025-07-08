package com.only4.algorithm.version4k.leetcode

/**
 * [54. 螺旋矩阵](https://leetcode.com/problems/spiral-matrix/)
 *
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 *
 * 解题思路：
 * 1. 使用四个变量表示当前未遍历区域的边界：上(top)、下(bottom)、左(left)、右(right)
 * 2. 按照顺时针方向（从左到右、从上到下、从右到左、从下到上）依次遍历边界上的元素
 * 3. 每遍历完一条边，相应的边界向内收缩一格
 * 4. 当边界交叉时（top > bottom 或 left > right），遍历结束
 *
 * 时间复杂度：O(m*n)，其中m和n分别是矩阵的行数和列数，需要遍历矩阵中的每个元素
 * 空间复杂度：O(1)，除了存储结果的数组外，只使用了常数级别的额外空间
 */
fun spiralOrder(matrix: Array<IntArray>): List<Int> {
    if (matrix.isEmpty()) return emptyList()

    var top = 0;
    var bottom = matrix.lastIndex
    var left = 0;
    var right = matrix[0].lastIndex
    val result = mutableListOf<Int>()

    while (top <= bottom && left <= right) {
        // 1. 从左到右遍历上边界
        for (i in left..right) {
            result.add(matrix[top][i])
        }
        top++

        // 2. 从上到下遍历右边界
        for (i in top..bottom) {
            result.add(matrix[i][right])
        }
        right--

        // 3. 从右到左遍历下边界（如果存在剩余行）
        if (top <= bottom) {
            for (i in right downTo left) {
                result.add(matrix[bottom][i])
            }
            bottom--
        }

        // 4. 从下到上遍历左边界（如果存在剩余列）
        if (left <= right) {
            for (i in bottom downTo top) {
                result.add(matrix[i][left])
            }
            left++
        }
    }

    return result
}
