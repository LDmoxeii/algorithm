package com.only4.algorithm.leetcode

/**
 * [438. 找到字符串中所有字母异位词](https://leetcode.cn/problems/find-all-anagrams-in-a-string/)
 *
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 *
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 *
 * 示例 1:
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 *
 * 示例 2:
 * 输入: s = "abab", p = "ab"
 * 输出: [0,1,2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
 *
 * 提示:
 * - 1 <= s.length, p.length <= 3 * 10^4
 * - s 和 p 仅包含小写字母
 *
 * 解题思路：使用滑动窗口法。
 * 1. 使用两个Map分别记录目标字符串p中每个字符的出现次数和当前窗口中每个字符的出现次数
 * 2. 维护一个valid变量，表示当前窗口中有多少个字符的出现次数与目标字符串相同
 * 3. 当valid等于目标字符串中不同字符的个数时，说明找到了一个异位词
 * 4. 使用左右指针维护一个大小为p.length的滑动窗口
 *
 * 时间复杂度：O(n)，其中n是字符串s的长度
 * 空间复杂度：O(k)，其中k是字符集大小，本题中k=26（小写字母）
 *
 * @param s 源字符串
 * @param p 目标字符串
 * @return 所有p的异位词在s中的起始索引列表
 */
fun findAnagrams(s: String, p: String): List<Int> {
    // 如果源字符串长度小于目标字符串长度，不可能存在异位词
    if (s.length < p.length) return emptyList()

    val result = mutableListOf<Int>()

    // 记录目标字符串中每个字符的出现次数
    val targetFreq = mutableMapOf<Char, Int>().withDefault { 0 }
    // 记录当前窗口中每个字符的出现次数
    val windowFreq = mutableMapOf<Char, Int>().withDefault { 0 }

    // 初始化目标字符串的字符频率
    p.forEach { targetFreq[it] = targetFreq.getValue(it) + 1 }

    // 滑动窗口的左右边界
    var left = 0;
    var right = 0

    // 记录当前窗口中有多少个字符的出现次数与目标字符串相同
    var matchCount = 0

    while (right < s.length) {
        // 获取右边界字符并右移
        val rightChar = s[right++]

        // 如果当前字符在目标字符串中存在
        if (rightChar in targetFreq) {
            // 更新窗口中字符的出现次数
            windowFreq[rightChar] = windowFreq.getValue(rightChar) + 1

            // 如果当前字符在窗口中的出现次数与目标字符串中的出现次数相同
            if (windowFreq[rightChar] == targetFreq[rightChar]) {
                matchCount++
            }
        }

        // 当窗口大小大于等于目标字符串长度时，需要移动左边界
        while (right - left >= p.length) {
            // 如果所有字符的出现次数都匹配，找到一个异位词
            if (matchCount == targetFreq.size) {
                result.add(left)
            }

            // 获取左边界字符并左移
            val leftChar = s[left++]

            // 如果左边界字符在目标字符串中存在
            if (leftChar in targetFreq) {
                // 如果移除前这个字符的出现次数正好匹配，移除后就不再匹配了
                if (windowFreq[leftChar] == targetFreq[leftChar]) {
                    matchCount--
                }

                // 更新窗口中字符的出现次数
                windowFreq[leftChar] = windowFreq.getValue(leftChar) - 1
            }
        }
    }

    return result
}
