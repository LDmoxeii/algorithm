package com.only4.algorithm.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FirstMissingPositiveTest {

    @Test
    fun `test example 1`() {
        val nums = intArrayOf(1, 2, 0)
        assertEquals(3, firstMissingPositive(nums))
    }

    @Test
    fun `test example 2`() {
        val nums = intArrayOf(3, 4, -1, 1)
        assertEquals(2, firstMissingPositive(nums))
    }

    @Test
    fun `test example 3`() {
        val nums = intArrayOf(7, 8, 9, 11, 12)
        assertEquals(1, firstMissingPositive(nums))
    }

    @Test
    fun `test empty array`() {
        val nums = intArrayOf()
        assertEquals(1, firstMissingPositive(nums))
    }

    @Test
    fun `test array with only negative numbers`() {
        val nums = intArrayOf(-1, -2, -3)
        assertEquals(1, firstMissingPositive(nums))
    }

    @Test
    fun `test array with consecutive positive integers starting from 1`() {
        val nums = intArrayOf(1, 2, 3, 4, 5)
        assertEquals(6, firstMissingPositive(nums))
    }

    @Test
    fun `test array with duplicates`() {
        val nums = intArrayOf(1, 1, 2, 2)
        assertEquals(3, firstMissingPositive(nums))
    }
} 