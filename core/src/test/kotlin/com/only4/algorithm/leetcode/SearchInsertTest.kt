package com.only4.algorithm.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class SearchInsertTest {

    @Test
    fun `测试目标值存在于数组中`() {
        // 测试用例1：目标值在数组中间
        val nums1 = intArrayOf(1, 3, 5, 6)
        val target1 = 5
        assertEquals(2, searchInsert(nums1, target1))

        // 测试用例2：目标值在数组开头
        val nums2 = intArrayOf(1, 3, 5, 6)
        val target2 = 1
        assertEquals(0, searchInsert(nums2, target2))

        // 测试用例3：目标值在数组末尾
        val nums3 = intArrayOf(1, 3, 5, 6)
        val target3 = 6
        assertEquals(3, searchInsert(nums3, target3))
    }

    @Test
    fun `测试目标值不存在于数组中`() {
        // 测试用例1：目标值应插入到数组中间
        val nums1 = intArrayOf(1, 3, 5, 6)
        val target1 = 2
        assertEquals(1, searchInsert(nums1, target1))

        // 测试用例2：目标值应插入到数组开头
        val nums2 = intArrayOf(1, 3, 5, 6)
        val target2 = 0
        assertEquals(0, searchInsert(nums2, target2))

        // 测试用例3：目标值应插入到数组末尾
        val nums3 = intArrayOf(1, 3, 5, 6)
        val target3 = 7
        assertEquals(4, searchInsert(nums3, target3))
    }

    @Test
    fun `测试边界情况`() {
        // 测试用例1：空数组
        val nums1 = intArrayOf()
        val target1 = 5
        assertEquals(0, searchInsert(nums1, target1))

        // 测试用例2：只有一个元素的数组，目标值小于该元素
        val nums2 = intArrayOf(3)
        val target2 = 1
        assertEquals(0, searchInsert(nums2, target2))

        // 测试用例3：只有一个元素的数组，目标值等于该元素
        val nums3 = intArrayOf(3)
        val target3 = 3
        assertEquals(0, searchInsert(nums3, target3))

        // 测试用例4：只有一个元素的数组，目标值大于该元素
        val nums4 = intArrayOf(3)
        val target4 = 5
        assertEquals(1, searchInsert(nums4, target4))
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    fun `参数化测试`(nums: IntArray, target: Int, expected: Int) {
        assertEquals(expected, searchInsert(nums, target))
    }

    companion object {
        @JvmStatic
        fun provideTestCases(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(intArrayOf(1, 3, 5, 6), 5, 2),
                Arguments.of(intArrayOf(1, 3, 5, 6), 2, 1),
                Arguments.of(intArrayOf(1, 3, 5, 6), 7, 4),
                Arguments.of(intArrayOf(1, 3, 5, 6), 0, 0),
                Arguments.of(intArrayOf(1), 0, 0),
                Arguments.of(intArrayOf(1), 1, 0),
                Arguments.of(intArrayOf(1), 2, 1),
                Arguments.of(intArrayOf(), 1, 0),
                Arguments.of(intArrayOf(1, 3, 5, 7, 9), 8, 4),
                Arguments.of(intArrayOf(1, 3, 5, 7, 9), 6, 3)
            )
        }
    }
} 