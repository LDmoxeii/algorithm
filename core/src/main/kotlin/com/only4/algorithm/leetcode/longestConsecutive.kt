package com.only4.algorithm.leetcode

import kotlin.math.max

/**
 * [128. 最长连续序列](https://leetcode.cn/problems/longest-consecutive-sequence/)
 *
 * 给定一个未排序的整数数组 nums，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 *
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 *
 * 示例 1：
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 *
 * 示例 2：
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 *
 * 提示：
 * - 0 <= nums.length <= 10^5
 * - -10^9 <= nums[i] <= 10^9
 *
 * 解题思路：使用HashSet存储所有数字，然后遍历数组中的每个数字。对于每个数字，
 * 如果它是一个序列的起点（即不存在比它小1的数字），则尝试找出以它开始的最长连续序列。
 * 通过不断检查当前数字加1是否存在于集合中，来确定序列的长度。
 *
 * 时间复杂度：O(n)，虽然有嵌套循环，但内层循环最多执行n次，因为每个数字最多被访问两次
 * 空间复杂度：O(n)，需要HashSet存储所有数字
 *
 * @param nums 未排序的整数数组
 * @return 最长连续序列的长度
 */
fun longestConsecutive(nums: IntArray): Int {
    if (nums.isEmpty()) return 0

    var maxLength = 0
    val numSet = nums.toHashSet()

    for (num in numSet) {
        // 只检查序列的起点（不存在前驱数字num-1）
        if (!numSet.contains(num - 1)) {
            var currentNum = num
            var currentLength = 1

            // 检查连续的后继数字
            while (numSet.contains(++currentNum)) {
                currentLength++
            }

            maxLength = max(maxLength, currentLength)
        }
    }

    return maxLength
}
