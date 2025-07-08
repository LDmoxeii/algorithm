package com.only4.algorithm.version4k.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LongestValidParenthesesTest {

    @Test
    fun `test examples from problem description`() {
        // 示例1: "(())" -> 4
        assertEquals(4, longestValidParentheses("(())"))

        // 示例2: "(()" -> 2
        assertEquals(2, longestValidParentheses("(()"))

        // 示例3: ")()())" -> 4
        assertEquals(4, longestValidParentheses(")()())"))

        // 示例4: "" -> 0
        assertEquals(0, longestValidParentheses(""))
    }

    @Test
    fun `test edge cases`() {
        // 单个字符
        assertEquals(0, longestValidParentheses("("))
        assertEquals(0, longestValidParentheses(")"))

        // 两个字符
        assertEquals(2, longestValidParentheses("()"))
        assertEquals(0, longestValidParentheses(")("))
        assertEquals(0, longestValidParentheses("(("))
        assertEquals(0, longestValidParentheses("))"))

        // 全是左括号
        assertEquals(0, longestValidParentheses("((("))

        // 全是右括号
        assertEquals(0, longestValidParentheses(")))"))
    }

    @Test
    fun `test basic valid patterns`() {
        // 基本有效模式
        assertEquals(2, longestValidParentheses("()"))
        assertEquals(4, longestValidParentheses("()()"))
        assertEquals(6, longestValidParentheses("()()()"))
        assertEquals(4, longestValidParentheses("(())"))
        assertEquals(6, longestValidParentheses("((()))"))
    }

    @Test
    fun `test mixed valid and invalid patterns`() {
        // 混合有效和无效的模式
        assertEquals(2, longestValidParentheses("(()"))
        assertEquals(2, longestValidParentheses("())"))
        assertEquals(6, longestValidParentheses("(()())"))
        assertEquals(4, longestValidParentheses(")()())"))
        assertEquals(6, longestValidParentheses("()(())"))
        assertEquals(6, longestValidParentheses("(()())"))
    }

    @Test
    fun `test complex cases`() {
        // 复杂情况
        assertEquals(24, longestValidParentheses("(()(((()())())()))()(())"))
        assertEquals(6, longestValidParentheses("()(())("))
        assertEquals(4, longestValidParentheses("())(())"))
        assertEquals(8, longestValidParentheses("(())(())"))
        assertEquals(8, longestValidParentheses("((())())"))
    }

    @Test
    fun `test nested parentheses`() {
        // 嵌套括号
        assertEquals(4, longestValidParentheses("(())"))
        assertEquals(6, longestValidParentheses("((()))"))
        assertEquals(8, longestValidParentheses("(((())))"))
        assertEquals(10, longestValidParentheses("((((()))))"))
    }

    @Test
    fun `test disconnected valid sequences`() {
        // 不连续的有效序列
        assertEquals(2, longestValidParentheses("())("))
        assertEquals(4, longestValidParentheses("()())("))
        assertEquals(4, longestValidParentheses(")(()()"))
        assertEquals(6, longestValidParentheses("()(()))("))
    }

    @Test
    fun `test with many invalid parentheses`() {
        // 包含大量无效括号
        assertEquals(2, longestValidParentheses(")()("))
        assertEquals(2, longestValidParentheses(")))()"))
        assertEquals(4, longestValidParentheses("(()))"))
        assertEquals(6, longestValidParentheses(")))(()())"))
    }
}
