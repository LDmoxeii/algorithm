package com.only4.algorithm.version4k.leetcode

fun numSquares(n: Int): Int {
    // 收集所有小于等于n的完全平方数
    val perfectSquares = mutableListOf<Int>()
    var sqrtValue = 1
    while (sqrtValue * sqrtValue <= n) {
        perfectSquares.add(sqrtValue * sqrtValue)
        sqrtValue++
    }

    // 创建dp数组，初始值设为最大整数
    val dp = IntArray(n + 1) { Int.MAX_VALUE }
    dp[0] = 0 // 组成0需要0个完全平方数

    // 对于每个数字，尝试使用每个完全平方数来减少它
    for (currentNum in 1..n) {
        for (square in perfectSquares) {
            if (currentNum < square) break // 完全平方数太大，无法使用

            // 使用当前完全平方数后，更新dp[currentNum]
            dp[currentNum] = minOf(dp[currentNum], dp[currentNum - square] + 1)
        }
    }

    return dp[n]
}
