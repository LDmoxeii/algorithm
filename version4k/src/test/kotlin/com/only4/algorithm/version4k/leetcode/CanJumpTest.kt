package com.only4.algorithm.version4k.leetcode

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class CanJumpTest {

    @Test
    fun `test example from problem description`() {
        // 示例1: [2,3,1,1,4] -> true
        assertTrue(canJump(intArrayOf(2, 3, 1, 1, 4)))

        // 示例2: [3,2,1,0,4] -> false
        assertFalse(canJump(intArrayOf(3, 2, 1, 0, 4)))
    }

    @Test
    fun `test single element array`() {
        // 单个元素的数组总是可以到达最后一个位置
        assertTrue(canJump(intArrayOf(0)))
        assertTrue(canJump(intArrayOf(1)))
        assertTrue(canJump(intArrayOf(5)))
    }

    @Test
    fun `test array with all zeros except first element`() {
        // [1,0,0,0] -> false (只能跳到索引1)
        assertFalse(canJump(intArrayOf(1, 0, 0, 0)))

        // [2,0,0,0] -> false (只能跳到索引2)
        assertFalse(canJump(intArrayOf(2, 0, 0, 0)))

        // [3,0,0,0] -> true (可以跳到索引3)
        assertTrue(canJump(intArrayOf(3, 0, 0, 0)))

        // [4,0,0,0] -> true (可以跳到索引3)
        assertTrue(canJump(intArrayOf(4, 0, 0, 0)))
    }

    @Test
    fun `test array with zeros in middle`() {
        // [2,0,1,0] -> true (可以从索引0直接跳到索引2)
        assertTrue(canJump(intArrayOf(2, 0, 1, 0)))

        // [2,0,0,1] -> false (跳到索引1或索引2后都无法继续)
        assertFalse(canJump(intArrayOf(2, 0, 0, 1)))

        // [3,0,0,1] -> true (可以从索引0直接跳到索引3)
        assertTrue(canJump(intArrayOf(3, 0, 0, 1)))
    }

    @Test
    fun `test array with large jumps`() {
        // [5,9,3,2,1,0,2,3,3,1,0,0] -> true
        assertTrue(canJump(intArrayOf(5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0)))
    }

    @Test
    fun `test array with exact jumps to reach end`() {
        // [1,1,1,1] -> true (每次只能跳1步，但可以到达终点)
        assertTrue(canJump(intArrayOf(1, 1, 1, 1)))
    }

    @Test
    fun `test array with zero at beginning`() {
        // [0,2,3] -> false (无法离开起点)
        assertFalse(canJump(intArrayOf(0, 2, 3)))
    }

    @Test
    fun `test edge cases`() {
        // 空数组 (这种情况在实际中不应该出现，因为题目约束数组长度至少为1)
        assertTrue(canJump(intArrayOf()))
    }
}
