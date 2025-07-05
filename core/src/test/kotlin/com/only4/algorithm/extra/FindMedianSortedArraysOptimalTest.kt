package com.only4.algorithm.extra

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class FindMedianSortedArraysOptimalTest {

    @Test
    fun `测试正常情况`() {
        // 测试用例1：两个数组长度相等，合并后为偶数长度
        val nums1 = intArrayOf(1, 3)
        val nums2 = intArrayOf(2, 4)
        assertEquals(2.5, findMedianSortedArraysOptimal(nums1, nums2))

        // 测试用例2：两个数组长度不等，合并后为奇数长度
        val nums3 = intArrayOf(1, 3)
        val nums4 = intArrayOf(2)
        assertEquals(2.0, findMedianSortedArraysOptimal(nums3, nums4))

        // 测试用例3：两个数组长度不等，合并后为偶数长度
        val nums5 = intArrayOf(1, 2)
        val nums6 = intArrayOf(3, 4, 5, 6)
        assertEquals(3.5, findMedianSortedArraysOptimal(nums5, nums6))
    }

    @Test
    fun `测试边界情况`() {
        // 测试用例1：一个数组为空，另一个数组长度为奇数
        val nums1 = intArrayOf()
        val nums2 = intArrayOf(1, 2, 3)
        assertEquals(2.0, findMedianSortedArraysOptimal(nums1, nums2))

        // 测试用例2：一个数组为空，另一个数组长度为偶数
        val nums3 = intArrayOf(1, 2, 3, 4)
        val nums4 = intArrayOf()
        assertEquals(2.5, findMedianSortedArraysOptimal(nums3, nums4))

        // 测试用例3：两个数组都只有一个元素
        val nums5 = intArrayOf(1)
        val nums6 = intArrayOf(2)
        assertEquals(1.5, findMedianSortedArraysOptimal(nums5, nums6))
    }

    @Test
    fun `测试特殊情况`() {
        // 测试用例1：两个数组有重叠元素
        val nums1 = intArrayOf(1, 2, 3)
        val nums2 = intArrayOf(2, 3, 4)
        assertEquals(2.5, findMedianSortedArraysOptimal(nums1, nums2))

        // 测试用例2：一个数组的所有元素都小于另一个数组
        val nums3 = intArrayOf(1, 2, 3)
        val nums4 = intArrayOf(4, 5, 6)
        assertEquals(3.5, findMedianSortedArraysOptimal(nums3, nums4))

        // 测试用例3：两个数组完全相同
        val nums5 = intArrayOf(1, 2, 3)
        val nums6 = intArrayOf(1, 2, 3)
        assertEquals(2.0, findMedianSortedArraysOptimal(nums5, nums6))
    }

    @Test
    fun `测试更复杂的情况`() {
        // 测试用例1：较大的数组
        val nums1 = intArrayOf(1, 3, 5, 7, 9, 11, 13, 15, 17, 19)
        val nums2 = intArrayOf(2, 4, 6, 8, 10, 12, 14, 16, 18, 20)
        assertEquals(10.5, findMedianSortedArraysOptimal(nums1, nums2))

        // 测试用例2：不均匀分布的数组
        val nums3 = intArrayOf(1, 10, 100, 1000)
        val nums4 = intArrayOf(2, 20, 200, 2000, 20000)
        assertEquals(100.0, findMedianSortedArraysOptimal(nums3, nums4))

        // 测试用例3：负数元素
        val nums5 = intArrayOf(-5, -3, -1)
        val nums6 = intArrayOf(2, 4, 6)
        assertEquals(0.5, findMedianSortedArraysOptimal(nums5, nums6))
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    fun `参数化测试`(nums1: IntArray, nums2: IntArray, expected: Double) {
        assertEquals(expected, findMedianSortedArraysOptimal(nums1, nums2), 0.00001)
    }

    companion object {
        @JvmStatic
        fun provideTestCases(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(intArrayOf(1, 3), intArrayOf(2), 2.0),
                Arguments.of(intArrayOf(1, 2), intArrayOf(3, 4), 2.5),
                Arguments.of(intArrayOf(), intArrayOf(1), 1.0),
                Arguments.of(intArrayOf(2), intArrayOf(), 2.0),
                Arguments.of(intArrayOf(1, 3, 5, 7), intArrayOf(2, 4, 6, 8), 4.5),
                Arguments.of(intArrayOf(1, 2, 3, 4, 5), intArrayOf(6, 7, 8, 9, 10), 5.5),
                Arguments.of(intArrayOf(1), intArrayOf(1), 1.0),
                Arguments.of(intArrayOf(1, 1, 1), intArrayOf(1, 1, 1), 1.0),
                Arguments.of(intArrayOf(1, 2), intArrayOf(1, 2), 1.5),
                Arguments.of(intArrayOf(1, 3, 5, 7, 9), intArrayOf(2, 4, 6, 8, 10), 5.5),
                Arguments.of(intArrayOf(1, 2, 3, 4), intArrayOf(5, 6, 7, 8, 9, 10), 5.5),
                Arguments.of(intArrayOf(-1, 0, 1), intArrayOf(2, 3, 4), 1.5),
                Arguments.of(intArrayOf(100, 200, 300), intArrayOf(1, 2, 3), 51.5)
            )
        }
    }
}
