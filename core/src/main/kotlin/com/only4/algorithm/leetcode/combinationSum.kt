package com.only4.algorithm.leetcode

/**
 * [39. 组合总和](https://leetcode.com/problems/combination-sum/)
 *
 * 给你一个无重复元素的整数数组 candidates 和一个目标整数 target，找出 candidates 中可以使数字和为目标数 target 的所有不同组合，
 * 并以列表形式返回。你可以按任意顺序返回这些组合。
 *
 * candidates 中的同一个数字可以无限制重复被选取。如果至少一个数字的被选数量不同，则两种组合是不同的。
 *
 * 解题思路：
 * 使用回溯算法，对于每个候选数字，有两种选择：选择或不选择。
 * 1. 先对数组排序，方便剪枝
 * 2. 使用回溯法遍历所有可能的组合
 * 3. 当当前和等于目标值时，将组合添加到结果中
 * 4. 当当前和大于目标值时，剪枝
 * 5. 从当前索引开始遍历，允许重复使用当前元素
 *
 * 时间复杂度：O(N * 2^N)，其中 N 是数组长度
 * 空间复杂度：O(target)，递归调用栈的深度最大为 target/min(candidates)
 */
fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
    // 对数组排序，方便剪枝
    candidates.sort()

    val result = mutableListOf<List<Int>>()
    val combination = mutableListOf<Int>()
    var currentSum = 0

    /**
     * 回溯函数，用于生成所有可能的组合
     *
     * @param startIndex 当前考虑的起始索引
     */
    fun backtrack(startIndex: Int) {
        // 找到一个有效组合
        if (currentSum == target) {
            result.add(combination.toList())
            return
        }

        // 从起始索引开始遍历所有可能的候选数字
        for (i in startIndex until candidates.size) {
            // 剪枝：如果当前数字已经使当前和超过目标值，后续更大的数字也会超过，直接结束循环
            if (currentSum + candidates[i] > target) {
                break
            }

            // 选择当前数字
            combination.add(candidates[i])
            currentSum += candidates[i]

            // 继续递归，注意传递的是i而不是i+1，因为可以重复使用同一个数字
            backtrack(i)

            // 回溯，撤销选择
            currentSum -= candidates[i]
            combination.removeAt(combination.lastIndex)
        }
    }

    backtrack(0)
    return result
}
