package com.only4.algorithm.leetcode

class MinStack() {

    val stack = ArrayDeque<IntArray>()

    init {
        stack.addLast(intArrayOf(0, Int.MAX_VALUE))
    }

    fun push(`val`: Int) {
        stack.addLast(intArrayOf(`val`, minOf(getMin(), `val`)))
    }

    fun pop() {
        stack.removeLast()
    }

    fun top(): Int {
        return stack.last()[0]
    }

    fun getMin(): Int {
        return stack.last()[1]
    }
}
