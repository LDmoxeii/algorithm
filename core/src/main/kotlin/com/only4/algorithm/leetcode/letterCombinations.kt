package com.only4.algorithm.leetcode

/**
 * [17. 电话号码的字母组合](https://leetcode.com/problems/letter-combinations-of-a-phone-number/)
 *
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 2: abc
 * 3: def
 * 4: ghi
 * 5: jkl
 * 6: mno
 * 7: pqrs
 * 8: tuv
 * 9: wxyz
 *
 * 解题思路：
 * 使用回溯算法，对每个数字对应的所有字母进行组合。
 * 1. 创建一个映射表，存储每个数字对应的字母
 * 2. 使用回溯法遍历所有可能的组合
 * 3. 当当前组合长度等于输入字符串长度时，将组合添加到结果中
 *
 * 时间复杂度：O(3^m * 4^n)，其中 m 是对应3个字母的数字个数，n 是对应4个字母的数字个数
 * 空间复杂度：O(m+n)，递归调用栈的深度最大为 m+n
 */
fun letterCombinations(digits: String): List<String> {
    // 处理边界情况：空字符串返回空列表
    if (digits.isEmpty()) return emptyList()

    // 定义电话按键映射
    val phoneMap = arrayOf(
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    )

    val result = mutableListOf<String>()
    val combination = StringBuilder()

    /**
     * 回溯函数，用于生成所有可能的字母组合
     *
     * @param index 当前处理的数字在digits中的索引
     */
    fun backtrack(index: Int) {
        // 如果当前组合长度等于输入字符串长度，说明找到了一个完整组合
        if (index == digits.length) {
            result.add(combination.toString())
            return
        }

        // 获取当前数字对应的所有可能字母
        val letters = phoneMap[digits[index].digitToInt()]

        // 遍历每个可能的字母
        for (letter in letters) {
            // 添加当前字母到组合中
            combination.append(letter)
            // 递归处理下一个数字
            backtrack(index + 1)
            // 回溯，移除最后添加的字母
            combination.deleteAt(combination.lastIndex)
        }
    }

    // 从第一个数字开始回溯
    backtrack(0)
    return result
}
