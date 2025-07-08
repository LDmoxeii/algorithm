package com.only4.algorithm.version4k.leetcode

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class MergeTest {

    @Test
    fun `test example 1`() {
        val intervals = arrayOf(
            intArrayOf(1, 3),
            intArrayOf(2, 6),
            intArrayOf(8, 10),
            intArrayOf(15, 18)
        )
        val expected = arrayOf(
            intArrayOf(1, 6),
            intArrayOf(8, 10),
            intArrayOf(15, 18)
        )
        val result = merge(intervals)
        assertArrayEquals(
            expected.map { it.toTypedArray() }.toTypedArray(),
            result.map { it.toTypedArray() }.toTypedArray()
        )
    }

    @Test
    fun `test example 2`() {
        val intervals = arrayOf(
            intArrayOf(1, 4),
            intArrayOf(4, 5)
        )
        val expected = arrayOf(
            intArrayOf(1, 5)
        )
        val result = merge(intervals)
        assertArrayEquals(
            expected.map { it.toTypedArray() }.toTypedArray(),
            result.map { it.toTypedArray() }.toTypedArray()
        )
    }

    @Test
    fun `test with empty array`() {
        val intervals = emptyArray<IntArray>()
        val expected = emptyArray<IntArray>()
        val result = merge(intervals)
        assertArrayEquals(
            expected.map { it.toTypedArray() }.toTypedArray(),
            result.map { it.toTypedArray() }.toTypedArray()
        )
    }

    @Test
    fun `test with single interval`() {
        val intervals = arrayOf(
            intArrayOf(1, 5)
        )
        val expected = arrayOf(
            intArrayOf(1, 5)
        )
        val result = merge(intervals)
        assertArrayEquals(
            expected.map { it.toTypedArray() }.toTypedArray(),
            result.map { it.toTypedArray() }.toTypedArray()
        )
    }

    @Test
    fun `test with non-overlapping intervals`() {
        val intervals = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(3, 4),
            intArrayOf(5, 6)
        )
        val expected = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(3, 4),
            intArrayOf(5, 6)
        )
        val result = merge(intervals)
        assertArrayEquals(
            expected.map { it.toTypedArray() }.toTypedArray(),
            result.map { it.toTypedArray() }.toTypedArray()
        )
    }

    @Test
    fun `test with all overlapping intervals`() {
        val intervals = arrayOf(
            intArrayOf(1, 10),
            intArrayOf(2, 9),
            intArrayOf(3, 8),
            intArrayOf(4, 7)
        )
        val expected = arrayOf(
            intArrayOf(1, 10)
        )
        val result = merge(intervals)
        assertArrayEquals(
            expected.map { it.toTypedArray() }.toTypedArray(),
            result.map { it.toTypedArray() }.toTypedArray()
        )
    }

    @Test
    fun `test with unsorted intervals`() {
        val intervals = arrayOf(
            intArrayOf(3, 6),
            intArrayOf(1, 3),
            intArrayOf(8, 10),
            intArrayOf(15, 18)
        )
        val expected = arrayOf(
            intArrayOf(1, 6),
            intArrayOf(8, 10),
            intArrayOf(15, 18)
        )
        val result = merge(intervals)
        assertArrayEquals(
            expected.map { it.toTypedArray() }.toTypedArray(),
            result.map { it.toTypedArray() }.toTypedArray()
        )
    }
}
