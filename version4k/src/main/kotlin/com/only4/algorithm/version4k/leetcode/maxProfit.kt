package com.only4.algorithm.version4k.leetcode

fun maxProfit(prices: IntArray): Int {
    var max = 0
    var min = Int.MAX_VALUE
    for (i in prices) {
        if (i < min) min = i
        else if (i - min > max) max = i - min
    }
    return max
}
