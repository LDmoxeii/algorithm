package com.only4.algorithm.version4k.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DecodeStringTest {

    @Test
    fun `test examples from problem description`() {
        // 示例1: "3[a]2[bc]" -> "aaabcbc"
        assertEquals("aaabcbc", decodeString("3[a]2[bc]"))

        // 示例2: "3[a2[c]]" -> "accaccacc"
        assertEquals("accaccacc", decodeString("3[a2[c]]"))

        // 示例3: "2[abc]3[cd]ef" -> "abcabccdcdcdef"
        assertEquals("abcabccdcdcdef", decodeString("2[abc]3[cd]ef"))
    }

    @Test
    fun `test simple cases`() {
        // 单个字符重复
        assertEquals("aaa", decodeString("3[a]"))

        // 多个字符重复
        assertEquals("abcabc", decodeString("2[abc]"))

        // 无重复，直接字符
        assertEquals("abc", decodeString("abc"))
    }

    @Test
    fun `test nested brackets`() {
        // 两层嵌套
        assertEquals("abcabc", decodeString("2[a1[bc]]"))

        // 三层嵌套
        assertEquals("abcabcabc", decodeString("3[a1[b1[c]]]"))

        // 复杂嵌套
        assertEquals("abcabccdcdcdxyz", decodeString("2[abc]3[cd]xyz"))
    }

    @Test
    fun `test edge cases`() {
        // 空字符串
        assertEquals("", decodeString(""))

        // 无括号的字符串
        assertEquals("abc", decodeString("abc"))

        // 重复次数为1
        assertEquals("a", decodeString("1[a]"))

        // 默认重复次数为1（当数字缺失时）
        assertEquals("a", decodeString("[a]"))

        // 大数字重复
        assertEquals("a".repeat(10), decodeString("10[a]"))

        // 重复空字符串
        assertEquals("", decodeString("3[]"))
    }

    @Test
    fun `test complex cases`() {
        // 混合嵌套和重复
        assertEquals("aaaabcabccdcdcdcd", decodeString("3[a]2[abc]4[cd]"))

        // 重复内部包含重复
        assertEquals("abcabcabcabc", decodeString("2[2[abc]]"))

        // 多层嵌套和混合字符
        assertEquals("abccdcdcdcdcdcdabcdcdc", decodeString("abc2[3[cd]]ab2[cd]c"))
    }
}
