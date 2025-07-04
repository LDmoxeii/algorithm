package com.only4.algorithm.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinWindowTest {

    @Test
    fun `test example 1`() {
        val s = "ADOBECODEBANC"
        val t = "ABC"
        val expected = "BANC"
        val result = minWindow(s, t)
        assertEquals(expected, result)
    }

    @Test
    fun `test example 2`() {
        val s = "a"
        val t = "a"
        val expected = "a"
        val result = minWindow(s, t)
        assertEquals(expected, result)
    }

    @Test
    fun `test example 3`() {
        val s = "a"
        val t = "aa"
        val expected = ""
        val result = minWindow(s, t)
        assertEquals(expected, result)
    }

    @Test
    fun `test with empty strings`() {
        val s = ""
        val t = ""
        val expected = ""
        val result = minWindow(s, t)
        assertEquals(expected, result)
    }

    @Test
    fun `test with empty target string`() {
        val s = "abc"
        val t = ""
        val expected = ""
        val result = minWindow(s, t)
        assertEquals(expected, result)
    }

    @Test
    fun `test with empty source string`() {
        val s = ""
        val t = "abc"
        val expected = ""
        val result = minWindow(s, t)
        assertEquals(expected, result)
    }

    @Test
    fun `test with repeated characters in target`() {
        val s = "ADOBECODEBANC"
        val t = "AABC"
        val expected = "ADOBECODEBA"
        val result = minWindow(s, t)
        assertEquals(expected, result)
    }

    @Test
    fun `test with all characters same`() {
        val s = "aaaaaaa"
        val t = "aaa"
        val expected = "aaa"
        val result = minWindow(s, t)
        assertEquals(expected, result)
    }
} 