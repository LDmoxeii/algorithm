package com.only4.algorithm.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaxProductTest {

    @Test
    fun `test examples from problem description`() {
        // 示例1: [2,3,-2,4] -> 6
        assertEquals(6, maxProduct(intArrayOf(2, 3, -2, 4)))
        // 最大乘积子数组是 [2,3]，乘积为 6

        // 示例2: [-2,0,-1] -> 0
        assertEquals(0, maxProduct(intArrayOf(-2, 0, -1)))
        // 最大乘积子数组是 [0]，乘积为 0
    }

    @Test
    fun `test edge cases`() {
        // 只有一个元素的数组
        assertEquals(5, maxProduct(intArrayOf(5)))
        assertEquals(-3, maxProduct(intArrayOf(-3)))

        // 两个元素的数组
        assertEquals(6, maxProduct(intArrayOf(2, 3)))
        assertEquals(2, maxProduct(intArrayOf(-1, -2)))
    }

    @Test
    fun `test arrays with all positive numbers`() {
        // 全是正数的数组
        assertEquals(6, maxProduct(intArrayOf(1, 2, 3)))
        assertEquals(120, maxProduct(intArrayOf(1, 2, 3, 4, 5)))
    }

    @Test
    fun `test arrays with all negative numbers`() {
        // 全是负数的数组
        assertEquals(-1, maxProduct(intArrayOf(-1)))
        assertEquals(2, maxProduct(intArrayOf(-1, -2)))
        assertEquals(1, maxProduct(intArrayOf(-1, -1, -1)))
        assertEquals(24, maxProduct(intArrayOf(-1, -2, -3, -4)))
    }

    @Test
    fun `test arrays with zeros`() {
        // 包含零的数组
        assertEquals(0, maxProduct(intArrayOf(0)))
        assertEquals(0, maxProduct(intArrayOf(0, 0, 0)))
        assertEquals(6, maxProduct(intArrayOf(2, 3, 0, 4)))
        assertEquals(4, maxProduct(intArrayOf(-2, 0, -1, 4)))
        assertEquals(24, maxProduct(intArrayOf(2, 3, -2, 4, 0, -1, -2, -3, -4)))
    }

    @Test
    fun `test arrays with mixed positive and negative numbers`() {
        // 混合正负数的数组
        assertEquals(36, maxProduct(intArrayOf(-2, -3, 1, 2, 3)))
        assertEquals(24, maxProduct(intArrayOf(-2, 3, -4)))
        assertEquals(48, maxProduct(intArrayOf(2, -3, 4, 1, -2)))
    }

    @Test
    fun `test arrays with alternating signs`() {
        // 符号交替的数组
        assertEquals(24, maxProduct(intArrayOf(1, -2, 3, -4)))
        assertEquals(36, maxProduct(intArrayOf(-1, 2, -3, 6)))
    }

    @Test
    fun `test complex cases`() {
        // 复杂情况
        assertEquals(960, maxProduct(intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)))
        assertEquals(360, maxProduct(intArrayOf(-6, 4, -5, 3, -1, -1, 0, -7, 0, -9, -4, 0)))
        assertEquals(24, maxProduct(intArrayOf(2, -5, -2, -4, 3)))
    }

    @Test
    fun `test large numbers`() {
        // 大数情况
        assertEquals(100 * 200 * 300, maxProduct(intArrayOf(100, 200, 300)))
        assertEquals(1000, maxProduct(intArrayOf(1000, -2000, 1000)))
    }

    @Test
    fun `test overflow handling`() {
        // 测试溢出处理
        val largeValue = Int.MAX_VALUE / 2
        assertEquals(largeValue * largeValue, maxProduct(intArrayOf(largeValue, largeValue)))

        // 负数溢出测试
        val minValue = Int.MIN_VALUE / 2
        assertEquals(minValue * minValue, maxProduct(intArrayOf(minValue, minValue)))
    }
}
