package com.only4.algorithm.version4k.leetcode

/**
 * [73. 矩阵置零](https://leetcode.com/problems/set-matrix-zeroes/)
 *
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。
 * 请使用原地算法。
 *
 * 解题思路：
 * 1. 使用两个集合分别记录需要置零的行和列
 * 2. 首先遍历矩阵，记录所有包含0的行和列的索引
 * 3. 再次遍历矩阵，将对应行和列的元素置为0
 *
 * 时间复杂度：O(m*n)，其中m和n分别是矩阵的行数和列数
 * 空间复杂度：O(m+n)，需要额外的集合存储行和列的索引
 */
fun setZeroes(matrix: Array<IntArray>): Unit {
    val zeroRows = mutableSetOf<Int>()
    val zeroCols = mutableSetOf<Int>()

    // 第一次遍历：找出所有包含0的行和列
    matrix.forEachIndexed { i, row ->
        row.forEachIndexed { j, value ->
            if (value == 0) {
                zeroRows.add(i)
                zeroCols.add(j)
            }
        }
    }

    // 第二次遍历：将对应行和列的元素置为0
    matrix.forEachIndexed { i, row ->
        row.forEachIndexed { j, _ ->
            if (i in zeroRows || j in zeroCols) {
                matrix[i][j] = 0
            }
        }
    }
}

