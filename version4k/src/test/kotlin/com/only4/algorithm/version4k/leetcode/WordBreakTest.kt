package com.only4.algorithm.version4k.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class WordBreakTest {

    @Test
    fun `test examples from problem description`() {
        // 示例1: s = "leetcode", wordDict = ["leet", "code"] -> true
        assertEquals(true, wordBreak("leetcode", listOf("leet", "code")))

        // 示例2: s = "applepenapple", wordDict = ["apple", "pen"] -> true
        assertEquals(true, wordBreak("applepenapple", listOf("apple", "pen")))

        // 示例3: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"] -> false
        assertEquals(false, wordBreak("catsandog", listOf("cats", "dog", "sand", "and", "cat")))
    }

    @Test
    fun `test edge cases`() {
        // 空字符串，任何字典都可以拆分
        assertEquals(true, wordBreak("", listOf("a", "b")))

        // 空字典，只有空字符串可以被拆分
        assertEquals(false, wordBreak("abc", listOf()))

        // 字典中包含空字符串，不影响结果
        assertEquals(true, wordBreak("abc", listOf("", "abc")))
        assertEquals(false, wordBreak("abcd", listOf("", "abc")))
    }

    @Test
    fun `test single character cases`() {
        // 单个字符的字符串和字典
        assertEquals(true, wordBreak("a", listOf("a")))
        assertEquals(false, wordBreak("a", listOf("b")))

        // 字典中有单个字符
        assertEquals(true, wordBreak("aaaa", listOf("a")))
        assertEquals(true, wordBreak("ababab", listOf("a", "b")))
    }

    @Test
    fun `test overlapping words`() {
        // 重叠单词的情况
        assertEquals(false, wordBreak("aaaba", listOf("a", "aa", "aaa", "aaaa")))

        // 需要回溯选择的情况
        assertEquals(true, wordBreak("abcdef", listOf("ab", "cd", "abcd", "ef", "c")))
        assertEquals(false, wordBreak("abcdef", listOf("ab", "abc", "de")))
    }

    @Test
    fun `test longer strings`() {
        // 较长的字符串
        assertEquals(true, wordBreak("programcreek", listOf("programcreek")))
        assertEquals(true, wordBreak("programcreek", listOf("program", "creek")))
        assertEquals(true, wordBreak("programcreek", listOf("program", "pro", "gram", "creek")))
        assertEquals(false, wordBreak("programcreek", listOf("program", "gram")))
    }

    @Test
    fun `test repeated patterns`() {
        // 重复模式
        assertEquals(true, wordBreak("abababab", listOf("ab")))
        assertEquals(true, wordBreak("abababab", listOf("a", "b", "ab")))
        assertEquals(false, wordBreak("abababab", listOf("aba", "bab")))
        assertEquals(false, wordBreak("abababab", listOf("aba", "ba")))
    }

    @Test
    fun `test performance cases`() {
        // 性能测试用例 - 长字符串，大词典
        val longString = "a".repeat(100)
        val bigDict = listOf("a", "aa", "aaa", "aaaa")
        assertEquals(true, wordBreak(longString, bigDict))

        // 最坏情况 - 需要尝试很多组合但最终失败
        val worstCaseString = "aaaaaaaaab"
        val worstCaseDict = listOf("a", "aa", "aaa", "aaaa")
        assertEquals(false, wordBreak(worstCaseString, worstCaseDict))
    }
}
