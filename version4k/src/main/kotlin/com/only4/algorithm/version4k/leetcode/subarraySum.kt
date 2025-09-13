package com.only4.algorithm.version4k.leetcode

fun subarraySum(nums: IntArray, k: Int): Int {
    // 记录前缀和的出现次数，初始化前缀和0出现1次（空数组）
    val prefixSumCount = mutableMapOf<Int, Int>().withDefault { 0 }
    prefixSumCount[0] = 1

    var count = 0
    var currentPrefixSum = 0

    for (num in nums) {
        // 计算当前前缀和
        currentPrefixSum += num

        // 查找是否存在前缀和为 currentPrefixSum - k
        // 如果存在，说明有子数组的和为k
        count += prefixSumCount.getValue(currentPrefixSum - k)

        // 更新当前前缀和的出现次数
        prefixSumCount[currentPrefixSum] = prefixSumCount.getValue(currentPrefixSum) + 1
    }

    return count
}
