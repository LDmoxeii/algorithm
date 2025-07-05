package com.only4.algorithm.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LargestRectangleAreaTest {

    @Test
    fun `test example from problem description`() {
        // 示例: [2,1,5,6,2,3] -> 10
        val heights = intArrayOf(2, 1, 5, 6, 2, 3)
        assertEquals(10, largestRectangleArea(heights))
    }

    @Test
    fun `test increasing heights`() {
        // 递增高度: [1, 2, 3, 4, 5] -> 9
        val heights = intArrayOf(1, 2, 3, 4, 5)
        assertEquals(9, largestRectangleArea(heights))
    }

    @Test
    fun `test decreasing heights`() {
        // 递减高度: [5, 4, 3, 2, 1] -> 9
        val heights = intArrayOf(5, 4, 3, 2, 1)
        assertEquals(9, largestRectangleArea(heights))
    }

    @Test
    fun `test same heights`() {
        // 相同高度: [3, 3, 3, 3] -> 12
        val heights = intArrayOf(3, 3, 3, 3)
        assertEquals(12, largestRectangleArea(heights))
    }

    @Test
    fun `test single height`() {
        // 单个高度: [5] -> 5
        val heights = intArrayOf(5)
        assertEquals(5, largestRectangleArea(heights))
    }

    @Test
    fun `test empty array`() {
        // 空数组: [] -> 0
        val heights = intArrayOf()
        assertEquals(0, largestRectangleArea(heights))
    }

    @Test
    fun `test complex pattern`() {
        // 复杂模式: [2, 4, 2, 1, 5, 6, 4, 2, 3] -> 12
        val heights = intArrayOf(2, 4, 2, 1, 5, 6, 4, 2, 3)
        assertEquals(12, largestRectangleArea(heights))
    }

    @Test
    fun `test with zeros`() {
        // 包含零高度: [2, 0, 3, 4, 0, 2] -> 6
        val heights = intArrayOf(2, 0, 3, 4, 0, 2)
        assertEquals(6, largestRectangleArea(heights))
    }

    @Test
    fun `test all zeros`() {
        // 全零高度: [0, 0, 0, 0] -> 0
        val heights = intArrayOf(0, 0, 0, 0)
        assertEquals(0, largestRectangleArea(heights))
    }

    @Test
    fun `test large values`() {
        // 大数值: [1000, 1000, 1000, 1000] -> 4000
        val heights = intArrayOf(1000, 1000, 1000, 1000)
        assertEquals(4000, largestRectangleArea(heights))
    }
}
