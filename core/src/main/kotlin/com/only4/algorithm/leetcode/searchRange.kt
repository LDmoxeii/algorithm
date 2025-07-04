package com.only4.algorithm.leetcode

fun searchRange(nums: IntArray, target: Int): IntArray {
    fun leftBound(nums: IntArray, target: Int): Int {
        var (left, right) = 0 to nums.lastIndex

        while (left <= right) {
            val mid = left + (right - left) / 2
            when {
                nums[mid] == target -> right = mid - 1
                nums[mid] < target -> left = mid + 1
                nums[mid] > target -> right = mid - 1
            }
        }

        return when {
            left < 0 -> -1
            left >= nums.size -> -1
            nums[left] != target -> -1
            else -> left
        }
    }

    fun rightBound(nums: IntArray, target: Int): Int {
        var (left, right) = 0 to nums.lastIndex

        while (left <= right) {
            val mid = left + (right - left) / 2
            when {
                nums[mid] == target -> left = mid + 1
                nums[mid] < target -> left = mid + 1
                nums[mid] > target -> right = mid - 1
            }
        }
        return when {
            right < 0 -> -1
            right >= nums.size -> -1
            nums[right] != target -> -1
            else -> right
        }
    }

    val left = leftBound(nums, target)
    val right = rightBound(nums, target)
    return intArrayOf(left, right)
}

fun main() {
    val nums = intArrayOf(5, 7, 7, 8, 8, 10)
    val target = 8
    val result = searchRange(nums, target)
    println(result.contentToString())
}
