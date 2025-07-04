package com.only4.algorithm.leetcode

fun searchInsert(nums: IntArray, target: Int): Int {
    var (left, right) = 0 to nums.lastIndex

    while (left <= right) {
        val mid = left + (right - left) / 2
        when {
            nums[mid] == target -> return mid
            nums[mid] < target -> left = mid + 1
            nums[mid] > target -> right = mid - 1
        }
    }
    println("$left + $right")
    return left
}

fun main() {
    val nums = intArrayOf(1, 3, 5, 6)
    println(searchInsert(nums, 5))
    println(searchInsert(nums, 2))
    println(searchInsert(nums, 7))
}
