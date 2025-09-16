package com.only4.algorithm.version4k.leetcode

fun lengthOfLIS(nums: IntArray): Int {
    // longestLengthEndingAt[i] 表示以nums[i]结尾的最长递增子序列的长度
    val longestLengthEndingAt = IntArray(nums.size) { 0 }
    var globalMaxLength = 0

    for (currentIndex in nums.indices) {
        val currentValue = nums[currentIndex]
        var maxLengthBeforeCurrent = 0

        // 检查当前元素之前的所有元素，寻找可以接在后面的最长子序列
        for (previousIndex in currentIndex - 1 downTo 0) {
            val previousValue = nums[previousIndex]

            // 如果找到一个更小的元素，当前元素可以接在其最长递增子序列后面
            if (previousValue < currentValue) {
                maxLengthBeforeCurrent = maxOf(
                    maxLengthBeforeCurrent,
                    longestLengthEndingAt[previousIndex]
                )
            }
        }

        // 当前位置的最长递增子序列长度 = 之前最长长度 + 1（当前元素）
        longestLengthEndingAt[currentIndex] = maxLengthBeforeCurrent + 1

        // 更新全局最大长度
        globalMaxLength = maxOf(globalMaxLength, longestLengthEndingAt[currentIndex])
    }

    return globalMaxLength
}
