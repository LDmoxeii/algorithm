package com.only4.algorithm.version4k.leetcode

fun findMin(nums: IntArray): Int {
    if (nums.isEmpty()) return -1
    if (nums.size == 1) return nums[0]

    var left = 0
    var right = nums.size - 1

    // 如果数组没有旋转（完全有序），直接返回第一个元素
    if (nums[left] < nums[right]) return nums[left]

    while (left < right) {
        val mid = left + (right - left) / 2

        when {
            // 如果中间值大于数组最后一个元素，最小值在右侧
            nums[mid] > nums[right] -> left = mid + 1
            // 否则，最小值在左侧
            else -> right = mid
        }
    }
    return nums[left]
}
