package com.only4.algorithm.leetcode

/**
 * [283. 移动零](https://leetcode.cn/problems/move-zeroes/)
 *
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 请注意，必须在不复制数组的情况下原地对数组进行操作。
 *
 * 示例 1:
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 *
 * 示例 2:
 * 输入: nums = [0]
 * 输出: [0]
 *
 * 提示:
 * - 1 <= nums.length <= 10^4
 * - -2^31 <= nums[i] <= 2^31 - 1
 *
 * 解题思路：使用双指针技术。一个指针用于遍历数组，另一个指针用于记录非零元素应该放置的位置。
 * 当遍历指针遇到非零元素时，将其与非零指针位置的元素交换，然后非零指针向前移动。
 * 这样可以保证所有非零元素都被移到数组前面，同时保持它们的相对顺序不变。
 *
 * 时间复杂度：O(n)，其中n是数组的长度
 * 空间复杂度：O(1)，只使用了常数额外空间
 *
 * @param nums 整数数组
 */
fun moveZeroes(nums: IntArray) {
    var nonZeroIndex = 0

    for (i in nums.indices) {
        if (nums[i] != 0) {
            // 交换当前元素与nonZeroIndex位置的元素
            if (i != nonZeroIndex) {
                nums[nonZeroIndex] = nums[i].also { nums[i] = nums[nonZeroIndex] }
            }
            nonZeroIndex++
        }
    }
}
