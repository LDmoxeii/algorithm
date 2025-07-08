package com.only4.algorithm.version4k.leetcode

/**
 * [169. Majority Element](https://leetcode.com/problems/majority-element)
 *
 * 给定一个大小为 n 的数组，找出其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 解题思路：
 * 本题采用 Boyer-Moore 投票算法。算法核心思想是：
 * 1. 维护一个候选元素 candidate 和计数器 count。
 * 2. 遍历数组，如果 count 为 0，则将当前元素设为 candidate。
 * 3. 如果当前元素等于 candidate，则 count++，否则 count--。
 * 4. 最终 candidate 即为多数元素。
 *
 * 该算法时间复杂度 O(n)，空间复杂度 O(1)。
 *
 * 其他常见解法：
 * - 哈希表统计法：遍历数组统计每个元素出现次数，空间复杂度 O(n)。
 * - 排序法：排序后取中间元素，时间复杂度 O(nlogn)。
 *
 * 用例场景：
 * - 输入 [3,2,3]，输出 3。
 * - 输入 [2,2,1,1,1,2,2]，输出 2。
 * - 适用于需要在 O(1) 空间复杂度下找出多数元素的场景。
 */
fun majorityElement(nums: IntArray): Int {
    var candidate = 0
    var champion = 0

    for (enemy in nums) {
        if (champion == 0) {
            candidate = enemy
        }
        champion += if (enemy == candidate) 1 else -1
    }

    return candidate
}
