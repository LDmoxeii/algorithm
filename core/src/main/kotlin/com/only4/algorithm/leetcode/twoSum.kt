package com.only4.algorithm.leetcode

/**
 * [1. 两数之和](https://leetcode.cn/problems/two-sum/)
 *
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素。
 *
 * 你可以按任意顺序返回答案。
 *
 * 示例 1：
 *
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 *
 * 示例 2：
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 *
 * 示例 3：
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 *
 * 提示：
 * - 2 <= nums.length <= 10^4
 * - -10^9 <= nums[i] <= 10^9
 * - -10^9 <= target <= 10^9
 * - 只会存在一个有效答案
 *
 * 进阶：你可以想出一个时间复杂度小于 O(n^2) 的算法吗？
 *
 * 解题思路：使用哈希表存储每个元素的值和索引，边遍历边查找。对于每个元素，计算目标值与当前元素的差值，
 * 并在哈希表中查找是否存在该差值。如果存在，则返回两个元素的索引；否则将当前元素及其索引存入哈希表。
 *
 * 时间复杂度：O(n)，其中n是数组长度
 * 空间复杂度：O(n)，需要哈希表存储数组中的元素
 *
 * @param nums 整数数组
 * @param target 目标和
 * @return 两个数的下标数组
 * @throws IllegalArgumentException 如果没有找到满足条件的两个数
 */
fun twoSum(nums: IntArray, target: Int): IntArray {
    val complementMap = HashMap<Int, Int>()

    nums.forEachIndexed { index, num ->
        val complement = target - num
        complementMap[complement]?.let { return intArrayOf(it, index) }
        complementMap[num] = index
    }

    throw IllegalArgumentException("No two sum solution")
}
