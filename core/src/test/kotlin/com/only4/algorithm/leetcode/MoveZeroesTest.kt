package com.only4.algorithm.leetcode

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class MoveZeroesTest {

    @Test
    fun `test example 1`() {
        val nums = intArrayOf(0, 1, 0, 3, 12)
        val expected = intArrayOf(1, 3, 12, 0, 0)

        moveZeroes(nums)

        assertArrayEquals(expected, nums)
    }

    @Test
    fun `test example 2`() {
        val nums = intArrayOf(0)
        val expected = intArrayOf(0)

        moveZeroes(nums)

        assertArrayEquals(expected, nums)
    }

    @Test
    fun `test all zeros`() {
        val nums = intArrayOf(0, 0, 0, 0)
        val expected = intArrayOf(0, 0, 0, 0)

        moveZeroes(nums)

        assertArrayEquals(expected, nums)
    }

    @Test
    fun `test no zeros`() {
        val nums = intArrayOf(1, 2, 3, 4)
        val expected = intArrayOf(1, 2, 3, 4)

        moveZeroes(nums)

        assertArrayEquals(expected, nums)
    }

    @Test
    fun `test zeros at beginning`() {
        val nums = intArrayOf(0, 0, 0, 1, 2, 3)
        val expected = intArrayOf(1, 2, 3, 0, 0, 0)

        moveZeroes(nums)

        assertArrayEquals(expected, nums)
    }

    @Test
    fun `test zeros at end`() {
        val nums = intArrayOf(1, 2, 3, 0, 0, 0)
        val expected = intArrayOf(1, 2, 3, 0, 0, 0)

        moveZeroes(nums)

        assertArrayEquals(expected, nums)
    }

    @Test
    fun `test zeros in middle`() {
        val nums = intArrayOf(1, 0, 0, 2, 0, 3)
        val expected = intArrayOf(1, 2, 3, 0, 0, 0)

        moveZeroes(nums)

        assertArrayEquals(expected, nums)
    }

    @Test
    fun `test alternating zeros`() {
        val nums = intArrayOf(1, 0, 2, 0, 3, 0)
        val expected = intArrayOf(1, 2, 3, 0, 0, 0)

        moveZeroes(nums)

        assertArrayEquals(expected, nums)
    }

    @Test
    fun `test large array`() {
        val nums = IntArray(1000) { i -> if (i % 2 == 0) 0 else i }
        val expected = IntArray(1000) { i ->
            if (i < 500) (i * 2) + 1 else 0
        }

        moveZeroes(nums)

        assertArrayEquals(expected, nums)
    }
}
