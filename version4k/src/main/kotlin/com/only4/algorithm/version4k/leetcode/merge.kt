package com.only4.algorithm.version4k.leetcode

fun merge(intervals: Array<IntArray>): Array<IntArray> {
    if (intervals.size <= 1) return intervals

    // 按区间起始位置排序
    intervals.sortBy { it[0] }

    val mergedIntervals = mutableListOf<IntArray>()
    mergedIntervals.add(intervals[0]) // 添加第一个区间

    for (i in 1 until intervals.size) {
        val currentInterval = intervals[i]
        val lastMergedInterval = mergedIntervals.last()

        // 如果当前区间与上一个区间重叠
        if (currentInterval[0] <= lastMergedInterval[1]) {
            // 合并区间：更新结束位置为两者的最大值
            lastMergedInterval[1] = maxOf(lastMergedInterval[1], currentInterval[1])
        } else {
            // 不重叠，添加新区间
            mergedIntervals.add(currentInterval)
        }
    }

    return mergedIntervals.toTypedArray()
}
