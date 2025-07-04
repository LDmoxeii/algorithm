package com.only4.algorithm.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindAnagramsTest {

    @Test
    fun `test example 1`() {
        val s = "cbaebabacd"
        val p = "abc"
        val expected = listOf(0, 6)
        val result = findAnagrams(s, p)
        assertEquals(expected, result)
    }

    @Test
    fun `test example 2`() {
        val s = "abab"
        val p = "ab"
        val expected = listOf(0, 1, 2)
        val result = findAnagrams(s, p)
        assertEquals(expected, result)
    }

    @Test
    fun `test empty string`() {
        val s = ""
        val p = "abc"
        val expected = emptyList<Int>()
        val result = findAnagrams(s, p)
        assertEquals(expected, result)
    }

    @Test
    fun `test p longer than s`() {
        val s = "ab"
        val p = "abc"
        val expected = emptyList<Int>()
        val result = findAnagrams(s, p)
        assertEquals(expected, result)
    }

    @Test
    fun `test with repeated characters`() {
        val s = "aabaa"
        val p = "aa"
        val expected = listOf(0, 3)
        val result = findAnagrams(s, p)
        assertEquals(expected, result)
    }

    @Test
    fun `test with no anagrams`() {
        val s = "hello"
        val p = "world"
        val expected = emptyList<Int>()
        val result = findAnagrams(s, p)
        assertEquals(expected, result)
    }
}
