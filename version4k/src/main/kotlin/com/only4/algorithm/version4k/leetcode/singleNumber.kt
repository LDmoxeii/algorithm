package com.only4.algorithm.version4k.leetcode

fun singleNumber(nums: IntArray): Int {
    // 利用异或运算性质：a xor a = 0, a xor 0 = a
    // 相同数字异或会抵消，只剩下出现一次的数字
    var uniqueNumber = nums[0]

    for (arrayIndex in 1 until nums.size) {
        val currentNumber = nums[arrayIndex]
        uniqueNumber = uniqueNumber xor currentNumber
    }

    return uniqueNumber
}
