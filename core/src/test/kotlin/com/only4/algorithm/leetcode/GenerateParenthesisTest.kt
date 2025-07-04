package com.only4.algorithm.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class GenerateParenthesisTest {

    @Test
    fun `test n equals 1`() {
        val n = 1
        val result = generateParenthesis(n)

        assertEquals(1, result.size)
        assertTrue(result.contains("()"))
    }

    @Test
    fun `test n equals 2`() {
        val n = 2
        val result = generateParenthesis(n)

        assertEquals(2, result.size)
        assertTrue(result.contains("(())"))
        assertTrue(result.contains("()()"))
    }

    @Test
    fun `test n equals 3`() {
        val n = 3
        val result = generateParenthesis(n)

        assertEquals(5, result.size)
        assertTrue(result.contains("((()))"))
        assertTrue(result.contains("(()())"))
        assertTrue(result.contains("(())()"))
        assertTrue(result.contains("()(())"))
        assertTrue(result.contains("()()()"))
    }

    @Test
    fun `test n equals 4`() {
        val n = 4
        val result = generateParenthesis(n)

        assertEquals(14, result.size)
        // 检查几个典型的括号组合
        assertTrue(result.contains("(((())))"))
        assertTrue(result.contains("((()()))"))
        assertTrue(result.contains("((())())"))
        assertTrue(result.contains("((()))()"))
        assertTrue(result.contains("(()(()))"))
        assertTrue(result.contains("(()()())"))
        assertTrue(result.contains("(()())()"))
        assertTrue(result.contains("(())(())"))
        assertTrue(result.contains("(())()()"))
        assertTrue(result.contains("()((()))"))
        assertTrue(result.contains("()(()())"))
        assertTrue(result.contains("()(())()"))
        assertTrue(result.contains("()()(())"))
        assertTrue(result.contains("()()()()"))
    }
}
