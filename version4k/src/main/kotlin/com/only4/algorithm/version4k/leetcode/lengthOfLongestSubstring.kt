package com.only4.algorithm.version4k.leetcode

fun lengthOfLongestSubstring(s: String): Int {
    if (s.isEmpty()) return 0

    val windowChars = mutableSetOf<Char>()
    var left = 0
    var maxLength = 0

    for (right in s.indices) {
        val rightChar = s[right]

        // 如果遇到重复字符，收缩左边界直到去除重复
        while (rightChar in windowChars) {
            windowChars.remove(s[left])
            left++
        }

        // 将当前字符加入窗口
        windowChars.add(rightChar)
        // 更新最大长度
        maxLength = maxOf(maxLength, right - left + 1)
    }

    return maxLength
}
