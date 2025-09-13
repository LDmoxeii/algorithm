package com.only4.algorithm.version4k.leetcode

fun maxArea(height: IntArray): Int {
    var left = 0
    var right = height.lastIndex
    var maxWater = 0

    while (left < right) {
        // 计算当前容器面积：宽度 × 高度（取较小值）
        val currentArea = minOf(height[left], height[right]) * (right - left)
        maxWater = maxOf(maxWater, currentArea)

        // 移动较短的那条边，因为较短的边限制了容器的高度
        if (height[left] < height[right]) {
            left++
        } else {
            right--
        }
    }

    return maxWater
}
