package com.only4.algorithm.version4k.leetcode

fun rob(nums: IntArray): Int {
    // 处理边界情况
    if (nums.size <= 2) return maxOf(nums.getOrElse(0) { 0 }, nums.getOrElse(1) { 0 })

    // prev表示偷到前两个房屋为止的最大金额
    var prev = 0
    // curr表示偷到前一个房屋为止的最大金额
    var curr = 0

    for (money in nums) {
        // 当前房屋的最大金额 = max(偷当前房屋 + 前两个房屋的最大金额, 不偷当前房屋)
        val maxMoney = maxOf(money + prev, curr)
        // 更新状态
        prev = curr
        curr = maxMoney
    }

    return curr
}
