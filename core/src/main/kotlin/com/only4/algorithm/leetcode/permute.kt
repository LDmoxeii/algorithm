package com.only4.algorithm.leetcode

/**
 * [46. 全排列](https://leetcode.com/problems/permutations/)
 *
 * 给定一个不含重复数字的数组 nums，返回其所有可能的全排列。
 *
 * 解题思路：回溯算法
 * 1. 使用一个布尔数组 used 记录哪些元素已经被使用
 * 2. 使用一个列表 track 记录当前排列
 * 3. 当 track 的长度等于 nums 的长度时，将当前排列添加到结果中
 * 4. 否则，遍历 nums 数组，对于每个未使用的元素，将其加入 track，然后递归处理
 * 5. 递归返回后，需要回溯，即移除最后添加的元素并标记为未使用
 *
 * 时间复杂度：O(n * n!)，其中 n 为数组长度
 * 空间复杂度：O(n)，递归调用栈的深度最大为 n
 */
fun permute(nums: IntArray): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    val track = mutableListOf<Int>()
    val used = BooleanArray(nums.size)

    fun backtrack() {
        // 如果路径长度等于数组长度，说明找到了一个全排列
        if (track.size == nums.size) {
            result.add(track.toList())
            return
        }

        // 尝试每个可能的选择
        for (i in nums.indices) {
            // 跳过已使用的元素
            if (used[i]) continue

            // 做选择
            track.add(nums[i])
            used[i] = true

            // 进入下一层决策树
            backtrack()

            // 撤销选择（回溯）
            track.removeAt(track.lastIndex)
            used[i] = false
        }
    }

    backtrack()
    return result
}
