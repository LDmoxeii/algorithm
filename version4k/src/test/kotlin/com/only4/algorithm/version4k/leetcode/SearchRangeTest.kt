package com.only4.algorithm.version4k.leetcode

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class SearchRangeTest {

    @Test
    fun `测试目标值存在于数组中`() {
        // 测试用例1：目标值在数组中有多个连续的元素
        val nums1 = intArrayOf(5, 7, 7, 8, 8, 10)
        val target1 = 8
        assertArrayEquals(intArrayOf(3, 4), searchRange(nums1, target1))

        // 测试用例2：目标值在数组中只有一个元素
        val nums2 = intArrayOf(5, 7, 7, 8, 10)
        val target2 = 8
        assertArrayEquals(intArrayOf(3, 3), searchRange(nums2, target2))

        // 测试用例3：目标值在数组开头
        val nums3 = intArrayOf(8, 8, 8, 10, 12)
        val target3 = 8
        assertArrayEquals(intArrayOf(0, 2), searchRange(nums3, target3))

        // 测试用例4：目标值在数组末尾
        val nums4 = intArrayOf(1, 2, 3, 8, 8)
        val target4 = 8
        assertArrayEquals(intArrayOf(3, 4), searchRange(nums4, target4))
    }

    @Test
    fun `测试目标值不存在于数组中`() {
        // 测试用例1：目标值小于数组中所有元素
        val nums1 = intArrayOf(5, 7, 7, 8, 8, 10)
        val target1 = 4
        assertArrayEquals(intArrayOf(-1, -1), searchRange(nums1, target1))

        // 测试用例2：目标值大于数组中所有元素
        val nums2 = intArrayOf(5, 7, 7, 8, 8, 10)
        val target2 = 12
        assertArrayEquals(intArrayOf(-1, -1), searchRange(nums2, target2))

        // 测试用例3：目标值在数组范围内但不存在
        val nums3 = intArrayOf(5, 7, 7, 8, 8, 10)
        val target3 = 6
        assertArrayEquals(intArrayOf(-1, -1), searchRange(nums3, target3))
    }

    @Test
    fun `测试边界情况`() {
        // 测试用例1：空数组
        val nums1 = intArrayOf()
        val target1 = 8
        assertArrayEquals(intArrayOf(-1, -1), searchRange(nums1, target1))

        // 测试用例2：只有一个元素的数组，目标值等于该元素
        val nums2 = intArrayOf(8)
        val target2 = 8
        assertArrayEquals(intArrayOf(0, 0), searchRange(nums2, target2))

        // 测试用例3：只有一个元素的数组，目标值不等于该元素
        val nums3 = intArrayOf(8)
        val target3 = 9
        assertArrayEquals(intArrayOf(-1, -1), searchRange(nums3, target3))

        // 测试用例4：所有元素都相同且等于目标值
        val nums4 = intArrayOf(8, 8, 8, 8, 8)
        val target4 = 8
        assertArrayEquals(intArrayOf(0, 4), searchRange(nums4, target4))
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    fun `参数化测试`(nums: IntArray, target: Int, expected: IntArray) {
        assertArrayEquals(expected, searchRange(nums, target))
    }

    companion object {
        @JvmStatic
        fun provideTestCases(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(intArrayOf(5, 7, 7, 8, 8, 10), 8, intArrayOf(3, 4)),
                Arguments.of(intArrayOf(5, 7, 7, 8, 8, 10), 6, intArrayOf(-1, -1)),
                Arguments.of(intArrayOf(), 0, intArrayOf(-1, -1)),
                Arguments.of(intArrayOf(1), 1, intArrayOf(0, 0)),
                Arguments.of(intArrayOf(1, 1, 1, 1, 1), 1, intArrayOf(0, 4)),
                Arguments.of(intArrayOf(1, 2, 3, 3, 3, 4, 5), 3, intArrayOf(2, 4)),
                Arguments.of(intArrayOf(1, 2, 3, 4, 5), 6, intArrayOf(-1, -1)),
                Arguments.of(intArrayOf(1, 2, 3, 4, 5), 0, intArrayOf(-1, -1)),
                Arguments.of(intArrayOf(1, 2, 2, 2, 3, 4, 5, 5, 5, 5), 5, intArrayOf(6, 9)),
                Arguments.of(intArrayOf(5, 5, 5, 5, 5), 5, intArrayOf(0, 4))
            )
        }
    }
}
