package com.only4.algorithm.version4k.leetcode

fun groupAnagrams(strs: Array<String>): List<List<String>> {
    // 哈希表：排序后的字符串 -> 原字符串列表
    val anagramGroups = HashMap<String, MutableList<String>>()

    strs.forEach { str ->
        // 将字符串转换为字符数组并排序
        val sortedStr = str.toCharArray().sorted().joinToString("")

        // 将原字符串添加到对应组中
        anagramGroups.getOrPut(sortedStr) { mutableListOf() }.add(str)
    }

    return anagramGroups.values.toList()
}
