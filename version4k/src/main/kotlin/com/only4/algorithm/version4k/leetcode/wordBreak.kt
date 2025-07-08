package com.only4.algorithm.version4k.leetcode

/**
 * [139. 单词拆分](https://leetcode.com/problems/word-break/)
 *
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 *
 * 示例:
 * - 输入: s = "leetcode", wordDict = ["leet", "code"]
 * - 输出: true
 * - 解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
 *
 * - 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * - 输出: true
 * - 解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
 *      注意，你可以重复使用字典中的单词。
 *
 * - 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * - 输出: false
 *
 * 解题思路:
 * 使用动态规划解决此问题。定义canBreak[position]表示字符串s的前position个字符是否可以被拆分为字典中的单词。
 * 1. 初始化canBreak[0] = true，表示空字符串可以被拆分
 * 2. 对于每个位置position，检查是否存在位置startPos使得canBreak[startPos]为true且s[startPos..position)在字典中
 * 3. 为了优化性能，我们:
 *    - 使用HashSet存储字典单词，使查找操作为O(1)
 *    - 预计算字典中最长单词的长度，减少内层循环的范围
 *    - 使用布尔数组代替List，使canBreak查找操作为O(1)
 *
 * 时间复杂度: O(n * L)，其中n是字符串长度，L是字典中最长单词的长度
 * 空间复杂度: O(n + m)，其中n是字符串长度，m是字典大小
 *
 * @param s 需要拆分的字符串
 * @param wordDict 可用于拆分的单词字典
 * @return 字符串s是否可以被拆分为字典中的单词
 */
fun wordBreak(s: String, wordDict: List<String>): Boolean {
    // 计算字典中最长单词的长度
    val maxWordLength = wordDict.maxOfOrNull { it.length } ?: 0

    // 将字典转换为HashSet以提高查找效率
    val wordSet = wordDict.toHashSet()

    // 创建canBreak数组，canBreak[position]表示s的前position个字符是否可以被拆分
    val canBreak = BooleanArray(s.length + 1)
    canBreak[0] = true // 空字符串可以被拆分

    // 对于每个位置position，检查是否可以从之前的某个位置加上字典中的单词得到
    for (position in 1..s.length) {
        // 只需要检查从position-maxWordLength到position-1的范围
        // 因为不可能有比最长单词更长的单词在字典中
        val minStartPos = maxOf(position - maxWordLength, 0)
        for (startPos in (position - 1).downTo(minStartPos)) {
            val word = s.substring(startPos, position)
            if (canBreak[startPos] && wordSet.contains(word)) {
                canBreak[position] = true
                break // 一旦找到一种可行拆分，就可以停止当前位置的检查
            }
        }
    }

    return canBreak[s.length]
}
