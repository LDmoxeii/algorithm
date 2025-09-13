package com.only4.algorithm.version4k.leetcode

fun minPathSum(grid: Array<IntArray>): Int {
    val m = grid.size
    val n = grid[0].size
    val dp = Array(m) { IntArray(n) }

    dp[0][0] = grid[0][0]

    for (i in 1 until m) {
        dp[i][0] = dp[i - 1][0] + grid[i][0]
    }

    for (j in 1 until n) {
        dp[0][j] = dp[0][j - 1] + grid[0][j]
    }

    for (i in 1 until m) {
        for (j in 1 until n) {
            dp[i][j] = minOf(dp[i - 1][j], dp[i][j - 1]) + grid[i][j]
        }
    }

    return dp[m - 1][n - 1]
}
