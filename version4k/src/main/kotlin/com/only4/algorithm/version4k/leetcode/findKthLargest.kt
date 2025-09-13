package com.only4.algorithm.version4k.leetcode

import kotlin.random.Random

fun findKthLargest(nums: IntArray, k: Int): Int {
    fun quickSelect(nums: List<Int>, k: Int): Int {
        val pivot = nums[Random.nextInt(nums.size)]

        val larger = mutableListOf<Int>()
        val equal = mutableListOf<Int>()
        val smaller = mutableListOf<Int>()

        for (num in nums) {
            when {
                num > pivot -> larger.add(num)
                num == pivot -> equal.add(num)
                else -> smaller.add(num)
            }
        }

        return when {
            k <= larger.size -> quickSelect(larger, k)
            k <= larger.size + equal.size -> pivot
            else -> quickSelect(smaller, k - larger.size - equal.size)
        }
    }

    return quickSelect(nums.toList(), k)
}
