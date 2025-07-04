package com.only4.algorithm.leetcode

fun subsetsWithDup(nums: IntArray): List<List<Int>> {
    nums.sort()
    var result = mutableListOf<List<Int>>()
    val track = mutableListOf<Int>()
    fun backtrack(start: Int) {
        result.add(track.toList())

        for (i in start..<nums.size) {
            if (i > start && nums[i - 1] == nums[i]) continue
            track.add(nums[i])
            backtrack(i + 1)
            track.removeLast()
        }
    }
    backtrack(0)
    return result
}

fun main() {
    val nums = intArrayOf(1, 2, 2)
    println(subsetsWithDup(nums))
}
