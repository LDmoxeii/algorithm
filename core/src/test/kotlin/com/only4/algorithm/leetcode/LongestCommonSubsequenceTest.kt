package com.only4.algorithm.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LongestCommonSubsequenceTest {

    /**
     * 测试原始问题描述中的示例
     */
    @Test
    fun `test examples from problem description`() {
        // 示例1: text1 = "abcde", text2 = "ace" -> 3
        assertEquals(3, longestCommonSubsequence("abcde", "ace"))

        // 示例2: text1 = "abc", text2 = "abc" -> 3
        assertEquals(3, longestCommonSubsequence("abc", "abc"))

        // 示例3: text1 = "abc", text2 = "def" -> 0
        assertEquals(0, longestCommonSubsequence("abc", "def"))
    }

    /**
     * 测试边界情况
     */
    @Test
    fun `test edge cases`() {
        // 两个空字符串
        assertEquals(0, longestCommonSubsequence("", ""))

        // 一个空字符串，一个非空字符串
        assertEquals(0, longestCommonSubsequence("", "abc"))
        assertEquals(0, longestCommonSubsequence("abc", ""))

        // 单个字符
        assertEquals(1, longestCommonSubsequence("a", "a"))
        assertEquals(0, longestCommonSubsequence("a", "b"))
    }

    /**
     * 测试完全相同的字符串
     */
    @Test
    fun `test identical strings`() {
        assertEquals(3, longestCommonSubsequence("abc", "abc"))
        assertEquals(5, longestCommonSubsequence("hello", "hello"))
        assertEquals(9, longestCommonSubsequence("algorithm", "algorithm"))
    }

    /**
     * 测试一个字符串是另一个字符串的子序列
     */
    @Test
    fun `test one string is subsequence of another`() {
        // text1是text2的子序列
        assertEquals(3, longestCommonSubsequence("abc", "axbycz"))
        assertEquals(5, longestCommonSubsequence("hello", "hweflflxo"))

        // text2是text1的子序列
        assertEquals(3, longestCommonSubsequence("axbycz", "abc"))
        assertEquals(5, longestCommonSubsequence("hweflflxo", "hello"))
    }

    /**
     * 测试有多个可能的最长公共子序列
     */
    @Test
    fun `test multiple possible LCS`() {
        // "ac", "bc", "ab" 都是可能的LCS，长度为2
        assertEquals(2, longestCommonSubsequence("abc", "bac"))

        // "acd", "ace" 都是可能的LCS，长度为3
        assertEquals(4, longestCommonSubsequence("abcde", "acdef"))
    }

    /**
     * 测试较长字符串
     */
    @Test
    fun `test longer strings`() {
        assertEquals(7, longestCommonSubsequence("algorithm", "logarithm"))
        assertEquals(3, longestCommonSubsequence("programming", "development"))
        assertEquals(7, longestCommonSubsequence("distance", "instance"))
        assertEquals(7, longestCommonSubsequence("computer", "commuter"))
    }

    /**
     * 测试重复字符的情况
     */
    @Test
    fun `test strings with repeated characters`() {
        assertEquals(3, longestCommonSubsequence("aaaa", "aaa"))
        assertEquals(4, longestCommonSubsequence("ababab", "abab"))
        assertEquals(6, longestCommonSubsequence("abcabcabc", "abcabc"))
    }

    /**
     * 测试特殊情况：字符串交错
     */
    @Test
    fun `test interleaved strings`() {
        assertEquals(4, longestCommonSubsequence("abcdef", "acef"))
        assertEquals(4, longestCommonSubsequence("abcdefgh", "bdeg"))
    }

    /**
     * 测试特殊情况：字符串逆序
     */
    @Test
    fun `test reversed strings`() {
        assertEquals(1, longestCommonSubsequence("abc", "cba"))
        assertEquals(2, longestCommonSubsequence("hello", "olleh"))
    }

    /**
     * 测试特殊情况：字符串部分重叠
     */
    @Test
    fun `test partially overlapping strings`() {
        assertEquals(3, longestCommonSubsequence("abcdef", "defghi"))
        assertEquals(2, longestCommonSubsequence("hello", "low"))
    }
}
