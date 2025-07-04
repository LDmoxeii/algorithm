package com.only4.algorithm.leetcode

/**
 * [3. 无重复字符的最长子串](https://leetcode.cn/problems/longest-substring-without-repeating-characters/)
 *
 * 给定一个字符串 s，请你找出其中不含有重复字符的最长子串的长度。
 *
 * 示例 1：
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 示例 2：
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 示例 3：
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是子串的长度，"pwke" 是一个子序列，不是子串。
 *
 * 提示：
 * - 0 <= s.length <= 5 * 10^4
 * - s 由英文字母、数字、符号和空格组成
 *
 * 解题思路：使用滑动窗口法。维护一个窗口，窗口内的字符都是不重复的。
 * 1. 使用一个Map来记录每个字符及其出现次数
 * 2. 使用左右指针表示窗口的边界
 * 3. 右指针不断向右移动，将字符加入窗口
 * 4. 当加入的字符在窗口中已存在时，不断移动左指针，直到窗口中不再有重复字符
 * 5. 在每一步更新最长无重复子串的长度
 *
 * 时间复杂度：O(n)，其中n是字符串的长度。左右指针最多各遍历整个字符串一次。
 * 空间复杂度：O(min(m, n))，其中m是字符集的大小，n是字符串的长度。
 *
 * @param s 输入字符串
 * @return 无重复字符的最长子串的长度
 */
fun lengthOfLongestSubstring(s: String): Int {
    if (s.isEmpty()) return 0

    // 使用HashMap记录字符及其出现次数
    val charFrequency = mutableMapOf<Char, Int>().withDefault { 0 }
    var maxLength = 0
    var left = 0;
    var right = 0

    // 右指针遍历字符串
    while (right < s.length) {
        val currentChar = s[right]
        // 将当前字符加入窗口并增加其计数
        charFrequency[currentChar] = charFrequency.getValue(currentChar) + 1

        // 当出现重复字符时，移动左指针直到窗口中不再有重复字符
        while (charFrequency[currentChar]!! > 1) {
            val leftChar = s[left]
            charFrequency[leftChar] = charFrequency.getValue(leftChar) - 1
            left++
        }

        // 更新最长无重复子串的长度
        maxLength = maxOf(maxLength, right - left + 1)
        right++
    }

    return maxLength
}
