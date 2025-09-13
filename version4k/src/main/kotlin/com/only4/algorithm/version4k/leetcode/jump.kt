package com.only4.algorithm.version4k.leetcode

fun jump(nums: IntArray): Int {
    if (nums.size <= 1) return 0

    var currentReach = 0
    var maxReach = 0
    var jumps = 0

    for (i in 0 until nums.size - 1) {
        maxReach = maxOf(maxReach, i + nums[i])

        if (i == currentReach) {
            currentReach = maxReach
            jumps++

            if (currentReach >= nums.lastIndex) {
                return jumps
            }
        }
    }
    return jumps
}
