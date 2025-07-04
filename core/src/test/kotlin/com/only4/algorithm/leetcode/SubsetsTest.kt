package com.only4.algorithm.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class SubsetsTest {

    @Test
    fun `test empty array`() {
        val nums = intArrayOf()
        val result = subsets(nums)

        assertEquals(1, result.size)
        assertTrue(result.contains(emptyList()))
    }

    @Test
    fun `test single element array`() {
        val nums = intArrayOf(1)
        val result = subsets(nums)

        assertEquals(2, result.size)
        assertTrue(result.contains(emptyList()))
        assertTrue(result.contains(listOf(1)))
    }

    @Test
    fun `test multiple elements array`() {
        val nums = intArrayOf(1, 2, 3)
        val result = subsets(nums)

        assertEquals(8, result.size) // 2^3 = 8 个子集

        // 验证所有可能的子集都存在
        assertTrue(result.contains(emptyList()))
        assertTrue(result.contains(listOf(1)))
        assertTrue(result.contains(listOf(1, 2)))
        assertTrue(result.contains(listOf(1, 2, 3)))
        assertTrue(result.contains(listOf(1, 3)))
        assertTrue(result.contains(listOf(2)))
        assertTrue(result.contains(listOf(2, 3)))
        assertTrue(result.contains(listOf(3)))
    }
}
