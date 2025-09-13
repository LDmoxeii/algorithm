package com.only4.algorithm.version4k.leetcode

fun coinChange(coins: IntArray, amount: Int): Int {
    // 创建dp数组，初始化为一个较大的值，避免整型溢出
    val dp = IntArray(amount + 1) { Int.MAX_VALUE / 2 }
    dp[0] = 0 // 凑成金额0不需要任何硬币

    // 计算每个金额所需的最少硬币数
    for (currentAmount in 1..amount) {
        for (coin in coins) {
            // 只有当硬币面额小于等于当前金额时才能使用
            if (currentAmount < coin) continue
            // 状态转移：使用当前硬币后，所需的最少硬币数
            dp[currentAmount] = minOf(dp[currentAmount], dp[currentAmount - coin] + 1)
        }
    }

    // 如果dp[amount]仍为初始值，说明无法凑成总金额
    return if (dp[amount] == Int.MAX_VALUE / 2) -1 else dp[amount]
}
