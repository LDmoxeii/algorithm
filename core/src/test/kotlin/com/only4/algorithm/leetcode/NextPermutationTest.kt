package com.only4.algorithm.leetcode

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class NextPermutationTest {
    @Test
    fun testExample1() {
        val nums = intArrayOf(1, 2, 3)
        nextPermutation(nums)
        assertArrayEquals(intArrayOf(1, 3, 2), nums)
    }

    @Test
    fun testExample2() {
        val nums = intArrayOf(3, 2, 1)
        nextPermutation(nums)
        assertArrayEquals(intArrayOf(1, 2, 3), nums)
    }

    @Test
    fun testExample3() {
        val nums = intArrayOf(1, 1, 5)
        nextPermutation(nums)
        assertArrayEquals(intArrayOf(1, 5, 1), nums)
    }

    @Test
    fun testSingleElement() {
        val nums = intArrayOf(1)
        nextPermutation(nums)
        assertArrayEquals(intArrayOf(1), nums)
    }

    @Test
    fun testTwoElements() {
        val nums = intArrayOf(1, 2)
        nextPermutation(nums)
        assertArrayEquals(intArrayOf(2, 1), nums)
    }

    @Test
    fun testAllSame() {
        val nums = intArrayOf(2, 2, 2)
        nextPermutation(nums)
        assertArrayEquals(intArrayOf(2, 2, 2), nums)
    }
}
