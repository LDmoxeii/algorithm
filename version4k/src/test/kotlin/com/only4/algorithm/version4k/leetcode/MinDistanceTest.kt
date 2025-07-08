package com.only4.algorithm.version4k.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinDistanceTest {

    /**
     * 测试原始问题描述中的示例
     */
    @Test
    fun `test examples from problem description`() {
        // 示例1: word1 = "horse", word2 = "ros" -> 3
        assertEquals(3, minDistance("horse", "ros"))

        // 示例2: word1 = "intention", word2 = "execution" -> 5
        assertEquals(5, minDistance("intention", "execution"))
    }

    /**
     * 测试边界情况
     */
    @Test
    fun `test edge cases`() {
        // 两个空字符串
        assertEquals(0, minDistance("", ""))

        // 一个空字符串，一个非空字符串
        assertEquals(3, minDistance("", "abc"))
        assertEquals(3, minDistance("abc", ""))

        // 单个字符
        assertEquals(0, minDistance("a", "a"))
        assertEquals(1, minDistance("a", "b"))
    }

    /**
     * 测试完全相同的字符串
     */
    @Test
    fun `test identical strings`() {
        assertEquals(0, minDistance("abc", "abc"))
        assertEquals(0, minDistance("hello", "hello"))
        assertEquals(0, minDistance("algorithm", "algorithm"))
    }

    /**
     * 测试只需要插入操作的情况
     */
    @Test
    fun `test insertion only`() {
        assertEquals(1, minDistance("abc", "abcd"))
        assertEquals(2, minDistance("abc", "abcde"))
        assertEquals(3, minDistance("abc", "abcdef"))
        assertEquals(3, minDistance("a", "abcd"))
    }

    /**
     * 测试只需要删除操作的情况
     */
    @Test
    fun `test deletion only`() {
        assertEquals(1, minDistance("abcd", "abc"))
        assertEquals(2, minDistance("abcde", "abc"))
        assertEquals(3, minDistance("abcdef", "abc"))
        assertEquals(3, minDistance("abcd", "a"))
    }

    /**
     * 测试只需要替换操作的情况
     */
    @Test
    fun `test replacement only`() {
        assertEquals(1, minDistance("abc", "abd"))
        assertEquals(2, minDistance("abc", "aed"))
        assertEquals(3, minDistance("abc", "def"))
    }

    /**
     * 测试需要混合操作的情况
     */
    @Test
    fun `test mixed operations`() {
        // 替换+删除
        assertEquals(1, minDistance("abcd", "abed"))

        // 插入+替换
        assertEquals(2, minDistance("abc", "abde"))

        // 删除+插入
        assertEquals(2, minDistance("abcd", "abef"))

        // 插入+删除+替换
        assertEquals(3, minDistance("abcde", "abfgh"))
    }

    /**
     * 测试较长字符串
     */
    @Test
    fun `test longer strings`() {
        assertEquals(3, minDistance("algorithm", "logarithm"))
        assertEquals(9, minDistance("programming", "development"))
        assertEquals(2, minDistance("distance", "instance"))
        assertEquals(1, minDistance("computer", "commuter"))
    }

    /**
     * 测试完全不同的字符串
     */
    @Test
    fun `test completely different strings`() {
        assertEquals(3, minDistance("abc", "def"))
        assertEquals(4, minDistance("hello", "world"))
        assertEquals(8, minDistance("abcdefgh", "ijklmnop"))
    }

    /**
     * 测试字符串前缀或后缀相同的情况
     */
    @Test
    fun `test strings with same prefix or suffix`() {
        // 相同前缀
        assertEquals(3, minDistance("abcde", "abfgh"))

        // 相同后缀
        assertEquals(2, minDistance("abcde", "fgcde"))

        // 相同前缀和后缀
        assertEquals(1, minDistance("abcde", "abcfe"))
    }

    /**
     * 测试特殊情况：字符串重复模式
     */
    @Test
    fun `test strings with repeating patterns`() {
        assertEquals(1, minDistance("aaaa", "aaa"))
        assertEquals(2, minDistance("ababab", "abab"))
        assertEquals(3, minDistance("abcabcabc", "abcabc"))
    }
}
