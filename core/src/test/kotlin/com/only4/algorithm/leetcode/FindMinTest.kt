package com.only4.algorithm.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class FindMinTest {

    @Test
    fun `测试旋转排序数组中的最小值`() {
        // 测试用例1：标准旋转数组
        val nums1 = intArrayOf(4, 5, 6, 7, 0, 1, 2)
        assertEquals(0, findMin(nums1))

        // 测试用例2：另一个旋转数组
        val nums2 = intArrayOf(3, 4, 5, 1, 2)
        assertEquals(1, findMin(nums2))

        // 测试用例3：完全有序（未旋转）
        val nums3 = intArrayOf(0, 1, 2, 4, 5, 6, 7)
        assertEquals(0, findMin(nums3))

        // 测试用例4：旋转一次（最大值在开头）
        val nums4 = intArrayOf(7, 0, 1, 2, 4, 5, 6)
        assertEquals(0, findMin(nums4))
    }

    @Test
    fun `测试边界情况`() {
        // 测试用例1：空数组
        val nums1 = intArrayOf()
        assertEquals(-1, findMin(nums1))

        // 测试用例2：只有一个元素的数组
        val nums2 = intArrayOf(5)
        assertEquals(5, findMin(nums2))

        // 测试用例3：两个元素的数组，已排序
        val nums3 = intArrayOf(1, 2)
        assertEquals(1, findMin(nums3))

        // 测试用例4：两个元素的数组，已旋转
        val nums4 = intArrayOf(2, 1)
        assertEquals(1, findMin(nums4))
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    fun `参数化测试`(nums: IntArray, expected: Int) {
        assertEquals(expected, findMin(nums))
    }

    companion object {
        @JvmStatic
        fun provideTestCases(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(intArrayOf(4, 5, 6, 7, 0, 1, 2), 0),
                Arguments.of(intArrayOf(3, 4, 5, 1, 2), 1),
                Arguments.of(intArrayOf(11, 13, 15, 17), 11),
                Arguments.of(intArrayOf(), -1),
                Arguments.of(intArrayOf(1), 1),
                Arguments.of(intArrayOf(1, 2), 1),
                Arguments.of(intArrayOf(2, 1), 1),
                Arguments.of(intArrayOf(5, 1, 2, 3, 4), 1),
                Arguments.of(intArrayOf(7, 8, 9, 1, 2, 3, 4, 5, 6), 1),
                Arguments.of(intArrayOf(2, 3, 4, 5, 6, 7, 8, 9, 1), 1)
            )
        }
    }
} 