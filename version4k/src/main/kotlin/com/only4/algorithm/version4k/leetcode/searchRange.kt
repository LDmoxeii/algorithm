package com.only4.algorithm.version4k.leetcode

fun searchRange(nums: IntArray, target: Int): IntArray {
    if (nums.isEmpty()) return intArrayOf(-1, -1)

    fun findLeftBound(): Int {
        var left = 0
        var right = nums.size - 1

        while (left <= right) {
            val mid = left + (right - left) / 2
            when {
                nums[mid] == target -> right = mid - 1
                nums[mid] < target -> left = mid + 1
                else -> right = mid - 1
            }
        }

        return if (left >= 0 && left < nums.size && nums[left] == target) left else -1
    }

    fun findRightBound(): Int {
        var left = 0
        var right = nums.size - 1

        while (left <= right) {
            val mid = left + (right - left) / 2
            when {
                nums[mid] == target -> left = mid + 1
                nums[mid] < target -> left = mid + 1
                else -> right = mid - 1
            }
        }

        return if (right >= 0 && right < nums.size && nums[right] == target) right else -1
    }

    return intArrayOf(findLeftBound(), findRightBound())
}
