package com.only4.algorithm.leetcode

fun combine(n: Int, k: Int): List<List<Int>> {
    var result = mutableListOf<List<Int>>()
    val track = mutableListOf<Int>()
    fun backtrack(start: Int) {
        if (track.size == k) result.add(track.toList()).run { return }

        for (i in start..n) {
            track.add(i)
            backtrack(i + 1)
            track.removeLast()
        }
    }
    backtrack(1)
    return result
}

fun main() {
    println(combine(4, 2))
}
