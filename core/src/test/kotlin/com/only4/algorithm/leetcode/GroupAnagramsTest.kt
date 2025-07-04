package com.only4.algorithm.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class GroupAnagramsTest {

    @Test
    fun `test example case`() {
        val strs = arrayOf("eat", "tea", "tan", "ate", "nat", "bat")
        val result = groupAnagrams(strs)

        // 结果可能顺序不同，需要灵活断言
        assertEquals(3, result.size)

        // 找到包含"eat"的组
        val eatGroup = result.find { it.contains("eat") }!!
        assertEquals(3, eatGroup.size)
        assertTrue(eatGroup.containsAll(listOf("eat", "tea", "ate")))

        // 找到包含"tan"的组
        val tanGroup = result.find { it.contains("tan") }!!
        assertEquals(2, tanGroup.size)
        assertTrue(tanGroup.containsAll(listOf("tan", "nat")))

        // 找到包含"bat"的组
        val batGroup = result.find { it.contains("bat") }!!
        assertEquals(1, batGroup.size)
        assertTrue(batGroup.contains("bat"))
    }

    @Test
    fun `test empty string`() {
        val strs = arrayOf("")
        val result = groupAnagrams(strs)

        assertEquals(1, result.size)
        assertEquals(1, result[0].size)
        assertEquals("", result[0][0])
    }

    @Test
    fun `test single character`() {
        val strs = arrayOf("a")
        val result = groupAnagrams(strs)

        assertEquals(1, result.size)
        assertEquals(1, result[0].size)
        assertEquals("a", result[0][0])
    }

    @Test
    fun `test multiple same anagrams`() {
        val strs = arrayOf("ddddddddddg", "dgggggggggg")
        val result = groupAnagrams(strs)

        assertEquals(2, result.size)
        assertEquals(1, result[0].size)
        assertEquals(1, result[1].size)
    }

    @Test
    fun `test no anagrams`() {
        val strs = arrayOf("abc", "def", "ghi")
        val result = groupAnagrams(strs)

        assertEquals(3, result.size)
        result.forEach { group ->
            assertEquals(1, group.size)
        }
    }

    @Test
    fun `test mixed length strings`() {
        val strs = arrayOf("abc", "cba", "ab", "ba", "a")
        val result = groupAnagrams(strs)

        assertEquals(3, result.size)

        // 找到包含"abc"的组
        val abcGroup = result.find { it.contains("abc") }!!
        assertEquals(2, abcGroup.size)
        assertTrue(abcGroup.containsAll(listOf("abc", "cba")))

        // 找到包含"ab"的组
        val abGroup = result.find { it.contains("ab") }!!
        assertEquals(2, abGroup.size)
        assertTrue(abGroup.containsAll(listOf("ab", "ba")))

        // 找到包含"a"的组
        val aGroup = result.find { it.contains("a") }!!
        assertEquals(1, aGroup.size)
        assertTrue(aGroup.contains("a"))
    }

    @Test
    fun `test large number of anagrams`() {
        val strs = arrayOf(
            "abc", "acb", "bac", "bca", "cab", "cba",
            "ab", "ba",
            "a"
        )
        val result = groupAnagrams(strs)

        assertEquals(3, result.size)

        // 验证每组的大小
        val sizes = result.map { it.size }.sorted()
        assertEquals(listOf(1, 2, 6), sizes)
    }
}
