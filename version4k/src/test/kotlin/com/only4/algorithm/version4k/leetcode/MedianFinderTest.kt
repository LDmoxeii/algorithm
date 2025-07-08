package com.only4.algorithm.version4k.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MedianFinderTest {

    @Test
    fun `test example from problem description`() {
        val medianFinder = MedianFinder()

        medianFinder.addNum(1)
        medianFinder.addNum(2)
        assertEquals(1.5, medianFinder.findMedian())

        medianFinder.addNum(3)
        assertEquals(2.0, medianFinder.findMedian())
    }

    @Test
    fun `test with odd number of elements`() {
        val medianFinder = MedianFinder()

        medianFinder.addNum(5)
        assertEquals(5.0, medianFinder.findMedian())

        medianFinder.addNum(3)
        medianFinder.addNum(8)
        assertEquals(5.0, medianFinder.findMedian())

        medianFinder.addNum(2)
        medianFinder.addNum(9)
        assertEquals(5.0, medianFinder.findMedian())
    }

    @Test
    fun `test with even number of elements`() {
        val medianFinder = MedianFinder()

        medianFinder.addNum(5)
        medianFinder.addNum(3)
        assertEquals(4.0, medianFinder.findMedian())

        medianFinder.addNum(8)
        medianFinder.addNum(2)
        assertEquals(4.0, medianFinder.findMedian())
    }

    @Test
    fun `test with negative numbers`() {
        val medianFinder = MedianFinder()

        medianFinder.addNum(-1)
        assertEquals(-1.0, medianFinder.findMedian())

        medianFinder.addNum(-2)
        assertEquals(-1.5, medianFinder.findMedian())

        medianFinder.addNum(-3)
        assertEquals(-2.0, medianFinder.findMedian())
    }

    @Test
    fun `test with mixed positive and negative numbers`() {
        val medianFinder = MedianFinder()

        medianFinder.addNum(-1)
        medianFinder.addNum(2)
        assertEquals(0.5, medianFinder.findMedian())

        medianFinder.addNum(-3)
        assertEquals(-1.0, medianFinder.findMedian())

        medianFinder.addNum(4)
        assertEquals(0.5, medianFinder.findMedian())
    }

    @Test
    fun `test with duplicate numbers`() {
        val medianFinder = MedianFinder()

        medianFinder.addNum(1)
        medianFinder.addNum(1)
        assertEquals(1.0, medianFinder.findMedian())

        medianFinder.addNum(2)
        assertEquals(1.0, medianFinder.findMedian())

        medianFinder.addNum(2)
        assertEquals(1.5, medianFinder.findMedian())
    }

    @Test
    fun `test with large sequence of numbers`() {
        val medianFinder = MedianFinder()
        val numbers = listOf(41, 35, 62, 5, 97, 108)

        // 添加数字并验证每一步的中位数
        medianFinder.addNum(numbers[0]) // [41]
        assertEquals(41.0, medianFinder.findMedian())

        medianFinder.addNum(numbers[1]) // [35, 41]
        assertEquals(38.0, medianFinder.findMedian())

        medianFinder.addNum(numbers[2]) // [35, 41, 62]
        assertEquals(41.0, medianFinder.findMedian())

        medianFinder.addNum(numbers[3]) // [5, 35, 41, 62]
        assertEquals(38.0, medianFinder.findMedian())

        medianFinder.addNum(numbers[4]) // [5, 35, 41, 62, 97]
        assertEquals(41.0, medianFinder.findMedian())

        medianFinder.addNum(numbers[5]) // [5, 35, 41, 62, 97, 108]
        assertEquals(51.5, medianFinder.findMedian())
    }
}
