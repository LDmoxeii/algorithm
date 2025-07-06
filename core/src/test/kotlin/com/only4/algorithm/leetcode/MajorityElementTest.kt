package com.only4.algorithm.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MajorityElementTest {
    @Test
    fun testExample1() {
        val nums = intArrayOf(3, 2, 3)
        assertEquals(3, majorityElement(nums))
    }

    @Test
    fun testExample2() {
        val nums = intArrayOf(2, 2, 1, 1, 1, 2, 2)
        assertEquals(2, majorityElement(nums))
    }

    @Test
    fun testAllSame() {
        val nums = intArrayOf(1, 1, 1, 1, 1)
        assertEquals(1, majorityElement(nums))
    }

    @Test
    fun testMajorityAtEnd() {
        val nums = intArrayOf(1, 2, 3, 4, 4, 4, 4)
        assertEquals(4, majorityElement(nums))
    }

    @Test
    fun testMajorityAtStart() {
        val nums = intArrayOf(5, 5, 5, 2, 3, 5, 1)
        assertEquals(5, majorityElement(nums))
    }

    @Test
    fun testSingleElement() {
        val nums = intArrayOf(7)
        assertEquals(7, majorityElement(nums))
    }
}
