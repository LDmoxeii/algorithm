package com.only4.algorithm.version4k.leetcode

fun twoSum(nums: IntArray, target: Int): IntArray {
    // 哈希表：数值 -> 索引
    val numIndexMap = HashMap<Int, Int>()

    nums.forEachIndexed { index, currentNum ->
        val complement = target - currentNum

        // 检查补数是否已存在，如果存在则返回结果
        numIndexMap[complement]?.let { complementIndex ->
            return intArrayOf(complementIndex, index)
        }

        // 存储当前数值和索引
        numIndexMap[currentNum] = index
    }

    throw IllegalArgumentException("No two sum solution")
}
