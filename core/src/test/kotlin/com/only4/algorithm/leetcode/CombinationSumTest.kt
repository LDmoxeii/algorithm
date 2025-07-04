package com.only4.algorithm.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class CombinationSumTest {

    @Test
    fun `test empty candidates`() {
        val candidates = intArrayOf()
        val target = 8
        val result = combinationSum(candidates, target)

        assertTrue(result.isEmpty())
    }

    @Test
    fun `test example 1`() {
        val candidates = intArrayOf(2, 3, 6, 7)
        val target = 7
        val result = combinationSum(candidates, target)

        assertEquals(2, result.size)
        assertTrue(result.contains(listOf(2, 2, 3)))
        assertTrue(result.contains(listOf(7)))
    }

    @Test
    fun `test example 2`() {
        val candidates = intArrayOf(2, 3, 5)
        val target = 8
        val result = combinationSum(candidates, target)

        assertEquals(3, result.size)
        assertTrue(result.contains(listOf(2, 2, 2, 2)))
        assertTrue(result.contains(listOf(2, 3, 3)))
        assertTrue(result.contains(listOf(3, 5)))
    }

    @Test
    fun `test no valid combinations`() {
        val candidates = intArrayOf(2)
        val target = 1
        val result = combinationSum(candidates, target)

        assertTrue(result.isEmpty())
    }

    @Test
    fun `test single element equal to target`() {
        val candidates = intArrayOf(1)
        val target = 1
        val result = combinationSum(candidates, target)

        assertEquals(1, result.size)
        assertTrue(result.contains(listOf(1)))
    }

    @Test
    fun `test repeated elements`() {
        val candidates = intArrayOf(1)
        val target = 2
        val result = combinationSum(candidates, target)

        assertEquals(1, result.size)
        assertTrue(result.contains(listOf(1, 1)))
    }
}
