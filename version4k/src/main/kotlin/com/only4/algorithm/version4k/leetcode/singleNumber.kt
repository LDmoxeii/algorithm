package com.only4.algorithm.version4k.leetcode

fun singleNumber(nums: IntArray): Int {
    var result = nums[0]
    for (i in 1 until nums.size) {
        result = result xor nums[i]
    }
    return result
}
