package com.only4.algorithm.version4k.leetcode

/**
 * 567. 字符串的排列
 *
 * 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
 * 换句话说，s1 的排列之一是 s2 的 子串 。
 *
 * 示例 1：
 * 输入：s1 = "ab" s2 = "eidbaooo"
 * 输出：true
 * 解释：s2 包含 s1 的排列之一 ("ba").
 *
 * 示例 2：
 * 输入：s1 = "ab" s2 = "eidboaoo"
 * 输出：false
 *
 * 解题思路：
 * 1. 使用滑动窗口算法，维护一个大小为s1.length的窗口
 * 2. 使用两个Map分别记录目标字符串s1中各字符的出现次数和窗口中各字符的出现次数
 * 3. 当窗口大小等于s1.length时，检查窗口中的字符出现次数是否与s1中相同
 *
 * @param s1 目标字符串
 * @param s2 源字符串
 * @return s2是否包含s1的排列
 */
fun checkInclusion(s1: String, s2: String): Boolean {
    // 处理空字符串的情况
    if (s1.isEmpty()) return true
    if (s2.isEmpty()) return false

    // 如果s1比s2长，s2不可能包含s1的排列
    if (s1.length > s2.length) return false

    // 使用数组代替Map来记录字符出现次数，提高效率（假设只有小写字母）
    val targetFreq = IntArray(26)
    val windowFreq = IntArray(26)

    // 初始化目标频率数组
    for (c in s1) {
        targetFreq[c - 'a']++
    }

    // 初始化窗口
    val windowSize = s1.length
    for (i in 0 until windowSize - 1) {
        windowFreq[s2[i] - 'a']++
    }

    // 滑动窗口
    for (i in windowSize - 1 until s2.length) {
        // 添加新字符到窗口
        windowFreq[s2[i] - 'a']++

        // 检查当前窗口是否与目标匹配
        if (targetFreq.contentEquals(windowFreq)) {
            return true
        }

        // 移除窗口最左侧的字符
        windowFreq[s2[i - windowSize + 1] - 'a']--
    }

    return false
}
