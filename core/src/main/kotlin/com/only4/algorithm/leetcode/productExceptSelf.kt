package com.only4.algorithm.leetcode

/**
 * [238. 除自身以外数组的乘积](https://leetcode.com/problems/product-of-array-except-self/)
 *
 * 给你一个整数数组 nums，返回 数组 answer，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 * 题目数据保证数组 nums 之中任意元素的全部前缀元素和后缀的乘积都在 32 位整数范围内。
 *
 * 解题思路：使用前缀积和后缀积
 * 1. 首先从左到右遍历数组，计算每个位置左侧所有数字的乘积
 * 2. 然后从右到左遍历数组，计算每个位置右侧所有数字的乘积并与左侧乘积相乘
 * 3. 这样每个位置的结果就是其左侧乘积乘以右侧乘积
 *
 * 时间复杂度：O(n)，其中n是数组的长度，需要遍历数组两次
 * 空间复杂度：O(1)，除了输出数组外，只使用了常数级别的额外空间
 */
fun productExceptSelf(nums: IntArray): IntArray {
    val n = nums.size
    val result = IntArray(n)

    // 计算左侧乘积
    var leftProduct = 1
    for (i in 0 until n) {
        result[i] = leftProduct
        leftProduct *= nums[i]
    }

    // 计算右侧乘积并与左侧乘积相乘
    var rightProduct = 1
    for (i in n - 1 downTo 0) {
        result[i] *= rightProduct
        rightProduct *= nums[i]
    }

    return result
}

