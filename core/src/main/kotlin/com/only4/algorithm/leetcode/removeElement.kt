package com.only4.algorithm.leetcode

fun removeElement(nums: IntArray, `val`: Int): Int {
    var (slow, fast) = 0 to 0
    while (fast < nums.size) {
        if (nums[fast] != `val`) nums[slow++] = nums[fast]
        fast++
    }
    return slow
}
