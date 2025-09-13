package com.only4.algorithm.version4k.leetcode

fun letterCombinations(digits: String): List<String> {
    if (digits.isEmpty()) return emptyList()

    val phoneMap = arrayOf(
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    )

    val result = mutableListOf<String>()
    val path = StringBuilder()

    fun backtrack(index: Int) {
        if (index == digits.length) {
            result.add(path.toString())
            return
        }

        val letters = phoneMap[digits[index].digitToInt()]
        for (letter in letters) {
            path.append(letter)
            backtrack(index + 1)
            path.deleteAt(path.lastIndex)
        }
    }
    backtrack(0)
    return result
}
