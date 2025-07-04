package com.only4.algorithm.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class SolveNQueensTest {

    @Test
    fun `test n equals 1`() {
        val n = 1
        val result = solveNQueens(n)

        assertEquals(1, result.size)
        assertEquals(listOf("Q"), result[0])
    }

    @Test
    fun `test n equals 4`() {
        val n = 4
        val result = solveNQueens(n)

        assertEquals(2, result.size)

        // 验证第一种解法
        val solution1 = listOf(
            ".Q..",
            "...Q",
            "Q...",
            "..Q."
        )

        // 验证第二种解法
        val solution2 = listOf(
            "..Q.",
            "Q...",
            "...Q",
            ".Q.."
        )

        // 检查结果中是否包含这两种解法
        assertTrue(result.contains(solution1) || result.contains(solution2))

        // 检查每个解法是否有效
        for (solution in result) {
            assertEquals(n, solution.size)
            for (row in solution) {
                assertEquals(n, row.length)
                assertEquals(1, row.count { it == 'Q' })
            }
        }
    }

    @Test
    fun `test n equals 5`() {
        val n = 5
        val result = solveNQueens(n)

        assertEquals(10, result.size)

        // 检查每个解法是否有效
        for (solution in result) {
            assertEquals(n, solution.size)
            for (row in solution) {
                assertEquals(n, row.length)
                assertEquals(1, row.count { it == 'Q' })
            }

            // 验证每个解法中的皇后位置是否有效
            assertTrue(isValidNQueensSolution(solution))
        }
    }

    @Test
    fun `test n equals 8`() {
        val n = 8
        val result = solveNQueens(n)

        assertEquals(92, result.size)

        // 检查每个解法是否有效
        for (solution in result) {
            assertEquals(n, solution.size)
            for (row in solution) {
                assertEquals(n, row.length)
                assertEquals(1, row.count { it == 'Q' })
            }

            // 验证每个解法中的皇后位置是否有效
            assertTrue(isValidNQueensSolution(solution))
        }
    }

    /**
     * 验证N皇后解法是否有效
     */
    private fun isValidNQueensSolution(board: List<String>): Boolean {
        val n = board.size
        val queensPositions = mutableListOf<Pair<Int, Int>>()

        // 找出所有皇后的位置
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (board[i][j] == 'Q') {
                    queensPositions.add(i to j)
                }
            }
        }

        // 检查是否有皇后在同一行、同一列或同一对角线上
        for (i in 0 until n - 1) {
            for (j in i + 1 until n) {
                val (r1, c1) = queensPositions[i]
                val (r2, c2) = queensPositions[j]

                // 检查是否在同一行或同一列
                if (r1 == r2 || c1 == c2) {
                    return false
                }

                // 检查是否在同一对角线上
                if (Math.abs(r1 - r2) == Math.abs(c1 - c2)) {
                    return false
                }
            }
        }

        return true
    }
}
