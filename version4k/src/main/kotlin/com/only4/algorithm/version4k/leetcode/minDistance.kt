package com.only4.algorithm.version4k.leetcode

fun minDistance(word1: String, word2: String): Int {
    val sourceWordLength = word1.length
    val targetWordLength = word2.length
    // minOperations[sourceIndex][targetIndex] 表示将 word1[0...sourceIndex-1] 转换为 word2[0...targetIndex-1] 所需的最少操作数
    val minOperations = Array(sourceWordLength + 1) { IntArray(targetWordLength + 1) }

    // 初始化边界条件：将空字符串转换为 word2 的前缀需要插入操作
    for (targetIndex in 0..targetWordLength) {
        minOperations[0][targetIndex] = targetIndex // 插入 targetIndex 个字符
    }

    // 初始化边界条件：将 word1 的前缀转换为空字符串需要删除操作
    for (sourceIndex in 0..sourceWordLength) {
        minOperations[sourceIndex][0] = sourceIndex // 删除 sourceIndex 个字符
    }

    // 计算所有子问题的最少操作数
    for (sourceIndex in 1..sourceWordLength) {
        for (targetIndex in 1..targetWordLength) {
            val sourceChar = word1[sourceIndex - 1]
            val targetChar = word2[targetIndex - 1]

            if (sourceChar == targetChar) {
                // 字符相同，不需要额外操作
                minOperations[sourceIndex][targetIndex] = minOperations[sourceIndex - 1][targetIndex - 1]
            } else {
                // 字符不同，考虑三种操作的最小值
                val insertCost = minOperations[sourceIndex][targetIndex - 1] + 1     // 插入字符
                val deleteCost = minOperations[sourceIndex - 1][targetIndex] + 1     // 删除字符
                val replaceCost = minOperations[sourceIndex - 1][targetIndex - 1] + 1 // 替换字符

                minOperations[sourceIndex][targetIndex] = minOf(insertCost, deleteCost, replaceCost)
            }
        }
    }

    return minOperations[sourceWordLength][targetWordLength]
}
