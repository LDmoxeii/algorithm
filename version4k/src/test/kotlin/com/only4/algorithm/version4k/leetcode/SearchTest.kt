package com.only4.algorithm.version4k.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class SearchTest {

    @Test
    fun `测试目标值存在于旋转数组中`() {
        // 测试用例1：标准旋转数组，目标值在右半部分
        val nums1 = intArrayOf(4, 5, 6, 7, 0, 1, 2)
        val target1 = 0
        assertEquals(4, search(nums1, target1))

        // 测试用例2：标准旋转数组，目标值在左半部分
        val nums2 = intArrayOf(4, 5, 6, 7, 0, 1, 2)
        val target2 = 5
        assertEquals(1, search(nums2, target2))

        // 测试用例3：旋转点在开头（相当于未旋转）
        val nums3 = intArrayOf(0, 1, 2, 4, 5, 6, 7)
        val target3 = 4
        assertEquals(3, search(nums3, target3))

        // 测试用例4：旋转点在末尾（相当于旋转了一个位置）
        val nums4 = intArrayOf(7, 0, 1, 2, 4, 5, 6)
        val target4 = 7
        assertEquals(0, search(nums4, target4))
    }

    @Test
    fun `测试目标值不存在于旋转数组中`() {
        // 测试用例1：目标值小于数组中所有元素
        val nums1 = intArrayOf(4, 5, 6, 7, 0, 1, 2)
        val target1 = -1
        assertEquals(-1, search(nums1, target1))

        // 测试用例2：目标值大于数组中所有元素
        val nums2 = intArrayOf(4, 5, 6, 7, 0, 1, 2)
        val target2 = 8
        assertEquals(-1, search(nums2, target2))

        // 测试用例3：目标值在数组范围内但不存在
        val nums3 = intArrayOf(4, 5, 6, 7, 0, 1, 2)
        val target3 = 3
        assertEquals(-1, search(nums3, target3))
    }

    @Test
    fun `测试边界情况`() {
        // 测试用例1：空数组
        val nums1 = intArrayOf()
        val target1 = 5
        assertEquals(-1, search(nums1, target1))

        // 测试用例2：只有一个元素的数组，目标值等于该元素
        val nums2 = intArrayOf(5)
        val target2 = 5
        assertEquals(0, search(nums2, target2))

        // 测试用例3：只有一个元素的数组，目标值不等于该元素
        val nums3 = intArrayOf(5)
        val target3 = 3
        assertEquals(-1, search(nums3, target3))

        // 测试用例4：两个元素的数组，旋转一次
        val nums4 = intArrayOf(1, 0)
        val target4 = 0
        assertEquals(1, search(nums4, target4))
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    fun `参数化测试`(nums: IntArray, target: Int, expected: Int) {
        assertEquals(expected, search(nums, target))
    }

    companion object {
        @JvmStatic
        fun provideTestCases(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(intArrayOf(4, 5, 6, 7, 0, 1, 2), 0, 4),
                Arguments.of(intArrayOf(4, 5, 6, 7, 0, 1, 2), 3, -1),
                Arguments.of(intArrayOf(), 0, -1),
                Arguments.of(intArrayOf(1), 1, 0),
                Arguments.of(intArrayOf(1), 0, -1),
                Arguments.of(intArrayOf(1, 3), 3, 1),
                Arguments.of(intArrayOf(3, 1), 3, 0),
                Arguments.of(intArrayOf(5, 1, 3), 5, 0),
                Arguments.of(intArrayOf(4, 5, 6, 7, 8, 1, 2, 3), 8, 4),
                Arguments.of(intArrayOf(8, 9, 2, 3, 4), 9, 1)
            )
        }
    }
}
