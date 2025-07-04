package com.only4.algorithm.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LengthOfLongestSubstringTest {

    @Test
    fun `test example 1`() {
        val s = "abcabcbb"
        val expected = 3
        val result = lengthOfLongestSubstring(s)
        assertEquals(expected, result)
    }

    @Test
    fun `test example 2`() {
        val s = "bbbbb"
        val expected = 1
        val result = lengthOfLongestSubstring(s)
        assertEquals(expected, result)
    }

    @Test
    fun `test example 3`() {
        val s = "pwwkew"
        val expected = 3
        val result = lengthOfLongestSubstring(s)
        assertEquals(expected, result)
    }

    @Test
    fun `test empty string`() {
        val s = ""
        val expected = 0
        val result = lengthOfLongestSubstring(s)
        assertEquals(expected, result)
    }

    @Test
    fun `test single character`() {
        val s = "a"
        val expected = 1
        val result = lengthOfLongestSubstring(s)
        assertEquals(expected, result)
    }

    @Test
    fun `test all unique characters`() {
        val s = "abcdefg"
        val expected = 7
        val result = lengthOfLongestSubstring(s)
        assertEquals(expected, result)
    }

    @Test
    fun `test with spaces and special characters`() {
        val s = "ab c!d"
        val expected = 6
        val result = lengthOfLongestSubstring(s)
        assertEquals(expected, result)
    }

    @Test
    fun `test with repeating pattern`() {
        val s = "abcdefgabcdefg"
        val expected = 7
        val result = lengthOfLongestSubstring(s)
        assertEquals(expected, result)
    }

    @Test
    fun `test with repeating characters at start`() {
        val s = "aabcd"
        val expected = 4
        val result = lengthOfLongestSubstring(s)
        assertEquals(expected, result)
    }

    @Test
    fun `test with repeating characters at end`() {
        val s = "abcdd"
        val expected = 4
        val result = lengthOfLongestSubstring(s)
        assertEquals(expected, result)
    }
}
