package com.only4.algorithm.leetcode

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ExistTest {

    @Test
    fun `test example 1`() {
        val board = arrayOf(
            charArrayOf('A', 'B', 'C', 'E'),
            charArrayOf('S', 'F', 'C', 'S'),
            charArrayOf('A', 'D', 'E', 'E')
        )
        val word = "ABCCED"

        val result = exist(board, word)

        assertTrue(result)
    }

    @Test
    fun `test example 2`() {
        val board = arrayOf(
            charArrayOf('A', 'B', 'C', 'E'),
            charArrayOf('S', 'F', 'C', 'S'),
            charArrayOf('A', 'D', 'E', 'E')
        )
        val word = "SEE"

        val result = exist(board, word)

        assertTrue(result)
    }

    @Test
    fun `test example 3`() {
        val board = arrayOf(
            charArrayOf('A', 'B', 'C', 'E'),
            charArrayOf('S', 'F', 'C', 'S'),
            charArrayOf('A', 'D', 'E', 'E')
        )
        val word = "ABCB"

        val result = exist(board, word)

        assertFalse(result)
    }

    @Test
    fun `test single character board`() {
        val board = arrayOf(
            charArrayOf('A')
        )

        assertTrue(exist(board, "A"))
        assertFalse(exist(board, "B"))
    }

    @Test
    fun `test word longer than board size`() {
        val board = arrayOf(
            charArrayOf('A', 'B'),
            charArrayOf('C', 'D')
        )
        val word = "ABCDE"

        val result = exist(board, word)

        assertFalse(result)
    }
}
