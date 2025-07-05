package com.only4.algorithm.leetcode

/**
 * [84. 柱状图中最大的矩形](https://leetcode.com/problems/largest-rectangle-in-histogram/)
 *
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 * 示例:
 * - 输入: [2,1,5,6,2,3]
 * - 输出: 10
 * - 解释: 高度为5和6的两个柱子组成的矩形面积为10
 *
 * 解题思路:
 * 使用单调栈解决此问题，需要计算每个柱子能够向左右延伸的最远距离。
 * 1. 首先，对于每个柱子，找到左边第一个比它矮的柱子位置，存储在left数组中
 * 2. 然后，对于每个柱子，找到右边第一个比它矮的柱子位置，存储在right数组中
 * 3. 最后，遍历每个柱子，计算以该柱子高度为矩形高度时的最大面积
 *
 * 时间复杂度: O(n)，其中n是柱子的数量，每个柱子最多入栈和出栈一次
 * 空间复杂度: O(n)，需要存储left和right数组以及栈
 *
 * @param heights 柱状图中各个柱子的高度数组
 * @return 能够勾勒出的矩形的最大面积
 */
fun largestRectangleArea(heights: IntArray): Int {
    // 处理空数组的边界情况
    if (heights.isEmpty()) {
        return 0
    }

    // 存储每个柱子左边第一个比它矮的柱子位置
    val left = IntArray(heights.size)
    // 存储每个柱子右边第一个比它矮的柱子位置
    val right = IntArray(heights.size)
    // 用于维护单调递增栈的索引
    val stack = ArrayDeque<Int>()
    var result = 0

    // 计算每个柱子左边第一个比它矮的柱子位置
    for (index in 0..heights.lastIndex) {
        // 当栈不为空且栈顶柱子高度大于等于当前柱子高度时，弹出栈顶
        while (stack.isNotEmpty() && heights[stack.last()] >= heights[index]) {
            stack.removeLast()
        }
        // 如果栈为空，说明左边没有比它矮的柱子，设置为-1
        // 否则，栈顶元素就是左边第一个比它矮的柱子位置
        left[index] = if (stack.isEmpty()) -1 else stack.last()
        // 将当前柱子索引入栈
        stack.addLast(index)
    }

    // 清空栈，准备计算右边界
    stack.clear()

    // 计算每个柱子右边第一个比它矮的柱子位置
    for (index in heights.lastIndex downTo 0) {
        // 当栈不为空且栈顶柱子高度大于等于当前柱子高度时，弹出栈顶
        while (stack.isNotEmpty() && heights[stack.last()] >= heights[index]) {
            stack.removeLast()
        }
        // 如果栈为空，说明右边没有比它矮的柱子，设置为heights.size
        // 否则，栈顶元素就是右边第一个比它矮的柱子位置
        right[index] = if (stack.isEmpty()) heights.size else stack.last()
        // 将当前柱子索引入栈
        stack.addLast(index)
    }

    // 计算每个柱子能够形成的最大矩形面积
    heights.forEachIndexed { index, height ->
        // 矩形宽度 = 右边界 - 左边界 - 1，高度 = 当前柱子高度
        val area = (right[index] - left[index] - 1) * height
        // 更新最大面积
        result = maxOf(result, area)
    }

    return result
}
