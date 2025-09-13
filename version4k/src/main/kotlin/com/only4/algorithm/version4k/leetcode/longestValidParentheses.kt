package com.only4.algorithm.version4k.leetcode

fun longestValidParentheses(s: String): Int {
    // 空字符串直接返回0
    if (s.isEmpty()) return 0

    // dp[i]表示以s[i]结尾的最长有效括号的长度
    val dp = IntArray(s.length)
    var maxLength = 0

    // 从索引1开始，因为单个字符不可能形成有效括号
    for (i in 1 until s.length) {
        when (s[i]) {
            // 如果是左括号，则以它结尾的子串不可能是有效括号
            '(' -> dp[i] = 0

            // 如果是右括号，则需要考虑两种情况
            ')' -> {
                when (s[i - 1]) {
                    // 情况1: 前一个字符是左括号，形如"...()"
                    '(' -> {
                        // dp[i-2]表示"..."部分的有效括号长度，加上新增的"()"长度2
                        dp[i] = (if (i >= 2) dp[i - 2] else 0) + 2
                    }
                    // 情况2: 前一个字符是右括号，形如"...)))"
                    ')' -> {
                        // 检查是否存在匹配的左括号
                        val matchingOpenPos = i - dp[i - 1] - 1
                        if (matchingOpenPos >= 0 && s[matchingOpenPos] == '(') {
                            // 计算新的有效括号长度
                            dp[i] = dp[i - 1] + 2 + (if (matchingOpenPos > 0) dp[matchingOpenPos - 1] else 0)
                        }
                    }
                }
            }
        }
        // 更新最长有效括号长度
        maxLength = maxOf(maxLength, dp[i])
    }

    return maxLength
}
