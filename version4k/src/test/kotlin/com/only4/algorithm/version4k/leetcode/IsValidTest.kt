package com.only4.algorithm.version4k.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class IsValidTest {

    @Test
    fun `test valid parentheses`() {
        // 简单有效括号
        assertEquals(true, isValid("()"))
        assertEquals(true, isValid("[]"))
        assertEquals(true, isValid("{}"))

        // 多种括号组合
        assertEquals(true, isValid("()[]{}"))
        assertEquals(true, isValid("{[]}"))
        assertEquals(true, isValid("([{}])"))

        // 嵌套括号
        assertEquals(true, isValid("({[]})"))
        assertEquals(true, isValid("(((())))"))
        assertEquals(true, isValid("{{[[]]}}"))
    }

    @Test
    fun `test invalid parentheses`() {
        // 不匹配的括号
        assertEquals(false, isValid("(]"))
        assertEquals(false, isValid("([)]"))
        assertEquals(false, isValid("]"))

        // 未闭合的括号
        assertEquals(false, isValid("("))
        assertEquals(false, isValid("["))
        assertEquals(false, isValid("{"))

        // 多余的闭合括号
        assertEquals(false, isValid("())"))
        assertEquals(false, isValid("(()"))
        assertEquals(false, isValid("{{}}}"))

        // 顺序错误的括号
        assertEquals(false, isValid(")("))
        assertEquals(false, isValid("}{}"))
        assertEquals(false, isValid("]["))
    }

    @Test
    fun `test edge cases`() {
        // 空字符串
        assertEquals(true, isValid(""))

        // 长字符串
        val longValid = "(" + "{}[]".repeat(1000) + ")"
        assertEquals(true, isValid(longValid))

        val longInvalid = "(" + "{}[]".repeat(1000)
        assertEquals(false, isValid(longInvalid))
    }
}
