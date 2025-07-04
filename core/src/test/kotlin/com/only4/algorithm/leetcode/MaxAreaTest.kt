package com.only4.algorithm.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaxAreaTest {

    @Test
    fun `test example 1`() {
        val height = intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)
        val expected = 49
        val result = maxArea(height)
        assertEquals(expected, result)
    }

    @Test
    fun `test example 2`() {
        val height = intArrayOf(1, 1)
        val expected = 1
        val result = maxArea(height)
        assertEquals(expected, result)
    }

    @Test
    fun `test empty array`() {
        val height = intArrayOf()
        val expected = 0
        val result = maxArea(height)
        assertEquals(expected, result)
    }

    @Test
    fun `test single element`() {
        val height = intArrayOf(5)
        val expected = 0
        val result = maxArea(height)
        assertEquals(expected, result)
    }

    @Test
    fun `test ascending heights`() {
        val height = intArrayOf(1, 2, 3, 4, 5)
        val expected = 6 // 容器由：min(2,5) * 3 = 6
        val result = maxArea(height)
        assertEquals(expected, result)
    }

    @Test
    fun `test descending heights`() {
        val height = intArrayOf(5, 4, 3, 2, 1)
        val expected = 6 // 容器由：min(5,2) * 3 = 6
        val result = maxArea(height)
        assertEquals(expected, result)
    }

    @Test
    fun `test large values`() {
        val height = intArrayOf(10000, 0, 10000)
        val expected = 20000 // 容器由第一个和最后一个元素组成：min(10000,10000) * 2 = 20000
        val result = maxArea(height)
        assertEquals(expected, result)
    }
}
