package com.only4.algorithm.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SingleNumberTest {

    /**
     * 测试原始问题描述中的示例
     */
    @Test
    fun `test examples from problem description`() {
        // 示例1: [2,2,1] -> 1
        assertEquals(1, singleNumber(intArrayOf(2, 2, 1)))

        // 示例2: [4,1,2,1,2] -> 4
        assertEquals(4, singleNumber(intArrayOf(4, 1, 2, 1, 2)))
    }

    /**
     * 测试边界情况
     */
    @Test
    fun `test edge cases`() {
        // 只有一个元素的数组
        assertEquals(5, singleNumber(intArrayOf(5)))

        // 三个元素，单一元素在中间
        assertEquals(3, singleNumber(intArrayOf(1, 3, 1)))

        // 三个元素，单一元素在开头
        assertEquals(2, singleNumber(intArrayOf(2, 3, 3)))

        // 三个元素，单一元素在结尾
        assertEquals(4, singleNumber(intArrayOf(5, 5, 4)))
    }

    /**
     * 测试负数情况
     */
    @Test
    fun `test negative numbers`() {
        // 包含负数
        assertEquals(-1, singleNumber(intArrayOf(1, 1, -1)))
        assertEquals(-5, singleNumber(intArrayOf(-5, 2, 2)))
        assertEquals(3, singleNumber(intArrayOf(-8, -8, 3)))
    }

    /**
     * 测试零的情况
     */
    @Test
    fun `test with zero`() {
        // 包含零
        assertEquals(0, singleNumber(intArrayOf(0, 1, 1)))
        assertEquals(2, singleNumber(intArrayOf(0, 0, 2)))
    }

    /**
     * 测试较大数组
     */
    @Test
    fun `test larger arrays`() {
        // 较大的数组
        assertEquals(7, singleNumber(intArrayOf(1, 2, 3, 4, 5, 6, 7, 1, 2, 3, 4, 5, 6)))
        assertEquals(100, singleNumber(intArrayOf(1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 100)))
    }

    /**
     * 测试元素顺序不同的情况
     */
    @Test
    fun `test different element orders`() {
        // 相同元素不相邻
        assertEquals(3, singleNumber(intArrayOf(1, 2, 3, 1, 2)))
        assertEquals(4, singleNumber(intArrayOf(1, 4, 2, 1, 2)))
    }

    /**
     * 测试极端值
     */
    @Test
    fun `test extreme values`() {
        // 整数最大值和最小值
        assertEquals(Int.MAX_VALUE, singleNumber(intArrayOf(Int.MIN_VALUE, Int.MIN_VALUE, Int.MAX_VALUE)))
        assertEquals(Int.MIN_VALUE, singleNumber(intArrayOf(Int.MAX_VALUE, Int.MAX_VALUE, Int.MIN_VALUE)))
    }
}
