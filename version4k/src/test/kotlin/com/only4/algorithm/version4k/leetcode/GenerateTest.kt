package com.only4.algorithm.version4k.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class GenerateTest {

    @Test
    fun `test examples from problem description`() {
        // 示例1: numRows = 5
        val expected5 = listOf(
            listOf(1),
            listOf(1, 1),
            listOf(1, 2, 1),
            listOf(1, 3, 3, 1),
            listOf(1, 4, 6, 4, 1)
        )
        assertEquals(expected5, generate(5))

        // 示例2: numRows = 1
        val expected1 = listOf(listOf(1))
        assertEquals(expected1, generate(1))
    }

    @Test
    fun `test edge cases`() {
        // numRows = 0
        assertEquals(emptyList<List<Int>>(), generate(0))

        // numRows = -1
        assertEquals(emptyList<List<Int>>(), generate(-1))
    }

    @Test
    fun `test additional cases`() {
        // numRows = 2
        val expected2 = listOf(
            listOf(1),
            listOf(1, 1)
        )
        assertEquals(expected2, generate(2))

        // numRows = 3
        val expected3 = listOf(
            listOf(1),
            listOf(1, 1),
            listOf(1, 2, 1)
        )
        assertEquals(expected3, generate(3))

        // numRows = 6
        val expected6 = listOf(
            listOf(1),
            listOf(1, 1),
            listOf(1, 2, 1),
            listOf(1, 3, 3, 1),
            listOf(1, 4, 6, 4, 1),
            listOf(1, 5, 10, 10, 5, 1)
        )
        assertEquals(expected6, generate(6))
    }

    @Test
    fun `verify pascal triangle properties`() {
        val triangle = generate(10)

        // 验证每行的第一个和最后一个元素都是1
        for (row in triangle) {
            assertEquals(1, row.first())
            assertEquals(1, row.last())
        }

        // 验证每个元素等于它上方两个元素之和（从第3行开始）
        for (i in 2 until triangle.size) {
            for (j in 1 until i) {
                assertEquals(
                    triangle[i - 1][j - 1] + triangle[i - 1][j],
                    triangle[i][j]
                )
            }
        }
    }
}
