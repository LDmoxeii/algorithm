package com.only4.algorithm.version4k.leetcode

fun moveZeroes(nums: IntArray) {
    var slow = 0 // 指向下一个非零元素应该放置的位置

    for (fast in nums.indices) {
        // 如果当前元素不为0，将其移动到slow位置
        if (nums[fast] != 0) {
            if (fast != slow) {
                // Kotlin的also语法实现交换
                nums[slow] = nums[fast].also { nums[fast] = nums[slow] }
            }
            slow++ // 更新下一个非零元素的位置
        }
    }
}
