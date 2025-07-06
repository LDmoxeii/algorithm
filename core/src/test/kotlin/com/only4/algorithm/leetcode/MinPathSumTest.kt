package com.only4.algorithm.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinPathSumTest {

    @Test
    fun `test examples from problem description`() {
        // 示例1: grid = [[1,3,1],[1,5,1],[4,2,1]] -> 7
        val grid1 = arrayOf(
            intArrayOf(1, 3, 1),
            intArrayOf(1, 5, 1),
            intArrayOf(4, 2, 1)
        )
        assertEquals(7, minPathSum(grid1))
        // 最小路径: 1→3→1→1→1

        // 示例2: grid = [[1,2,3],[4,5,6]] -> 12
        val grid2 = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6)
        )
        assertEquals(12, minPathSum(grid2))
        // 最小路径: 1→2→3→6 或 1→4→5→6
    }

    @Test
    fun `test edge cases`() {
        // 1x1 网格
        val singleCell = arrayOf(intArrayOf(5))
        assertEquals(5, minPathSum(singleCell))

        // 1xn 网格
        val singleRow = arrayOf(intArrayOf(1, 2, 3, 4, 5))
        assertEquals(15, minPathSum(singleRow))

        // mx1 网格
        val singleColumn = arrayOf(
            intArrayOf(1),
            intArrayOf(2),
            intArrayOf(3),
            intArrayOf(4),
            intArrayOf(5)
        )
        assertEquals(15, minPathSum(singleColumn))
    }

    @Test
    fun `test grids with large values`() {
        // 包含大值的网格
        val gridWithLargeValues = arrayOf(
            intArrayOf(1, 100, 1),
            intArrayOf(100, 1, 100),
            intArrayOf(1, 100, 1)
        )
        assertEquals(203, minPathSum(gridWithLargeValues))
    }

    @Test
    fun `test non-square grids`() {
        // 非正方形网格
        val nonSquareGrid = arrayOf(
            intArrayOf(1, 2, 3, 4),
            intArrayOf(5, 6, 7, 8),
            intArrayOf(9, 10, 11, 12)
        )
        assertEquals(30, minPathSum(nonSquareGrid))
        // 最小路径: 1→2→3→4→8→12
    }

    @Test
    fun `test grids with obvious optimal path`() {
        // 有明显最优路径的网格
        val gridWithObviousPath = arrayOf(
            intArrayOf(1, 1, 1),
            intArrayOf(9, 9, 1),
            intArrayOf(9, 9, 1)
        )
        assertEquals(5, minPathSum(gridWithObviousPath))
        // 最小路径: 1→1→1→1→1

        val anotherGridWithObviousPath = arrayOf(
            intArrayOf(1, 9, 9),
            intArrayOf(1, 9, 9),
            intArrayOf(1, 1, 1)
        )
        assertEquals(5, minPathSum(anotherGridWithObviousPath))
        // 最小路径: 1→1→1→1→1
    }

    @Test
    fun `test grids with multiple optimal paths`() {
        // 有多条最优路径的网格
        val gridWithMultiplePaths = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 1, 2),
            intArrayOf(7, 2, 1)
        )
        assertEquals(7, minPathSum(gridWithMultiplePaths))
        // 最小路径可以是: 1→2→1→2→1 或 1→4→1→1
    }

    @Test
    fun `test large grids`() {
        // 较大的网格
        val largeGrid = Array(10) { row ->
            IntArray(10) { col ->
                (row + col) % 5 + 1 // 生成1-5之间的值
            }
        }
        // 手动计算最小路径和
        val expectedSum = 55 // 这个值需要根据生成的网格手动计算
        assertEquals(expectedSum, minPathSum(largeGrid))
    }
}
