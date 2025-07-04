package com.only4.algorithm.leetcode

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class CheckInclusionTest {

    @Test
    fun `test example 1 - permutation exists`() {
        // 示例1：s1 = "ab", s2 = "eidbaooo" -> true
        val s1 = "ab"
        val s2 = "eidbaooo"

        val result = checkInclusion(s1, s2)

        assertTrue(result)
    }

    @Test
    fun `test example 2 - permutation does not exist`() {
        // 示例2：s1 = "ab", s2 = "eidboaoo" -> false
        val s1 = "ab"
        val s2 = "eidboaoo"

        val result = checkInclusion(s1, s2)

        assertFalse(result)
    }

    @Test
    fun `test permutation at the beginning`() {
        // 排列在字符串开头
        val s1 = "abc"
        val s2 = "abcdefg"

        val result = checkInclusion(s1, s2)

        assertTrue(result)
    }

    @Test
    fun `test permutation at the end`() {
        // 排列在字符串结尾
        val s1 = "abc"
        val s2 = "defgcba"

        val result = checkInclusion(s1, s2)

        assertTrue(result)
    }

    @Test
    fun `test s1 longer than s2`() {
        // s1比s2长，不可能包含排列
        val s1 = "abcdef"
        val s2 = "abc"

        val result = checkInclusion(s1, s2)

        assertFalse(result)
    }

    @Test
    fun `test empty s1`() {
        // s1为空字符串，任何字符串都包含空字符串的排列
        val s1 = ""
        val s2 = "abc"

        val result = checkInclusion(s1, s2)

        assertTrue(result)
    }

    @Test
    fun `test empty s2`() {
        // s2为空字符串，不可能包含非空s1的排列
        val s1 = "abc"
        val s2 = ""

        val result = checkInclusion(s1, s2)

        assertFalse(result)
    }

    @Test
    fun `test both empty`() {
        // 两个字符串都为空
        val s1 = ""
        val s2 = ""

        val result = checkInclusion(s1, s2)

        assertTrue(result)
    }

    @Test
    fun `test with repeated characters`() {
        // s1包含重复字符
        val s1 = "aab"
        val s2 = "eidbaaooo"

        val result = checkInclusion(s1, s2)

        assertTrue(result)
    }

    @Test
    fun `test with all same characters`() {
        // s1全是相同的字符
        val s1 = "aaa"
        val s2 = "aaabaaaa"

        val result = checkInclusion(s1, s2)

        assertTrue(result)
    }

    @Test
    fun `test with non-overlapping characters`() {
        // s1和s2没有共同字符
        val s1 = "abc"
        val s2 = "defghi"

        val result = checkInclusion(s1, s2)

        assertFalse(result)
    }

    @Test
    fun `test with exact match`() {
        // s1和s2完全相同
        val s1 = "abcdef"
        val s2 = "abcdef"

        val result = checkInclusion(s1, s2)

        assertTrue(result)
    }

    @Test
    fun `test with multiple valid permutations`() {
        // s2中包含多个s1的排列
        val s1 = "ab"
        val s2 = "abcdeabfgba"

        val result = checkInclusion(s1, s2)

        assertTrue(result)
    }

    @Test
    fun `test with almost matching substring`() {
        // s2包含几乎匹配的子串，但不完全匹配
        val s1 = "aabb"
        val s2 = "aabcbba"

        val result = checkInclusion(s1, s2)

        assertFalse(result)
    }

    @Test
    fun `test with large strings`() {
        // 较大的字符串测试
        val s1 = "abcdefghijklmnopqrstuvwxyz"
        val s2 = "bcdefghijklmnopqrstuvwxyza" // s1的一个排列

        val result = checkInclusion(s1, s2)

        assertTrue(result)
    }
}
