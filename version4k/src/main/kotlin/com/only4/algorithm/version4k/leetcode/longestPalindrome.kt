package com.only4.algorithm.version4k.leetcode

fun longestPalindrome(s: String): String {
    val stringLength = s.length
    if (stringLength < 2) return s

    // isPalindrome[leftIndex][rightIndex] 表示子串 s[leftIndex...rightIndex] 是否为回文串
    val isPalindrome = Array(stringLength) { BooleanArray(stringLength) }
    var longestPalindromeStart = 0
    var longestPalindromeLength = 1

    // 初始化长度为1的子串（单个字符必然是回文）
    for (charIndex in 0 until stringLength) {
        isPalindrome[charIndex][charIndex] = true
    }

    // 检查长度为2的子串
    for (leftIndex in 0 until stringLength - 1) {
        val rightIndex = leftIndex + 1
        if (s[leftIndex] == s[rightIndex]) {
            isPalindrome[leftIndex][rightIndex] = true
            longestPalindromeStart = leftIndex
            longestPalindromeLength = 2
        }
    }

    // 检查长度为3及以上的子串
    for (currentSubstringLength in 3..stringLength) {
        for (leftIndex in 0..stringLength - currentSubstringLength) {
            val rightIndex = leftIndex + currentSubstringLength - 1
            val leftChar = s[leftIndex]
            val rightChar = s[rightIndex]
            val innerSubstringIsPalindrome = isPalindrome[leftIndex + 1][rightIndex - 1]

            if (leftChar == rightChar && innerSubstringIsPalindrome) {
                isPalindrome[leftIndex][rightIndex] = true
                if (currentSubstringLength > longestPalindromeLength) {
                    longestPalindromeStart = leftIndex
                    longestPalindromeLength = currentSubstringLength
                }
            }
        }
    }

    return s.substring(longestPalindromeStart, longestPalindromeStart + longestPalindromeLength)
}
