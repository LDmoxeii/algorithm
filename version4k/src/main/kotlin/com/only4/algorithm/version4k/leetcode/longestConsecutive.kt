package com.only4.algorithm.version4k.leetcode

fun longestConsecutive(nums: IntArray): Int {
    if (nums.isEmpty()) return 0

    // 哈希表存储所有数字，实现O(1)查找
    val numSet = nums.toHashSet()
    var maxLength = 0

    for (num in numSet) {
        // 只检查序列的起点（不存在前驱数字num-1）
        if (!numSet.contains(num - 1)) {
            var currentNum = num
            var currentLength = 1

            // 向后查找连续数字
            while (numSet.contains(currentNum + 1)) {
                currentNum++
                currentLength++
            }

            maxLength = maxOf(maxLength, currentLength)
        }
    }

    return maxLength
}
