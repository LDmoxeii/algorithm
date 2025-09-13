package com.only4.algorithm.version4k.leetcode

fun search(nums: IntArray, target: Int): Int {
    if (nums.isEmpty()) return -1

    fun findMinIndex(): Int {
        var left = 0
        var right = nums.size - 1

        while (left < right) {
            val mid = left + (right - left) / 2
            when {
                nums[mid] > nums[right] -> left = mid + 1
                else -> right = mid
            }
        }
        return left
    }

    fun binarySearch(left: Int, right: Int): Int {
        var lo = left
        var hi = right

        while (lo <= hi) {
            val mid = lo + (hi - lo) / 2
            when {
                nums[mid] == target -> return mid
                nums[mid] > target -> hi = mid - 1
                else -> lo = mid + 1
            }
        }
        return -1
    }

    val pivotIndex = findMinIndex()

    return when {
        pivotIndex == 0 -> binarySearch(0, nums.size - 1)
        target > nums.last() -> binarySearch(0, pivotIndex - 1)
        else -> binarySearch(pivotIndex, nums.size - 1)
    }
}
