package com.only4.algorithm.version4k.leetcode

fun generateParenthesis(totalParenthesesPairs: Int): List<String> {
    val allValidParenthesesCombinations = mutableListOf<String>()
    val currentParenthesesSequence = StringBuilder()

    /**
     * 使用回溯算法构建所有有效的括号组合
     * @param currentLeftParenthesesCount 当前序列中左括号的数量
     * @param currentRightParenthesesCount 当前序列中右括号的数量
     */
    fun buildValidParenthesesWithBacktracking(
        currentLeftParenthesesCount: Int,
        currentRightParenthesesCount: Int,
    ) {
        // 终止条件：序列长度达到2n，找到一个完整的有效括号组合
        if (currentParenthesesSequence.length == totalParenthesesPairs * 2) {
            allValidParenthesesCombinations.add(currentParenthesesSequence.toString())
            return
        }

        // 选择1：添加左括号（条件：左括号数量未达到上限）
        if (currentLeftParenthesesCount < totalParenthesesPairs) {
            // 选择：添加左括号
            currentParenthesesSequence.append("(")

            // 递归：继续构建序列，左括号数量+1
            buildValidParenthesesWithBacktracking(
                currentLeftParenthesesCount + 1,
                currentRightParenthesesCount
            )

            // 回溯：移除刚添加的左括号，尝试其他可能
            currentParenthesesSequence.deleteAt(currentParenthesesSequence.lastIndex)
        }

        // 选择2：添加右括号（条件：右括号数量小于左括号数量，确保括号匹配）
        if (currentLeftParenthesesCount > currentRightParenthesesCount) {
            // 选择：添加右括号
            currentParenthesesSequence.append(")")

            // 递归：继续构建序列，右括号数量+1
            buildValidParenthesesWithBacktracking(
                currentLeftParenthesesCount,
                currentRightParenthesesCount + 1
            )

            // 回溯：移除刚添加的右括号，尝试其他可能
            currentParenthesesSequence.deleteAt(currentParenthesesSequence.lastIndex)
        }
    }

    buildValidParenthesesWithBacktracking(0, 0)  // 从0个左括号和0个右括号开始
    return allValidParenthesesCombinations
}
