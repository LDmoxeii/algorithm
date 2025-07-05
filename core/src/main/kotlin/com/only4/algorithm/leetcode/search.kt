package com.only4.algorithm.leetcode

/**
 * [33. 搜索旋转排序数组](https://leetcode.com/problems/search-in-rotated-sorted-array/)
 *
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，
 * 使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。
 * 例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 *
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
 *
 * 示例:
 * - 输入: nums = [4,5,6,7,0,1,2], target = 0 输出: 4
 * - 输入: nums = [4,5,6,7,0,1,2], target = 3 输出: -1
 * - 输入: nums = [1], target = 0 输出: -1
 *
 * 解题思路:
 * 1. 首先使用二分查找找到数组中的最小值位置（旋转点）
 * 2. 然后根据目标值与数组最后一个元素的大小关系，决定在哪个部分进行二分查找：
 *    - 如果目标值大于数组最后一个元素，则在左半部分查找
 *    - 否则在右半部分查找
 * 3. 在确定的部分使用标准二分查找
 *
 * 时间复杂度: O(log n)，使用了两次二分查找
 * 空间复杂度: O(1)，只使用了常数级别的额外空间
 */
fun search(nums: IntArray, target: Int): Int {
    // 处理空数组情况
    if (nums.isEmpty()) return -1

    /**
     * 查找旋转数组中的最小值位置（旋转点）
     */
    fun IntArray.findMin(): Int {
        var left = 0
        var right = this.lastIndex

        while (left <= right) {
            val mid = left + (right - left) / 2
            when {
                this[mid] > this.last() -> left = mid + 1 // 最小值在右侧
                else -> right = mid - 1 // 最小值在左侧或当前位置
            }
        }
        return left
    }

    /**
     * 在指定范围内进行标准二分查找
     */
    fun IntArray.binarySearch(left: Int, right: Int): Int {
        var lo = left
        var hi = right

        while (lo <= hi) {
            val mid = lo + (hi - lo) / 2
            when {
                this[mid] == target -> return mid // 找到目标值
                this[mid] > target -> hi = mid - 1 // 目标值在左侧
                else -> lo = mid + 1 // 目标值在右侧
            }
        }
        return -1 // 未找到目标值
    }

    // 找到旋转点
    val pivotIndex = nums.findMin()

    // 根据目标值与数组最后一个元素的关系，决定在哪个部分查找
    return when {
        // 如果数组未旋转或旋转点是第一个元素，直接在整个数组中查找
        pivotIndex == 0 -> nums.binarySearch(0, nums.lastIndex)
        // 如果目标值大于数组最后一个元素，在左半部分查找
        target > nums.last() -> nums.binarySearch(0, pivotIndex - 1)
        // 否则在右半部分查找
        else -> nums.binarySearch(pivotIndex, nums.lastIndex)
    }
}
