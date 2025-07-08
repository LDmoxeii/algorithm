package com.only4.algorithm.version4k.leetcode

import java.util.*

/**
 * [347. 前K个高频元素](https://leetcode.com/problems/top-k-frequent-elements/)
 *
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按任意顺序返回答案。
 *
 * 示例:
 * - 输入: nums = [1,1,1,2,2,3], k = 2
 * - 输出: [1,2]
 *
 * - 输入: nums = [1], k = 1
 * - 输出: [1]
 *
 * 解题思路:
 * 使用优先队列（堆）来找出前K个高频元素。
 * 1. 首先统计每个元素出现的频率，使用HashMap
 * 2. 使用小顶堆保存频率最高的k个元素，堆顶是频率最小的元素
 * 3. 遍历频率表，维护一个大小为k的小顶堆
 * 4. 最后将堆中的元素转换为数组返回
 *
 * 时间复杂度: O(n log k)，其中n是数组长度，k是要返回的元素个数
 * 空间复杂度: O(n + k)，哈希表需要O(n)空间，堆需要O(k)空间
 *
 * @param nums 整数数组
 * @param k 要返回的高频元素的数量
 * @return 出现频率前k高的元素数组
 */
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

    // 使用小顶堆，按照频率排序（频率小的在堆顶）
    val minHeap = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })

    // 维护大小为k的小顶堆
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

