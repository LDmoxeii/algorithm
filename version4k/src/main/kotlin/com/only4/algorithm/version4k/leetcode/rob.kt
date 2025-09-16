package com.only4.algorithm.version4k.leetcode

fun rob(nums: IntArray): Int {
    // 处理边界情况
    if (nums.size <= 2) {
        return maxOf(nums.getOrElse(0) { 0 }, nums.getOrElse(1) { 0 })
    }

    // 偷到前两个房屋时的最大金额（即不偷上一个房屋的情况）
    var maxMoneyTwoHousesBack = 0
    // 偷到前一个房屋时的最大金额
    var maxMoneyOneHouseBack = 0

    for (currentHouseMoney in nums) {
        // 计算偷到当前房屋时的最大金额
        // 选择：偷当前房屋+前两个房屋的最大金额 vs 不偷当前房屋
        val maxMoneyAtCurrentHouse = maxOf(
            currentHouseMoney + maxMoneyTwoHousesBack,  // 偷当前房屋
            maxMoneyOneHouseBack                        // 不偷当前房屋
        )

        // 更新状态：为下一轮计算做准备
        maxMoneyTwoHousesBack = maxMoneyOneHouseBack
        maxMoneyOneHouseBack = maxMoneyAtCurrentHouse
    }

    return maxMoneyOneHouseBack
}
