package com.only4.algorithm.version4k.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class LongestPalindromeTest {

    /**
     * 测试原始问题描述中的示例
     */
    @Test
    fun `test examples from problem description`() {
        // 示例1: "babad" -> "bab" 或 "aba"
        val result1 = longestPalindrome("babad")
        assertTrue(result1 == "bab" || result1 == "aba")

        // 示例2: "cbbd" -> "bb"
        assertEquals("bb", longestPalindrome("cbbd"))
    }

    /**
     * 测试边界情况
     */
    @Test
    fun `test edge cases`() {
        // 空字符串
        assertEquals("", longestPalindrome(""))

        // 单个字符
        assertEquals("a", longestPalindrome("a"))

        // 两个相同字符
        assertEquals("aa", longestPalindrome("aa"))

        // 两个不同字符
        val result = longestPalindrome("ab")
        assertTrue(result == "a" || result == "b")
    }

    /**
     * 测试奇数长度的回文串
     */
    @Test
    fun `test palindromes of odd length`() {
        // 奇数长度的回文串
        assertEquals("a", longestPalindrome("a"))
        assertEquals("aba", longestPalindrome("aba"))
        assertEquals("ccc", longestPalindrome("ccc"))
        assertEquals("abcba", longestPalindrome("abcba"))
        assertEquals("racecar", longestPalindrome("racecar"))
    }

    /**
     * 测试偶数长度的回文串
     */
    @Test
    fun `test palindromes of even length`() {
        // 偶数长度的回文串
        assertEquals("aa", longestPalindrome("aa"))
        assertEquals("bb", longestPalindrome("abb"))
        assertEquals("abba", longestPalindrome("abba"))
        assertEquals("abccba", longestPalindrome("abccba"))
    }

    /**
     * 测试包含多个回文串的字符串
     */
    @Test
    fun `test strings with multiple palindromes`() {
        // 包含多个回文串的字符串，返回最长的
        assertEquals("aba", longestPalindrome("abac"))
        assertEquals("anana", longestPalindrome("banana"))
        assertEquals("aaaa", longestPalindrome("aaaa"))
        assertEquals("aabaa", longestPalindrome("aabaa"))
    }

    /**
     * 测试回文串在不同位置的情况
     */
    @Test
    fun `test strings with palindromes at different positions`() {
        // 回文串在不同位置
        assertEquals("aba", longestPalindrome("aba123"))
        assertEquals("aba", longestPalindrome("123aba"))
        assertEquals("aba", longestPalindrome("12aba34"))
        assertEquals("abcba", longestPalindrome("12abcba34"))
    }

    /**
     * 测试长字符串
     */
    @Test
    fun `test long strings`() {
        // 较长的字符串
        assertEquals("abcdefgfedcba", longestPalindrome("xabcdefgfedcbay"))

        // 长字符串中的短回文
        val longString = "a" + "b".repeat(1000) + "cdc" + "b".repeat(1000) + "a"
        assertEquals("a" + "b".repeat(1000) + "cdc" + "b".repeat(1000) + "a", longestPalindrome(longString))
    }

    /**
     * 测试特殊情况
     */
    @Test
    fun `test special cases`() {
        // 全部相同的字符
        assertEquals("aaaaa", longestPalindrome("aaaaa"))

        // 没有回文子串长度超过1的情况
        val result = longestPalindrome("abcdef")
        assertTrue(result.length == 1) // 任何单个字符都是回文

        // 字符串本身就是回文
        assertEquals("abcdeedcba", longestPalindrome("abcdeedcba"))
    }

    /**
     * 测试三种算法实现的一致性
     */
    @Test
    fun `test consistency between implementations`() {
        val testCases = listOf(
            "",
            "a",
            "aa",
            "ab",
            "aba",
            "abba",
            "abcba",
            "babad",
            "cbbd",
            "racecar",
            "banana",
            "aaaaa",
            "abcdef",
            "abcdeedcba",
            "xabcdefgfedcbay"
        )

        for (testCase in testCases) {
            // 由于回文串可能有多个相同长度的结果，我们比较长度而不是具体字符串
            val dpResult = longestPalindromeDP(testCase)
            val expandResult = longestPalindromeExpand(testCase)
            val manacherResult = longestPalindromeManacher(testCase)

            assertEquals(
                dpResult.length, expandResult.length,
                "DP和中心扩展法在'$testCase'上结果长度不一致"
            )
            assertEquals(
                expandResult.length, manacherResult.length,
                "中心扩展法和Manacher算法在'$testCase'上结果长度不一致"
            )

            // 如果字符串不为空，验证结果是否为回文
            if (testCase.isNotEmpty()) {
                assertTrue(isPalindrome(dpResult), "DP结果'$dpResult'不是回文")
                assertTrue(isPalindrome(expandResult), "中心扩展法结果'$expandResult'不是回文")
                assertTrue(isPalindrome(manacherResult), "Manacher算法结果'$manacherResult'不是回文")
            }
        }
    }

    /**
     * 测试三种算法的性能比较
     * 注意：这不是严格的性能测试，只是简单比较
     */
    @Test
    fun `test performance comparison`() {
        // 创建一个较长的字符串进行测试
        val longString = "a" + "b".repeat(1000) + "cdc" + "b".repeat(1000) + "a"

        // 测量动态规划方法的执行时间
        val dpStartTime = System.currentTimeMillis()
        val dpResult = longestPalindromeDP(longString)
        val dpEndTime = System.currentTimeMillis()
        val dpTime = dpEndTime - dpStartTime

        // 测量中心扩展法的执行时间
        val expandStartTime = System.currentTimeMillis()
        val expandResult = longestPalindromeExpand(longString)
        val expandEndTime = System.currentTimeMillis()
        val expandTime = expandEndTime - expandStartTime

        // 测量Manacher算法的执行时间
        val manacherStartTime = System.currentTimeMillis()
        val manacherResult = longestPalindromeManacher(longString)
        val manacherEndTime = System.currentTimeMillis()
        val manacherTime = manacherEndTime - manacherStartTime

        // 验证结果长度一致
        assertEquals(dpResult.length, expandResult.length)
        assertEquals(expandResult.length, manacherResult.length)

        // 输出执行时间，但不进行断言
        println("动态规划方法执行时间: $dpTime ms")
        println("中心扩展法执行时间: $expandTime ms")
        println("Manacher算法执行时间: $manacherTime ms")
    }

    /**
     * 辅助函数：检查字符串是否为回文
     */
    private fun isPalindrome(s: String): Boolean {
        var left = 0
        var right = s.length - 1

        while (left < right) {
            if (s[left] != s[right]) {
                return false
            }
            left++
            right--
        }

        return true
    }
}
