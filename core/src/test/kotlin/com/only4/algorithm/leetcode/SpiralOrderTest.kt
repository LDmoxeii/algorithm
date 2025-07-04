package com.only4.algorithm.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SpiralOrderTest {

    @Test
    fun `test example 1`() {
        val matrix = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6),
            intArrayOf(7, 8, 9)
        )
        val expected = listOf(1, 2, 3, 6, 9, 8, 7, 4, 5)

        val result = spiralOrder(matrix)

        assertEquals(expected, result)
    }

    @Test
    fun `test example 2`() {
        val matrix = arrayOf(
            intArrayOf(1, 2, 3, 4),
            intArrayOf(5, 6, 7, 8),
            intArrayOf(9, 10, 11, 12)
        )
        val expected = listOf(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7)

        val result = spiralOrder(matrix)

        assertEquals(expected, result)
    }

    @Test
    fun `test empty matrix`() {
        val matrix = arrayOf<IntArray>()
        val expected = emptyList<Int>()

        val result = spiralOrder(matrix)

        assertEquals(expected, result)
    }

    @Test
    fun `test single row matrix`() {
        val matrix = arrayOf(
            intArrayOf(1, 2, 3, 4)
        )
        val expected = listOf(1, 2, 3, 4)

        val result = spiralOrder(matrix)

        assertEquals(expected, result)
    }

    @Test
    fun `test single column matrix`() {
        val matrix = arrayOf(
            intArrayOf(1),
            intArrayOf(2),
            intArrayOf(3),
            intArrayOf(4)
        )
        val expected = listOf(1, 2, 3, 4)

        val result = spiralOrder(matrix)

        assertEquals(expected, result)
    }

    @Test
    fun `test single element matrix`() {
        val matrix = arrayOf(
            intArrayOf(1)
        )
        val expected = listOf(1)

        val result = spiralOrder(matrix)

        assertEquals(expected, result)
    }
}
