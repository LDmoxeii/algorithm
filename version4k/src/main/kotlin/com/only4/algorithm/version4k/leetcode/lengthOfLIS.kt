package com.only4.algorithm.version4k.leetcode

fun lengthOfLIS(nums: IntArray): Int {
    // dp[i]表示以nums[i]结尾的最长递增子序列的长度
    val dp = IntArray(nums.size) { 0 }
    var maxLength = 0

    for (i in nums.indices) {
        // 检查当前元素之前的所有元素
        for (j in i - 1 downTo 0) {
            // 如果找到一个更小的元素，可以将当前元素接在其后形成更长的递增子序列
            if (nums[j] < nums[i]) {
                dp[i] = maxOf(dp[i], dp[j])
            }
        }
        // 将当前元素本身算入长度
        dp[i]++

        // 更新全局最大长度
        maxLength = maxOf(maxLength, dp[i])
    }

    return maxLength
}
