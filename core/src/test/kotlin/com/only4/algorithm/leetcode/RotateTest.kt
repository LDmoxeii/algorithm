package com.only4.algorithm.leetcode

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class RotateTest {

    @Nested
    @DisplayName("轮转数组测试")
    inner class RotateArrayTest {
        @Test
        fun `rotate empty array`() {
            val nums = intArrayOf()
            rotate(nums, 3)
            assertArrayEquals(intArrayOf(), nums)
        }

        @Test
        fun `rotate array with k equals 0`() {
            val nums = intArrayOf(1, 2, 3, 4, 5, 6, 7)
            rotate(nums, 0)
            assertArrayEquals(intArrayOf(1, 2, 3, 4, 5, 6, 7), nums)
        }

        @Test
        fun `rotate array with k less than array length`() {
            val nums = intArrayOf(1, 2, 3, 4, 5, 6, 7)
            rotate(nums, 3)
            assertArrayEquals(intArrayOf(5, 6, 7, 1, 2, 3, 4), nums)
        }

        @Test
        fun `rotate array with k equals array length`() {
            val nums = intArrayOf(1, 2, 3, 4, 5, 6, 7)
            rotate(nums, 7)
            assertArrayEquals(intArrayOf(1, 2, 3, 4, 5, 6, 7), nums)
        }

        @Test
        fun `rotate array with k greater than array length`() {
            val nums = intArrayOf(1, 2, 3, 4, 5, 6, 7)
            rotate(nums, 10)
            assertArrayEquals(intArrayOf(5, 6, 7, 1, 2, 3, 4), nums)
        }
    }

    @Nested
    @DisplayName("旋转图像测试")
    inner class RotateImageTest {
        @Test
        fun `rotate empty matrix`() {
            val matrix = arrayOf<IntArray>()
            rotate(matrix)
            assertArrayEquals(arrayOf<IntArray>(), matrix)
        }

        @Test
        fun `rotate 1x1 matrix`() {
            val matrix = arrayOf(intArrayOf(1))
            rotate(matrix)
            assertArrayEquals(arrayOf(intArrayOf(1)), matrix)
        }

        @Test
        fun `rotate 2x2 matrix`() {
            val matrix = arrayOf(
                intArrayOf(1, 2),
                intArrayOf(3, 4)
            )
            rotate(matrix)
            assertArrayEquals(
                arrayOf(
                    intArrayOf(3, 1),
                    intArrayOf(4, 2)
                ),
                matrix
            )
        }

        @Test
        fun `rotate 3x3 matrix`() {
            val matrix = arrayOf(
                intArrayOf(1, 2, 3),
                intArrayOf(4, 5, 6),
                intArrayOf(7, 8, 9)
            )
            rotate(matrix)
            assertArrayEquals(
                arrayOf(
                    intArrayOf(7, 4, 1),
                    intArrayOf(8, 5, 2),
                    intArrayOf(9, 6, 3)
                ),
                matrix
            )
        }

        @Test
        fun `rotate 4x4 matrix`() {
            val matrix = arrayOf(
                intArrayOf(5, 1, 9, 11),
                intArrayOf(2, 4, 8, 10),
                intArrayOf(13, 3, 6, 7),
                intArrayOf(15, 14, 12, 16)
            )
            rotate(matrix)
            assertArrayEquals(
                arrayOf(
                    intArrayOf(15, 13, 2, 5),
                    intArrayOf(14, 3, 4, 1),
                    intArrayOf(12, 6, 8, 9),
                    intArrayOf(16, 7, 10, 11)
                ),
                matrix
            )
        }
    }
} 