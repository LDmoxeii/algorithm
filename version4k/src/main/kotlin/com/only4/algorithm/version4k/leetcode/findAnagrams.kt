package com.only4.algorithm.version4k.leetcode

fun findAnagrams(s: String, p: String): List<Int> {
    val result = mutableListOf<Int>()

    if (s.length < p.length) return result

    // 统计目标字符串的字符频率
    val targetFreq = IntArray(26)
    p.forEach { targetFreq[it - 'a']++ }

    // 统计滑动窗口的字符频率
    val windowFreq = IntArray(26)
    val windowSize = p.length

    // 初始化第一个窗口
    for (i in 0 until windowSize) {
        windowFreq[s[i] - 'a']++
    }

    // 检查第一个窗口
    if (targetFreq.contentEquals(windowFreq)) {
        result.add(0)
    }

    // 滑动窗口
    for (right in windowSize until s.length) {
        // 添加右边新字符
        windowFreq[s[right] - 'a']++
        // 移除左边旧字符
        val left = right - windowSize
        windowFreq[s[left] - 'a']--

        // 检查当前窗口是否为异位词
        if (targetFreq.contentEquals(windowFreq)) {
            result.add(left + 1)
        }
    }

    return result
}
