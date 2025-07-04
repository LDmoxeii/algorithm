package com.only4.algorithm.leetcode

/**
 * [15. 三数之和](https://leetcode.cn/problems/3sum/)
 *
 * 给你一个整数数组 nums，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k，
 * 同时还满足 nums[i] + nums[j] + nums[k] == 0。请返回所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 示例 1：
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 解释：
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0
 * 不同的三元组是 [-1,0,1] 和 [-1,-1,2]
 * 注意，输出的顺序和三元组的顺序并不重要。
 *
 * 示例 2：
 * 输入：nums = [0,1,1]
 * 输出：[]
 * 解释：唯一可能的三元组和不为 0。
 *
 * 示例 3：
 * 输入：nums = [0,0,0]
 * 输出：[[0,0,0]]
 * 解释：唯一可能的三元组和为 0。
 *
 * 提示：
 * - 3 <= nums.length <= 3000
 * - -10^5 <= nums[i] <= 10^5
 *
 * 解题思路：使用排序+双指针法。首先对数组进行排序，然后固定第一个数，使用双指针在剩余部分寻找和为第一个数的相反数的两个数。
 * 为了避免重复解，需要跳过重复的数字。此外，添加了一些优化条件，当确定无法找到满足条件的三元组时提前终止循环。
 *
 * 时间复杂度：O(n²)，其中n是数组的长度。排序的时间复杂度是O(nlogn)，双指针遍历的时间复杂度是O(n²)
 * 空间复杂度：O(logn)，排序所需的空间复杂度
 *
 * @param nums 整数数组
 * @return 所有和为0且不重复的三元组列表
 */
fun threeSum(nums: IntArray): List<List<Int>> {
    // 对数组进行排序，便于去重和使用双指针
    nums.sort()
    val result = mutableListOf<List<Int>>()

    // 固定第一个数，然后在剩余部分使用双指针查找另外两个数
    for (i in 0..nums.lastIndex - 2) {
        val current = nums[i]

        // 跳过重复的第一个数
        if (i > 0 && current == nums[i - 1]) continue

        // 优化：如果当前数字大于0，由于数组已排序，后面的数字都大于0，三数之和必然大于0
        if (current > 0) break

        // 优化：如果当前数字与最大的两个数相加仍小于0，则跳过
        if (current + nums[nums.lastIndex - 1] + nums[nums.lastIndex] < 0) continue

        // 优化：如果当前数字与最小的两个数相加仍大于0，则后面不可能有解
        if (current + nums[i + 1] + nums[i + 2] > 0) break

        var left = i + 1
        var right = nums.lastIndex

        while (left < right) {
            val sum = current + nums[left] + nums[right]

            when {
                sum == 0 -> {
                    // 找到一组解
                    result.add(listOf(current, nums[left], nums[right]))

                    // 跳过重复的左右指针
                    do {
                        left++
                    } while (left < right && nums[left] == nums[left - 1])
                    do {
                        right--
                    } while (left < right && nums[right] == nums[right + 1])
                }

                sum < 0 -> left++  // 和小于0，左指针右移
                else -> right--    // 和大于0，右指针左移
            }
        }
    }

    return result
}
