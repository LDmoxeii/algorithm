package com.only4.algorithm.version4k.leetcode

class MinStack {
    private val stack = ArrayDeque<Pair<Int, Int>>()

    fun push(value: Int) {
        val currentMin = if (stack.isEmpty()) value else minOf(getMin(), value)
        stack.addLast(Pair(value, currentMin))
    }

    fun pop() {
        stack.removeLast()
    }

    fun top(): Int = stack.last().first

    fun getMin(): Int = stack.last().second
}
