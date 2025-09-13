package com.only4.algorithm.version4k.leetcode

fun permute(nums: IntArray): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    val path = mutableListOf<Int>()
    val used = BooleanArray(nums.size)

    fun backtrack() {
        if (path.size == nums.size) {
            result.add(path.toList())
            return
        }

        for (i in nums.indices) {
            if (used[i]) continue

            used[i] = true
            path.add(nums[i])
            backtrack()
            path.removeAt(path.lastIndex)
            used[i] = false
        }
    }
    backtrack()
    return result
}
