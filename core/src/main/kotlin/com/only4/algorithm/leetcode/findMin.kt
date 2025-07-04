package com.only4.algorithm.leetcode

fun findMin(nums: IntArray): Int {
    var (left, right) = 0 to nums.lastIndex

    while (left <= right) {
        val mid = left + (right - left) / 2
        when {
            nums[mid] > nums.last() -> left = mid + 1
            else -> right = mid - 1
        }
    }
    return left
}
