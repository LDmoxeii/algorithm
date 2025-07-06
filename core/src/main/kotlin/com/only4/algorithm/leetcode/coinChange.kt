package com.only4.algorithm.leetcode

/**
 * [322. 零钱兑换](https://leetcode.com/problems/coin-change/)
 *
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * 你可以认为每种硬币的数量是无限的。
 *
 * 示例:
 * - 输入: coins = [1,2,5], amount = 11
 * - 输出: 3
 * - 解释: 11 = 5 + 5 + 1
 *
 * - 输入: coins = [2], amount = 3
 * - 输出: -1
 *
 * - 输入: coins = [1], amount = 0
 * - 输出: 0
 *
 * 解题思路:
 * 使用动态规划解决此问题。定义dp[currentAmount]为凑成金额currentAmount所需的最少硬币数。
 * 1. 初始化dp[0] = 0，因为凑成金额0不需要任何硬币
 * 2. 对于其他金额currentAmount，初始化为一个较大的值（这里用Int.MAX_VALUE/2，避免后续加1操作溢出）
 * 3. 对于每个金额currentAmount，遍历所有硬币面额，如果当前面额小于等于currentAmount，则尝试用该硬币
 * 4. 状态转移方程: dp[currentAmount] = min(dp[currentAmount], dp[currentAmount - coin] + 1)
 * 5. 最终如果dp[amount]仍为初始值，则返回-1，否则返回dp[amount]
 *
 * 时间复杂度: O(amount * n)，其中n是硬币的种类数，需要计算amount个状态，每个状态需要遍历n个硬币
 * 空间复杂度: O(amount)，需要一个大小为amount+1的dp数组
 *
 * @param coins 不同面额的硬币数组
 * @param amount 需要凑成的总金额
 * @return 凑成总金额所需的最少硬币个数，如果无法凑成则返回-1
 */
fun coinChange(coins: IntArray, amount: Int): Int {
    // 创建dp数组，dp[currentAmount]表示凑成金额currentAmount所需的最少硬币数
    // 初始化为一个较大的值，避免整型溢出
    val dp = IntArray(amount + 1) { Int.MAX_VALUE / 2 }
    // 基础情况：凑成金额0不需要任何硬币
    dp[0] = 0

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
