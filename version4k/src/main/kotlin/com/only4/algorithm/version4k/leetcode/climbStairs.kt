package com.only4.algorithm.version4k.leetcode

fun climbStairs(n: Int): Int {
    if (n <= 2) return n

    // prev表示到达前两阶的方法数
    var prev = 1
    // curr表示到达前一阶的方法数
    var curr = 2

    // 从第3阶开始计算
    for (i in 3..n) {
        // 计算当前阶的方法数
        val sum = prev + curr
        // 更新状态：当前的前一阶变成下一轮的前两阶
        prev = curr
        // 当前阶的方法数变成下一轮的前一阶
        curr = sum
    }

    return curr
}
