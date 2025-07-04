package com.only4.algorithm.leetcode

/**
 * [22. 括号生成](https://leetcode.com/problems/generate-parentheses/)
 *
 * 给定 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且有效的括号组合。
 *
 * 解题思路：
 * 使用回溯算法，通过跟踪已经放置的左括号和右括号的数量来生成所有有效的括号组合。
 * 1. 左括号数量不能超过 n
 * 2. 右括号数量不能超过左括号数量
 * 3. 当左右括号数量都等于 n 时，我们找到了一个有效组合
 *
 * 时间复杂度：O(4^n / sqrt(n))，卡特兰数的渐近表达式
 * 空间复杂度：O(n)，递归调用栈的深度最大为 2n
 */
fun generateParenthesis(n: Int): List<String> {
    val result = mutableListOf<String>()

    /**
     * 回溯函数，用于生成所有可能的括号组合
     *
     * @param index 当前已放置的括号总数
     * @param openCount 当前已放置的左括号数量
     * @param path 当前构建的括号组合
     */
    fun backtrack(index: Int, openCount: Int, path: StringBuilder) {
        // 如果已放置的括号总数等于 2n，说明找到了一个有效组合
        if (index == n * 2) {
            result.add(path.toString())
            return
        }

        // 如果左括号数量小于 n，可以放置左括号
        if (openCount < n) {
            path.append("(")
            backtrack(index + 1, openCount + 1, path)
            path.deleteAt(path.lastIndex) // 回溯，删除最后添加的左括号
        }

        // 如果右括号数量小于左括号数量，可以放置右括号
        // index - openCount 表示已放置的右括号数量
        if (index - openCount < openCount) {
            path.append(")")
            backtrack(index + 1, openCount, path)
            path.deleteAt(path.lastIndex) // 回溯，删除最后添加的右括号
        }
    }

    backtrack(0, 0, StringBuilder())
    return result
}
