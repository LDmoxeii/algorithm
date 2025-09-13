package com.only4.algorithm.version4k.leetcode

fun longestPalindrome(s: String): String {
    val n = s.length
    if (n < 2) return s

    val dp = Array(n) { BooleanArray(n) }
    var start = 0
    var maxLen = 1

    for (i in 0 until n) {
        dp[i][i] = true
    }

    for (i in 0 until n - 1) {
        if (s[i] == s[i + 1]) {
            dp[i][i + 1] = true
            start = i
            maxLen = 2
        }
    }

    for (len in 3..n) {
        for (i in 0..n - len) {
            val j = i + len - 1
            if (s[i] == s[j] && dp[i + 1][j - 1]) {
                dp[i][j] = true
                if (len > maxLen) {
                    start = i
                    maxLen = len
                }
            }
        }
    }

    return s.substring(start, start + maxLen)
}
