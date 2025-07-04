package com.only4.algorithm.leetcode

fun dailyTemperatures(temperatures: IntArray): IntArray {
    val stack = ArrayDeque<Int>()
    val result = IntArray(temperatures.size)

    temperatures.forEachIndexed { day, temperature ->
        while (stack.isNotEmpty() && temperatures[stack.last()] < temperature)
            stack.removeLast().also { result[it] = day - it }
        stack.addLast(day)
    }
    return result
}
