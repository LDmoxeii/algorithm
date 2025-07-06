package com.only4.algorithm.leetcode

/**
 * [152. 乘积最大子数组](https://leetcode.com/problems/maximum-product-subarray/)
 *
 * 给你一个整数数组 nums，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 * 测试用例的答案是一个 32-位 整数。
 * 子数组是数组的连续子序列。
 *
 * 示例:
 * - 输入: nums = [2,3,-2,4]
 * - 输出: 6
 * - 解释: 子数组 [2,3] 有最大乘积 6。
 *
 * - 输入: nums = [-2,0,-1]
 * - 输出: 0
 * - 解释: 结果不能为负数，所以最大乘积为 0。
 *
 * 解题思路:
 * 使用动态规划解决此问题。由于负数的特殊性（两个负数相乘会变成正数），我们需要同时跟踪最大值和最小值。
 * 1. 定义dp[i]为一个二元组(min, max)，分别表示以nums[i]结尾的子数组的最小乘积和最大乘积
 * 2. 对于每个位置i，当前元素nums[i]可能是正数或负数：
 *    - 如果是正数，则最大乘积可能是前一个最大乘积乘以当前数，最小乘积可能是前一个最小乘积乘以当前数
 *    - 如果是负数，则最大乘积可能是前一个最小乘积乘以当前数，最小乘积可能是前一个最大乘积乘以当前数
 *    - 同时，当前元素自己可能比乘积更大/更小
 * 3. 因此，对于每个位置i，我们计算：
 *    - min = min(nums[i] * dp[i-1].min, nums[i] * dp[i-1].max, nums[i])
 *    - max = max(nums[i] * dp[i-1].min, nums[i] * dp[i-1].max, nums[i])
 * 4. 最终结果是所有dp[i].max中的最大值
 *
 * 时间复杂度: O(n)，其中n是数组长度，只需遍历一次数组
 * 空间复杂度: O(n)，需要一个长度为n的dp数组
 *
 * @param nums 整数数组
 * @return 乘积最大的连续子数组的乘积
 */
fun maxProduct(nums: IntArray): Int {
    // dp[i]表示以nums[i]结尾的子数组的(最小乘积, 最大乘积)
    val dp = Array(nums.size) { 0L to 0L }
    var maxProductResult = nums[0].toLong()

    // 初始化第一个元素
    dp[0] = nums[0].toLong() to nums[0].toLong()

    for (i in 1 until nums.size) {
        val currentNum = nums[i].toLong()
        val prevMin = dp[i - 1].first
        val prevMax = dp[i - 1].second

        // 计算当前位置的最小乘积和最大乘积
        // 需要考虑三种情况：当前数乘以前一个最小值，当前数乘以前一个最大值，或者只取当前数
        val currentMin = minOf(currentNum * prevMin, currentNum * prevMax, currentNum)
        val currentMax = maxOf(currentNum * prevMin, currentNum * prevMax, currentNum)

        dp[i] = currentMin to currentMax

        // 更新全局最大乘积
        maxProductResult = maxOf(maxProductResult, currentMax)
    }

    return maxProductResult.toInt()
}
