package com.only4.algorithm.version4k.leetcode

/**
 * [560. 和为K的子数组](https://leetcode.cn/problems/subarray-sum-equals-k/)
 *
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回该数组中和为 k 的连续子数组的个数。
 *
 * 示例 1：
 * 输入：nums = [1,1,1], k = 2
 * 输出：2
 *
 * 示例 2：
 * 输入：nums = [1,2,3], k = 3
 * 输出：2
 *
 * 提示：
 * - 1 <= nums.length <= 2 * 10^4
 * - -1000 <= nums[i] <= 1000
 * - -10^7 <= k <= 10^7
 *
 * 解题思路：使用前缀和和哈希表优化。
 * 1. 维护一个哈希表，记录前缀和出现的次数
 * 2. 遍历数组，计算当前前缀和，然后查找是否存在前缀和等于(当前前缀和-k)的情况
 * 3. 如果存在，则说明从之前某个位置到当前位置的子数组和为k
 *
 * 时间复杂度：O(n)，其中n为数组长度
 * 空间复杂度：O(n)，哈希表在最坏情况下可能需要存储n个不同的前缀和
 *
 * @param nums 整数数组
 * @param k 目标和
 * @return 和为k的连续子数组的个数
 */
fun subarraySum(nums: IntArray, k: Int): Int {
    // 记录结果：和为k的子数组个数
    var count = 0

    // 记录前缀和的出现次数，初始化{0:1}表示空数组的和为0出现了1次
    val prefixSumCount = mutableMapOf<Int, Int>().withDefault { 0 }
    prefixSumCount[0] = 1

    // 当前前缀和
    var currentSum = 0

    // 遍历数组
    for (num in nums) {
        // 更新当前前缀和
        currentSum += num

        // 如果存在一个前缀和为(currentSum - k)，则说明存在一个子数组的和为k
        // 该子数组为从前缀和为(currentSum - k)的位置到当前位置
        count += prefixSumCount.getValue(currentSum - k)

        // 更新前缀和的出现次数
        prefixSumCount[currentSum] = prefixSumCount.getValue(currentSum) + 1
    }

    return count
}
