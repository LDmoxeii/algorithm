package com.only4.algorithm.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindKthLargestTest {

    @Test
    fun `test examples from problem description`() {
        // 示例1: [3,2,1,5,6,4], k=2 -> 5
        assertEquals(5, findKthLargest(intArrayOf(3, 2, 1, 5, 6, 4), 2))

        // 示例2: [3,2,3,1,2,4,5,5,6], k=4 -> 4
        assertEquals(4, findKthLargest(intArrayOf(3, 2, 3, 1, 2, 4, 5, 5, 6), 4))
    }

    @Test
    fun `test sorted array`() {
        // 升序数组: [1,2,3,4,5], k=2 -> 4
        assertEquals(4, findKthLargest(intArrayOf(1, 2, 3, 4, 5), 2))

        // 降序数组: [5,4,3,2,1], k=3 -> 3
        assertEquals(3, findKthLargest(intArrayOf(5, 4, 3, 2, 1), 3))
    }

    @Test
    fun `test array with duplicates`() {
        // 包含重复元素: [3,3,3,3,3], k=1 -> 3
        assertEquals(3, findKthLargest(intArrayOf(3, 3, 3, 3, 3), 1))

        // 包含重复元素: [1,1,2,2,3,3], k=3 -> 2
        assertEquals(2, findKthLargest(intArrayOf(1, 1, 2, 2, 3, 3), 3))
    }

    @Test
    fun `test single element array`() {
        // 单元素数组: [42], k=1 -> 42
        assertEquals(42, findKthLargest(intArrayOf(42), 1))
    }

    @Test
    fun `test edge cases`() {
        // k=1（最大元素）: [5,3,1,4,2], k=1 -> 5
        assertEquals(5, findKthLargest(intArrayOf(5, 3, 1, 4, 2), 1))

        // k=数组长度（最小元素）: [5,3,1,4,2], k=5 -> 1
        assertEquals(1, findKthLargest(intArrayOf(5, 3, 1, 4, 2), 5))
    }

    @Test
    fun `test large array`() {
        // 大数组: [1..100], k=50 -> 51
        val largeArray = IntArray(100) { it + 1 }
        assertEquals(51, findKthLargest(largeArray, 50))
    }

    @Test
    fun `test negative numbers`() {
        // 包含负数: [-1,-2,0,3,5], k=2 -> 3
        assertEquals(3, findKthLargest(intArrayOf(-1, -2, 0, 3, 5), 2))
    }
}
