package com.only4.algorithm.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LongestConsecutiveTest {

    @Test
    fun `test example 1`() {
        val nums = intArrayOf(100, 4, 200, 1, 3, 2)
        val expected = 4
        val result = longestConsecutive(nums)
        assertEquals(expected, result)
    }

    @Test
    fun `test example 2`() {
        val nums = intArrayOf(0, 3, 7, 2, 5, 8, 4, 6, 0, 1)
        val expected = 9
        val result = longestConsecutive(nums)
        assertEquals(expected, result)
    }

    @Test
    fun `test empty array`() {
        val nums = intArrayOf()
        val expected = 0
        val result = longestConsecutive(nums)
        assertEquals(expected, result)
    }

    @Test
    fun `test single element array`() {
        val nums = intArrayOf(1)
        val expected = 1
        val result = longestConsecutive(nums)
        assertEquals(expected, result)
    }

    @Test
    fun `test duplicate elements`() {
        val nums = intArrayOf(1, 2, 3, 3, 4, 5)
        val expected = 5
        val result = longestConsecutive(nums)
        assertEquals(expected, result)
    }

    @Test
    fun `test negative numbers`() {
        val nums = intArrayOf(-3, -2, -1, 0, 1)
        val expected = 5
        val result = longestConsecutive(nums)
        assertEquals(expected, result)
    }

    @Test
    fun `test non-consecutive elements`() {
        val nums = intArrayOf(5, 10, 15, 20)
        val expected = 1
        val result = longestConsecutive(nums)
        assertEquals(expected, result)
    }

    @Test
    fun `test large gap`() {
        val nums = intArrayOf(1, 2, 3, 1000, 1001, 1002, 1003, 1004)
        val expected = 5
        val result = longestConsecutive(nums)
        assertEquals(expected, result)
    }

    @Test
    fun `test all same elements`() {
        val nums = intArrayOf(5, 5, 5, 5, 5)
        val expected = 1
        val result = longestConsecutive(nums)
        assertEquals(expected, result)
    }

    @Test
    fun `test multiple sequences`() {
        val nums = intArrayOf(1, 2, 3, 7, 8, 9, 10, 15, 16, 17)
        val expected = 4
        val result = longestConsecutive(nums)
        assertEquals(expected, result)
    }
} 