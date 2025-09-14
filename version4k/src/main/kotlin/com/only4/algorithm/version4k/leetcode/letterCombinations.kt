package com.only4.algorithm.version4k.leetcode

fun letterCombinations(inputPhoneDigits: String): List<String> {
    // 边界条件：如果输入为空，返回空列表
    if (inputPhoneDigits.isEmpty()) return emptyList()

    // 电话按键到字母的映射表（数组索引对应数字，值为对应字母）
    val digitToLettersMap = arrayOf(
        "",      // 0 - 无对应字母
        "",      // 1 - 无对应字母
        "abc",   // 2
        "def",   // 3
        "ghi",   // 4
        "jkl",   // 5
        "mno",   // 6
        "pqrs",  // 7
        "tuv",   // 8
        "wxyz"   // 9
    )

    val allLetterCombinations = mutableListOf<String>()
    val currentCombinationPath = StringBuilder()

    /**
     * 使用回溯算法生成所有可能的字母组合
     * @param currentDigitIndex 当前正在处理的数字位置索引
     */
    fun generateCombinationsWithBacktracking(currentDigitIndex: Int) {
        // 终止条件：已经处理完所有数字，当前路径就是一个完整的字母组合
        if (currentDigitIndex == inputPhoneDigits.length) {
            allLetterCombinations.add(currentCombinationPath.toString())
            return
        }

        // 获取当前数字对应的所有可能字母
        val currentDigit = inputPhoneDigits[currentDigitIndex]
        val availableLettersForCurrentDigit = digitToLettersMap[currentDigit.digitToInt()]

        // 尝试当前数字对应的每个字母
        for (candidateLetter in availableLettersForCurrentDigit) {
            // 选择：将候选字母添加到当前组合路径
            currentCombinationPath.append(candidateLetter)

            // 递归：继续处理下一个数字
            generateCombinationsWithBacktracking(currentDigitIndex + 1)

            // 回溯：移除刚添加的字母，尝试其他可能的字母选择
            currentCombinationPath.deleteAt(currentCombinationPath.lastIndex)
        }
    }

    generateCombinationsWithBacktracking(0)  // 从第0个数字开始处理
    return allLetterCombinations
}
