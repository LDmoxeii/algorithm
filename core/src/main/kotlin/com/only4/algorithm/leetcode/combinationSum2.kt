package com.only4.algorithm.leetcode

fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
    candidates.sort()
    var result = mutableListOf<List<Int>>()
    val track = mutableListOf<Int>()
    var trackSum = 0
    fun backtrack(start: Int) {
        if (trackSum == target) result.add(track.toList()).run { return }
        if (trackSum > target) return

        for (i in start..<candidates.size) {
            if (i > start && candidates[i - 1] == candidates[i]) continue
            track.add(candidates[i].also { trackSum += it })
            backtrack(i + 1)
            track.removeLast().also { trackSum -= it }
        }
    }
    backtrack(0)
    return result
}

fun main() {
    val result = combinationSum2(intArrayOf(10, 1, 2, 7, 6, 1, 5), 8)
    println(result)
}
