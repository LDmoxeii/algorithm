package com.only4.algorithm.version4k.leetcode

fun generate(numRows: Int): List<List<Int>> {
    // 参数校验
    if (numRows <= 0) return emptyList()

    // 创建结果列表，每行的长度为i+1，初始值都为1
    val result = List(numRows) { i -> MutableList(i + 1) { 1 } }

    // 从第3行(索引为2)开始填充中间元素
    for (i in 2 until numRows) {
        for (j in 1 until i) {
            // 当前元素等于上一行左上方和右上方元素之和
            result[i][j] = result[i - 1][j - 1] + result[i - 1][j]
        }
    }

    return result
}
