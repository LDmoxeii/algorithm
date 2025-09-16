package com.only4.algorithm.version4k.leetcode

fun findMedianSortedArrays(a: IntArray, b: IntArray): Double {
    // 确保 a 是较短的数组
    val (shorter, longer) = if (a.size > b.size) b to a else a to b

    val m = shorter.size
    val n = longer.size

    // 使用二分搜索找到正确的分割点
    var left = -1
    var right = m

    while (left + 1 < right) {
        val i = (left + right) / 2
        val j = (m + n + 1) / 2 - i - 2

        if (shorter[i] <= longer[j + 1]) {
            left = i
        } else {
            right = i
        }
    }

    // 计算最终结果
    val i = left
    val j = (m + n + 1) / 2 - i - 2

    val ai = shorter.getOrElse(i) { Int.MIN_VALUE }
    val bj = longer.getOrElse(j) { Int.MIN_VALUE }
    val ai1 = shorter.getOrElse(i + 1) { Int.MAX_VALUE }
    val bj1 = longer.getOrElse(j + 1) { Int.MAX_VALUE }

    val max1 = maxOf(ai, bj)
    val min2 = minOf(ai1, bj1)

    return if ((m + n) % 2 > 0) max1.toDouble() else (max1 + min2) / 2.0
}
