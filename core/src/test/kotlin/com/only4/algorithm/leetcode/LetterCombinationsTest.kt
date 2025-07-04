package com.only4.algorithm.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class LetterCombinationsTest {

    @Test
    fun `test empty input`() {
        val digits = ""
        val result = letterCombinations(digits)

        assertTrue(result.isEmpty())
    }

    @Test
    fun `test single digit`() {
        val digits = "2"
        val result = letterCombinations(digits)

        assertEquals(3, result.size)
        assertTrue(result.containsAll(listOf("a", "b", "c")))
    }

    @Test
    fun `test two digits`() {
        val digits = "23"
        val result = letterCombinations(digits)

        assertEquals(9, result.size)
        val expected = listOf("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf")
        assertTrue(result.containsAll(expected))
    }

    @Test
    fun `test three digits`() {
        val digits = "234"
        val result = letterCombinations(digits)

        assertEquals(27, result.size) // 3 * 3 * 3 = 27

        // 检查几个随机组合是否存在
        assertTrue(result.contains("adg"))
        assertTrue(result.contains("bfi"))
        assertTrue(result.contains("ceh"))
    }
}
