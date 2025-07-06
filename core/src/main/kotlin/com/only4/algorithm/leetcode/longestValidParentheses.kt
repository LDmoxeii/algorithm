package com.only4.algorithm.leetcode

/**
 * [32. 最长有效括号](https://leetcode.com/problems/longest-valid-parentheses/)
 *
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 *
 * 示例:
 * - 输入: s = "(()"
 * - 输出: 2
 * - 解释: 最长有效括号子串是 "()"
 *
 * - 输入: s = ")()())"
 * - 输出: 4
 * - 解释: 最长有效括号子串是 "()()"
 *
 * - 输入: s = ""
 * - 输出: 0
 *
 * 解题思路:
 * 使用动态规划解决此问题。定义dp[i]为以s[i]结尾的最长有效括号的长度。
 * 1. 如果s[i]是'('，则dp[i] = 0，因为以'('结尾的子串不可能是有效括号
 * 2. 如果s[i]是')'，则有两种情况:
 *    a. 如果s[i-1]是'('，即形如"...()"，则dp[i] = dp[i-2] + 2
 *    b. 如果s[i-1]是')'，即形如"...))"，需要检查s[i-dp[i-1]-1]是否为'('
 *       - 如果是'('，则dp[i] = dp[i-1] + 2 + dp[i-dp[i-1]-2]
 *       - 这种情况处理的是形如"((...)))"的情况，其中"(...)"是一个有效括号
 * 3. 最终结果是dp数组中的最大值
 *
 * 时间复杂度: O(n)，其中n是字符串长度，只需遍历一次字符串
 * 空间复杂度: O(n)，需要一个长度为n的dp数组
 *
 * @param s 只包含 '(' 和 ')' 的字符串
 * @return 最长有效括号子串的长度
 */
fun longestValidParentheses(s: String): Int {
    // 空字符串直接返回0
    if (s.isEmpty()) return 0

    // dp[i]表示以s[i]结尾的最长有效括号的长度
    val dpLengths = IntArray(s.length)
    var maxLength = 0

    // 从索引1开始，因为单个字符不可能形成有效括号
    for (i in 1 until s.length) {
        when (s[i]) {
            // 如果是左括号，则以它结尾的子串不可能是有效括号
            '(' -> dpLengths[i] = 0

            // 如果是右括号，则需要考虑两种情况
            ')' -> {
                // 情况1: 前一个字符是左括号，形如"...()"
                if (s[i - 1] == '(') {
                    // dp[i-2]表示"..."部分的有效括号长度，加上新增的"()"长度2
                    dpLengths[i] = dpLengths.getOrElse(i - 2) { 0 } + 2
                }
                // 情况2: 前一个字符是右括号，形如"...))"
                else {
                    // 检查是否存在匹配的左括号
                    val possibleMatchingOpenPos = i - dpLengths[i - 1] - 1
                    if (s.getOrElse(possibleMatchingOpenPos) { ')' } == '(') {
                        // 计算新的有效括号长度:
                        // dpLengths[i-1]是"...)"部分的长度
                        // 2是新匹配的一对括号"()"
                        // dpLengths.getOrElse(possibleMatchingOpenPos - 1) { 0 }是左括号前面的有效括号长度
                        dpLengths[i] = dpLengths[i - 1] + 2 + dpLengths.getOrElse(possibleMatchingOpenPos - 1) { 0 }
                    }
                }
            }
        }

        // 更新最长有效括号长度
        maxLength = maxOf(maxLength, dpLengths[i])
    }

    return maxLength
}
