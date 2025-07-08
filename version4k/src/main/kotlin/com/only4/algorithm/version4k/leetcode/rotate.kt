package com.only4.algorithm.version4k.leetcode

/**
 * [189. 轮转数组](https://leetcode.com/problems/rotate-array/)
 *
 * 给你一个数组，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 *
 * 解题思路：使用三次翻转法
 * 1. 先将整个数组翻转
 * 2. 再将前k%n个元素翻转
 * 3. 最后将剩余元素翻转
 *
 * 时间复杂度：O(n)，其中n是数组的长度
 * 空间复杂度：O(1)，只使用了常数级别的额外空间
 */
fun rotate(nums: IntArray, k: Int): Unit {
    if (nums.isEmpty()) return

    fun IntArray.reverseSub(start: Int, end: Int) {
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

    val n = nums.size
    val mod = k % n
    nums.reverseSub(0, n - 1)
    nums.reverseSub(0, mod - 1)
    nums.reverseSub(mod, n - 1)
}

/**
 * [48. 旋转图像](https://leetcode.com/problems/rotate-image/)
 *
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 *
 * 解题思路：从外到内一层一层旋转
 * 1. 对于每一层，我们执行四边的旋转
 * 2. 使用临时变量保存一个角落的值，然后执行循环替换
 * 3. 从外层向内层进行处理
 *
 * 时间复杂度：O(n²)，其中n是矩阵的边长
 * 空间复杂度：O(1)，只使用了常数级别的额外空间
 */
fun rotate(matrix: Array<IntArray>): Unit {
    if (matrix.isEmpty() || matrix[0].isEmpty()) return

    var top = 0;
    var bottom = matrix.lastIndex
    var left = 0;
    var right = matrix.lastIndex

    while (top < bottom) {
        val steps = right - left
        for (offset in 0 until steps) {
            val temp = matrix[top][left + offset]

            // 左下 -> 左上
            matrix[top][left + offset] = matrix[bottom - offset][left]
            // 右下 -> 左下
            matrix[bottom - offset][left] = matrix[bottom][right - offset]
            // 右上 -> 右下
            matrix[bottom][right - offset] = matrix[top + offset][right]
            // 左上(temp) -> 右上
            matrix[top + offset][right] = temp
        }
        left++;right--
        top++;bottom--
    }
}
