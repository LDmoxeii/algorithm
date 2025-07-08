package com.only4.algorithm.version4k.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindDuplicateTest {
    @Test
    fun testExample1() {
        val nums = intArrayOf(1, 3, 4, 2, 2)
        assertEquals(2, findDuplicate(nums))
    }

    @Test
    fun testExample2() {
        val nums = intArrayOf(3, 1, 3, 4, 2)
        assertEquals(3, findDuplicate(nums))
    }

    @Test
    fun testDuplicateAtStart() {
        val nums = intArrayOf(2, 2, 3, 4, 5, 6, 7, 8, 9, 1)
        assertEquals(2, findDuplicate(nums))
    }

    @Test
    fun testDuplicateAtEnd() {
        val nums = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 9)
        assertEquals(9, findDuplicate(nums))
    }

    @Test
    fun testAllSame() {
        val nums = intArrayOf(1, 1, 1, 1, 1, 1, 1, 1, 1, 1)
        assertEquals(1, findDuplicate(nums))
    }
}
