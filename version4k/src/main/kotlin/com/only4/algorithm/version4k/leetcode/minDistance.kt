package com.only4.algorithm.version4k.leetcode

fun minDistance(word1: String, word2: String): Int {
    val m = word1.length
    val n = word2.length
    val dp = Array(m + 1) { IntArray(n + 1) }

    for (j in 0..n) {
        dp[0][j] = j
    }

    for (i in 0..m) {
        dp[i][0] = i
    }

    for (i in 1..m) {
        for (j in 1..n) {
            if (word1[i - 1] == word2[j - 1]) {
                dp[i][j] = dp[i - 1][j - 1]
            } else {
                dp[i][j] = minOf(
                    dp[i][j - 1] + 1,     // 插入操作
                    dp[i - 1][j] + 1,     // 删除操作
                    dp[i - 1][j - 1] + 1  // 替换操作
                )
            }
        }
    }

    return dp[m][n]
}
