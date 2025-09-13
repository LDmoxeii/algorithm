package com.only4.algorithm.version4k.leetcode

fun firstMissingPositive(nums: IntArray): Int {
    val n = nums.size

    // 第一次遍历：将每个数放到它应该在的位置上
    for (i in 0 until n) {
        // 当前数在有效范围内且不在正确位置上时，将其交换到正确位置
        while (nums[i] in 1..n && nums[nums[i] - 1] != nums[i]) {
            // 交换 nums[i] 和 nums[nums[i] - 1]
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
