package com.only4.algorithm.version4k.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ClimbStairsTest {

    @Test
    fun `test examples from problem description`() {
        // 示例1: n = 2 -> 2种方法
        assertEquals(2, climbStairs(2))

        // 示例2: n = 3 -> 3种方法
        assertEquals(3, climbStairs(3))
    }

    @Test
    fun `test edge cases`() {
        // n = 0 -> 0种方法
        assertEquals(0, climbStairs(0))

        // n = 1 -> 1种方法
        assertEquals(1, climbStairs(1))
    }

    @Test
    fun `test additional cases`() {
        // n = 4 -> 5种方法
        // 1+1+1+1, 1+1+2, 1+2+1, 2+1+1, 2+2
        assertEquals(5, climbStairs(4))

        // n = 5 -> 8种方法
        assertEquals(8, climbStairs(5))

        // n = 6 -> 13种方法
        assertEquals(13, climbStairs(6))
    }

    @Test
    fun `test larger inputs`() {
        // n = 10 -> 89种方法
        assertEquals(89, climbStairs(10))

        // n = 20 -> 10946种方法
        assertEquals(10946, climbStairs(20))
    }

    @Test
    fun `verify fibonacci sequence property`() {
        // 验证斐波那契数列性质: F(n) = F(n-1) + F(n-2)
        for (n in 3..20) {
            assertEquals(climbStairs(n - 1) + climbStairs(n - 2), climbStairs(n))
        }
    }
}
