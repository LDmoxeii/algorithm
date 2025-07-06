package com.only4.algorithm.leetcode

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class SortColorsTest {
    @Test
    fun testExample1() {
        val nums = intArrayOf(2, 0, 2, 1, 1, 0)
        sortColors(nums)
        assertArrayEquals(intArrayOf(0, 0, 1, 1, 2, 2), nums)
    }

    @Test
    fun testExample2() {
        val nums = intArrayOf(2, 0, 1)
        sortColors(nums)
        assertArrayEquals(intArrayOf(0, 1, 2), nums)
    }

    @Test
    fun testAllZeros() {
        val nums = intArrayOf(0, 0, 0)
        sortColors(nums)
        assertArrayEquals(intArrayOf(0, 0, 0), nums)
    }

    @Test
    fun testAllOnes() {
        val nums = intArrayOf(1, 1, 1)
        sortColors(nums)
        assertArrayEquals(intArrayOf(1, 1, 1), nums)
    }

    @Test
    fun testAllTwos() {
        val nums = intArrayOf(2, 2, 2)
        sortColors(nums)
        assertArrayEquals(intArrayOf(2, 2, 2), nums)
    }

    @Test
    fun testMixed() {
        val nums = intArrayOf(1, 2, 0, 1, 2, 0, 1)
        sortColors(nums)
        assertArrayEquals(intArrayOf(0, 0, 1, 1, 1, 2, 2), nums)
    }

    @Test
    fun testSingleElement() {
        val nums = intArrayOf(1)
        sortColors(nums)
        assertArrayEquals(intArrayOf(1), nums)
    }
}
