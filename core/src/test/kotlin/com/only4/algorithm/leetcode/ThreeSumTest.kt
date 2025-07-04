package com.only4.algorithm.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ThreeSumTest {

    @Test
    fun `test example 1`() {
        val nums = intArrayOf(-1, 0, 1, 2, -1, -4)
        val expected = listOf(
            listOf(-1, -1, 2),
            listOf(-1, 0, 1)
        )
        val result = threeSum(nums)

        // 因为结果顺序不重要，所以需要对每个三元组排序后再比较
        assertEquals(expected.size, result.size)
        expected.forEach { expectedTriplet ->
            assert(result.any { resultTriplet ->
                expectedTriplet.sorted() == resultTriplet.sorted()
            })
        }
    }

    @Test
    fun `test example 2`() {
        val nums = intArrayOf(0, 1, 1)
        val expected = emptyList<List<Int>>()
        val result = threeSum(nums)
        assertEquals(expected, result)
    }

    @Test
    fun `test example 3`() {
        val nums = intArrayOf(0, 0, 0)
        val expected = listOf(listOf(0, 0, 0))
        val result = threeSum(nums)
        assertEquals(expected, result)
    }

    @Test
    fun `test empty array`() {
        val nums = intArrayOf()
        val expected = emptyList<List<Int>>()
        val result = threeSum(nums)
        assertEquals(expected, result)
    }

    @Test
    fun `test array with duplicates`() {
        val nums = intArrayOf(-2, 0, 0, 2, 2)
        val expected = listOf(listOf(-2, 0, 2))
        val result = threeSum(nums)

        assertEquals(expected.size, result.size)
        expected.forEach { expectedTriplet ->
            assert(result.any { resultTriplet ->
                expectedTriplet.sorted() == resultTriplet.sorted()
            })
        }
    }

    @Test
    fun `test array with all negative numbers`() {
        val nums = intArrayOf(-1, -2, -3, -4)
        val expected = emptyList<List<Int>>()
        val result = threeSum(nums)
        assertEquals(expected, result)
    }

    @Test
    fun `test array with all positive numbers`() {
        val nums = intArrayOf(1, 2, 3, 4)
        val expected = emptyList<List<Int>>()
        val result = threeSum(nums)
        assertEquals(expected, result)
    }

    @Test
    fun `test large array with multiple solutions`() {
        val nums = intArrayOf(-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6)
        val expected = listOf(
            listOf(-4, -2, 6),
            listOf(-4, 0, 4),
            listOf(-4, 1, 3),
            listOf(-4, 2, 2),
            listOf(-2, -2, 4),
            listOf(-2, 0, 2)
        )
        val result = threeSum(nums)

        assertEquals(expected.size, result.size)
        expected.forEach { expectedTriplet ->
            assert(result.any { resultTriplet ->
                expectedTriplet.sorted() == resultTriplet.sorted()
            })
        }
    }
}
