package com.only4.algorithm.leetcode

fun search(nums: IntArray, target: Int): Int {
    fun IntArray.findMin(): Int {
        var (left, right) = 0 to this.lastIndex

        while (left <= right) {
            val mid = left + (right - left) / 2
            when {
                this[mid] > this.last() -> left = mid + 1
                else -> right = mid - 1
            }
        }
        return left
    }

    fun IntArray.binarySearch(left: Int, right: Int): Int {
        var (left, right) = left to right

        while (left <= right) {
            val mid = left + (right - left) / 2
            when {
                nums[mid] == target -> return mid
                nums[mid] > target -> right = mid - 1
                nums[mid] < target -> left = mid + 1
            }
        }
        return -1
    }

    val mid = nums.findMin()
    return when {
        target > nums.last() -> nums.binarySearch(0, mid - 1)
        else -> nums.binarySearch(mid, nums.lastIndex)
    }
}

fun main() {
    val nums = intArrayOf(4, 5, 6, 7, 0, 1, 2)
    println(search(nums, 0))
    println(search(nums, 3))
}
