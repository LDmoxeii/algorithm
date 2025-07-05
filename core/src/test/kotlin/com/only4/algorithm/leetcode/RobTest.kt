package com.only4.algorithm.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RobTest {

    @Test
    fun `test examples from problem description`() {
        // 示例1: [1,2,3,1] -> 4
        assertEquals(4, rob(intArrayOf(1, 2, 3, 1)))

        // 示例2: [2,7,9,3,1] -> 12
        assertEquals(12, rob(intArrayOf(2, 7, 9, 3, 1)))
    }

    @Test
    fun `test edge cases`() {
        // 空数组
        assertEquals(0, rob(intArrayOf()))

        // 只有一个房屋
        assertEquals(5, rob(intArrayOf(5)))

        // 只有两个房屋
        assertEquals(7, rob(intArrayOf(3, 7)))
    }

    @Test
    fun `test additional cases`() {
        // 三个房屋，偷第1和第3个
        assertEquals(8, rob(intArrayOf(5, 2, 3)))

        // 四个房屋，偷第1和第3个
        assertEquals(10, rob(intArrayOf(5, 1, 5, 1)))

        // 四个房屋，偷第2和第4个
        assertEquals(12, rob(intArrayOf(1, 7, 1, 5)))

        // 长数组，交替偷
        assertEquals(16, rob(intArrayOf(2, 1, 4, 1, 6, 1, 4)))

        // 长数组，不是简单的交替偷
        assertEquals(25, rob(intArrayOf(2, 10, 3, 6, 8, 1, 7)))
    }

    @Test
    fun `test consecutive houses`() {
        // 连续的房屋，应该选择较大的金额
        assertEquals(100, rob(intArrayOf(10, 100, 10)))
        assertEquals(200, rob(intArrayOf(100, 10, 10, 100)))
    }

    @Test
    fun `verify dynamic programming property`() {
        // 验证动态规划的性质
        val nums = intArrayOf(2, 7, 9, 3, 1)

        // 手动计算每一步的最大值
        // 第1步：2
        assertEquals(2, rob(intArrayOf(2)))

        // 第2步：max(2, 7) = 7
        assertEquals(7, rob(intArrayOf(2, 7)))

        // 第3步：max(2+9, 7) = 11
        assertEquals(11, rob(intArrayOf(2, 7, 9)))

        // 第4步：max(7+3, 11) = 11
        assertEquals(11, rob(intArrayOf(2, 7, 9, 3)))

        // 第5步：max(11+1, 11) = 12
        assertEquals(12, rob(intArrayOf(2, 7, 9, 3, 1)))
    }
}
