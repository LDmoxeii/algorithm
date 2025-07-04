package com.only4.algorithm.leetcode

/**
 * [56. 合并区间](https://leetcode.cn/problems/merge-intervals/)
 *
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi]。
 * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 *
 * 示例 1：
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 *
 * 示例 2：
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 * 提示：
 * - 1 <= intervals.length <= 10^4
 * - intervals[i].length == 2
 * - 0 <= starti <= endi <= 10^4
 *
 * 解题思路：
 * 1. 首先按照区间的起始位置进行排序
 * 2. 然后遍历排序后的区间，如果当前区间的起始位置小于等于结果数组中最后一个区间的结束位置，
 *    则说明两个区间有重叠，需要合并，更新结果数组中最后一个区间的结束位置为两个区间结束位置的较大值
 * 3. 如果没有重叠，则将当前区间直接添加到结果数组中
 *
 * 时间复杂度：O(nlogn)，其中n是区间的数量，排序需要O(nlogn)的时间
 * 空间复杂度：O(n)，需要存储合并后的区间
 *
 * @param intervals 区间数组，每个区间由两个整数表示 [start, end]
 * @return 合并后的区间数组
 */
fun merge(intervals: Array<IntArray>): Array<IntArray> {
    // 边界条件检查
    if (intervals.isEmpty()) return emptyArray()
    if (intervals.size == 1) return intervals

    // 按区间起始位置排序
    intervals.sortBy { it[0] }

    // 存储合并后的结果
    val mergedIntervals = mutableListOf<IntArray>()

    // 遍历排序后的区间
    for (interval in intervals) {
        // 如果结果列表为空或当前区间与上一个区间不重叠
        if (mergedIntervals.isEmpty() || interval[0] > mergedIntervals.last()[1]) {
            // 添加新区间
            mergedIntervals.add(interval)
        } else {
            // 有重叠，合并区间
            mergedIntervals.last()[1] = maxOf(mergedIntervals.last()[1], interval[1])
        }
    }

    return mergedIntervals.toTypedArray()
}
