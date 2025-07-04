package com.only4.algorithm.leetcode

/**
 * [41. 缺失的第一个正数](https://leetcode.com/problems/first-missing-positive/)
 *
 * 给你一个未排序的整数数组 nums，请你找出其中没有出现的最小的正整数。
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 *
 * 解题思路：原地哈希
 * 1. 遍历数组，将每个数放到它应该在的位置上（nums[i] 应该放在索引 nums[i]-1 的位置上）
 * 2. 再次遍历数组，第一个不在正确位置上的元素的索引+1就是我们要找的数
 * 3. 如果所有元素都在正确位置上，则返回数组长度+1
 *
 * 时间复杂度：O(n)，其中n是数组的长度
 * 空间复杂度：O(1)，只使用了常数级别的额外空间
 */
fun firstMissingPositive(nums: IntArray): Int {
    val n = nums.size

    // 第一次遍历：将每个数放到它应该在的位置上
    for (i in 0 until n) {
        // 当前数在有效范围内且不在正确位置上时，将其交换到正确位置
        while (nums[i] in 1..n && nums[nums[i] - 1] != nums[i]) {
            val temp = nums[nums[i] - 1]
            nums[nums[i] - 1] = nums[i]
            nums[i] = temp
        }
    }

    // 第二次遍历：找到第一个不在正确位置上的元素
    for (i in 0 until n) {
        if (nums[i] != i + 1) {
            return i + 1
        }
    }

    // 如果所有元素都在正确位置上，返回n+1
    return n + 1
}
