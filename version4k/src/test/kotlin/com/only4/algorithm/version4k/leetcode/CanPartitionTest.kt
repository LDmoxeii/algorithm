package com.only4.algorithm.version4k.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CanPartitionTest {

    @Test
    fun `test examples from problem description`() {
        // 示例1: [1,5,11,5] -> true
        assertEquals(true, canPartition(intArrayOf(1, 5, 11, 5)))
        // 可以分割成 [1, 5, 5] 和 [11]

        // 示例2: [1,2,3,5] -> false
        assertEquals(false, canPartition(intArrayOf(1, 2, 3, 5)))
        // 不能分割成两个元素和相等的子集
    }

    @Test
    fun `test edge cases`() {
        // 只有两个元素的数组，可以平分
        assertEquals(true, canPartition(intArrayOf(1, 1)))
        assertEquals(true, canPartition(intArrayOf(3, 3)))

        // 只有两个元素的数组，不能平分
        assertEquals(false, canPartition(intArrayOf(1, 2)))

        // 单个元素的数组，不可能平分（和必为奇数）
        assertEquals(false, canPartition(intArrayOf(1)))
        assertEquals(false, canPartition(intArrayOf(100)))
    }

    @Test
    fun `test arrays with equal elements`() {
        // 所有元素相等且为偶数个
        assertEquals(true, canPartition(intArrayOf(1, 1, 1, 1)))
        assertEquals(true, canPartition(intArrayOf(5, 5, 5, 5, 5, 5)))

        // 所有元素相等且为奇数个
        assertEquals(false, canPartition(intArrayOf(1, 1, 1)))
        assertEquals(false, canPartition(intArrayOf(5, 5, 5)))
    }

    @Test
    fun `test arrays with one large element`() {
        // 一个元素大于等于数组和的一半
        assertEquals(true, canPartition(intArrayOf(10, 10)))
        assertEquals(false, canPartition(intArrayOf(11, 10)))
        assertEquals(true, canPartition(intArrayOf(5, 1, 1, 1, 2)))
        assertEquals(false, canPartition(intArrayOf(6, 1, 1, 1, 2)))
    }

    @Test
    fun `test larger arrays`() {
        // 较大的数组，可以平分
        assertEquals(true, canPartition(intArrayOf(1, 2, 3, 4, 5, 5)))
        assertEquals(true, canPartition(intArrayOf(3, 3, 3, 4, 5)))
        assertEquals(true, canPartition(intArrayOf(1, 1, 1, 1, 2, 2, 2, 2)))

        // 较大的数组，不能平分
        assertEquals(false, canPartition(intArrayOf(1, 2, 3, 4, 5, 6)))
        assertEquals(true, canPartition(intArrayOf(1, 2, 5, 8)))
    }

    @Test
    fun `test complex cases`() {
        // 复杂情况，可以平分
        assertEquals(true, canPartition(intArrayOf(1, 5, 11, 5)))
        assertEquals(true, canPartition(intArrayOf(1, 2, 3, 4, 5, 5)))
        assertEquals(true, canPartition(intArrayOf(14, 9, 8, 4, 3, 2)))

        // 复杂情况，不能平分
        assertEquals(false, canPartition(intArrayOf(1, 2, 3, 4, 5)))
        assertEquals(false, canPartition(intArrayOf(1, 2, 3, 5)))
        assertEquals(false, canPartition(intArrayOf(100, 1, 2, 3, 4, 5, 6, 7)))
    }

    @Test
    fun `test large numbers`() {
        // 较大的数字
        assertEquals(true, canPartition(intArrayOf(100, 100)))
        assertEquals(true, canPartition(intArrayOf(100, 50, 50)))
        assertEquals(true, canPartition(intArrayOf(100, 98, 2)))
        assertEquals(false, canPartition(intArrayOf(100, 99)))
    }
}
