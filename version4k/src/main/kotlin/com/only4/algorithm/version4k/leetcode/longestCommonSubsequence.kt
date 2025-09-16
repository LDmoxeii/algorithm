package com.only4.algorithm.version4k.leetcode

fun longestCommonSubsequence(text1: String, text2: String): Int {
    val firstStringLength = text1.length
    val secondStringLength = text2.length
    // lcsLength[firstIndex][secondIndex] 表示 text1[0...firstIndex-1] 和 text2[0...secondIndex-1] 的最长公共子序列长度
    val lcsLength = Array(firstStringLength + 1) { IntArray(secondStringLength + 1) }

    // 遍历两个字符串的所有字符组合
    for (firstIndex in 1..firstStringLength) {
        for (secondIndex in 1..secondStringLength) {
            val firstChar = text1[firstIndex - 1]
            val secondChar = text2[secondIndex - 1]

            if (firstChar == secondChar) {
                // 字符相同时：当前LCS长度 = 去掉当前字符后的LCS长度 + 1
                val previousLcsLength = lcsLength[firstIndex - 1][secondIndex - 1]
                lcsLength[firstIndex][secondIndex] = previousLcsLength + 1
            } else {
                // 字符不同时：取两种情况的最大值
                val lcsWithoutFirstChar = lcsLength[firstIndex - 1][secondIndex]
                val lcsWithoutSecondChar = lcsLength[firstIndex][secondIndex - 1]
                lcsLength[firstIndex][secondIndex] = maxOf(lcsWithoutFirstChar, lcsWithoutSecondChar)
            }
        }
    }

    return lcsLength[firstStringLength][secondStringLength]
}
