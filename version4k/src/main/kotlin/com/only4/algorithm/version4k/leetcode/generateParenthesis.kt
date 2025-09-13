package com.only4.algorithm.version4k.leetcode

fun generateParenthesis(n: Int): List<String> {
    val result = mutableListOf<String>()
    val path = StringBuilder()

    fun backtrack(leftCount: Int, rightCount: Int) {
        if (path.length == n * 2) {
            result.add(path.toString())
            return
        }

        if (leftCount < n) {
            path.append("(")
            backtrack(leftCount + 1, rightCount)
            path.deleteAt(path.lastIndex)
        }

        if (leftCount > rightCount) {
            path.append(")")
            backtrack(leftCount, rightCount + 1)
            path.deleteAt(path.lastIndex)
        }
    }
    backtrack(0, 0)
    return result
}
