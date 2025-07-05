package com.only4.algorithm.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PartitionLabelsTest {

    @Test
    fun `test example from problem description`() {
        // 示例: "ababcbacadefegdehijhklij" -> [9,7,8]
        val input = "ababcbacadefegdehijhklij"
        val expected = listOf(9, 7, 8)
        assertEquals(expected, partitionLabels(input))
    }

    @Test
    fun `test empty string`() {
        // 空字符串应该返回空列表
        assertEquals(emptyList<Int>(), partitionLabels(""))
    }

    @Test
    fun `test single character`() {
        // 单个字符应该返回包含1的列表
        assertEquals(listOf(1), partitionLabels("a"))
    }

    @Test
    fun `test all same characters`() {
        // 所有相同字符应该返回包含字符串长度的列表
        assertEquals(listOf(5), partitionLabels("aaaaa"))
    }

    @Test
    fun `test all different characters`() {
        // 所有不同字符应该返回包含所有1的列表
        assertEquals(listOf(1, 1, 1, 1, 1), partitionLabels("abcde"))
    }

    @Test
    fun `test alternating characters`() {
        // 交替出现的字符应该被分组在一起
        assertEquals(listOf(4), partitionLabels("abab"))
    }

    @Test
    fun `test complex case`() {
        // 复杂情况：多个不同的片段
        assertEquals(listOf(8, 4), partitionLabels("abccaddbeffe"))
    }

    @Test
    fun `test characters with large gaps`() {
        // 字符间有较大间隔的情况
        assertEquals(listOf(10), partitionLabels("abcdefgabc"))
    }

    @Test
    fun `test characters appearing only once`() {
        // 每个字符只出现一次的情况
        val input = "xyzabcdefg"
        val result = partitionLabels(input)
        // 验证结果列表中所有元素之和等于字符串长度
        assertEquals(input.length, result.sum())
    }
}
