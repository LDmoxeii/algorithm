package com.only4.algorithm.version4k.leetcode

fun subsets(nums: IntArray): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    val path = mutableListOf<Int>()

    fun backtrack(startIndex: Int) {
        result.add(path.toList())

        for (i in startIndex until nums.size) {
            path.add(nums[i])
            backtrack(i + 1)
            path.removeAt(path.lastIndex)
        }
    }
    backtrack(0)
    return result
}
