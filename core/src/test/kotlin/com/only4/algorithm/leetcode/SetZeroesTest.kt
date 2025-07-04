package com.only4.algorithm.leetcode

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class SetZeroesTest {

    @Test
    fun `test example 1`() {
        val matrix = arrayOf(
            intArrayOf(1, 1, 1),
            intArrayOf(1, 0, 1),
            intArrayOf(1, 1, 1)
        )
        val expected = arrayOf(
            intArrayOf(1, 0, 1),
            intArrayOf(0, 0, 0),
            intArrayOf(1, 0, 1)
        )

        setZeroes(matrix)

        assertArrayEquals(expected, matrix)
    }

    @Test
    fun `test example 2`() {
        val matrix = arrayOf(
            intArrayOf(0, 1, 2, 0),
            intArrayOf(3, 4, 5, 2),
            intArrayOf(1, 3, 1, 5)
        )
        val expected = arrayOf(
            intArrayOf(0, 0, 0, 0),
            intArrayOf(0, 4, 5, 0),
            intArrayOf(0, 3, 1, 0)
        )

        setZeroes(matrix)

        assertArrayEquals(expected, matrix)
    }

    @Test
    fun `test empty matrix`() {
        val matrix = arrayOf<IntArray>()
        val expected = arrayOf<IntArray>()

        setZeroes(matrix)

        assertArrayEquals(expected, matrix)
    }

    @Test
    fun `test matrix with no zeros`() {
        val matrix = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6),
            intArrayOf(7, 8, 9)
        )
        val expected = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6),
            intArrayOf(7, 8, 9)
        )

        setZeroes(matrix)

        assertArrayEquals(expected, matrix)
    }

    @Test
    fun `test matrix with all zeros`() {
        val matrix = arrayOf(
            intArrayOf(0, 0),
            intArrayOf(0, 0)
        )
        val expected = arrayOf(
            intArrayOf(0, 0),
            intArrayOf(0, 0)
        )

        setZeroes(matrix)

        assertArrayEquals(expected, matrix)
    }
}
