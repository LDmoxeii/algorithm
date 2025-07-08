package com.only4.algorithm.version4k.leetcode

/**
 * [55. 跳跃游戏](https://leetcode.com/problems/jump-game/)
 *
 * 给定一个非负整数数组 nums ，你最初位于数组的第一个下标。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标。
 *
 * 示例:
 * - 输入: nums = [2,3,1,1,4]
 * - 输出: true
 * - 解释: 我们可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 *
 * - 输入: nums = [3,2,1,0,4]
 * - 输出: false
 * - 解释: 无论怎样，你总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ，所以你永远不可能到达最后一个下标。
 *
 * 解题思路:
 * 使用贪心算法，维护一个变量 maxReach，表示当前能够到达的最远位置。
 * 遍历数组，对于每个位置 i，如果 i 大于 maxReach，说明无法到达位置 i，返回 false。
 * 否则，更新 maxReach = max(maxReach, i + nums[i])，表示从位置 i 能跳到的最远距离。
 * 如果 maxReach 大于等于数组最后一个位置，返回 true。
 *
 * 时间复杂度: O(n)，其中 n 是数组长度，只需要遍历一次数组
 * 空间复杂度: O(1)，只使用了常数级别的额外空间
 *
 * @param nums 非负整数数组，表示每个位置可以跳跃的最大长度
 * @return 是否能够到达最后一个下标
 */
fun canJump(nums: IntArray): Boolean {
    // 如果数组只有一个元素，直接返回 true
    if (nums.size == 1) return true

    // maxReach 表示当前能够到达的最远位置
    var maxReach = 0

    // 遍历数组中的每个位置
    for (i in nums.indices) {
        // 如果当前位置已经超过了能够到达的最远位置，说明无法继续前进
        if (i > maxReach) return false

        // 更新能够到达的最远位置
        maxReach = maxOf(maxReach, i + nums[i])

        // 如果已经能够到达或超过最后一个位置，返回 true
        if (maxReach >= nums.lastIndex) return true
    }

    // 遍历结束后，判断是否能够到达最后一个位置
    return maxReach >= nums.lastIndex
}

