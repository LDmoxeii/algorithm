package com.only4.algorithm.version4k.leetcode

fun wordBreak(s: String, wordDict: List<String>): Boolean {
    // 计算字典中最长单词的长度，用于优化搜索范围
    val maxWordLengthInDict = wordDict.maxOfOrNull { it.length } ?: 0

    // 将字典转换为HashSet以提高查找效率
    val dictWordSet = wordDict.toHashSet()

    // canBreakUpToPosition[i] 表示字符串s的前i个字符是否可以被拆分
    val canBreakUpToPosition = BooleanArray(s.length + 1)
    canBreakUpToPosition[0] = true // 空字符串可以被拆分

    // 对于每个位置，检查是否可以从之前的某个位置加上字典中的单词得到
    for (currentPosition in 1..s.length) {
        // 只检查可能的起始位置范围，优化时间复杂度
        val earliestStartPosition = maxOf(currentPosition - maxWordLengthInDict, 0)

        for (startPosition in (currentPosition - 1).downTo(earliestStartPosition)) {
            // 提取从startPosition到currentPosition的子串
            val candidateWord = s.substring(startPosition, currentPosition)

            // 如果前面部分可以拆分且当前子串在字典中，则当前位置可以拆分
            if (canBreakUpToPosition[startPosition] && dictWordSet.contains(candidateWord)) {
                canBreakUpToPosition[currentPosition] = true
                break // 找到一种可行拆分即可停止
            }
        }
    }

    return canBreakUpToPosition[s.length]
}
