package com.only4.algorithm.leetcode

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class TrieTest {

    private lateinit var trie: Trie

    @BeforeEach
    fun setUp() {
        trie = Trie()
    }

    @Test
    fun `test example from LeetCode`() {
        // 插入单词 "apple"
        trie.insert("apple")

        // 搜索 "apple" 应返回 true
        assertTrue(trie.search("apple"))

        // 搜索 "app" 应返回 false，因为没有插入 "app"
        assertFalse(trie.search("app"))

        // 检查前缀 "app" 应返回 true，因为 "apple" 以 "app" 开头
        assertTrue(trie.startsWith("app"))

        // 插入单词 "app"
        trie.insert("app")

        // 现在搜索 "app" 应返回 true
        assertTrue(trie.search("app"))
    }

    @Test
    fun `test empty string`() {
        // 插入空字符串
        trie.insert("")

        // 搜索空字符串应返回 true
        assertTrue(trie.search(""))

        // 任何字符串的前缀都包含空字符串
        assertTrue(trie.startsWith(""))
    }

    @Test
    fun `test case sensitivity`() {
        trie.insert("Apple")
        trie.insert("apple")

        // 大小写敏感，所以两个都应该可以找到
        assertTrue(trie.search("Apple"))
        assertTrue(trie.search("apple"))

        // 但不能找到不同大小写的变体
        assertFalse(trie.search("APPLE"))
        assertFalse(trie.search("aPPle"))
    }

    @Test
    fun `test multiple words with common prefixes`() {
        // 插入多个有共同前缀的单词
        trie.insert("app")
        trie.insert("apple")
        trie.insert("application")
        trie.insert("append")

        // 所有插入的单词都应该能找到
        assertTrue(trie.search("app"))
        assertTrue(trie.search("apple"))
        assertTrue(trie.search("application"))
        assertTrue(trie.search("append"))

        // 共同前缀检查
        assertTrue(trie.startsWith("app"))
        assertTrue(trie.startsWith("appl"))
        assertTrue(trie.startsWith("appli"))
        assertTrue(trie.startsWith("appen"))

        // 未插入的单词不应该能找到
        assertFalse(trie.search("ap"))
        assertFalse(trie.search("appli"))
        assertFalse(trie.search("appl"))
        assertFalse(trie.search("applications"))
    }

    @Test
    fun `test words with special characters`() {
        // 插入包含特殊字符的单词
        trie.insert("hello-world")
        trie.insert("hello_world")
        trie.insert("hello@world")

        // 所有插入的单词都应该能找到
        assertTrue(trie.search("hello-world"))
        assertTrue(trie.search("hello_world"))
        assertTrue(trie.search("hello@world"))

        // 共同前缀检查
        assertTrue(trie.startsWith("hello-"))
        assertTrue(trie.startsWith("hello_"))
        assertTrue(trie.startsWith("hello@"))

        // 未插入的变体不应该能找到
        assertFalse(trie.search("helloworld"))
        assertFalse(trie.search("hello.world"))
    }

    @Test
    fun `test with numeric characters`() {
        // 插入包含数字的单词
        trie.insert("test123")
        trie.insert("123test")
        trie.insert("test123test")

        // 所有插入的单词都应该能找到
        assertTrue(trie.search("test123"))
        assertTrue(trie.search("123test"))
        assertTrue(trie.search("test123test"))

        // 共同前缀检查
        assertTrue(trie.startsWith("test"))
        assertTrue(trie.startsWith("123"))
        assertTrue(trie.startsWith("test123t"))

        // 未插入的变体不应该能找到
        assertFalse(trie.search("test"))
        assertFalse(trie.search("123"))
        assertFalse(trie.search("test123456"))
    }

    @Test
    fun `test non-existent words and prefixes`() {
        trie.insert("hello")
        trie.insert("world")

        // 不存在的单词应该返回 false
        assertFalse(trie.search("hi"))
        assertFalse(trie.search("hell"))
        assertFalse(trie.search("helloo"))
        assertFalse(trie.search("worl"))

        // 不存在的前缀应该返回 false
        assertFalse(trie.startsWith("hi"))
        assertFalse(trie.startsWith("worldd"))
    }

    @Test
    fun `test with long words`() {
        // 插入长单词
        val longWord = "pneumonoultramicroscopicsilicovolcanoconiosis" // 一个很长的单词
        trie.insert(longWord)

        // 应该能找到完整的单词
        assertTrue(trie.search(longWord))

        // 应该能找到前缀
        assertTrue(trie.startsWith("pneumono"))
        assertTrue(trie.startsWith("pneumonoultramicroscopic"))

        // 不应该能找到不是前缀的部分
        assertFalse(trie.startsWith("microscopic"))

        // 不应该能找到稍微不同的单词
        assertFalse(trie.search(longWord + "s"))
    }

    @Test
    fun `test with overlapping words`() {
        // 插入一些重叠的单词
        trie.insert("a")
        trie.insert("ab")
        trie.insert("abc")

        // 所有插入的单词都应该能找到
        assertTrue(trie.search("a"))
        assertTrue(trie.search("ab"))
        assertTrue(trie.search("abc"))

        // 前缀检查
        assertTrue(trie.startsWith("a"))
        assertTrue(trie.startsWith("ab"))
        assertTrue(trie.startsWith("abc"))
    }
}
