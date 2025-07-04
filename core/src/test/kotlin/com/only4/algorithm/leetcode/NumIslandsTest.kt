package com.only4.algorithm.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumIslandsTest {

    // 辅助函数：复制二维字符数组，防止测试间相互干扰
    private fun copyGrid(grid: Array<CharArray>): Array<CharArray> {
        return Array(grid.size) { i -> grid[i].copyOf() }
    }

    @Test
    fun `test example 1 - one island`() {
        val grid = arrayOf(
            charArrayOf('1', '1', '1', '1', '0'),
            charArrayOf('1', '1', '0', '1', '0'),
            charArrayOf('1', '1', '0', '0', '0'),
            charArrayOf('0', '0', '0', '0', '0')
        )
        val expected = 1
        val result = numIslands(copyGrid(grid))
        assertEquals(expected, result)
    }

    @Test
    fun `test example 2 - three islands`() {
        val grid = arrayOf(
            charArrayOf('1', '1', '0', '0', '0'),
            charArrayOf('1', '1', '0', '0', '0'),
            charArrayOf('0', '0', '1', '0', '0'),
            charArrayOf('0', '0', '0', '1', '1')
        )
        val expected = 3
        val result = numIslands(copyGrid(grid))
        assertEquals(expected, result)
    }

    @Test
    fun `test example 3 - checkerboard pattern`() {
        val grid = arrayOf(
            charArrayOf('1', '0', '1', '0', '1'),
            charArrayOf('0', '1', '0', '1', '0'),
            charArrayOf('1', '0', '1', '0', '1'),
            charArrayOf('0', '1', '0', '1', '0')
        )
        val expected = 10
        val result = numIslands(copyGrid(grid))
        assertEquals(expected, result)
    }

    @Test
    fun `test empty grid`() {
        val grid = arrayOf<CharArray>()
        val expected = 0
        val result = numIslands(grid)
        assertEquals(expected, result)
    }

    @Test
    fun `test grid with empty rows`() {
        val grid = arrayOf(
            charArrayOf(),
            charArrayOf()
        )
        val expected = 0
        val result = numIslands(grid)
        assertEquals(expected, result)
    }

    @Test
    fun `test grid with no islands`() {
        val grid = arrayOf(
            charArrayOf('0', '0', '0'),
            charArrayOf('0', '0', '0'),
            charArrayOf('0', '0', '0')
        )
        val expected = 0
        val result = numIslands(copyGrid(grid))
        assertEquals(expected, result)
    }

    @Test
    fun `test grid with all islands`() {
        val grid = arrayOf(
            charArrayOf('1', '1', '1'),
            charArrayOf('1', '1', '1'),
            charArrayOf('1', '1', '1')
        )
        val expected = 1
        val result = numIslands(copyGrid(grid))
        assertEquals(expected, result)
    }

    @Test
    fun `test grid with complex island shapes`() {
        val grid = arrayOf(
            charArrayOf('1', '1', '0', '0', '0'),
            charArrayOf('1', '0', '0', '0', '1'),
            charArrayOf('0', '0', '1', '0', '1'),
            charArrayOf('0', '1', '1', '1', '0')
        )
        val expected = 3
        val result = numIslands(copyGrid(grid))
        assertEquals(expected, result)
    }

    @Test
    fun `test grid with single cell island`() {
        val grid = arrayOf(
            charArrayOf('0', '0', '0'),
            charArrayOf('0', '1', '0'),
            charArrayOf('0', '0', '0')
        )
        val expected = 1
        val result = numIslands(copyGrid(grid))
        assertEquals(expected, result)
    }

    @Test
    fun `test grid with islands connected diagonally`() {
        // 注意：对角线连接不算作同一个岛屿
        val grid = arrayOf(
            charArrayOf('1', '0', '1'),
            charArrayOf('0', '0', '0'),
            charArrayOf('1', '0', '1')
        )
        val expected = 4
        val result = numIslands(copyGrid(grid))
        assertEquals(expected, result)
    }

    @Test
    fun `test grid with spiral island`() {
        val grid = arrayOf(
            charArrayOf('1', '1', '1', '1', '1'),
            charArrayOf('0', '0', '0', '0', '1'),
            charArrayOf('1', '1', '1', '0', '1'),
            charArrayOf('1', '0', '0', '0', '1'),
            charArrayOf('1', '1', '1', '1', '1')
        )
        val expected = 1
        val result = numIslands(copyGrid(grid))
        assertEquals(expected, result)
    }

    @Test
    fun `test grid with U-shaped island`() {
        val grid = arrayOf(
            charArrayOf('1', '0', '1'),
            charArrayOf('1', '0', '1'),
            charArrayOf('1', '1', '1')
        )
        val expected = 1
        val result = numIslands(copyGrid(grid))
        assertEquals(expected, result)
    }

    @Test
    fun `test grid with islands on edges`() {
        val grid = arrayOf(
            charArrayOf('1', '0', '0', '0', '1'),
            charArrayOf('0', '0', '0', '0', '0'),
            charArrayOf('0', '0', '0', '0', '0'),
            charArrayOf('1', '0', '0', '0', '1')
        )
        val expected = 4
        val result = numIslands(copyGrid(grid))
        assertEquals(expected, result)
    }

    @Test
    fun `test grid with zigzag island`() {
        val grid = arrayOf(
            charArrayOf('1', '0', '0'),
            charArrayOf('1', '1', '0'),
            charArrayOf('0', '1', '1')
        )
        val expected = 1
        val result = numIslands(copyGrid(grid))
        assertEquals(expected, result)
    }

    @Test
    fun `test grid with single row`() {
        val grid = arrayOf(
            charArrayOf('1', '0', '1', '0', '1')
        )
        val expected = 3
        val result = numIslands(copyGrid(grid))
        assertEquals(expected, result)
    }

    @Test
    fun `test grid with single column`() {
        val grid = arrayOf(
            charArrayOf('1'),
            charArrayOf('0'),
            charArrayOf('1'),
            charArrayOf('0'),
            charArrayOf('1')
        )
        val expected = 3
        val result = numIslands(copyGrid(grid))
        assertEquals(expected, result)
    }

    @Test
    fun `test multiple calls with same grid`() {
        val grid = arrayOf(
            charArrayOf('1', '1', '0'),
            charArrayOf('1', '0', '0'),
            charArrayOf('0', '0', '1')
        )

        // 第一次调用
        val expected1 = 2
        val result1 = numIslands(copyGrid(grid))
        assertEquals(expected1, result1)

        // 第二次调用，确保原始grid未被修改
        val expected2 = 2
        val result2 = numIslands(copyGrid(grid))
        assertEquals(expected2, result2)

        // 检查原始grid是否保持不变
        assertEquals('1', grid[0][0])
        assertEquals('1', grid[0][1])
        assertEquals('0', grid[0][2])
        assertEquals('1', grid[1][0])
        assertEquals('0', grid[1][1])
        assertEquals('0', grid[1][2])
        assertEquals('0', grid[2][0])
        assertEquals('0', grid[2][1])
        assertEquals('1', grid[2][2])
    }
}
