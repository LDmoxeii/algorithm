package com.only4.algorithm.leetcode

fun permuteUnique(nums: IntArray): List<List<Int>> {
    nums.sort()
    var result = mutableListOf<List<Int>>()
    val track = mutableListOf<Int>()
    val used = BooleanArray(nums.size) { false }
    fun backtrack() {
        if (track.size == nums.size) result.add(track.toList()).run { return }

        for (i in 0..<nums.size) {
            if (used[i]) continue
            if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) continue
            track.add(nums[i]).run { used[i] = true }
            backtrack()
            track.removeLast().run { used[i] = false }
        }
    }
    backtrack()
    return result
}

fun main() {
    println(permuteUnique(intArrayOf(1, 1, 2)))
}
