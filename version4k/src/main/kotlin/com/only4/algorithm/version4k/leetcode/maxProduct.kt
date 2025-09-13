package com.only4.algorithm.version4k.leetcode

fun maxProduct(nums: IntArray): Int {
    // dp[i]表示以nums[i]结尾的子数组的(最小乘积, 最大乘积)
    val dp = Array(nums.size) { 0L to 0L }
    var maxResult = nums[0].toLong()

    // 初始化第一个元素
    dp[0] = nums[0].toLong() to nums[0].toLong()

    for (i in 1 until nums.size) {
        val currentNum = nums[i].toLong()
        val (prevMin, prevMax) = dp[i - 1]

        // 计算当前位置的最小乘积和最大乘积
        // 需要考虑三种情况：当前数乘以前面最小值、最大值，或者只取当前数
        val currentMin = minOf(currentNum * prevMin, currentNum * prevMax, currentNum)
        val currentMax = maxOf(currentNum * prevMin, currentNum * prevMax, currentNum)

        dp[i] = currentMin to currentMax

        // 更新全局最大乘积
        maxResult = maxOf(maxResult, currentMax)
    }

    return maxResult.toInt()
}
