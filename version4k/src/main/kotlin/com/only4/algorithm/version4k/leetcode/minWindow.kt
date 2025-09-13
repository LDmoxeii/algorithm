package com.only4.algorithm.version4k.leetcode

fun minWindow(s: String, t: String): String {
    if (s.length < t.length) return ""

    // 统计目标字符串中每个字符的出现频率
    val targetFreq = mutableMapOf<Char, Int>().withDefault { 0 }
    t.forEach { targetFreq[it] = targetFreq.getValue(it) + 1 }

    // 统计当前窗口中每个字符的出现频率
    val windowFreq = mutableMapOf<Char, Int>().withDefault { 0 }

    var left = 0
    var matchCount = 0 // 已匹配的字符种类数
    var minLength = Int.MAX_VALUE
    var minStart = 0

    for (right in s.indices) {
        val rightChar = s[right]

        // 如果当前字符在目标字符串中
        if (rightChar in targetFreq) {
            windowFreq[rightChar] = windowFreq.getValue(rightChar) + 1

            // 如果当前字符的频率刚好匹配目标频率
            if (windowFreq[rightChar] == targetFreq[rightChar]) {
                matchCount++
            }
        }

        // 当所有字符都匹配时，尝试收缩窗口
        while (matchCount == targetFreq.size) {
            // 更新最小覆盖子串
            val currentLength = right - left + 1
            if (currentLength < minLength) {
                minLength = currentLength
                minStart = left
            }

            val leftChar = s[left]
            left++

            // 如果左边界字符在目标字符串中
            if (leftChar in targetFreq) {
                // 如果移除前字符频率刚好匹配，移除后就不匹配了
                if (windowFreq[leftChar] == targetFreq[leftChar]) {
                    matchCount--
                }
                windowFreq[leftChar] = windowFreq.getValue(leftChar) - 1
            }
        }
    }

    return if (minLength == Int.MAX_VALUE) "" else s.substring(minStart, minStart + minLength)
}
