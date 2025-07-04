package com.only4.algorithm.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class OrangesRottingTest {

    // 辅助函数：复制二维整数数组，防止测试间相互干扰
    private fun copyGrid(grid: Array<IntArray>): Array<IntArray> {
        return Array(grid.size) { i -> grid[i].copyOf() }
    }

    @Test
    fun `test example 1 - all oranges can rot`() {
        val grid = arrayOf(
            intArrayOf(2, 1, 1),
            intArrayOf(1, 1, 0),
            intArrayOf(0, 1, 1)
        )
        val expected = 4
        val result = orangesRotting(copyGrid(grid))
        assertEquals(expected, result)
    }

    @Test
    fun `test example 2 - some oranges cannot rot`() {
        val grid = arrayOf(
            intArrayOf(2, 1, 1),
            intArrayOf(0, 1, 1),
            intArrayOf(1, 0, 1)
        )
        val expected = -1
        val result = orangesRotting(copyGrid(grid))
        assertEquals(expected, result)
    }

    @Test
    fun `test example 3 - no fresh oranges`() {
        val grid = arrayOf(
            intArrayOf(0, 2)
        )
        val expected = 0
        val result = orangesRotting(copyGrid(grid))
        assertEquals(expected, result)
    }

    @Test
    fun `test empty grid`() {
        val grid = arrayOf(
            intArrayOf()
        )
        val expected = 0
        val result = orangesRotting(copyGrid(grid))
        assertEquals(expected, result)
    }

    @Test
    fun `test grid with only fresh oranges`() {
        val grid = arrayOf(
            intArrayOf(1, 1),
            intArrayOf(1, 1)
        )
        val expected = -1
        val result = orangesRotting(copyGrid(grid))
        assertEquals(expected, result)
    }

    @Test
    fun `test grid with only rotten oranges`() {
        val grid = arrayOf(
            intArrayOf(2, 2),
            intArrayOf(2, 2)
        )
        val expected = 0
        val result = orangesRotting(copyGrid(grid))
        assertEquals(expected, result)
    }

    @Test
    fun `test grid with only empty cells`() {
        val grid = arrayOf(
            intArrayOf(0, 0),
            intArrayOf(0, 0)
        )
        val expected = 0
        val result = orangesRotting(copyGrid(grid))
        assertEquals(expected, result)
    }

    @Test
    fun `test grid with multiple rotten oranges`() {
        val grid = arrayOf(
            intArrayOf(2, 0, 1, 1),
            intArrayOf(1, 0, 1, 1),
            intArrayOf(0, 1, 1, 2)
        )
        val expected = 3
        val result = orangesRotting(copyGrid(grid))
        assertEquals(expected, result)
    }

    @Test
    fun `test grid with zigzag pattern`() {
        val grid = arrayOf(
            intArrayOf(2, 1, 0),
            intArrayOf(0, 1, 1),
            intArrayOf(1, 0, 2)
        )
        val expected = -1
        val result = orangesRotting(copyGrid(grid))
        assertEquals(expected, result)
    }

    @Test
    fun `test grid with single row`() {
        val grid = arrayOf(
            intArrayOf(2, 1, 1, 1, 1)
        )
        val expected = 4
        val result = orangesRotting(copyGrid(grid))
        assertEquals(expected, result)
    }

    @Test
    fun `test grid with single column`() {
        val grid = arrayOf(
            intArrayOf(2),
            intArrayOf(1),
            intArrayOf(1),
            intArrayOf(1),
            intArrayOf(1)
        )
        val expected = 4
        val result = orangesRotting(copyGrid(grid))
        assertEquals(expected, result)
    }

    @Test
    fun `test grid with isolated fresh oranges`() {
        val grid = arrayOf(
            intArrayOf(2, 0, 1),
            intArrayOf(0, 0, 0),
            intArrayOf(1, 0, 2)
        )
        val expected = -1
        val result = orangesRotting(copyGrid(grid))
        assertEquals(expected, result)
    }

    @Test
    fun `test grid with complex pattern`() {
        val grid = arrayOf(
            intArrayOf(2, 1, 1, 1, 1),
            intArrayOf(1, 0, 0, 0, 1),
            intArrayOf(1, 0, 2, 0, 1),
            intArrayOf(1, 0, 0, 0, 1),
            intArrayOf(1, 1, 1, 1, 1)
        )
        val expected = 8
        val result = orangesRotting(copyGrid(grid))
        assertEquals(expected, result)
    }

    @Test
    fun `test multiple calls with same grid`() {
        val grid = arrayOf(
            intArrayOf(2, 1, 1),
            intArrayOf(1, 1, 0),
            intArrayOf(0, 1, 1)
        )

        // 第一次调用
        val expected1 = 4
        val result1 = orangesRotting(copyGrid(grid))
        assertEquals(expected1, result1)

        // 第二次调用，确保原始grid未被修改
        val expected2 = 4
        val result2 = orangesRotting(copyGrid(grid))
        assertEquals(expected2, result2)

        // 检查原始grid是否保持不变
        assertEquals(2, grid[0][0])
        assertEquals(1, grid[0][1])
        assertEquals(1, grid[0][2])
        assertEquals(1, grid[1][0])
        assertEquals(1, grid[1][1])
        assertEquals(0, grid[1][2])
        assertEquals(0, grid[2][0])
        assertEquals(1, grid[2][1])
        assertEquals(1, grid[2][2])
    }
}
