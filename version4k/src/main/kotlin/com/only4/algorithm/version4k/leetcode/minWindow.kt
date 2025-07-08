package com.only4.algorithm.version4k.leetcode

/**
 * [76. 最小覆盖子串](https://leetcode.cn/problems/minimum-window-substring/)
 *
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 ""。
 *
 * 注意：
 * - 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * - 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 *
 * 示例 1：
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
 *
 * 示例 2：
 * 输入：s = "a", t = "a"
 * 输出："a"
 * 解释：整个字符串 s 是最小覆盖子串。
 *
 * 示例 3：
 * 输入：s = "a", t = "aa"
 * 输出：""
 * 解释：t 中两个字符 'a' 均应包含在 s 的子串中，因此没有符合条件的子串，返回空字符串。
 *
 * 提示：
 * - 1 <= s.length, t.length <= 10^5
 * - s 和 t 由英文字母组成
 *
 * 解题思路：使用滑动窗口法。
 * 1. 使用两个哈希表分别记录目标字符串t中每个字符的出现次数和当前窗口中每个字符的出现次数
 * 2. 维护一个有效匹配计数器valid，表示当前窗口中有多少个字符的出现次数已经满足了目标要求
 * 3. 当valid等于目标字符串中不同字符的个数时，说明找到了一个覆盖子串
 * 4. 然后尝试缩小窗口，找到最小的覆盖子串
 *
 * 时间复杂度：O(n)，其中n是字符串s的长度
 * 空间复杂度：O(k)，其中k是字符集大小，本题中k最大为128（ASCII字符集）
 *
 * @param s 源字符串
 * @param t 目标字符串
 * @return 最小覆盖子串，如果不存在则返回空字符串
 */
fun minWindow(s: String, t: String): String {
    // 边界条件检查
    if (s.isEmpty() || t.isEmpty() || s.length < t.length) return ""

    // 记录目标字符串中每个字符的出现次数
    val targetFreq = mutableMapOf<Char, Int>().withDefault { 0 }
    // 记录当前窗口中每个字符的出现次数
    val windowFreq = mutableMapOf<Char, Int>().withDefault { 0 }

    // 初始化目标字符串的字符频率
    t.forEach { targetFreq[it] = targetFreq.getValue(it) + 1 }

    // 滑动窗口的左右边界
    var left = 0;
    var right = 0

    // 记录当前窗口中有多少个字符的出现次数已经满足了目标要求
    var matchCount = 0

    // 记录最小覆盖子串的起始位置和长度
    var minStart = 0
    var minLength = Int.MAX_VALUE

    while (right < s.length) {
        // 获取右边界字符并右移
        val rightChar = s[right++]

        // 如果当前字符在目标字符串中存在
        if (rightChar in targetFreq) {
            // 更新窗口中字符的出现次数
            windowFreq[rightChar] = windowFreq.getValue(rightChar) + 1

            // 如果当前字符在窗口中的出现次数刚好等于目标字符串中的出现次数
            if (windowFreq[rightChar] == targetFreq[rightChar]) {
                matchCount++
            }
        }

        // 当所有字符都匹配时，尝试缩小窗口
        while (matchCount == targetFreq.size) {
            // 更新最小覆盖子串
            val currentLength = right - left
            if (currentLength < minLength) {
                minStart = left
                minLength = currentLength
            }

            // 获取左边界字符并左移
            val leftChar = s[left++]

            // 如果左边界字符在目标字符串中存在
            if (leftChar in targetFreq) {
                // 如果移除前这个字符的出现次数正好等于目标字符串中的出现次数
                // 移除后就不再满足要求了
                if (windowFreq[leftChar] == targetFreq[leftChar]) {
                    matchCount--
                }

                // 更新窗口中字符的出现次数
                windowFreq[leftChar] = windowFreq.getValue(leftChar) - 1
            }
        }
    }

    return if (minLength == Int.MAX_VALUE) "" else s.substring(minStart, minStart + minLength)
}
