package com.only4.algorithm.version4k.leetcode

fun maxSubArray(nums: IntArray): Int {
    var currentSum = nums[0]
    var maxSum = nums[0]

    for (i in 1 until nums.size) {
        // 状态转移：选择加入前面的子数组或重新开始
        currentSum = maxOf(nums[i], currentSum + nums[i])
        // 更新全局最大和
        maxSum = maxOf(maxSum, currentSum)
    }

    return maxSum
}
