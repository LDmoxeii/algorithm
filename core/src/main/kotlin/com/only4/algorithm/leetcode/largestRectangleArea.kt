package com.only4.algorithm.leetcode

fun largestRectangleArea(heights: IntArray): Int {
    val left = IntArray(heights.size)
    val right = IntArray(heights.size)
    val stack = ArrayDeque<Int>()
    var result = 0
    for (index in 0..heights.lastIndex) {
        while (stack.isNotEmpty() && heights[stack.last()] >= heights[index]) stack.removeLast()
        left[index] = if (stack.isEmpty()) -1 else stack.last()
        stack.addLast(index)
    }

    stack.clear()

    for (index in heights.lastIndex downTo 0) {
        while (stack.isNotEmpty() && heights[stack.last()] >= heights[index]) stack.removeLast()
        right[index] = if (stack.isEmpty()) heights.size else stack.last()
        stack.addLast(index)
    }

    heights.forEachIndexed { index, height ->
        result = maxOf(result, (right[index] - left[index] - 1) * height)
    }

    return result
}

fun main() {
    val heights = intArrayOf(1, 1)
    println(largestRectangleArea(heights))
}
