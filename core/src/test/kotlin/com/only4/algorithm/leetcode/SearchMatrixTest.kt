package com.only4.algorithm.leetcode

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class SearchMatrixTest {

    @Test
    fun `test example 1`() {
        val matrix = arrayOf(
            intArrayOf(1, 4, 7, 11, 15),
            intArrayOf(2, 5, 8, 12, 19),
            intArrayOf(3, 6, 9, 16, 22),
            intArrayOf(10, 13, 14, 17, 24),
            intArrayOf(18, 21, 23, 26, 30)
        )

        assertTrue(searchMatrix(matrix, 5))
    }

    @Test
    fun `test example 2`() {
        val matrix = arrayOf(
            intArrayOf(1, 4, 7, 11, 15),
            intArrayOf(2, 5, 8, 12, 19),
            intArrayOf(3, 6, 9, 16, 22),
            intArrayOf(10, 13, 14, 17, 24),
            intArrayOf(18, 21, 23, 26, 30)
        )

        assertFalse(searchMatrix(matrix, 20))
    }

    @Test
    fun `test empty matrix`() {
        val emptyMatrix = arrayOf<IntArray>()
        assertFalse(searchMatrix(emptyMatrix, 0))
    }

    @Test
    fun `test matrix with empty rows`() {
        val matrixWithEmptyRows = arrayOf(intArrayOf())
        assertFalse(searchMatrix(matrixWithEmptyRows, 1))
    }

    @Test
    fun `test target in top-right corner`() {
        val matrix = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6),
            intArrayOf(7, 8, 9)
        )

        assertTrue(searchMatrix(matrix, 3))
    }

    @Test
    fun `test target in bottom-left corner`() {
        val matrix = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6),
            intArrayOf(7, 8, 9)
        )

        assertTrue(searchMatrix(matrix, 7))
    }

    @Test
    fun `test target not in matrix`() {
        val matrix = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6),
            intArrayOf(7, 8, 9)
        )

        assertFalse(searchMatrix(matrix, 10))
    }
}
