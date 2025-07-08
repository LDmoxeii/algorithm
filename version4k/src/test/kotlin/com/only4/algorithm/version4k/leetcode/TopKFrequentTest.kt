package com.only4.algorithm.version4k.leetcode

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class TopKFrequentTest {

    @Test
    fun `test examples from problem description`() {
        // 示例1: [1,1,1,2,2,3], k=2 -> [1,2] (频率: 1出现3次, 2出现2次, 3出现1次)
        val result1 = topKFrequent(intArrayOf(1, 1, 1, 2, 2, 3), 2)
        assertEquals(2, result1.size)
        assertTrue(result1.contains(1))
        assertTrue(result1.contains(2))

        // 示例2: [1], k=1 -> [1]
        assertArrayEquals(intArrayOf(1), topKFrequent(intArrayOf(1), 1))
    }

    @Test
    fun `test array with same frequency elements`() {
        // [1,1,2,2,3,3], k=2 -> 任意两个数字都可以
        val result = topKFrequent(intArrayOf(1, 1, 2, 2, 3, 3), 2)
        assertEquals(2, result.size)
        assertTrue(result.any { it == 1 || it == 2 || it == 3 })
    }

    @Test
    fun `test array with all elements having same frequency`() {
        // [1,2,3,4,5], k=3 -> 任意三个数字
        val result = topKFrequent(intArrayOf(1, 2, 3, 4, 5), 3)
        assertEquals(3, result.size)
    }

    @Test
    fun `test k equals number of unique elements`() {
        // [1,1,2,2,3,3,4], k=4 -> [1,2,3,4]
        val result = topKFrequent(intArrayOf(1, 1, 2, 2, 3, 3, 4), 4)
        assertEquals(4, result.size)
        assertTrue(result.contains(1))
        assertTrue(result.contains(2))
        assertTrue(result.contains(3))
        assertTrue(result.contains(4))
    }

    @Test
    fun `test array with negative numbers`() {
        // [-1,-1,2,2,2,3], k=2 -> [2,-1]
        val result = topKFrequent(intArrayOf(-1, -1, 2, 2, 2, 3), 2)
        assertEquals(2, result.size)
        assertTrue(result.contains(2))
        assertTrue(result.contains(-1))
    }

    @Test
    fun `test large array`() {
        // 构建一个大数组，每个数字i出现i次
        val largeArray = mutableListOf<Int>()
        for (i in 1..10) {
            repeat(i) { largeArray.add(i) }
        }

        // 获取前3个高频元素，应该是[10,9,8]
        val result = topKFrequent(largeArray.toIntArray(), 3)
        assertEquals(3, result.size)
        assertTrue(result.contains(10))
        assertTrue(result.contains(9))
        assertTrue(result.contains(8))
    }

    private fun assertTrue(condition: Boolean) {
        assertEquals(true, condition)
    }
}
