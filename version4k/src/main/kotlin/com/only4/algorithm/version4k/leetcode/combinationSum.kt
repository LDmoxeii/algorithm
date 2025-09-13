package com.only4.algorithm.version4k.leetcode

fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
    candidates.sort()
    val result = mutableListOf<List<Int>>()
    val path = mutableListOf<Int>()

    fun backtrack(startIndex: Int, remainingTarget: Int) {
        if (remainingTarget == 0) {
            result.add(path.toList())
            return
        }
        if (remainingTarget < 0) return

        for (i in startIndex until candidates.size) {
            if (candidates[i] > remainingTarget) break

            path.add(candidates[i])
            backtrack(i, remainingTarget - candidates[i])
            path.removeAt(path.lastIndex)
        }
    }
    backtrack(0, target)
    return result
}
