package com.only4.algorithm.version4k.leetcode

fun maxProduct(nums: IntArray): Int {
    // productRangeEndingAt[i] 表示以nums[i]结尾的子数组的(最小乘积, 最大乘积)
    val productRangeEndingAt = Array(nums.size) { 0L to 0L }
    var globalMaxProduct = nums[0].toLong()

    // 初始化第一个元素的最小和最大乘积
    productRangeEndingAt[0] = nums[0].toLong() to nums[0].toLong()

    for (currentIndex in 1 until nums.size) {
        val currentNumber = nums[currentIndex].toLong()
        val (previousMinProduct, previousMaxProduct) = productRangeEndingAt[currentIndex - 1]

        // 计算当前位置结尾的子数组可能的最小和最大乘积
        // 考虑三种情况：
        // 1. 当前数乘以前面的最小乘积
        // 2. 当前数乘以前面的最大乘积
        // 3. 当前数单独作为新子数组的开始
        val productWithPreviousMin = currentNumber * previousMinProduct
        val productWithPreviousMax = currentNumber * previousMaxProduct

        val currentMinProduct = minOf(
            productWithPreviousMin,
            productWithPreviousMax,
            currentNumber
        )
        val currentMaxProduct = maxOf(
            productWithPreviousMin,
            productWithPreviousMax,
            currentNumber
        )

        // 更新当前位置的最小和最大乘积
        productRangeEndingAt[currentIndex] = currentMinProduct to currentMaxProduct

        // 更新全局最大乘积
        globalMaxProduct = maxOf(globalMaxProduct, currentMaxProduct)
    }

    return globalMaxProduct.toInt()
}
