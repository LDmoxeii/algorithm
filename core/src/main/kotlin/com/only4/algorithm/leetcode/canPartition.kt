package com.only4.algorithm.leetcode

/**
 * [416. 分割等和子集](https://leetcode.com/problems/partition-equal-subset-sum/)
 *
 * 给你一个 只包含正整数 的非空数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 * 示例:
 * - 输入: nums = [1,5,11,5]
 * - 输出: true
 * - 解释: 数组可以分割成 [1, 5, 5] 和 [11]。
 *
 * - 输入: nums = [1,2,3,5]
 * - 输出: false
 * - 解释: 数组不能分割成两个元素和相等的子集。
 *
 * 解题思路:
 * 这个问题可以转化为"0-1背包问题"。如果数组可以分成两个和相等的子集，那么每个子集的和应该是数组总和的一半。
 * 因此，问题变成了：是否可以从数组中选出一些数字，使它们的和恰好等于数组总和的一半。
 *
 * 使用动态规划解决:
 * 1. 如果数组总和是奇数，则不可能分割成两个和相等的子集，直接返回false
 * 2. 定义dp[i][j]表示：使用前i个数字，是否可以组成和为j的子集
 * 3. 状态转移方程:
 *    - dp[i][j] = dp[i-1][j]                             // 不选择第i个数字
 *    - 或者 dp[i][j] = dp[i-1][j-nums[i-1]]              // 选择第i个数字（如果j >= nums[i-1]）
 * 4. 最终返回dp[n][target]，其中n是数组长度，target是数组总和的一半
 *
 * 时间复杂度: O(n * target)，其中n是数组长度，target是数组总和的一半
 * 空间复杂度: O(n * target)，需要一个二维dp数组
 *
 * @param nums 只包含正整数的非空数组
 * @return 是否可以将数组分割成两个和相等的子集
 */
fun canPartition(nums: IntArray): Boolean {
    // 计算数组总和
    val totalSum = nums.sum()

    // 如果总和为奇数，无法分割成两个和相等的子集
    if (totalSum % 2 != 0) return false

    // 目标和为总和的一半
    val targetSum = totalSum / 2
    val numCount = nums.size

    // dp[i][j]表示：使用前i个数字，是否可以组成和为j的子集
    val dp = Array(numCount + 1) { BooleanArray(targetSum + 1) }

    // 基础情况：空子集的和为0，所以dp[0][0] = true
    dp[0][0] = true

    // 填充dp数组
    for (i in 0 until numCount) {
        val currentNum = nums[i]
        for (j in 0..targetSum) {
            // 不选择当前数字的情况
            dp[i + 1][j] = dp[i][j]

            // 选择当前数字的情况（如果j >= currentNum）
            if (j >= currentNum) {
                dp[i + 1][j] = dp[i + 1][j] || dp[i][j - currentNum]
            }
        }
    }

    // 返回最终结果：使用所有数字，是否可以组成和为targetSum的子集
    return dp[numCount][targetSum]
}
