package com.only4.algorithm.version4k.leetcode

fun dailyTemperatures(temperatures: IntArray): IntArray {
    val stack = ArrayDeque<Int>()
    val result = IntArray(temperatures.size)

    temperatures.forEachIndexed { day, temperature ->
        while (stack.isNotEmpty() && temperatures[stack.last()] < temperature) {
            val prevDay = stack.removeLast()
            result[prevDay] = day - prevDay
        }
        stack.addLast(day)
    }

    return result
}
