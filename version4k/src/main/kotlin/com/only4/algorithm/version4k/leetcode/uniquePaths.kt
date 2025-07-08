package com.only4.algorithm.version4k.leetcode

/**
 * [62. 不同路径](https://leetcode.com/problems/unique-paths/)
 *
 * 一个机器人位于一个 m x n 网格的左上角（起始点在下图中标记为 "Start" ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 "Finish" ）。
 * 问总共有多少条不同的路径？
 *
 * 示例:
 * - 输入: m = 3, n = 7
 * - 输出: 28
 *
 * - 输入: m = 3, n = 2
 * - 输出: 3
 * - 解释: 从左上角开始，有三条路径可以到达右下角:
 *   1. 向右 -> 向下 -> 向下
 *   2. 向下 -> 向右 -> 向下
 *   3. 向下 -> 向下 -> 向右
 *
 * 解题思路:
 * 使用动态规划解决此问题。定义dp[i][j]为到达位置(i,j)的不同路径数。
 * 1. 由于机器人只能向下或向右移动，所以第一行和第一列的所有位置只有一种到达方式
 * 2. 对于其他位置(i,j)，可以从上方(i-1,j)或左方(i,j-1)到达，因此:
 *    dp[i][j] = dp[i-1][j] + dp[i][j-1]
 * 3. 最终返回dp[m][n]，即右下角位置的路径数
 *
 * 时间复杂度: O(m * n)，需要填充整个dp数组
 * 空间复杂度: O(m * n)，需要一个m*n的dp数组（这里使用Map存储）
 *
 * @param rows 网格的行数 m
 * @param cols 网格的列数 n
 * @return 从左上角到右下角的不同路径数
 */
fun uniquePaths(rows: Int, cols: Int): Int {
    // 使用Map存储每个位置的路径数，键为(row, col)坐标对
    val pathsToLocation = mutableMapOf<Pair<Int, Int>, Int>().also { pathMap ->
        // 初始化第一列，每个位置只有一种到达方式（一直向下）
        for (row in 1..rows) {
            pathMap[row to 1] = 1
        }
        // 初始化第一行，每个位置只有一种到达方式（一直向右）
        for (col in 1..cols) {
            pathMap[1 to col] = 1
        }
    }

    // 填充dp数组，计算每个位置的路径数
    for (row in 2..rows) {
        for (col in 2..cols) {
            // 当前位置的路径数 = 上方位置的路径数 + 左方位置的路径数
            pathsToLocation[row to col] = pathsToLocation[row - 1 to col]!! + pathsToLocation[row to col - 1]!!
        }
    }

    // 返回右下角位置的路径数
    return pathsToLocation[rows to cols]!!
}
