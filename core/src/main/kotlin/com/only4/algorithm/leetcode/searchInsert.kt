package com.only4.algorithm.leetcode

/**
 * [35. 搜索插入位置](https://leetcode.com/problems/search-insert-position/)
 *
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 *
 * 示例:
 * - 输入: [1,3,5,6], 5 输出: 2
 * - 输入: [1,3,5,6], 2 输出: 1
 * - 输入: [1,3,5,6], 7 输出: 4
 * - 输入: [1,3,5,6], 0 输出: 0
 *
 * 解题思路:
 * 使用二分查找算法。对于有序数组，我们可以通过二分查找快速定位目标值的位置。
 * 如果目标值存在于数组中，直接返回其索引；
 * 如果目标值不存在，二分查找结束后的left指针位置就是目标值应该插入的位置。
 *
 * 时间复杂度: O(log n)，其中n是数组长度，二分查找的时间复杂度为对数级别
 * 空间复杂度: O(1)，只使用了常数级别的额外空间
 */
fun searchInsert(nums: IntArray, target: Int): Int {
    var left = 0
    var right = nums.lastIndex

    while (left <= right) {
        val mid = left + (right - left) / 2

        when {
            nums[mid] == target -> return mid
            nums[mid] < target -> left = mid + 1
            else -> right = mid - 1
        }
    }

    return left
}
