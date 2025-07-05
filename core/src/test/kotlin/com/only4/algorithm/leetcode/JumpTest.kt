package com.only4.algorithm.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class JumpTest {

    @Test
    fun `test example from problem description`() {
        // 示例1: [2,3,1,1,4] -> 2
        assertEquals(2, jump(intArrayOf(2, 3, 1, 1, 4)))

        // 示例2: [2,3,0,1,4] -> 2
        assertEquals(2, jump(intArrayOf(2, 3, 0, 1, 4)))
    }

    @Test
    fun `test single element array`() {
        // 单个元素的数组不需要跳跃
        assertEquals(0, jump(intArrayOf(0)))
        assertEquals(0, jump(intArrayOf(1)))
        assertEquals(0, jump(intArrayOf(5)))
    }

    @Test
    fun `test array with all ones`() {
        // [1,1,1,1,1] -> 4 (每次只能跳1步)
        assertEquals(4, jump(intArrayOf(1, 1, 1, 1, 1)))
    }

    @Test
    fun `test array with large first element`() {
        // [5,1,1,1,1] -> 1 (可以一次跳到终点)
        assertEquals(1, jump(intArrayOf(5, 1, 1, 1, 1)))
    }

    @Test
    fun `test array with increasing elements`() {
        // [1,2,3,4,5] -> 3 (需要跳3次: 0->1->3->4)
        assertEquals(3, jump(intArrayOf(1, 2, 3, 4, 5)))
    }

    @Test
    fun `test array with decreasing elements`() {
        // [5,4,3,2,1] -> 1 (可以一次跳到终点)
        assertEquals(1, jump(intArrayOf(5, 4, 3, 2, 1)))
    }

    @Test
    fun `test array with zeros`() {
        // [2,0,0,0,1] -> 2 (需要跳2次: 0->2->4)
        assertEquals(2, jump(intArrayOf(2, 0, 0, 0, 1)))
    }

    @Test
    fun `test large array`() {
        // 构建一个大数组，每个位置可以跳到下一个位置
        val largeArray = IntArray(1000) { 1 }
        assertEquals(999, jump(largeArray))

        // 构建一个大数组，第一个位置可以直接跳到终点
        val largeArray2 = IntArray(1000) { 1 }
        largeArray2[0] = 999
        assertEquals(1, jump(largeArray2))
    }
}
