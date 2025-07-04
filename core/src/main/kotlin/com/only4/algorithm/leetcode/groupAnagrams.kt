package com.only4.algorithm.leetcode

/**
 * [49. 字母异位词分组](https://leetcode.cn/problems/group-anagrams/)
 *
 * 给你一个字符串数组 strs，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 *
 * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。
 *
 * 示例 1：
 * 输入：strs = ["eat","tea","tan","ate","nat","bat"]
 * 输出：[["bat"],["nat","tan"],["ate","eat","tea"]]
 *
 * 示例 2：
 * 输入：strs = [""]
 * 输出：[[""]]
 *
 * 示例 3：
 * 输入：strs = ["a"]
 * 输出：[["a"]]
 *
 * 提示：
 * - 1 <= strs.length <= 10^4
 * - 0 <= strs[i].length <= 100
 * - strs[i] 仅包含小写字母
 *
 * 解题思路：将每个单词按照字母顺序排序后得到一个唯一的键，具有相同键的单词是字母异位词。
 * 使用HashMap存储这个键到对应单词列表的映射，最后返回所有单词列表。
 *
 * 时间复杂度：O(n * k * log(k))，其中n是数组长度，k是单词的最大长度
 * 空间复杂度：O(n * k)
 *
 * @param strs 字符串数组
 * @return 按字母异位词分组后的列表
 */
fun groupAnagrams(strs: Array<String>): List<List<String>> {
    val anagramGroups = HashMap<String, MutableList<String>>()

    strs.forEach { word ->
        val sortedWord = word.toCharArray().sorted().joinToString("")
        anagramGroups.getOrPut(sortedWord) { mutableListOf() }.add(word)
    }

    return anagramGroups.values.toList()
}
