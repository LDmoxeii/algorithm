package com.only4.algorithm.version4k.leetcode

import java.util.*

fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
    if (nums.isEmpty() || k <= 0) return IntArray(0)

    // 使用双端队列存储索引，维护单调递减
    val deque = ArrayDeque<Int>()
    val result = IntArray(nums.size - k + 1)

    for (right in nums.indices) {
        // 移除队尾所有小于当前元素的索引，维护单调递减
        while (deque.isNotEmpty() && nums[deque.peekLast()] < nums[right]) {
            deque.pollLast()
        }

        // 当前索引入队
        deque.offerLast(right)

        // 计算左边界
        val left = right - k + 1

        // 移除超出窗口范围的索引
        if (deque.peekFirst() < left) {
            deque.pollFirst()
        }

        // 当窗口形成时，记录最大值
        if (left >= 0) {
            result[left] = nums[deque.peekFirst()]
        }
    }

    return result
}
