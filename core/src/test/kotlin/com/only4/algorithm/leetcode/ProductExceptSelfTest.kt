package com.only4.algorithm.leetcode

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class ProductExceptSelfTest {

    @Test
    fun `test product except self with positive numbers`() {
        val nums = intArrayOf(1, 2, 3, 4)
        val expected = intArrayOf(24, 12, 8, 6)

        val result = productExceptSelf(nums)

        assertArrayEquals(expected, result)
    }

    @Test
    fun `test product except self with negative and zero numbers`() {
        val nums = intArrayOf(-1, 1, 0, -3, 3)
        val expected = intArrayOf(0, 0, 9, 0, 0)

        val result = productExceptSelf(nums)

        assertArrayEquals(expected, result)
    }

    @Test
    fun `test product except self with all ones`() {
        val nums = intArrayOf(1, 1, 1, 1)
        val expected = intArrayOf(1, 1, 1, 1)

        val result = productExceptSelf(nums)

        assertArrayEquals(expected, result)
    }

    @Test
    fun `test product except self with multiple zeros`() {
        val nums = intArrayOf(0, 0, 1, 2)
        val expected = intArrayOf(0, 0, 0, 0)

        val result = productExceptSelf(nums)

        assertArrayEquals(expected, result)
    }

    @Test
    fun `test product except self with single zero`() {
        val nums = intArrayOf(0, 1, 2, 3)
        val expected = intArrayOf(6, 0, 0, 0)

        val result = productExceptSelf(nums)

        assertArrayEquals(expected, result)
    }
}
