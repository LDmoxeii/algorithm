package com.only4.algorithm.version4k.leetcode

import java.util.*

fun topKFrequent(nums: IntArray, k: Int): IntArray {
    // 统计每个元素出现的频率
    val frequencyMap = mutableMapOf<Int, Int>()
    nums.forEach { num ->
        frequencyMap[num] = frequencyMap.getOrDefault(num, 0) + 1
    }

    // 如果k等于唯一元素的数量，直接返回所有元素
    if (k == frequencyMap.size) {
        return frequencyMap.keys.toIntArray()
    }

    // 使用最小堆，按照频率排序（频率小的在堆顶）
    val minHeap = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })

    // 维护大小为k的最小堆
    for ((num, frequency) in frequencyMap) {
        minHeap.offer(Pair(num, frequency))
        if (minHeap.size > k) {
            minHeap.poll() // 移除频率最小的元素
        }
    }

    // 将堆中的元素转换为数组
    return IntArray(k) {
        minHeap.poll().first
    }
}

