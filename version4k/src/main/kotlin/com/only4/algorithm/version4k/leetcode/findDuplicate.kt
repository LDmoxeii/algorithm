package com.only4.algorithm.version4k.leetcode

/**
 * [287. Find the Duplicate Number](https://leetcode.com/problems/find-the-duplicate-number)
 *
 * 给定一个包含 n+1 个整数的数组 nums，数组中的每个整数都在 1 到 n 之间（包括 1 和 n），且只有一个重复的数字，找出这个重复的数字。
 * 要求不能修改数组（即不能排序），只能使用常数级别的额外空间，且时间复杂度为 O(n)。
 *
 * 解题思路：
 * 本题采用"弗洛伊德判圈法"（Floyd's Tortoise and Hare Cycle Detection）。
 * - 将数组视为链表，nums[i] 表示下一个节点索引。
 * - 先用快慢指针找到相遇点，再从头和相遇点分别出发，最终相遇点即为重复数字。
 * - 时间复杂度 O(n)，空间复杂度 O(1)。
 *
 * 其他常见解法：
 * - 二分查找法：统计小于等于 mid 的元素个数，判断区间。
 * - 哈希表法：空间复杂度 O(n)，不符合本题要求。
 *
 * 用例场景：
 * - 输入 [1,3,4,2,2]，输出 2。
 * - 输入 [3,1,3,4,2]，输出 3。
 * - 适用于需要在不修改原数组且常数空间下查找重复元素的场景。
 */
fun findDuplicate(nums: IntArray): Int {
    // 使用弗洛伊德判圈法（快慢指针）查找环的入口
    var slow = nums[0]
    var fast = nums[0]

    // 第一步：快慢指针相遇，找到环中的一个相遇点
    do {
        slow = nums[slow]         // 慢指针每次走一步
        fast = nums[nums[fast]]   // 快指针每次走两步
    } while (slow != fast)

    // 第二步：将慢指针重新指向起点，快慢指针同步前进
    slow = nums[0]
    while (slow != fast) {
        slow = nums[slow]
        fast = nums[fast]
    }

    // 相遇点即为重复数字
    return slow
}
