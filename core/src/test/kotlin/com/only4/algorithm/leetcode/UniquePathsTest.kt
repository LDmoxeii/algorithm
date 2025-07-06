package com.only4.algorithm.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class UniquePathsTest {

    @Test
    fun `test examples from problem description`() {
        // 示例1: m = 3, n = 7 -> 28
        assertEquals(28, uniquePaths(3, 7))

        // 示例2: m = 3, n = 2 -> 3
        assertEquals(3, uniquePaths(3, 2))
    }

    @Test
    fun `test edge cases`() {
        // 1x1 网格只有一条路径
        assertEquals(1, uniquePaths(1, 1))

        // 1xn 或 mx1 网格只有一条路径
        assertEquals(1, uniquePaths(1, 10))
        assertEquals(1, uniquePaths(10, 1))
    }

    @Test
    fun `test small grids`() {
        // 2x2 网格有两条路径
        assertEquals(2, uniquePaths(2, 2))

        // 2x3 网格有三条路径
        assertEquals(3, uniquePaths(2, 3))

        // 3x3 网格有六条路径
        assertEquals(6, uniquePaths(3, 3))
    }

    @Test
    fun `test medium grids`() {
        // 4x4 网格
        assertEquals(20, uniquePaths(4, 4))

        // 5x5 网格
        assertEquals(70, uniquePaths(5, 5))

        // 非正方形网格
        assertEquals(15, uniquePaths(3, 5))
        assertEquals(15, uniquePaths(5, 3))
    }

    @Test
    fun `test large grids`() {
        // 10x10 网格
        assertEquals(48620, uniquePaths(10, 10))

        // 非正方形大网格
        assertEquals(6906900, uniquePaths(10, 20)) // 较大网格的路径数
    }

    @Test
    fun `test symmetry property`() {
        // 测试对称性质：m x n 网格的路径数应该等于 n x m 网格的路径数
        assertEquals(uniquePaths(3, 7), uniquePaths(7, 3))
        assertEquals(uniquePaths(5, 8), uniquePaths(8, 5))
        assertEquals(uniquePaths(10, 15), uniquePaths(15, 10))
    }

    @Test
    fun `test mathematical formula`() {
        // 不同路径的数量实际上是组合数 C(m+n-2, m-1) 或 C(m+n-2, n-1)
        // 测试几个可以通过数学公式验证的情况

        // C(3+3-2, 3-1) = C(4, 2) = 6
        assertEquals(6, uniquePaths(3, 3))

        // C(4+5-2, 4-1) = C(7, 3) = 35
        assertEquals(35, uniquePaths(4, 5))

        // C(6+4-2, 6-1) = C(8, 5) = 56
        assertEquals(56, uniquePaths(6, 4))
    }
}
