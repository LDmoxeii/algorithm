package com.only4.algorithm.version4k.leetcode

fun sortColors(nums: IntArray) {
    var left = 0
    var mid = 0
    var right = nums.lastIndex

    while (mid <= right) {
        when (nums[mid]) {
            0 -> {
                nums.swap(left, mid)
                left++
                mid++
            }
            1 -> {
                mid++
            }
            2 -> {
                nums.swap(mid, right)
                right--
            }
        }
    }
}

private fun IntArray.swap(i: Int, j: Int) {
    this[i] = this[j].also { this[j] = this[i] }
}
