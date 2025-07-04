package com.only4.algorithm.leetcode

fun combinationSum3(k: Int, n: Int): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    val track = mutableListOf<Int>()
    var trackSum = 0
    fun backtrack(start: Int) {
        if (trackSum == n && track.size == k) result.add(track.toList())
        if (track.size > k) return
        if (trackSum > n) return

        for (index in start..9) {
            track.add(index.also { trackSum += it })
            backtrack(index + 1)
            track.removeLast().also { trackSum -= it }
        }
    }
    backtrack(1)
    return result
}
