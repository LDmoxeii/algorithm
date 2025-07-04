package com.only4.algorithm.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaxSubArrayTest {

    @Test
    fun `test example 1`() {
        val nums = intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)
        val expected = 6
        val result = maxSubArray(nums)
        assertEquals(expected, result)
    }

    @Test
    fun `test example 2`() {
        val nums = intArrayOf(1)
        val expected = 1
        val result = maxSubArray(nums)
        assertEquals(expected, result)
    }

    @Test
    fun `test example 3`() {
        val nums = intArrayOf(5, 4, -1, 7, 8)
        val expected = 23
        val result = maxSubArray(nums)
        assertEquals(expected, result)
    }

    @Test
    fun `test with empty array`() {
        val nums = intArrayOf()
        val expected = 0
        val result = maxSubArray(nums)
        assertEquals(expected, result)
    }

    @Test
    fun `test with all negative numbers`() {
        val nums = intArrayOf(-1, -2, -3, -4)
        val expected = -1
        val result = maxSubArray(nums)
        assertEquals(expected, result)
    }

    @Test
    fun `test with all positive numbers`() {
        val nums = intArrayOf(1, 2, 3, 4)
        val expected = 10
        val result = maxSubArray(nums)
        assertEquals(expected, result)
    }

    @Test
    fun `test with alternating positive and negative numbers`() {
        val nums = intArrayOf(1, -1, 2, -2, 3, -3)
        val expected = 3
        val result = maxSubArray(nums)
        assertEquals(expected, result)
    }
}