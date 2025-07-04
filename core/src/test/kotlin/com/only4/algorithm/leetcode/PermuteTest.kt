package com.only4.algorithm.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PermuteTest {

    @Test
    fun testPermute() {
        // 测试用例1: [1,2,3]
        val nums1 = intArrayOf(1, 2, 3)
        val expected1 = listOf(
            listOf(1, 2, 3),
            listOf(1, 3, 2),
            listOf(2, 1, 3),
            listOf(2, 3, 1),
            listOf(3, 1, 2),
            listOf(3, 2, 1)
        )
        val result1 = permute(nums1)
        assertEquals(expected1.size, result1.size)
        for (perm in expected1) {
            assert(result1.contains(perm)) { "结果中应包含排列 $perm" }
        }

        // 测试用例2: [0,1]
        val nums2 = intArrayOf(0, 1)
        val expected2 = listOf(
            listOf(0, 1),
            listOf(1, 0)
        )
        val result2 = permute(nums2)
        assertEquals(expected2.size, result2.size)
        for (perm in expected2) {
            assert(result2.contains(perm)) { "结果中应包含排列 $perm" }
        }

        // 测试用例3: [1]
        val nums3 = intArrayOf(1)
        val expected3 = listOf(
            listOf(1)
        )
        val result3 = permute(nums3)
        assertEquals(expected3, result3)
    }
}
