package com.only4.algorithm.leetcode

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class MaxSlidingWindowTest {

    @Nested
    inner class MaxSlidingWindowTests {
        @Test
        fun `test example 1`() {
            val nums = intArrayOf(1, 3, -1, -3, 5, 3, 6, 7)
            val k = 3
            val expected = intArrayOf(3, 3, 5, 5, 6, 7)
            val result = maxSlidingWindow(nums, k)
            assertArrayEquals(expected, result)
        }

        @Test
        fun `test example 2`() {
            val nums = intArrayOf(1)
            val k = 1
            val expected = intArrayOf(1)
            val result = maxSlidingWindow(nums, k)
            assertArrayEquals(expected, result)
        }

        @Test
        fun `test with empty array`() {
            val nums = intArrayOf()
            val k = 0
            val expected = intArrayOf()
            val result = maxSlidingWindow(nums, k)
            assertArrayEquals(expected, result)
        }

        @Test
        fun `test with window size equal to array length`() {
            val nums = intArrayOf(1, 3, 5, 7, 9)
            val k = 5
            val expected = intArrayOf(9)
            val result = maxSlidingWindow(nums, k)
            assertArrayEquals(expected, result)
        }

        @Test
        fun `test with decreasing array`() {
            val nums = intArrayOf(9, 7, 5, 3, 1)
            val k = 3
            val expected = intArrayOf(9, 7, 5)
            val result = maxSlidingWindow(nums, k)
            assertArrayEquals(expected, result)
        }

        @Test
        fun `test with all same elements`() {
            val nums = intArrayOf(5, 5, 5, 5, 5)
            val k = 3
            val expected = intArrayOf(5, 5, 5)
            val result = maxSlidingWindow(nums, k)
            assertArrayEquals(expected, result)
        }
    }

    @Nested
    inner class MaxSlidingWindowOptimizedTests {
        @Test
        fun `test example 1`() {
            val nums = intArrayOf(1, 3, -1, -3, 5, 3, 6, 7)
            val k = 3
            val expected = intArrayOf(3, 3, 5, 5, 6, 7)
            val result = maxSlidingWindowOptimized(nums, k)
            assertArrayEquals(expected, result)
        }

        @Test
        fun `test example 2`() {
            val nums = intArrayOf(1)
            val k = 1
            val expected = intArrayOf(1)
            val result = maxSlidingWindowOptimized(nums, k)
            assertArrayEquals(expected, result)
        }

        @Test
        fun `test with empty array`() {
            val nums = intArrayOf()
            val k = 0
            val expected = intArrayOf()
            val result = maxSlidingWindowOptimized(nums, k)
            assertArrayEquals(expected, result)
        }

        @Test
        fun `test with window size equal to array length`() {
            val nums = intArrayOf(1, 3, 5, 7, 9)
            val k = 5
            val expected = intArrayOf(9)
            val result = maxSlidingWindowOptimized(nums, k)
            assertArrayEquals(expected, result)
        }

        @Test
        fun `test with decreasing array`() {
            val nums = intArrayOf(9, 7, 5, 3, 1)
            val k = 3
            val expected = intArrayOf(9, 7, 5)
            val result = maxSlidingWindowOptimized(nums, k)
            assertArrayEquals(expected, result)
        }

        @Test
        fun `test with all same elements`() {
            val nums = intArrayOf(5, 5, 5, 5, 5)
            val k = 3
            val expected = intArrayOf(5, 5, 5)
            val result = maxSlidingWindowOptimized(nums, k)
            assertArrayEquals(expected, result)
        }
    }
}
