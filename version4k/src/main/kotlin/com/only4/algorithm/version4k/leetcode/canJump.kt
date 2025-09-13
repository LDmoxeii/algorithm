package com.only4.algorithm.version4k.leetcode

fun canJump(nums: IntArray): Boolean {
    if (nums.size == 1) return true

    var maxReach = 0

    for (i in nums.indices) {
        if (i > maxReach) return false

        maxReach = maxOf(maxReach, i + nums[i])

        if (maxReach >= nums.lastIndex) return true
    }

    return maxReach >= nums.lastIndex
}

