package com.only4.algorithm.leetcode

/**
 * [31. Next Permutation](https://leetcode.com/problems/next-permutation)
 *
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（升序）。
 * 必须原地修改，只允许使用常数级额外空间。
 *
 * 解题思路：
 * 1. 从右向左找到第一个下降点 i（即 nums[i] < nums[i+1]）。
 * 2. 如果找到了，继续从右向左找到第一个比 nums[i] 大的元素 j，交换 nums[i] 和 nums[j]。
 * 3. 最后将 i+1 到末尾的部分反转，使其变为最小升序。
 * 4. 如果没有找到下降点，说明当前序列已是最大排列，直接整体反转为最小排列。
 *
 * 该算法时间复杂度 O(n)，空间复杂度 O(1)。
 *
 * 用例场景：
 * - 输入 [1,2,3]，输出 [1,3,2]
 * - 输入 [3,2,1]，输出 [1,2,3]
 * - 输入 [1,1,5]，输出 [1,5,1]
 * - 适用于需要生成下一个字典序排列的场景
 */
fun nextPermutation(nums: IntArray) {
    val n = nums.size
    var i = n - 2

    // 第一步：从右向左找到第一个下降点 nums[i] < nums[i+1]
    while (i >= 0 && nums[i] >= nums[i + 1]) {
        i--
    }

    // 如果存在这样的 i，进行交换和反转
    if (i >= 0) {
        val j = (n - 1 downTo i + 1).first { nums[it] > nums[i] }
        nums.swap(i, j)
    }

    // 反转 nums[i+1..n-1]
    nums.reverse(i + 1, n - 1)
}

// 交换数组中的两个元素（Kotlin扩展函数）
private fun IntArray.swap(i: Int, j: Int) {
    this[i] = this[j].also { this[j] = this[i] }
}

// 反转数组中 [from..to] 的部分（Kotlin扩展函数）
private fun IntArray.reverse(from: Int, to: Int) {
    var l = from
    var r = to
    while (l < r) {
        swap(l, r)
        l++
        r--
    }
}

