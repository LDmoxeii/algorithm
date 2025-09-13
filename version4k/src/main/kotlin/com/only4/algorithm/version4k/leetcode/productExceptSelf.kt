package com.only4.algorithm.version4k.leetcode

fun productExceptSelf(nums: IntArray): IntArray {
    val n = nums.size
    val result = IntArray(n)

    // 第一次遍历：计算左侧乘积
    result[0] = 1 // 第一个元素左侧没有元素，乘积为1
    for (i in 1 until n) {
        result[i] = result[i - 1] * nums[i - 1]
    }

    // 第二次遍历：计算右侧乘积并与左侧乘积相乘
    var rightProduct = 1 // 右侧乘积的累积值
    for (i in n - 1 downTo 0) {
        result[i] *= rightProduct // 左侧乘积 × 右侧乘积
        rightProduct *= nums[i] // 更新右侧乘积
    }

    return result
}

