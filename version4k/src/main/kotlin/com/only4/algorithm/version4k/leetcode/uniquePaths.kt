package com.only4.algorithm.version4k.leetcode

fun uniquePaths(m: Int, n: Int): Int {
    // pathCountToPosition[row][col] 表示到达位置(row, col)的不同路径数
    val pathCountToPosition = Array(m) { IntArray(n) }

    // 初始化第一列，从起点到第一列任意位置只有一种路径（一直向下）
    for (rowIndex in 0 until m) {
        pathCountToPosition[rowIndex][0] = 1
    }

    // 初始化第一行，从起点到第一行任意位置只有一种路径（一直向右）
    for (colIndex in 0 until n) {
        pathCountToPosition[0][colIndex] = 1
    }

    // 计算其他位置的路径数：路径数 = 上方路径数 + 左方路径数
    for (rowIndex in 1 until m) {
        for (colIndex in 1 until n) {
            val pathsFromAbove = pathCountToPosition[rowIndex - 1][colIndex]
            val pathsFromLeft = pathCountToPosition[rowIndex][colIndex - 1]
            pathCountToPosition[rowIndex][colIndex] = pathsFromAbove + pathsFromLeft
        }
    }

    // 返回到达右下角的路径总数
    return pathCountToPosition[m - 1][n - 1]
}
