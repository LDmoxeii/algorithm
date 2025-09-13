package com.only4.algorithm.version4k.leetcode

fun rotate(nums: IntArray, k: Int): Unit {
    val n = nums.size
    val effectiveK = k % n // 避免无效轮转

    if (effectiveK == 0) return

    // 扩展函数：反转数组的指定区间
    fun IntArray.reverseRange(start: Int, end: Int) {
        var left = start
        var right = end
        while (left < right) {
            val temp = this[left]
            this[left] = this[right]
            this[right] = temp
            left++
            right--
        }
    }

    // 反转整个数组
    nums.reverseRange(0, n - 1)
    // 反转前k个元素
    nums.reverseRange(0, effectiveK - 1)
    // 反转后n-k个元素
    nums.reverseRange(effectiveK, n - 1)
}

fun rotate(matrix: Array<IntArray>): Unit {
    val n = matrix.size

    // 分层处理，每次处理一个同心圆环
    for (layer in 0 until n / 2) {
        val first = layer
        val last = n - 1 - layer

        // 处理当前层的每个位置
        for (offset in first until last) {
            // 保存top位置的值
            val temp = matrix[first][offset]

            // left → top
            matrix[first][offset] = matrix[last - (offset - first)][first]

            // bottom → left
            matrix[last - (offset - first)][first] = matrix[last][last - (offset - first)]

            // right → bottom
            matrix[last][last - (offset - first)] = matrix[offset][last]

            // temp(top) → right
            matrix[offset][last] = temp
        }
    }
}
