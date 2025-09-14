package com.only4.algorithm.version4k.leetcode

fun threeSum(nums: IntArray): List<List<Int>> {
    nums.sort() // 排序便于去重和剪枝
    val result = mutableListOf<List<Int>>()

    for (i in 0..nums.lastIndex - 2) {
        // 跳过重复的第一个数
        if (i > 0 && nums[i] == nums[i - 1]) continue

        // 剪枝：如果当前数大于0，后面都是正数，三数之和必然大于0
        if (nums[i] > 0) break

        // 剪枝优化：当前数与最大两数之和仍小于0，跳过
        if (nums[i] + nums[nums.lastIndex - 1] + nums[nums.lastIndex] < 0) continue

        // 剪枝优化：当前数与最小两数之和大于0，无解
        if (nums[i] + nums[i + 1] + nums[i + 2] > 0) break

        var left = i + 1
        var right = nums.lastIndex

        while (left < right) {
            val sum = nums[i] + nums[left] + nums[right]

            when {
                sum == 0 -> {
                    result.add(listOf(nums[i], nums[left], nums[right]))

                    // 跳过重复的左右指针值
                    do {
                        left++
                    } while (left < right && nums[left] == nums[left - 1])

                    do {
                        right--
                    } while (left < right && nums[right] == nums[right + 1])
                }
                sum < 0 -> left++  // 和太小，左指针右移
                else -> right--    // 和太大，右指针左移
            }
        }
    }

    return result
}
