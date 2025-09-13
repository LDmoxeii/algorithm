package com.only4.algorithm.version4k.leetcode

fun nextPermutation(nums: IntArray) {
    val n = nums.size
    var i = n - 2

    // 第一步：从右向左找到第一个下降点 nums[i] < nums[i+1]
    while (i >= 0 && nums[i] >= nums[i + 1]) {
        i--
    }

    // 如果存在这样的 i，进行交换和反转
    if (i >= 0) {
        val j = (n - 1 downTo i + 1).first { nums[it] > nums[i] }
        nums.swap(i, j)
    }

    // 反转 nums[i+1..n-1]
    nums.reverse(i + 1, n - 1)
}

private fun IntArray.swap(i: Int, j: Int) {
    this[i] = this[j].also { this[j] = this[i] }
}

private fun IntArray.reverse(from: Int, to: Int) {
    var left = from
    var right = to
    while (left < right) {
        swap(left, right)
        left++
        right--
    }
}

