package com.only4.algorithm.leetcode

fun longestPalindrome(s: String): String {
    var res = ""
    fun palindrome(s: String, left: Int, right: Int): String {
        var (left, right) = left to right
        while (
            left >= 0 && right < s.length
            && s[left] == s[right]
        ) {
            left--
            right++
        }
        return s.substring(left + 1, right)
    }

    s.forEachIndexed { index, it ->
        val s1 = palindrome(s, index, index)
        val s2 = palindrome(s, index, index + 1)

        res = if (res.length > s1.length) res else s1
        res = if (res.length > s2.length) res else s2
    }
    return res
}
