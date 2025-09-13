package com.only4.algorithm.version4k.leetcode

fun largestRectangleArea(heights: IntArray): Int {
    if (heights.isEmpty()) return 0

    val leftBoundary = IntArray(heights.size)
    val rightBoundary = IntArray(heights.size)
    val stack = ArrayDeque<Int>()
    var maxArea = 0

    // 计算每个柱子左边第一个比它矮的柱子位置
    for (i in heights.indices) {
        while (stack.isNotEmpty() && heights[stack.last()] >= heights[i]) {
            stack.removeLast()
        }
        leftBoundary[i] = if (stack.isEmpty()) -1 else stack.last()
        stack.addLast(i)
    }

    stack.clear()

    // 计算每个柱子右边第一个比它矮的柱子位置
    for (i in heights.indices.reversed()) {
        while (stack.isNotEmpty() && heights[stack.last()] >= heights[i]) {
            stack.removeLast()
        }
        rightBoundary[i] = if (stack.isEmpty()) heights.size else stack.last()
        stack.addLast(i)
    }

    // 计算每个柱子能够形成的最大矩形面积
    heights.forEachIndexed { i, height ->
        val area = (rightBoundary[i] - leftBoundary[i] - 1) * height
        maxArea = maxOf(maxArea, area)
    }

    return maxArea
}
