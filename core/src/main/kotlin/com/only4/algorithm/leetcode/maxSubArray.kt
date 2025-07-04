package com.only4.algorithm.leetcode

/**
 * [53. 最大子数组和](https://leetcode.cn/problems/maximum-subarray/)
 *
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 子数组是数组中的一个连续部分。
 *
 * 示例 1：
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 * 示例 2：
 * 输入：nums = [1]
 * 输出：1
 *
 * 示例 3：
 * 输入：nums = [5,4,-1,7,8]
 * 输出：23
 *
 * 提示：
 * - 1 <= nums.length <= 10^5
 * - -10^4 <= nums[i] <= 10^4
 *
 * 解题思路：使用动态规划。
 * 1. 定义dp[i]表示以第i个元素结尾的最大连续子数组和
 * 2. 状态转移方程：dp[i] = max(dp[i-1] + nums[i], nums[i])
 *    - 如果dp[i-1] > 0，则将当前元素加入前面的子数组
 *    - 如果dp[i-1] <= 0，则以当前元素开始新的子数组
 * 3. 最终结果为dp数组中的最大值
 *
 * 时间复杂度：O(n)，其中n是数组长度
 * 空间复杂度：O(1)，使用常数额外空间
 *
 * @param nums 整数数组
 * @return 最大子数组和
 */
fun maxSubArray(nums: IntArray): Int {
    // 边界条件检查
    if (nums.isEmpty()) return 0
    if (nums.size == 1) return nums[0]

    // 记录全局最大子数组和
    var maxSum = nums[0]
    // 记录当前子数组和
    var currentSum = nums[0]

    // 从第二个元素开始遍历
    for (i in 1 until nums.size) {
        // 状态转移：选择加入前面的子数组或重新开始
        currentSum = maxOf(nums[i], currentSum + nums[i])
        // 更新全局最大和
        maxSum = maxOf(maxSum, currentSum)
    }

    return maxSum
}
