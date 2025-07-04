package com.only4.algorithm.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SubarraySumTest {

    @Test
    fun `test example 1`() {
        val nums = intArrayOf(1, 1, 1)
        val k = 2
        val expected = 2
        val result = subarraySum(nums, k)
        assertEquals(expected, result)
    }

    @Test
    fun `test example 2`() {
        val nums = intArrayOf(1, 2, 3)
        val k = 3
        val expected = 2
        val result = subarraySum(nums, k)
        assertEquals(expected, result)
    }

    @Test
    fun `test with negative numbers`() {
        val nums = intArrayOf(3, 4, -7, 1, 3, 3, 1, -4)
        val k = 7
        val expected = 4
        val result = subarraySum(nums, k)
        assertEquals(expected, result)
    }

    @Test
    fun `test with empty array`() {
        val nums = intArrayOf()
        val k = 5
        val expected = 0
        val result = subarraySum(nums, k)
        assertEquals(expected, result)
    }

    @Test
    fun `test with single element equal to k`() {
        val nums = intArrayOf(5)
        val k = 5
        val expected = 1
        val result = subarraySum(nums, k)
        assertEquals(expected, result)
    }

    @Test
    fun `test with single element not equal to k`() {
        val nums = intArrayOf(5)
        val k = 3
        val expected = 0
        val result = subarraySum(nums, k)
        assertEquals(expected, result)
    }

    @Test
    fun `test with zero sum`() {
        val nums = intArrayOf(1, -1, 0, 1, -1)
        val k = 0
        val expected = 7
        // [1,-1], [1, -1, 0], [1, -1, 0, 1, -1],
        // [-1, 0, 1],
        // [0], [0, 1, -1],
        // [1,-1]
        val result = subarraySum(nums, k)
        assertEquals(expected, result)
    }
}
