package com.only4.algorithm.version4k.leetcode

fun maxProfit(prices: IntArray): Int {
    var maxProfit = 0
    var minPrice = Int.MAX_VALUE

    for (price in prices) {
        if (price < minPrice) {
            minPrice = price
        } else if (price - minPrice > maxProfit) {
            maxProfit = price - minPrice
        }
    }

    return maxProfit
}
