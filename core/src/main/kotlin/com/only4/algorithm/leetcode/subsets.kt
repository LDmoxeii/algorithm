package com.only4.algorithm.leetcode

/**
 * [78. 子集](https://leetcode.com/problems/subsets/)
 *
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 * 解题思路：
 * 使用回溯算法，对于每个元素都有两种选择：选择或不选择。
 * 1. 首先将当前路径添加到结果集中（空集也是一个子集）
 * 2. 从当前索引开始遍历数组，将元素添加到路径中
 * 3. 递归处理下一个索引
 * 4. 回溯，移除最后添加的元素
 *
 * 时间复杂度：O(n * 2^n)，其中n是数组长度
 * 空间复杂度：O(n)，递归调用栈的深度最大为n
 */
fun subsets(nums: IntArray): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    val track = mutableListOf<Int>()

    fun backtrack(index: Int) {
        // 将当前路径添加到结果集中
        result.add(track.toList())

        // 从当前索引开始遍历
        for (i in index until nums.size) {
            // 做选择
            track.add(nums[i])
            // 递归
            backtrack(i + 1)
            // 撤销选择
            track.removeAt(track.lastIndex)
        }
    }

    backtrack(0)
    return result
}
