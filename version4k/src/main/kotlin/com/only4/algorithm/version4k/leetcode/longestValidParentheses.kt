package com.only4.algorithm.version4k.leetcode

fun longestValidParentheses(s: String): Int {
    // 空字符串直接返回0
    if (s.isEmpty()) return 0

    // maxValidLengthEndingAt[i] 表示以s[i]结尾的最长有效括号的长度
    val maxValidLengthEndingAt = IntArray(s.length)
    var globalMaxValidLength = 0

    // 从索引1开始，因为单个字符不可能形成有效括号
    for (currentIndex in 1 until s.length) {
        val currentChar = s[currentIndex]

        when (currentChar) {
            // 如果是左括号，则以它结尾的子串不可能是有效括号
            '(' -> maxValidLengthEndingAt[currentIndex] = 0

            // 如果是右括号，则需要考虑两种情况
            ')' -> {
                val previousChar = s[currentIndex - 1]

                when (previousChar) {
                    // 情况1: 前一个字符是左括号，形如"...()"
                    '(' -> {
                        // 前面部分的有效括号长度 + 新增的"()"长度2
                        val previousValidLength = if (currentIndex >= 2) {
                            maxValidLengthEndingAt[currentIndex - 2]
                        } else {
                            0
                        }
                        maxValidLengthEndingAt[currentIndex] = previousValidLength + 2
                    }

                    // 情况2: 前一个字符是右括号，形如"...)))"
                    ')' -> {
                        // 检查是否存在匹配的左括号
                        val previousValidLength = maxValidLengthEndingAt[currentIndex - 1]
                        val potentialMatchingLeftParenIndex = currentIndex - previousValidLength - 1

                        if (potentialMatchingLeftParenIndex >= 0 &&
                            s[potentialMatchingLeftParenIndex] == '('
                        ) {
                            // 找到匹配的左括号，计算新的有效括号长度
                            val validLengthBeforeMatch = if (potentialMatchingLeftParenIndex > 0) {
                                maxValidLengthEndingAt[potentialMatchingLeftParenIndex - 1]
                            } else {
                                0
                            }

                            maxValidLengthEndingAt[currentIndex] =
                                previousValidLength + 2 + validLengthBeforeMatch
                        }
                    }
                }
            }
        }

        // 更新全局最长有效括号长度
        globalMaxValidLength = maxOf(globalMaxValidLength, maxValidLengthEndingAt[currentIndex])
    }

    return globalMaxValidLength
}
