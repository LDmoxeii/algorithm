package com.only4.algorithm.leetcode

val memo = mutableMapOf<Int, Int>()
fun coinChange(coins: IntArray, amount: Int): Int {

    if (amount == 0) return 0
    if (amount < 0) return -1
    if (memo.containsKey(amount)) return memo[amount]!!
    var result = Int.MAX_VALUE

    for (coin in coins) {
        coinChange(coins, amount - coin).also {
            if (it == -1) return@also
            else result = minOf(result, it + 1)
        }
    }
    return (if (result == Int.MAX_VALUE) -1 else result).also { memo[amount] = it }
}

fun main() {
    println(coinChange(intArrayOf(1, 2, 5), 100))
}
