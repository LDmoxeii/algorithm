package com.only4.algorithm.leetcode

fun minDistance(word1: String, word2: String): Int {
    val memo = mutableMapOf<Pair<Int, Int>, Int>()
    fun dp(i: Int, j: Int): Int {
        if (i == -1) return j + 1
        if (j == -1) return i + 1
        if (memo.containsKey(i to j)) return memo[i to j]!!
        return (if (word1[i] == word2[j])
            dp(i - 1, j - 1)
        else minOf(
            dp(i, j - 1) + 1, // 插入
            dp(i - 1, j) + 1, // 删除
            dp(i - 1, j - 1) + 1 // 替换
        )).also { memo[i to j] = it }
    }
    return dp(word1.lastIndex, word2.lastIndex)
}

fun main() {
    println(minDistance("horse", "ros"))
    println(minDistance("intention", "execution"))
}
