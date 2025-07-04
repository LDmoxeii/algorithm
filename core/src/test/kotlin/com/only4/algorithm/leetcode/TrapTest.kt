package com.only4.algorithm.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TrapTest {

    @Test
    fun `test example 1`() {
        val heights = intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)
        val expected = 6
        val result = trap(heights)
        assertEquals(expected, result)
    }

    @Test
    fun `test example 2`() {
        val heights = intArrayOf(4, 2, 0, 3, 2, 5)
        val expected = 9
        val result = trap(heights)
        assertEquals(expected, result)
    }

    @Test
    fun `test empty array`() {
        val heights = intArrayOf()
        val expected = 0
        val result = trap(heights)
        assertEquals(expected, result)
    }

    @Test
    fun `test array with single element`() {
        val heights = intArrayOf(5)
        val expected = 0
        val result = trap(heights)
        assertEquals(expected, result)
    }

    @Test
    fun `test array with two elements`() {
        val heights = intArrayOf(5, 3)
        val expected = 0
        val result = trap(heights)
        assertEquals(expected, result)
    }

    @Test
    fun `test array with no trapped water`() {
        val heights = intArrayOf(1, 2, 3, 4, 5)
        val expected = 0
        val result = trap(heights)
        assertEquals(expected, result)
    }

    @Test
    fun `test array with decreasing heights`() {
        val heights = intArrayOf(5, 4, 3, 2, 1)
        val expected = 0
        val result = trap(heights)
        assertEquals(expected, result)
    }

    @Test
    fun `test array with valley shape`() {
        val heights = intArrayOf(5, 1, 5)
        val expected = 4
        val result = trap(heights)
        assertEquals(expected, result)
    }

    @Test
    fun `test array with complex shape`() {
        val heights = intArrayOf(5, 2, 1, 2, 1, 5)
        val expected = 14
        val result = trap(heights)
        assertEquals(expected, result)
    }
}