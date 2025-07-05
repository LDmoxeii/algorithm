package com.only4.algorithm.leetcode

/**
 * [279. 完全平方数](https://leetcode.com/problems/perfect-squares/)
 *
 * 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量。
 * 完全平方数是指可以表示为某个整数的平方的数，例如 1、4、9、16 等。
 *
 * 示例:
 * - 输入: n = 12
 * - 输出: 3
 * - 解释: 12 = 4 + 4 + 4
 *
 * - 输入: n = 13
 * - 输出: 2
 * - 解释: 13 = 4 + 9
 *
 * 解题思路:
 * 使用动态规划解决此问题。定义dp[i]为组成数字i所需的最少完全平方数的数量。
 * 1. 首先收集所有小于等于n的完全平方数
 * 2. 对于每个数字i，尝试用每个完全平方数j*j来减少它，并找到最小值：
 *    dp[i] = min(dp[i], dp[i - j*j] + 1)
 * 3. 最终dp[n]即为所求
 *
 * 时间复杂度: O(n * sqrt(n))，其中n是目标数，需要计算每个从1到n的数的最小平方数数量
 * 空间复杂度: O(n)，需要一个大小为n+1的dp数组
 *
 * @param n 目标整数
 * @return 和为n的完全平方数的最少数量
 */
fun numSquares(n: Int): Int {
    // 收集所有小于等于n的完全平方数
    val perfectSquares = mutableListOf<Int>()
    var i = 1
    while (i * i <= n) {
        perfectSquares.add(i * i)
        i++
    }

    // 创建dp数组，初始值设为最大整数（表示无法到达）
    val dp = IntArray(n + 1) { Int.MAX_VALUE }
    // 基础情况：组成0需要0个完全平方数
    dp[0] = 0

    // 对于每个数字j，尝试使用每个完全平方数来减少它
    for (j in 1..n) {
        for (square in perfectSquares) {
            // 如果当前完全平方数大于j，则无法使用
            if (j < square) break

            // 使用当前完全平方数后，更新dp[j]
            dp[j] = minOf(dp[j], dp[j - square] + 1)
        }
    }

    return dp[n]
}
