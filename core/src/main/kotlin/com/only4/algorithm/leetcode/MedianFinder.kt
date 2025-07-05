package com.only4.algorithm.leetcode

import java.util.*

/**
 * [295. 数据流的中位数](https://leetcode.com/problems/find-median-from-data-stream/)
 *
 * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
 *
 * 例如：
 * - [2,3,4] 的中位数是 3
 * - [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 *
 * 设计一个支持以下两种操作的数据结构：
 * - void addNum(int num) - 从数据流中添加一个整数到数据结构中
 * - double findMedian() - 返回目前所有元素的中位数
 *
 * 示例：
 * ```
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
 * ```
 *
 * 解题思路：
 * 使用两个堆来维护数据流的中位数：
 * 1. 大顶堆(maxHeap)：存储较小的一半数字，堆顶是这些数字中的最大值
 * 2. 小顶堆(minHeap)：存储较大的一半数字，堆顶是这些数字中的最小值
 *
 * 我们保持以下不变量：
 * - 大顶堆的大小等于小顶堆的大小，或者比小顶堆大1
 * - 大顶堆中的所有元素都小于或等于小顶堆中的所有元素
 *
 * 这样，中位数就可以通过堆顶元素快速计算：
 * - 如果两个堆大小相等，中位数是两个堆顶元素的平均值
 * - 如果大顶堆比小顶堆多一个元素，中位数就是大顶堆的堆顶元素
 *
 * 时间复杂度：
 * - addNum: O(log n)，其中n是当前数据流中的元素数量
 * - findMedian: O(1)
 * 空间复杂度：O(n)，需要存储所有元素
 */
class MedianFinder {
    // 大顶堆，存储较小的一半数字
    private val maxHeap = PriorityQueue<Int> { a, b -> b - a }

    // 小顶堆，存储较大的一半数字
    private val minHeap = PriorityQueue<Int> { a, b -> a - b }

    /**
     * 从数据流中添加一个整数
     *
     * @param num 要添加的整数
     */
    fun addNum(num: Int) {
        // 如果两个堆大小相等，添加到大顶堆
        if (maxHeap.size == minHeap.size) {
            // 但为了保持大顶堆中的元素都小于小顶堆中的元素
            // 我们先将num添加到小顶堆，然后将小顶堆的最小值移到大顶堆
            minHeap.offer(num)
            maxHeap.offer(minHeap.poll())
        } else {
            // 如果大顶堆比小顶堆大，添加到小顶堆
            // 同样，为了保持有序性，先添加到大顶堆，再将大顶堆的最大值移到小顶堆
            maxHeap.offer(num)
            minHeap.offer(maxHeap.poll())
        }
    }

    /**
     * 返回当前所有元素的中位数
     *
     * @return 中位数
     */
    fun findMedian(): Double {
        return if (maxHeap.size == minHeap.size) {
            // 如果两个堆大小相等，中位数是两个堆顶元素的平均值
            (maxHeap.peek() + minHeap.peek()) / 2.0
        } else {
            // 如果大顶堆比小顶堆大，中位数是大顶堆的堆顶元素
            maxHeap.peek().toDouble()
        }
    }
}
