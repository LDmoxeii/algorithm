package com.only4.algorithm.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CoinChangeTest {

    @Test
    fun `test examples from problem description`() {
        // 示例1: coins = [1,2,5], amount = 11 -> 3
        assertEquals(3, coinChange(intArrayOf(1, 2, 5), 11))

        // 示例2: coins = [2], amount = 3 -> -1
        assertEquals(-1, coinChange(intArrayOf(2), 3))

        // 示例3: coins = [1], amount = 0 -> 0
        assertEquals(0, coinChange(intArrayOf(1), 0))
    }

    @Test
    fun `test edge cases`() {
        // 金额为0，任何硬币都可以凑成，需要0个
        assertEquals(0, coinChange(intArrayOf(5, 10), 0))

        // 没有硬币，无法凑成任何非零金额
        assertEquals(-1, coinChange(intArrayOf(), 5))

        // 硬币面额都大于目标金额，无法凑成
        assertEquals(-1, coinChange(intArrayOf(5, 10), 3))
    }

    @Test
    fun `test additional cases`() {
        // 只有一种硬币，且可以整除目标金额
        assertEquals(4, coinChange(intArrayOf(2), 8))

        // 多种硬币，贪心选择不是最优解
        assertEquals(2, coinChange(intArrayOf(1, 3, 4), 6)) // 应该选择 3+3 而不是 4+1+1

        // 多种硬币，包含1，任何金额都能凑成
        assertEquals(11, coinChange(intArrayOf(1), 11))

        // 多种硬币，最优解需要组合使用
        assertEquals(3, coinChange(intArrayOf(1, 4, 5), 12)) // 4+4+4 比 5+5+1+1 少一个
    }

    @Test
    fun `test larger amounts`() {
        // 较大金额
        assertEquals(6, coinChange(intArrayOf(1, 2, 5, 10), 18)) // 10+5+1+1+1
        assertEquals(4, coinChange(intArrayOf(2, 5, 10, 25), 37)) // 25+10+2

        // 硬币面额不是按顺序的
        assertEquals(3, coinChange(intArrayOf(9, 6, 5, 1), 11)) // 9+1+1
    }

    @Test
    fun `test special cases`() {
        // 硬币包含目标金额
        assertEquals(1, coinChange(intArrayOf(1, 3, 5, 7), 7))

        // 最小硬币不是1，但仍能凑成
        assertEquals(2, coinChange(intArrayOf(2, 3, 5), 8)) // 3+5

        // 硬币面额有重复
        assertEquals(2, coinChange(intArrayOf(1, 1, 2, 5), 6)) // 5+1
    }
}
