package com.only4.algorithm.version4k.leetcode

fun wordBreak(s: String, wordDict: List<String>): Boolean {
    // 计算字典中最长单词的长度
    val maxWordLength = wordDict.maxOfOrNull { it.length } ?: 0

    // 将字典转换为HashSet以提高查找效率
    val wordSet = wordDict.toHashSet()

    // dp[i]表示s的前i个字符是否可以被拆分
    val dp = BooleanArray(s.length + 1)
    dp[0] = true // 空字符串可以被拆分

    // 对于每个位置，检查是否可以从之前的某个位置加上字典中的单词得到
    for (i in 1..s.length) {
        // 只检查从i-maxWordLength到i-1的范围，优化时间复杂度
        val startPos = maxOf(i - maxWordLength, 0)
        for (j in (i - 1).downTo(startPos)) {
            val word = s.substring(j, i)
            if (dp[j] && wordSet.contains(word)) {
                dp[i] = true
                break // 找到一种可行拆分即可停止
            }
        }
    }

    return dp[s.length]
}
