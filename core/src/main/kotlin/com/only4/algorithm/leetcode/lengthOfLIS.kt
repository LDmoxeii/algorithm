package com.only4.algorithm.leetcode

/**
 * [300. 最长递增子序列](https://leetcode.com/problems/longest-increasing-subsequence/)
 *
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。
 * 例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 *
 * 示例:
 * - 输入: nums = [10,9,2,5,3,7,101,18]
 * - 输出: 4
 * - 解释: 最长递增子序列是 [2,3,7,101]，因此长度为 4。
 *
 * - 输入: nums = [0,1,0,3,2,3]
 * - 输出: 4
 * - 解释: 最长递增子序列是 [0,1,2,3]，因此长度为 4。
 *
 * 解题思路:
 * 使用动态规划解决此问题。定义dp[i]为以nums[i]结尾的最长递增子序列的长度。
 * 1. 对于每个位置i，初始dp[i] = 0
 * 2. 对于每个位置i，遍历它之前的所有位置j
 *    - 如果nums[j] < nums[i]，说明可以将nums[i]接在nums[j]后面形成更长的递增子序列
 *    - 此时dp[i] = max(dp[i], dp[j])
 * 3. 最后dp[i]需要加1，因为nums[i]本身也算一个长度
 * 4. 最终结果是所有dp[i]中的最大值
 *
 * 时间复杂度: O(n²)，其中n是数组长度，需要两层循环遍历
 * 空间复杂度: O(n)，需要一个长度为n的dp数组
 *
 * @param nums 整数数组
 * @return 最长递增子序列的长度
 */
fun lengthOfLIS(nums: IntArray): Int {
    // dp[i]表示以nums[i]结尾的最长递增子序列的长度
    val dpLengths = IntArray(nums.size) { 0 }
    var maxLength = 0

    for (currentIndex in nums.indices) {
        // 检查当前元素之前的所有元素
        for (previousIndex in currentIndex - 1 downTo 0) {
            // 如果找到一个更小的元素，可以将当前元素接在其后形成更长的递增子序列
            if (nums[previousIndex] < nums[currentIndex]) {
                dpLengths[currentIndex] = maxOf(dpLengths[currentIndex], dpLengths[previousIndex])
            }
        }
        // 将当前元素本身算入长度
        dpLengths[currentIndex]++

        // 更新全局最大长度
        maxLength = maxOf(maxLength, dpLengths[currentIndex])
    }

    return maxLength
}
