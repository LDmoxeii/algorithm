package com.only4.algorithm.leetcode

/**
 * [45. 跳跃游戏 II](https://leetcode.com/problems/jump-game-ii/)
 *
 * 给你一个非负整数数组 nums，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * 假设你总是可以到达数组的最后一个位置。
 *
 * 示例:
 * - 输入: nums = [2,3,1,1,4]
 * - 输出: 2
 * - 解释: 跳到最后一个位置的最小跳跃数是 2。从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 *
 * - 输入: nums = [2,3,0,1,4]
 * - 输出: 2
 *
 * 解题思路:
 * 使用贪心算法，维护当前能到达的最远位置(maxReach)和当前跳跃能到达的边界(curReach)。
 * 每当到达当前跳跃的边界时，更新边界并将跳跃次数加1。
 * 这种方法被称为"贪心跳跃"，因为我们总是尽可能远地跳跃。
 *
 * 时间复杂度: O(n)，其中n是数组长度，只需要遍历一次数组
 * 空间复杂度: O(1)，只使用了常数级别的额外空间
 *
 * @param nums 非负整数数组，表示每个位置可以跳跃的最大长度
 * @return 到达最后一个位置的最小跳跃次数
 */
fun jump(nums: IntArray): Int {
    // 如果数组长度为1，不需要跳跃
    if (nums.size <= 1) return 0

    // curReach: 当前跳跃能到达的边界
    var curReach = 0
    // maxReach: 从当前位置能到达的最远位置
    var maxReach = 0
    // result: 跳跃次数
    var result = 0

    // 遍历数组中的每个位置（除了最后一个，因为到达最后一个位置就结束了）
    for (i in 0 until nums.size - 1) {
        // 更新从当前位置能到达的最远位置
        maxReach = maxOf(maxReach, i + nums[i])

        // 如果到达了当前跳跃的边界 必须进行下一跳 落脚点可能是范围内的任意一点(不关心)
        if (i == curReach) {
            // 更新边界为能到达的最远位置
            curReach = maxReach
            // 跳跃次数加1
            result++

            // 如果已经可以到达最后一个位置，提前返回结果
            if (curReach >= nums.lastIndex) {
                return result
            }
        }
    }

    return result
}
