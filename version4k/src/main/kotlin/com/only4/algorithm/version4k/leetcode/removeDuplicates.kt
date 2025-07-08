package com.only4.algorithm.version4k.leetcode

fun removeDuplicates(nums: IntArray): Int {
    if (nums.isEmpty()) return 0
    var (slow, fast) = 0 to 0
    while (fast < nums.size) {
        when (nums[fast] != nums[slow]) {
            true -> nums[++slow] = nums[fast++]
            else -> fast++
        }
    }
    return slow + 1
}
