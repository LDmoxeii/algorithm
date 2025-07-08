package com.only4.algorithm.version4k.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LengthOfLISTest {

    @Test
    fun `test examples from problem description`() {
        // 示例1: [10,9,2,5,3,7,101,18] -> 4
        assertEquals(4, lengthOfLIS(intArrayOf(10, 9, 2, 5, 3, 7, 101, 18)))
        // 最长递增子序列是 [2,3,7,101]

        // 示例2: [0,1,0,3,2,3] -> 4
        assertEquals(4, lengthOfLIS(intArrayOf(0, 1, 0, 3, 2, 3)))
        // 最长递增子序列是 [0,1,2,3]

        // 示例3: [7,7,7,7,7,7,7] -> 1
        assertEquals(1, lengthOfLIS(intArrayOf(7, 7, 7, 7, 7, 7, 7)))
        // 最长递增子序列是 [7]
    }

    @Test
    fun `test edge cases`() {
        // 空数组
        assertEquals(0, lengthOfLIS(intArrayOf()))

        // 只有一个元素的数组
        assertEquals(1, lengthOfLIS(intArrayOf(5)))

        // 两个元素的数组 - 递增
        assertEquals(2, lengthOfLIS(intArrayOf(1, 2)))

        // 两个元素的数组 - 递减
        assertEquals(1, lengthOfLIS(intArrayOf(2, 1)))

        // 两个元素的数组 - 相等
        assertEquals(1, lengthOfLIS(intArrayOf(1, 1)))
    }

    @Test
    fun `test strictly increasing arrays`() {
        // 严格递增数组
        assertEquals(5, lengthOfLIS(intArrayOf(1, 2, 3, 4, 5)))
        assertEquals(8, lengthOfLIS(intArrayOf(1, 3, 5, 7, 9, 11, 13, 15)))
    }

    @Test
    fun `test strictly decreasing arrays`() {
        // 严格递减数组
        assertEquals(1, lengthOfLIS(intArrayOf(5, 4, 3, 2, 1)))
        assertEquals(1, lengthOfLIS(intArrayOf(15, 13, 11, 9, 7, 5, 3, 1)))
    }

    @Test
    fun `test arrays with repeated elements`() {
        // 包含重复元素的数组
        assertEquals(3, lengthOfLIS(intArrayOf(1, 2, 2, 3)))
        assertEquals(2, lengthOfLIS(intArrayOf(1, 1, 1, 2, 2, 2)))
        assertEquals(6, lengthOfLIS(intArrayOf(1, 2, 3, 3, 4, 5, 6)))
    }

    @Test
    fun `test arrays with non-consecutive increasing elements`() {
        // 非连续递增的数组
        assertEquals(5, lengthOfLIS(intArrayOf(10, 22, 9, 33, 21, 50, 41, 60)))
        // 最长递增子序列是 [10, 22, 33, 50, 60] 或 [10, 22, 33, 41, 60]
        assertEquals(6, lengthOfLIS(intArrayOf(0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15)))
        // 最长递增子序列是 [0, 2, 6, 9, 11, 15] 等多种可能
    }

    @Test
    fun `test arrays with alternating patterns`() {
        // 交替模式的数组
        assertEquals(5, lengthOfLIS(intArrayOf(1, 3, 2, 4, 3, 5, 4, 6)))
        // 可能的最长递增子序列包括 [1, 3, 4, 5, 6] 或 [1, 2, 4, 5, 6] 等
        assertEquals(5, lengthOfLIS(intArrayOf(1, 3, 2, 4, 3, 5, 4, 6)))
    }

    @Test
    fun `test complex cases`() {
        // 复杂情况
        assertEquals(6, lengthOfLIS(intArrayOf(3, 5, 6, 2, 5, 4, 19, 5, 6, 7, 12)))
        // 可能的最长递增子序列包括 [3, 5, 6, 7, 12] 或 [3, 5, 6, 19] 等
        assertEquals(5, lengthOfLIS(intArrayOf(1, 2, 3, 0, 1, 2, 3, 4)))
        // 最长递增子序列是 [0, 1, 2, 3, 4]
    }

    @Test
    fun `test negative numbers`() {
        // 包含负数的数组
        assertEquals(4, lengthOfLIS(intArrayOf(-2, -1, 0, 1)))
        assertEquals(4, lengthOfLIS(intArrayOf(-10, -5, -3, -7, -2, -8)))
        // 最长递增子序列是 [-10, -5, -3] 或 [-10, -7, -2]
    }

    @Test
    fun `test large numbers`() {
        // 包含大数的数组
        assertEquals(5, lengthOfLIS(intArrayOf(1000, 2000, 1500, 3000, 4000, 3500, 5000)))
        // 最长递增子序列是 [1000, 1500, 3000, 3500, 5000]
    }
}
