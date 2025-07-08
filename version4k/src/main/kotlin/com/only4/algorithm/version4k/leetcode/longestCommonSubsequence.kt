package com.only4.algorithm.version4k.leetcode

/**
 * [1143. 最长公共子序列](https://leetcode.com/problems/longest-common-subsequence/)
 *
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。
 * 一个字符串的子序列是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * 两个字符串的公共子序列是这两个字符串所共同拥有的子序列。
 *
 * 示例:
 * - 输入: text1 = "abcde", text2 = "ace"
 * - 输出: 3
 * - 解释: 最长公共子序列是 "ace"，它的长度为 3。
 *
 * - 输入: text1 = "abc", text2 = "abc"
 * - 输出: 3
 * - 解释: 最长公共子序列是 "abc"，它的长度为 3。
 *
 * - 输入: text1 = "abc", text2 = "def"
 * - 输出: 0
 * - 解释: 两个字符串没有公共子序列，返回 0。
 *
 * 解题思路:
 * 使用动态规划解决此问题。定义dp[i][j]表示text1[0...i-1]和text2[0...j-1]的最长公共子序列的长度。
 * 状态转移方程:
 * 1. 如果text1[i-1] == text2[j-1]，则dp[i][j] = dp[i-1][j-1] + 1
 * 2. 否则，dp[i][j] = max(dp[i-1][j], dp[i][j-1])
 *
 * 时间复杂度: O(m*n)，其中m和n分别是两个字符串的长度
 * 空间复杂度: O(m*n)，需要一个m*n的dp数组
 *
 * @param text1 第一个字符串
 * @param text2 第二个字符串
 * @return 最长公共子序列的长度
 */
fun longestCommonSubsequence(text1: String, text2: String): Int {
    // 创建dp数组，dp[i][j]表示text1[0...i-1]和text2[0...j-1]的最长公共子序列长度
    val dpTable = Array(text1.length + 1) { IntArray(text2.length + 1) }

    // 填充dp数组
    for (i in 1..text1.length) {
        for (j in 1..text2.length) {
            // 如果当前字符相同，则最长公共子序列长度加1
            if (text1[i - 1] == text2[j - 1]) {
                dpTable[i][j] = dpTable[i - 1][j - 1] + 1
            } else {
                // 否则取两种情况的最大值
                dpTable[i][j] = maxOf(dpTable[i - 1][j], dpTable[i][j - 1])
            }
        }
    }

    // 返回最终结果
    return dpTable[text1.length][text2.length]
}
