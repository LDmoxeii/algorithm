package com.only4.algorithm.version4k.leetcode

/**
 * [34. 在排序数组中查找元素的第一个和最后一个位置](https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)
 *
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 *
 * 示例:
 * - 输入: nums = [5,7,7,8,8,10], target = 8 输出: [3,4]
 * - 输入: nums = [5,7,7,8,8,10], target = 6 输出: [-1,-1]
 * - 输入: nums = [], target = 0 输出: [-1,-1]
 *
 * 解题思路:
 * 使用两次二分查找，分别找到目标值的左边界和右边界。
 * 1. 左边界查找：当找到目标值时，继续向左查找，缩小右边界
 * 2. 右边界查找：当找到目标值时，继续向右查找，缩小左边界
 * 3. 最后返回左边界和右边界的索引
 *
 * 时间复杂度: O(log n)，其中n是数组长度，使用了两次二分查找
 * 空间复杂度: O(1)，只使用了常数级别的额外空间
 */
fun searchRange(nums: IntArray, target: Int): IntArray {
    /**
     * 查找目标值的左边界
     */
    fun leftBound(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.lastIndex

        while (left <= right) {
            val mid = left + (right - left) / 2
            when {
                nums[mid] == target -> right = mid - 1 // 找到目标值，继续向左查找
                nums[mid] < target -> left = mid + 1
                else -> right = mid - 1
            }
        }

        // 检查left是否有效且等于目标值
        return when {
            left < 0 || left >= nums.size -> -1
            nums[left] != target -> -1
            else -> left
        }
    }

    /**
     * 查找目标值的右边界
     */
    fun rightBound(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.lastIndex

        while (left <= right) {
            val mid = left + (right - left) / 2
            when {
                nums[mid] == target -> left = mid + 1 // 找到目标值，继续向右查找
                nums[mid] < target -> left = mid + 1
                else -> right = mid - 1
            }
        }

        // 检查right是否有效且等于目标值
        return when {
            right < 0 || right >= nums.size -> -1
            nums[right] != target -> -1
            else -> right
        }
    }

    // 处理空数组情况
    if (nums.isEmpty()) return intArrayOf(-1, -1)

    val left = leftBound(nums, target)
    val right = rightBound(nums, target)
    return intArrayOf(left, right)
}
