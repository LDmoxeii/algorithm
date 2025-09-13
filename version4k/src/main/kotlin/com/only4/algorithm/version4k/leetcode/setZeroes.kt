package com.only4.algorithm.version4k.leetcode

fun setZeroes(matrix: Array<IntArray>): Unit {
    val zeroRows = mutableSetOf<Int>()
    val zeroCols = mutableSetOf<Int>()

    // 第一次遍历：找出所有包含0的行和列
    matrix.forEachIndexed { row, rowArray ->
        rowArray.forEachIndexed { col, value ->
            if (value == 0) {
                zeroRows.add(row)
                zeroCols.add(col)
            }
        }
    }

    // 第二次遍历：将对应行和列的元素置为0
    matrix.forEachIndexed { row, rowArray ->
        rowArray.forEachIndexed { col, _ ->
            if (row in zeroRows || col in zeroCols) {
                matrix[row][col] = 0
            }
        }
    }
}

