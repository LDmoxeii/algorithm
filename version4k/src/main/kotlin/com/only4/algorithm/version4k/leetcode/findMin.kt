package com.only4.algorithm.version4k.leetcode

/**
 * [153. 寻找旋转排序数组中的最小值](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)
 *
 * 已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次旋转后，得到输入数组。
 * 例如，原数组 [0,1,2,4,5,6,7] 在变化后可能得到：
 * - 若旋转 4 次，则可以得到 [4,5,6,7,0,1,2]
 * - 若旋转 7 次，则可以得到 [0,1,2,4,5,6,7]
 *
 * 给你一个元素值互不相同的数组 nums，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。
 * 请你找出并返回数组中的最小元素。
 * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
 *
 * 示例:
 * - 输入: nums = [3,4,5,1,2] 输出: 1
 * - 输入: nums = [4,5,6,7,0,1,2] 输出: 0
 * - 输入: nums = [11,13,15,17] 输出: 11
 *
 * 解题思路:
 * 使用二分查找来找到旋转排序数组中的最小值。关键思路是比较中间元素与数组最后一个元素的大小关系：
 * 1. 如果中间元素大于最后一个元素，说明最小值在中间元素的右侧
 * 2. 否则，最小值在中间元素的左侧（包括中间元素本身）
 * 3. 当左右指针相遇时，左指针指向的就是最小值
 *
 * 时间复杂度: O(log n)，二分查找的时间复杂度
 * 空间复杂度: O(1)，只使用了常数级别的额外空间
 */
fun findMin(nums: IntArray): Int {
    // 处理边界情况：空数组或只有一个元素的数组
    if (nums.isEmpty()) return -1
    if (nums.size == 1) return nums[0]

    var left = 0
    var right = nums.lastIndex

    // 如果数组没有旋转（完全有序），直接返回第一个元素
    if (nums[left] < nums[right]) return nums[left]

    while (left <= right) {
        val mid = left + (right - left) / 2

        // 检查mid是否是最小值的位置
        if (mid > 0 && nums[mid] < nums[mid - 1]) {
            return nums[mid]
        }

        // 检查mid+1是否是最小值的位置
        if (mid < nums.lastIndex && nums[mid] > nums[mid + 1]) {
            return nums[mid + 1]
        }

        when {
            // 如果中间值大于数组最后一个元素，最小值在右侧
            nums[mid] > nums[right] -> left = mid + 1
            // 否则，最小值在左侧
            else -> right = mid - 1
        }
    }

    // 理论上不会执行到这里，但为了代码完整性，返回第一个元素
    return nums[0]
}
