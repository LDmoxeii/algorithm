package com.only4.algorithm.leetcode

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

class TwoSumTest {

    @Test
    fun `test example case`() {
        val numbers = intArrayOf(2, 7, 11, 15)
        val target = 9
        val expected = intArrayOf(0, 1)

        val result = twoSum(numbers, target)

        assertArrayEquals(expected, result)
    }

    @Test
    fun `test with target at end of array`() {
        val numbers = intArrayOf(2, 3, 4, 5, 6)
        val target = 11
        val expected = intArrayOf(3, 4)

        val result = twoSum(numbers, target)

        assertArrayEquals(expected, result)
    }

    @Test
    fun `test with target at beginning of array`() {
        val numbers = intArrayOf(1, 2, 3, 4, 5)
        val target = 3
        val expected = intArrayOf(0, 1)

        val result = twoSum(numbers, target)

        assertArrayEquals(expected, result)
    }

    @Test
    fun `test with minimum array size`() {
        val numbers = intArrayOf(1, 2)
        val target = 3
        val expected = intArrayOf(0, 1)

        val result = twoSum(numbers, target)

        assertArrayEquals(expected, result)
    }

    @Test
    fun `test with large numbers`() {
        val numbers = intArrayOf(1000, 2000, 3000, 4000)
        val target = 7000
        val expected = intArrayOf(2, 3)

        val result = twoSum(numbers, target)

        assertArrayEquals(expected, result)
    }

    @Test
    fun `test no solution throws exception`() {
        val numbers = intArrayOf(1, 2, 3, 4)
        val target = 10

        assertThrows(IllegalArgumentException::class.java) {
            twoSum(numbers, target)
        }
    }

    @Test
    fun `extend 001`() {
        // 测试扩展001
        val numbers = intArrayOf(3, 2, 4)
        val target = 6
        val expected = intArrayOf(1, 2)

        val result = twoSum(numbers, target)

        assertArrayEquals(expected, result)
    }
}
