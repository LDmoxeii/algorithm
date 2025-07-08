package com.only4.algorithm.version4k.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumSquaresTest {

    @Test
    fun `test examples from problem description`() {
        // 示例1: 12 = 4 + 4 + 4，需要3个完全平方数
        assertEquals(3, numSquares(12))

        // 示例2: 13 = 4 + 9，需要2个完全平方数
        assertEquals(2, numSquares(13))
    }

    @Test
    fun `test perfect squares`() {
        // 完全平方数本身只需要1个
        assertEquals(1, numSquares(1))  // 1 = 1
        assertEquals(1, numSquares(4))  // 4 = 4
        assertEquals(1, numSquares(9))  // 9 = 9
        assertEquals(1, numSquares(16)) // 16 = 16
        assertEquals(1, numSquares(25)) // 25 = 25
    }

    @Test
    fun `test small numbers`() {
        // 2 = 1 + 1
        assertEquals(2, numSquares(2))

        // 3 = 1 + 1 + 1
        assertEquals(3, numSquares(3))

        // 5 = 4 + 1
        assertEquals(2, numSquares(5))

        // 6 = 4 + 1 + 1
        assertEquals(3, numSquares(6))

        // 7 = 4 + 1 + 1 + 1
        assertEquals(4, numSquares(7))

        // 8 = 4 + 4
        assertEquals(2, numSquares(8))
    }

    @Test
    fun `test larger numbers`() {
        // 18 = 9 + 9
        assertEquals(2, numSquares(18))

        // 43 = 25 + 9 + 9
        assertEquals(3, numSquares(43))

        // 48 = 16 + 16 + 16
        assertEquals(3, numSquares(48))

        // 49 = 49
        assertEquals(1, numSquares(49))

        // 50 = 49 + 1
        assertEquals(2, numSquares(50))
    }

    @Test
    fun `test lagrangian four-square theorem`() {
        // 拉格朗日四平方定理：任何正整数都可以表示为至多4个平方数之和
        // 所以结果应该总是小于等于4
        for (i in 1..100) {
            val result = numSquares(i)
            assert(result <= 4) { "Result for $i is $result, which is greater than 4" }
        }
    }
}
