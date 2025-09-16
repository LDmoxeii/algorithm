package com.only4.algorithm.version4k.leetcode

fun generate(numRows: Int): List<List<Int>> {
    // 参数校验
    if (numRows <= 0) return emptyList()

    // 创建杨辉三角结果列表，每行长度为rowIndex+1，初始值都为1
    val pascalTriangle = List(numRows) { rowIndex ->
        MutableList(rowIndex + 1) { 1 }
    }

    // 从第3行(索引为2)开始填充中间元素
    for (rowIndex in 2 until numRows) {
        for (columnIndex in 1 until rowIndex) {
            // 当前元素 = 上一行左上方元素 + 上一行右上方元素
            val leftParentValue = pascalTriangle[rowIndex - 1][columnIndex - 1]
            val rightParentValue = pascalTriangle[rowIndex - 1][columnIndex]
            val currentValue = leftParentValue + rightParentValue

            pascalTriangle[rowIndex][columnIndex] = currentValue
        }
    }

    return pascalTriangle
}
